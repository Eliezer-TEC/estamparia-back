package estampariaback.estamparia.dw.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modelo")
@NoArgsConstructor

public class Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valorVenda;
	private Double custo;
	private LocalDate dataCadastro;
	private LocalDate dataFimVigencia;

	// @OneToMany(mappedBy = "modelo")

	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modelo(Integer id, Double valorVenda, Double custo, LocalDate dataCadastro, LocalDate dataFimVigencia) {
		super();
		this.id = id;
		this.valorVenda = valorVenda;
		this.custo = custo;
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

}
