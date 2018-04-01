package negocio;

import java.util.List;

public class Compra {

	public List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public double valorTotal() {

		double valor = 0;

		if (this.produtos.size() != 0) {
			for (Produto produto : produtos) {
				valor += produto.getPreco();
			}
		}

		return valor;
	}
}
