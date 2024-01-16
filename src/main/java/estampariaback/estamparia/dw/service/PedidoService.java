package estampariaback.estamparia.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Pedido;
import estampariaback.estamparia.dw.model.repository.PedidoRepository;
import estampariaback.estamparia.dw.model.seletor.PedidoSeletor;
import estampariaback.estamparia.dw.model.specification.PedidoSpecifications;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido inserir(Pedido novoPedido) throws CampoInvalidoException {
        validarCamposObrigatorios(novoPedido);
        return pedidoRepository.save(novoPedido);
    }

    private void validarCamposObrigatorios(Pedido novoPedido) throws CampoInvalidoException {
    	String mensagemValidacao = "";

		mensagemValidacao += validarCamposObrigatorios(novoPedido.getStatus(), "status");
		mensagemValidacao += validarCampoDouble(novoPedido.getTotal(), "total");


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
    private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if(valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}
    public boolean excluir(Integer id) {
        pedidoRepository.deleteById(id.longValue());
        return true;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido atualizar(Pedido pedidoParaAtualizar) throws CampoInvalidoException {
        validarCamposObrigatorios(pedidoParaAtualizar);
        return pedidoRepository.save(pedidoParaAtualizar);
    }

	public List<Pedido> listarComSeletor(PedidoSeletor seletor) {
		Specification<Pedido> specification = PedidoSpecifications.comFiltros(seletor);
        return pedidoRepository.findAll(specification);
	}
    @Transactional
	public Pedido consultarPorId(Long id) {
    	return pedidoRepository.findById(id.longValue()).get();
	}
}
