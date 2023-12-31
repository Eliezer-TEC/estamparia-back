package estampariaback.estamparia.dw.model.seletor;

import java.sql.Date;


public class PessoaSeletor {

	private Integer id;
	private int idEndereco;
	private String nome;
	private String cpf;
	private Date dtNascMaximo;
	private Date dtNascMinimo;

	private String email;
	private String ddd;
	private String telefone;
	private String senha;
	private Boolean funcionario;

	public PessoaSeletor() {
		super();
	}

	

	public Date getDtNascMaximo() {
		return dtNascMaximo;
	}



	public void setDtNascMaximo(Date dtNascMaximo) {
		this.dtNascMaximo = dtNascMaximo;
	}



	public Date getDtNascMinimo() {
		return dtNascMinimo;
	}



	public void setDtNascMinimo(Date dtNascMinimo) {
		this.dtNascMinimo = dtNascMinimo;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean isFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}

}
