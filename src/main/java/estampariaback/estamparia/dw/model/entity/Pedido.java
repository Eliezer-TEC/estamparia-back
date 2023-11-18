package estampariaback.estamparia.dw.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int idPessoa;
	private int idCamisa;
	private int idEndereco;
	private double total;
	private String status;

	
	public Pedido() {
		super();
	}
	public Pedido(Integer id, int idPessoa, int idCamisa, int idEndereco, double total, String status) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.idCamisa = idCamisa;
		this.idEndereco = idEndereco;
		this.total = total;
		this.status = status;
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
	
	
	
	

}
