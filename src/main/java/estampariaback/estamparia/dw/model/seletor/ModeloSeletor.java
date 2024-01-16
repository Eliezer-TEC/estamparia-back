package estampariaback.estamparia.dw.model.seletor;

import java.time.LocalDate;



public class ModeloSeletor {

	private Integer id;
	private String nome;
	private Double custo;
	private Double valorVenda;

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
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
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
