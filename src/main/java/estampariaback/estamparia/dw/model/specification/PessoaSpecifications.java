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

            if (seletor.getDtNasc() != null) {
                predicates.add(cb.equal(root.get("dtNasc"), seletor.getDtNasc()));
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

            predicates.add(cb.equal(root.get("senha"), seletor.getSenha()));
            predicates.add(cb.equal(root.get("funcionario"), seletor.isFuncionario()));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
