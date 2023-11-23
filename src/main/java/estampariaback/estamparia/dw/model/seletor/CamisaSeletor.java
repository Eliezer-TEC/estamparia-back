package estampariaback.estamparia.dw.model.seletor;

import java.util.List;

public class CamisaSeletor {

	private Integer id;

	private String cor;
	private String estampa;
	private Integer idModelo;
	private List<String> tamanhos;

	
	public CamisaSeletor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getEstampa() {
		return estampa;
	}

	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}

	public Integer getId_modelo() {
		return idModelo;
	}

	public void setId_modelo(Integer id_modelo) {
		this.idModelo = id_modelo;
	}

	public List<String> getTamanhos() {
		return tamanhos;
	}

	public void setTamanhos(List<String> tamanhos) {
		this.tamanhos = tamanhos;
	}

}
