package estampariaback.estamparia.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Pessoa;
import estampariaback.estamparia.dw.service.PessoaService;

@RestController
@RequestMapping(path = "/api/pessoa")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public Pessoa salvar(@RequestBody Pessoa novaPessoa) throws CampoInvalidoException {
        return pessoaService.inserir(novaPessoa);
    }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return pessoaService.excluir(id);
    }

    @PutMapping("/atualizar")
    public boolean atualizar(@RequestBody Pessoa pessoaParaAtualizar) throws CampoInvalidoException {
        return pessoaService.atualizar(pessoaParaAtualizar) != null;
    }

    @GetMapping(path = "/todos")
    public List<Pessoa> listarTodos() {
        return pessoaService.listarTodos();
    }
    
 	@GetMapping(path = "/{id}")
 	public Pessoa consultarPorId(@PathVariable Integer id) {
 		return pessoaService.consultarPorId(id.longValue());

 	}
}
