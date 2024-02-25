package estampariaback.estamparia.dw.model.seletor;


public class PedidoSeletor {

	private Integer id;
	private String nome;
	private Double total;
	private String status;
	private Integer quantidade;
	private String cor;
	private String tamanho;
	private byte[] estampa;

	public PedidoSeletor() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public byte[] getEstampa() {
		return estampa;
	}

	public void setEstampa(byte[] estampa) {
		this.estampa = estampa;
	}
	
	
	

	

	
}
