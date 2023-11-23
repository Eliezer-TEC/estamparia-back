package estampariaback.estamparia.dw.model.seletor;

import jakarta.persistence.Column;

public class PedidoSeletor {

	private Integer id;
	@Column(name = "ID_PESSOA")
	private int idPessoa;

	@Column(name = "ID_CAMISA")
	private int idCamisa;

	@Column(name = "ID_ENDERECO")
	private int idEndereco;
	private Double totalMinimo;
	private Double totalMaximo;

	@Column(name = "STATUS_PEDIDO")
	private String status;

	private Double quantidadeMinima;
	private Double quantidadeMaxima;

	public PedidoSeletor() {
		super();
	}

	public Double getTotalMinimo() {
		return totalMinimo;
	}

	public void setTotalMinimo(Double totalMinimo) {
		this.totalMinimo = totalMinimo;
	}

	public Double getTotalMaximo() {
		return totalMaximo;
	}

	public void setTotalMaximo(Double totalMaximo) {
		this.totalMaximo = totalMaximo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getIdCamisa() {
		return idCamisa;
	}

	public void setIdCamisa(int idCamisa) {
		this.idCamisa = idCamisa;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(Double quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	public Double getQuantidadeMaxima() {
		return quantidadeMaxima;
	}

	public void setQuantidadeMaxima(Double quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}

}
