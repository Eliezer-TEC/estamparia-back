package estampariaback.estamparia.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import estampariaback.estamparia.dw.model.entity.Modelo;
import estampariaback.estamparia.dw.model.seletor.ModeloSeletor;

public class ModeloSpecifications {

	public static Specification<Modelo> comFiltros(ModeloSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getId() != null) {
				predicates.add(cb.equal(root.get("id"), seletor.getId()));
			}
			
			if (seletor.getNome() != null && !seletor.getNome().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			if (seletor.getValorVenda() != null) {
				predicates.add(cb.equal(root.get("valorVenda"), seletor.getValorVenda()));
			}

			if (seletor.getCusto() != null) {
				predicates.add(cb.equal(root.get("custo"), seletor.getCusto()));
			}
			

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
