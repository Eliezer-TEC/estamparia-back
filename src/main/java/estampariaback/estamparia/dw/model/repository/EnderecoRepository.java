package estampariaback.estamparia.dw.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import estampariaback.estamparia.dw.model.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>, JpaSpecificationExecutor<Endereco> {
	List<Endereco> findAllByidLike(Integer id);
}
