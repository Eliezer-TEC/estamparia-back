package estampariaback.estamparia.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import estampariaback.estamparia.dw.model.entity.Camisa;
import estampariaback.estamparia.dw.model.seletor.CamisaSeletor;
import jakarta.persistence.criteria.Predicate;

public class CamisaSpecification {

	public static Specification<Camisa> comFiltros(CamisaSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getTamanhos() != null && seletor.getTamanhos() != null) {
				Predicate predicado = root.get("tamanho").in(seletor.getTamanhos());
				predicates.add(predicado);
			}
			
			if (seletor.getCor() != null) {
				// WHERE peso >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("cor"), seletor.getCor()));

			} 
			if (seletor.getEstampa() != null) {
				// WHERE peso <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("estampa"), seletor.getEstampa()));
			}

			
					return cb.and(predicates.toArray(new Predicate[0]));
		};
	

		}

}
