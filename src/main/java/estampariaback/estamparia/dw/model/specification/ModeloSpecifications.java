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

			if (seletor.getValorVendaMinimo() != null) {
				predicates.add(cb.equal(root.get("valorVendaMinimo"), seletor.getValorVendaMinimo()));
			}

			if (seletor.getValorVendaMinimo() != null && seletor.getValorVendaMaximo() != null) {
				// WHERE peso BETWEEN min AND max
				predicates.add(
						cb.between(root.get("peso"), seletor.getValorVendaMinimo(), seletor.getValorVendaMaximo()));
			} else if (seletor.getValorVendaMinimo() != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorVendaMinimo()));
			} else if (seletor.getValorVendaMaximo() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorVendaMaximo()));
			}

			if (seletor.getCustoMinimo() != null && seletor.getCustoMaximo() != null) {
				// WHERE peso BETWEEN min AND max
				predicates.add(cb.between(root.get("custo"), seletor.getCustoMinimo(), seletor.getCustoMaximo()));
			} else if (seletor.getCustoMinimo() != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("custo"), seletor.getCustoMinimo()));
			} else if (seletor.getCustoMaximo() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("custo"), seletor.getCustoMaximo()));
			}

			if (seletor.getDataCadastroMinimo() != null && seletor.getDataCadastroMaximo() != null) {
				// WHERE dataCadastro BETWEEN min AND max
				predicates.add(cb.between(root.get("dataCadastro"), seletor.getDataCadastroMinimo(),
						seletor.getDataCadastroMaximo()));
			} else if (seletor.getDataCadastroMinimo() != null) {
				// WHERE dataCadastro >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataCadastro"), seletor.getDataCadastroMinimo()));
			} else if (seletor.getDataCadastroMaximo() != null) {
				// WHERE dataCadastro <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("dataCadastro"), seletor.getDataCadastroMaximo()));
			}

			if (seletor.getDataFimVigenciaMinimo() != null && seletor.getDataFimVigenciaMaximo() != null) {
				// WHERE dataCadastro BETWEEN min AND max
				predicates.add(cb.between(root.get("dataCadastro"), seletor.getDataFimVigenciaMinimo(),
						seletor.getDataFimVigenciaMaximo()));
			} else if (seletor.getDataFimVigenciaMinimo() != null) {
				// WHERE dataCadastro >= min
				predicates
						.add(cb.greaterThanOrEqualTo(root.get("dataFimVigencia"), seletor.getDataFimVigenciaMinimo()));
			} else if (seletor.getDataFimVigenciaMaximo() != null) {
				// WHERE dataCadastro <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("dataFimVigencia"), seletor.getDataFimVigenciaMaximo()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
