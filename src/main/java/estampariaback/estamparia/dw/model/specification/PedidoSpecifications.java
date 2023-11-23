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

            if (seletor.getIdPessoa() != 0) {
                predicates.add(cb.equal(root.get("idPessoa"), seletor.getIdPessoa()));
            }

            if (seletor.getIdCamisa() != 0) {
                predicates.add(cb.equal(root.get("idCamisa"), seletor.getIdCamisa()));
            }

            if (seletor.getIdEndereco() != 0) {
                predicates.add(cb.equal(root.get("idEndereco"), seletor.getIdEndereco()));
            }

            if(seletor.getTotalMinimo() != null && seletor.getTotalMaximo() != null) {
            	//WHERE peso BETWEEN min AND max
            	predicates.add(cb.between(root.get("total"), seletor.getTotalMinimo(), 
            			seletor.getTotalMaximo()));
            } else if(seletor.getTotalMinimo() != null) {
            	predicates.add(cb.greaterThanOrEqualTo(root.get("total"), seletor.getTotalMinimo()));
            } else if(seletor.getTotalMaximo() != null) {
            	predicates.add(cb.lessThanOrEqualTo(root.get("total"), seletor.getTotalMaximo()));
            }

            if (seletor.getStatus() != null && !seletor.getStatus().isEmpty()) {
                predicates.add(cb.equal(root.get("status"), seletor.getStatus()));
            }

            if(seletor.getQuantidadeMinima() != null && seletor.getQuantidadeMaxima() != null) {
            	//WHERE peso BETWEEN min AND max
            	predicates.add(cb.between(root.get("peso"), seletor.getQuantidadeMinima(), 
            			seletor.getQuantidadeMaxima()));
            } else if(seletor.getQuantidadeMinima() != null) {
            	predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getQuantidadeMinima()));
            } else if(seletor.getQuantidadeMaxima() != null) {
            	predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getQuantidadeMaxima()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
