package estampariaback.estamparia.dw.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

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
import estampariaback.estamparia.dw.model.seletor.CamisaSeletor;
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
			InputStream inputStream = foto.getInputStream();
			novaCamisa.setEstampa(foto.getBytes());
			novaCamisa.setNomeArquivo(foto.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return camisaService.inserir(novaCamisa);
	}

	// Delete de camisas
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
	    Camisa camisaExistente = camisaService.buscarPorId(id);
	    if(camisaExistente != null) {
	    	return	camisaService.excluir(id);
	    }
		return false;

	}

	// Atualizar
	@PutMapping("/atualizar")
	public boolean atualizar(Camisa produtoParaAtualizar, @RequestParam("foto") MultipartFile foto)
	        throws CampoInvalidoException {
	    // Verificar se a camisa com o ID fornecido existe no banco de dados
	    Camisa camisaExistente = camisaService.buscarPorId(produtoParaAtualizar.getId());

	    if (camisaExistente != null) {
	        try {
	            produtoParaAtualizar.setEstampa(foto.getBytes());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return camisaService.atualizar(produtoParaAtualizar) != null;
	    } else {
	       
	        return false;
	    }
	}

	// listar todos
	@GetMapping(path = "/todos")
	public List<Camisa> listarTodos() {
		List<Camisa> camisas = camisaService.listarTodos();
		return camisas;
	}
	
	@PostMapping("/filtro")
	public List<Camisa> listarComSeletor(@RequestBody CamisaSeletor seletor){
		return camisaService.listarComSeletor(seletor);
	}
	
//	@GetMapping("/{id}")
//	public Camisa consultarPorId(@PathVariable Integer id) {   //PATH VARIABLE PERMITE PESQUISAR NA URL DIRETO COM O NÚMERO
//		return camisaService.consultarPorId(id.longValue());
//	}
	
	@PostMapping
    public ResponseEntity<String> uploadArquivo(@RequestParam("file") MultipartFile file) {
        camisaService.salvarArquivo(file);
        return ResponseEntity.ok("Arquivo salvo com sucesso!");
    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<byte[]> downloadArquivo(@PathVariable Integer id) {
	        byte[] camisa = camisaService.carregarArquivo(id);
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentDispositionFormData("attachment", "estampa.bin");
	        
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=camisa.bin")
	                .body(camisa);
	    }
	
	

}
