package estampariaback.estamparia.dw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import estampariaback.estamparia.dw.model.entity.Camisa;

@Repository
public interface CamisaRepository extends JpaRepository<Camisa, Long>, JpaSpecificationExecutor<Camisa> {
	List<Camisa> findAllByEstampaLike(String nomeInformado);
}
