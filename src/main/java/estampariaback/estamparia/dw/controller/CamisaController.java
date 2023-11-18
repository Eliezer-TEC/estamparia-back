package estampariaback.estamparia.dw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Camisa;
import estampariaback.estamparia.dw.service.CamisaService;


@RestController
@RequestMapping(path = "/api/camisa")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class CamisaController {
	
	@Autowired
	private CamisaService camisaService;
	
	@PostMapping("/cadastrar")
	public Camisa salvar(@RequestBody Camisa novaCamisa) throws CampoInvalidoException {
		return camisaService.inserir(novaCamisa);
	}
}
