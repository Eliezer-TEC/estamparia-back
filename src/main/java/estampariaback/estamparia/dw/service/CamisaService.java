package estampariaback.estamparia.dw.service;

import org.springframework.beans.factory.annotation.Autowired;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Camisa;
import estampariaback.estamparia.dw.repository.CamisaRepository;

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
		mensagemValidacao += validarCamposObrigatorios(novaCamisa.getEstampa(), "Estampa");
		mensagemValidacao += validarCamposObrigatorios(novaCamisa.getTamanho(), "Tamanho");
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCamposObrigatorios(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}
}
