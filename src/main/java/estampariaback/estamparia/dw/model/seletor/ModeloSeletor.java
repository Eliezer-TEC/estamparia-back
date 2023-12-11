package estampariaback.estamparia.dw.model.seletor;

import java.time.LocalDate;



public class ModeloSeletor {

	private Integer id;
	private String nome;
	private Double custo;
	private Double valorVenda;
	
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

	
	
}
