package estampariaback.estamparia.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Endereco;
import estampariaback.estamparia.dw.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco inserir(Endereco novoEndereco) throws CampoInvalidoException {
		validarCamposObrigatorios(novoEndereco);
		return enderecoRepository.save(novoEndereco);
	}

	private void validarCamposObrigatorios(Endereco novoEndereco) throws CampoInvalidoException {
		String mensagemValidacao = "";

		mensagemValidacao += validarCamposObrigatorios(novoEndereco.getBairro(), "bairro");
		mensagemValidacao += validarCamposObrigatorios(novoEndereco.getCep(), "cep");
		mensagemValidacao += validarCamposObrigatorios(novoEndereco.getCidade(), "cidade");
		mensagemValidacao += validarCamposObrigatorios(novoEndereco.getComplemento(), "complemento");
		mensagemValidacao += validarCamposObrigatorios(novoEndereco.getEstado(), "estado");
		mensagemValidacao += validarCamposObrigatorios(novoEndereco.getNumero(), "numero");
		mensagemValidacao += validarCamposObrigatorios(novoEndereco.getRua(), "rua");

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
		enderecoRepository.deleteById(id.longValue());
		return true;
	}

	public Endereco atualizar(Endereco enderecoParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(enderecoParaAtualizar);
		return enderecoRepository.save(enderecoParaAtualizar);
	}

	public List<Endereco> listarTodos() {
		return enderecoRepository.findAll();
	}

}
