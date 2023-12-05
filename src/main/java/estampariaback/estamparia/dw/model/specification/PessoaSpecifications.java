package estampariaback.estamparia.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import estampariaback.estamparia.dw.model.entity.Pessoa;
import estampariaback.estamparia.dw.model.seletor.PessoaSeletor;
import jakarta.persistence.criteria.Predicate;

public class PessoaSpecifications {

	public static Specification<Pessoa> comFiltros(PessoaSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getId() != null) {
				predicates.add(cb.equal(root.get("id"), seletor.getId()));
			}

			if (seletor.getIdEndereco() != 0) {
				predicates.add(cb.equal(root.get("idEndereco"), seletor.getIdEndereco()));
			}

			if (seletor.getNome() != null && !seletor.getNome().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			if (seletor.getCpf() != null && !seletor.getCpf().isEmpty()) {
				predicates.add(cb.equal(root.get("cpf"), seletor.getCpf()));
			}

			if (seletor.getDtNascMinimo() != null && seletor.getDtNascMaximo() != null) {
				// WHERE dataCadastro BETWEEN min AND max
				predicates.add(cb.between(root.get("dtNasc"), seletor.getDtNascMinimo(), seletor.getDtNascMaximo()));
			} else if (seletor.getDtNascMinimo() != null) {
				// WHERE dataCadastro >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("dtNasc"), seletor.getDtNascMinimo()));
			} else if (seletor.getDtNascMaximo() != null) {
				// WHERE dataCadastro <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("dtNasc"), seletor.getDtNascMaximo()));
			}

			if (seletor.getEmail() != null && !seletor.getEmail().isEmpty()) {
				predicates.add(cb.equal(root.get("email"), seletor.getEmail()));
			}

			if (seletor.getDdd() != null && !seletor.getDdd().isEmpty()) {
				predicates.add(cb.equal(root.get("ddd"), seletor.getDdd()));
			}

			if (seletor.getTelefone() != null && !seletor.getTelefone().isEmpty()) {
				predicates.add(cb.equal(root.get("telefone"), seletor.getTelefone()));
			}
			if (seletor.getSenha() != null && !seletor.getSenha().isEmpty()) {
				predicates.add(cb.equal(root.get("senha"), seletor.getSenha()));
			}
			if (seletor.isFuncionario() != null) {
				predicates.add(cb.equal(root.get("funcionario"), seletor.isFuncionario()));
			}

		
		return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}



