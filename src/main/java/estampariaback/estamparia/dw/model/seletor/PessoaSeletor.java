package estampariaback.estamparia.dw.model.seletor;

import java.sql.Date;

import jakarta.persistence.Column;

public class PessoaSeletor {

	private Integer id;
	private int idEndereco;
	private String nome;
	private String cpf;
	@Column(name = "DT_NASC")
	private Date dtNasc;
	private String email;
	private String ddd;
	private String telefone;
	private String senha;
	private boolean funcionario;

	public PessoaSeletor() {
		super();
	}

	public PessoaSeletor(Integer id, int idEndereco, String nome, String cpf, Date dtNasc, String email, String ddd,
			String telefone, String senha, boolean funcionario) {
		super();
		this.id = id;
		this.idEndereco = idEndereco;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.email = email;
		this.ddd = ddd;
		this.telefone = telefone;
		this.senha = senha;
		this.funcionario = funcionario;
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

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
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

	public boolean isFuncionario() {
		return funcionario;
	}

	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}

}
