package estampariaback.estamparia.dw.model.entity;

import java.util.List;


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
	private String cpr;
	private String estampa;

	private int id_modelo;

	//@JsonBackReference
	//@OneToMany(mappedBy = "camisa")

	public Camisa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Camisa(Integer id, String tamanho, String cpr, String estampa, int id_modelo) {
		super();
		this.id = id;
		this.tamanho = tamanho;
		this.cpr = cpr;
		this.estampa = estampa;
		this.id_modelo = id_modelo;
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

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public String getEstampa() {
		return estampa;
	}

	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}

	public int getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}
	
	

}
