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

			if (seletor.getTamanhoMinimo() != null && seletor.getTamanhoMinimo() != null) {
				predicates.add(cb.between(root.get("tamanho"), seletor.getTamanhoMinimo(), seletor.getTamanhoMinimo()));
			}
			if (seletor.getTamanhoMaximo() != null && seletor.getTamanhoMaximo() != null) {
				// WHERE peso BETWEEN min AND max
				predicates.add(cb.between(root.get("tamanho"), seletor.getTamanhoMaximo(), seletor.getTamanhoMaximo()));

			} else if (seletor.getCor() != null) {
				// WHERE peso >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getCor()));

			} else if (seletor.getEstampa() != null) {
				// WHERE peso <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getEstampa()));
			}

			
					return cb.and(predicates.toArray(new Predicate[0]));
		};
	

		}

}
