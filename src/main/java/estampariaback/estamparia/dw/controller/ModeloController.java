package estampariaback.estamparia.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Modelo;
import estampariaback.estamparia.dw.service.ModeloService;

@RestController
@RequestMapping(path = "/api/modelo")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class ModeloController {
    
    @Autowired
    private ModeloService modeloService;

    @PostMapping("/cadastrar")
    public Modelo salvar(@RequestBody Modelo novoModelo) throws CampoInvalidoException {
        return modeloService.inserir(novoModelo);
    }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return modeloService.excluir(id);
    }

    @PutMapping("/atualizar")
    public boolean atualizar(@RequestBody Modelo modeloParaAtualizar) throws CampoInvalidoException {
        return modeloService.atualizar(modeloParaAtualizar) != null;
    }

    @GetMapping(path = "/todos")
    public List<Modelo> listarTodos() {
        return modeloService.listarTodos();
    }
    
 	@GetMapping(path = "/{id}")
 	public Modelo consultarPorId(@PathVariable Integer id) {
 		return modeloService.consultarPorId(id.longValue());

 	}
}
