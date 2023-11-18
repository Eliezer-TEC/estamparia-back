package estampariaback.estamparia.dw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import estampariaback.estamparia.dw.model.entity.Camisa;


public interface CamisaRepository extends JpaRepository<Camisa, Long>, JpaSpecificationExecutor<Camisa> {
	List<Camisa> findAllByNomeLike(String nomeInformado);
}
