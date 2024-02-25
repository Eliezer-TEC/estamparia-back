package estampariaback.estamparia.dw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ID_PESSOA")
	private int idPessoa;

	private double total;

	@Column(name = "STATUS_PEDIDO")
	private String status;

	@Column(name = "QUANTIDADE")
	private Double quantidade;

	// adicionar os campos de pedido
	@Column(name = "TAMANHO")
	private String tamanho;
	@Column(name = "COR")
	private String cor;
	
	@Column(name = "ESTAMPA")
	@Lob
	private byte[] estampa;
	@Column(name = "ID_MODELO")
	private Integer idModelo;
	@Column(name = "NOME_ARQUIVO")
	private String nomeArquivo;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, int idPessoa, double total, String status, Double quantidade, String tamanho, String cor,
			byte[] estampa, Integer idModelo, String nomeArquivo) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.total = total;
		this.status = status;
		this.quantidade = quantidade;
		this.tamanho = tamanho;
		this.cor = cor;
		this.estampa = estampa;
		this.idModelo = idModelo;
		this.nomeArquivo = nomeArquivo;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public byte[] getEstampa() {
		return estampa;
	}

	public void setEstampa(byte[] estampa) {
		this.estampa = estampa;
	}

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	
}