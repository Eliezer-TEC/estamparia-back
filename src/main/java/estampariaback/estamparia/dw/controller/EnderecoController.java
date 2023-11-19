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
import estampariaback.estamparia.dw.model.entity.Endereco;
import estampariaback.estamparia.dw.service.EnderecoService;


@RestController
@RequestMapping(path = "/api/endereco")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class EnderecoController {
	@Autowired //injeção de dependência (tomcat vai instanciar o objeto produtoService sob demanda)
	private EnderecoService enderecoService;
	
	//Cadastro de enderecos
		@PostMapping("/cadastrar")
		public Endereco salvar(@RequestBody Endereco novoEndereco) throws CampoInvalidoException {
			return enderecoService.inserir(novoEndereco);
		}
		
		//Delete de enderecos 
		@DeleteMapping("/{id}")
		public boolean excluir(@PathVariable Integer id) {
			return enderecoService.excluir(id);
		}
		
		//Atualizar
		@PutMapping()
		public boolean atualizar(@RequestBody Endereco enderecoParaAtualizar) 
				throws CampoInvalidoException {
			return enderecoService.atualizar(enderecoParaAtualizar) != null;
		}
		
		
		
		//listar todos
		@GetMapping(path = "/todos")
		public List<Endereco> listarTodos(){
			List<Endereco> endereco = enderecoService.listarTodos();
			return endereco;
		}
}
