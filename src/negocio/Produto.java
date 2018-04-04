package negocio;

public class Produto {

	public int id;
	public String nome;
	public double preco;
	public String marca;
	public String sexo;

	public Produto(int id, String nome, double preco, String marca) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
	}

	public Produto(int id, String nome, double preco, String marca, String sexo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
