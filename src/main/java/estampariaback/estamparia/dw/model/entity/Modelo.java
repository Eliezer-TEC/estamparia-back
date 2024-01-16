package estampariaback.estamparia.dw.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modelo")
public class Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	@Column(name = "VALOR_VENDA")
	private Double valorVenda;
	private Double custo;
	private String nome;

	@Column(name = "DT_CADASTRO")
	private LocalDate dataCadastro;
	@Column(name = "DT_FIM_VIGENCIA")
	private LocalDate dataFimVigencia;

	public Modelo() {
		super();
	}

	public Modelo(Integer id, Double valorVenda, Double custo, String nome, LocalDate dataCadastro,
			LocalDate dataFimVigencia) {
		super();
		this.id = id;
		this.valorVenda = valorVenda;
		this.custo = custo;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataFimVigencia = dataFimVigencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}

