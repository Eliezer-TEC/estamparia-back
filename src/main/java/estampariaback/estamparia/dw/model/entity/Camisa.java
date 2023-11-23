package estampariaback.estamparia.dw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "camisa")
@NoArgsConstructor

public class Camisa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tamanho;
	private String cor;
	private byte[] estampa;
	private Integer idModelo;
	@Column(name = "NOME_ARQUIVO")
	private String nomeArquivo;

	//@JsonBackReference
	//@OneToMany(mappedBy = "camisa")

	public Camisa() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	public Camisa(Integer id, String tamanho, String cor, byte[] estampa, Integer idModelo, String nomeArquivo) {
		super();
		this.id = id;
		this.tamanho = tamanho;
		this.cor = cor;
		this.estampa = estampa;
		this.idModelo = idModelo;
		this.nomeArquivo = nomeArquivo;
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getId_modelo() {
		return idModelo;
	}

	public void setId_modelo(int id_modelo) {
		this.idModelo = id_modelo;
	}
	
	

}
