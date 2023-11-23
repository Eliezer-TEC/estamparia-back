package estampariaback.estamparia.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Pedido;
import estampariaback.estamparia.dw.service.PedidoService;

@RestController
@RequestMapping(path = "/api/pedido")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/cadastrar")
    public Pedido salvar(@RequestBody Pedido novoPedido) throws CampoInvalidoException {
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
    
 	@GetMapping(path = "/{id}")
 	public Pedido consultarPorId(@PathVariable Integer id) {
 		return pedidoService.consultarPorId(id.longValue());

 	}
}
