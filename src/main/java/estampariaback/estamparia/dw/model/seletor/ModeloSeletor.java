package estampariaback.estamparia.dw.model.seletor;

import java.time.LocalDate;



public class ModeloSeletor {

	private Integer id;
	private Double valorVendaMinimo;
	private Double valorVendaMaximo;
	private Double custoMinimo;
	private Double custoMaximo;
	private LocalDate dataFimVigenciaMinimo;
	private LocalDate dataFimVigenciaMaximo;
	private LocalDate dataCadastroMinimo;
	private LocalDate dataCadastroMaximo;


	public ModeloSeletor() {
		super();
		// TODO Auto-generated constructor stub
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


	public Double getCustoMinimo() {
		return custoMinimo;
	}


	public void setCustoMinimo(Double custoMinimo) {
		this.custoMinimo = custoMinimo;
	}


	public Double getCustoMaximo() {
		return custoMaximo;
	}


	public void setCustoMaximo(Double custoMaximo) {
		this.custoMaximo = custoMaximo;
	}


	public LocalDate getDataFimVigenciaMinimo() {
		return dataFimVigenciaMinimo;
	}


	public void setDataFimVigenciaMinimo(LocalDate dataFimVigenciaMinimo) {
		this.dataFimVigenciaMinimo = dataFimVigenciaMinimo;
	}


	public LocalDate getDataFimVigenciaMaximo() {
		return dataFimVigenciaMaximo;
	}


	public void setDataFimVigenciaMaximo(LocalDate dataFimVigenciaMaximo) {
		this.dataFimVigenciaMaximo = dataFimVigenciaMaximo;
	}


	public LocalDate getDataCadastroMinimo() {
		return dataCadastroMinimo;
	}


	public void setDataCadastroMinimo(LocalDate dataCadastroMinimo) {
		this.dataCadastroMinimo = dataCadastroMinimo;
	}


	public LocalDate getDataCadastroMaximo() {
		return dataCadastroMaximo;
	}


	public void setDataCadastroMaximo(LocalDate dataCadastroMaximo) {
		this.dataCadastroMaximo = dataCadastroMaximo;
	}


}
