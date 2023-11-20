package estampariaback.estamparia.dw.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import estampariaback.estamparia.dw.model.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>, JpaSpecificationExecutor<Pedido> {
	List<Pedido> findAllByIdLike(Integer id); 
}