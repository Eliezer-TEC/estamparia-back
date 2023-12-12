package estampariaback.estamparia.dw.service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Camisa;
import estampariaback.estamparia.dw.model.repository.CamisaRepository;

import jakarta.transaction.Transactional;

import estampariaback.estamparia.dw.model.seletor.CamisaSeletor;
import estampariaback.estamparia.dw.model.specification.CamisaSpecification;


@Service
public class CamisaService {

	@Autowired
	private CamisaRepository camisaRepository;

	public Camisa inserir(Camisa novaCamisa) throws CampoInvalidoException {
		validarCamposObrigatorios(novaCamisa);
		return camisaRepository.save(novaCamisa);
	}

	private void validarCamposObrigatorios(Camisa novaCamisa) throws CampoInvalidoException {
		String mensagemValidacao = "";

		mensagemValidacao += validarCamposObrigatorios(novaCamisa.getCor(), "cor");
		mensagemValidacao += validarCamposObrigatorios(novaCamisa.getTamanho(), "Tamanho");
		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCamposObrigatorios(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public boolean excluir(Integer id) {
		camisaRepository.deleteById(id.longValue());

		return true;
	}

	public List<Camisa> listarTodos() {
		return camisaRepository.findAll();
	}

	public Camisa atualizar(Camisa produtoParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(produtoParaAtualizar);

		return camisaRepository.save(produtoParaAtualizar);
	}

	@Transactional
	public Camisa consultarPorId(Long id) {
		return camisaRepository.findById(id.longValue()).get();

	}
		
	/*Se existe Para deletar e atualizar
	  */
	 
	public Camisa buscarPorId(Integer id) {
		Optional<Camisa> camisaOptional = camisaRepository.findById(id.longValue());

		// Verificar se a camisa com o ID fornecido existe
		if (camisaOptional.isPresent()) {
			return camisaOptional.get();
		} else {
			throw new NoSuchElementException("ID não encontrado: " + id);
		}
	}

	public List<Camisa> listarComSeletor(CamisaSeletor seletor) {
		Specification<Camisa> specification = CamisaSpecification.comFiltros(seletor);
		return camisaRepository.findAll(specification);
	}

	 public void salvarArquivo(MultipartFile file) {
	        try {
	            Camisa arquivo = new Camisa();
	            arquivo.setNomeArquivo(file.getOriginalFilename());
	            arquivo.setEstampa(file.getBytes());
	            camisaRepository.save(arquivo);
	        } catch (IOException e) {
	            // Lidar com exceções
	        }
	    }
	 public Integer converterLongParaInteger(Long id) {
		    if (id != null) {
		        return id.intValue();
		    }
		    return null; 
		}

	 public byte[] carregarArquivo(Integer id) {
		 Long idLong = id != null ? id.longValue() : null;
	        return camisaRepository.findById(idLong)
	                .map(Camisa::getEstampa)
	                .orElse(null);
	    }
	 
	 

}
