package estampariaback.estamparia.dw.model.seletor;

public class CamisaSeletor {

	private Integer id;
	private String tamanhoMinimo;
	private String tamanhoMaximo;
	private String cor;
	private String estampa;

	private Integer idModelo;

	public CamisaSeletor(Integer id, String tamanhoMinimo, String tamanhoMaximo, String cor, String estampa,
			Integer idModelo) {
		super();
		this.id = id;
		this.tamanhoMinimo = tamanhoMinimo;
		this.tamanhoMaximo = tamanhoMaximo;
		this.cor = cor;
		this.estampa = estampa;
		this.idModelo = idModelo;
	}

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

	public String getTamanhoMinimo() {
		return tamanhoMinimo;
	}

	public void setTamanhoMinimo(String tamanhoMinimo) {
		this.tamanhoMinimo = tamanhoMinimo;
	}

	public String getTamanhoMaximo() {
		return tamanhoMaximo;
	}

	public void setTamanhoMaximo(String tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
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

}
