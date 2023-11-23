package estampariaback.estamparia.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import estampariaback.estamparia.dw.model.entity.Endereco;
import estampariaback.estamparia.dw.model.seletor.EnderecoSeletor;
import jakarta.persistence.criteria.Predicate;

public class EnderecoSpecifications {

    public static Specification<Endereco> comFiltros(EnderecoSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seletor.getRua() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("rua")), "%" +  seletor.getRua().toLowerCase() + "%"));
            }

            if (seletor.getNumero() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("numero")), "%" +  seletor.getNumero().toLowerCase() + "%"));
            }

            if (seletor.getBairro() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("bairro")), "%" +  seletor.getBairro().toLowerCase() + "%"));
            }

            if (seletor.getCep() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("cep")), "%" +  seletor.getCep().toLowerCase() + "%"));
            }

            if (seletor.getCidade() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("cidade")), "%" +  seletor.getCidade().toLowerCase() + "%"));
            }

            if (seletor.getEstado() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("estado")), "%" +  seletor.getEstado().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}
