package estampariaback.estamparia.dw.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Camisa;
import estampariaback.estamparia.dw.service.CamisaService;

@RestController
@RequestMapping(path = "/api/camisa")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class CamisaController {

	@Autowired
	private CamisaService camisaService;

	// Cadastro de camisas
	@PostMapping("/cadastrar")
	public Camisa salvar(Camisa novaCamisa, @RequestParam("foto") MultipartFile foto) throws CampoInvalidoException {
		try {
			novaCamisa.setEstampa(foto.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return camisaService.inserir(novaCamisa);
	}

	// Delete de camisas
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return camisaService.excluir(id);
	}

	// Atualizar
	@PutMapping("/atualizar")
	public boolean atualizar(Camisa produtoParaAtualizar, @RequestParam("foto") MultipartFile foto)
			throws CampoInvalidoException {
		try {
			produtoParaAtualizar.setEstampa(foto.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return camisaService.atualizar(produtoParaAtualizar) != null;
	}

	// listar todos
	@GetMapping(path = "/todos")
	public List<Camisa> listarTodos() {
		List<Camisa> camisas = camisaService.listarTodos();
		return camisas;
	}

}