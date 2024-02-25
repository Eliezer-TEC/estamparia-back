package estampariaback.estamparia.dw.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Camisa;
import estampariaback.estamparia.dw.model.entity.Pedido;
import estampariaback.estamparia.dw.model.seletor.PedidoSeletor;
import estampariaback.estamparia.dw.service.PedidoService;

@RestController
@RequestMapping(path = "/api/pedido")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/cadastrar")
    public Pedido salvar(Pedido novoPedido, @RequestParam("estampa") MultipartFile estampa) throws CampoInvalidoException, IOException {
    	// Aqui você pode acessar o byte[] da imagem usando foto.getBytes()
        byte[] estampaBytes = estampa.getBytes();

        // Faça o que for necessário com o byte[], por exemplo, atribuir ao pedido
        novoPedido.setEstampa(estampaBytes);

        // Continue com o resto da lógica de salvamento
        return pedidoService.inserir(novoPedido);
    }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return pedidoService.excluir(id);
    }

    @PutMapping("/atualizar")
    public boolean atualizar(@RequestBody Pedido pedidoParaAtualizar) throws CampoInvalidoException {
        return pedidoService.atualizar(pedidoParaAtualizar) != null;
    }

    @GetMapping(path = "/todos")
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }
    @PostMapping("/filtro")
	public List<Pedido> listarComSeletor(@RequestBody PedidoSeletor seletor){
		return pedidoService.listarComSeletor(seletor);
	}
    
 	@GetMapping(path = "/{id}")
 	public Pedido consultarPorId(@PathVariable Integer id) {
 		return pedidoService.consultarPorId(id.longValue());

 	}
}
