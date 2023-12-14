package estampariaback.estamparia.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import estampariaback.estamparia.dw.model.entity.Pedido;
import estampariaback.estamparia.dw.model.seletor.PedidoSeletor;
import jakarta.persistence.criteria.Predicate;

public class PedidoSpecifications {

	public static Specification<Pedido> comFiltros(PedidoSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getId() != null) {
				predicates.add(cb.equal(root.get("id"), seletor.getId()));
			}

			if (seletor.getNome() != null && !seletor.getNome().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			if (seletor.getTotal() != null) {
				predicates.add(cb.equal(root.get("total"), seletor.getTotal()));
			}

			if (seletor.getQuantidade() != null) {
				predicates.add(cb.equal(root.get("quantidade"), seletor.getQuantidade()));
			}

			if (seletor.getTamanho() != null && seletor.getTamanho() != null) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			if (seletor.getCor() != null && !seletor.getCor().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));

			}
			if (seletor.getEstampa() != null) {
				predicates.add(cb.equal(root.get("estampa"), seletor.getEstampa()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
