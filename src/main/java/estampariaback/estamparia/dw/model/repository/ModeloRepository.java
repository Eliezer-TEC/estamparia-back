package estampariaback.estamparia.dw.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import estampariaback.estamparia.dw.model.entity.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long>, JpaSpecificationExecutor<Modelo> {
	List<Modelo> findAllByIdLike(Integer id); 
}
