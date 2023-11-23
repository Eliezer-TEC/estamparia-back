package estampariaback.estamparia.dw.model.seletor;

import java.time.LocalDate;

import jakarta.persistence.Column;


public class ModeloSeletor {

	private Integer id;
	private Double valorVendaMinimo;
	private Double valorVendaMaximo;
	private Double custo;

	@Column(name = "DT_CADASTRO")
	private LocalDate dataCadastro;
	@Column(name = "DT_FIM_VIGENCIA")
	private LocalDate dataFimVigencia;

	public ModeloSeletor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeloSeletor(Integer id, Double valorVendaMinimo, Double valorVendaMaximo, Double custo,
			LocalDate dataCadastro, LocalDate dataFimVigencia) {
		super();
		this.id = id;
		this.valorVendaMinimo = valorVendaMinimo;
		this.valorVendaMaximo = valorVendaMaximo;
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

	public Double getValorVendaMinimo() {
		return valorVendaMinimo;
	}

	public void setValorVendaMinimo(Double valorVendaMinimo) {
		this.valorVendaMinimo = valorVendaMinimo;
	}

	public Double getValorVendaMaximo() {
		return valorVendaMaximo;
	}

	public void setValorVendaMaximo(Double valorVendaMaximo) {
		this.valorVendaMaximo = valorVendaMaximo;
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
