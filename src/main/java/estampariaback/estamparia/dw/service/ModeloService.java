package estampariaback.estamparia.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Modelo;
import estampariaback.estamparia.dw.repository.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository modeloRepository;

	public Modelo inserir(Modelo novoModelo) throws CampoInvalidoException {
		validarCamposObrigatorios(novoModelo);
		return modeloRepository.save(novoModelo);
	}

	private void validarCamposObrigatorios(Modelo novoModelo) throws CampoInvalidoException {
		String mensagemValidacao = "";

		mensagemValidacao += validarCampoDouble(novoModelo.getCusto(), "custo");
		mensagemValidacao += validarCampoDouble(novoModelo.getValorVenda(), "valor_venda");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}
	
	
	private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if (valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public boolean excluir(Integer id) {
		modeloRepository.deleteById(id.longValue());
		return true;
	}

	public List<Modelo> listarTodos() {
		return modeloRepository.findAll();
	}

	public Modelo atualizar(Modelo modeloParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(modeloParaAtualizar);
		return modeloRepository.save(modeloParaAtualizar);
	}
}
