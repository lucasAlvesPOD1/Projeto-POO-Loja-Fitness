package negocio;

public class Cliente extends Usuario {

	public Cliente(int id, String nome, String email, String login, String senha) {
		super(id, nome, email, login, senha);
	}

	
	public Cliente() {
		
	}

	public Compra compra;

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}
