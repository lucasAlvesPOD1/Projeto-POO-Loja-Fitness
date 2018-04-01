package negocio;

public class Usuario {

	private Long id;
	private String nome;
	private String email;
	private String login;
	private String senha;

	protected boolean execucao;

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome.toString().toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email.toString().toUpperCase();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login.toString().toUpperCase();
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
