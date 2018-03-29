package persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import negocio.IExibir;

public class Usuario implements IExibir {

	private String nome;
	private String email;
	private String login;
	private String senha;

	private Scanner scan;
	private boolean execucao;
	private Collection<Usuario> listaClientes;

	public Usuario() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
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

	@Override
	public String toString() {
		return "Cliente: nome=" + nome + ", \n \tlogin=" + login + "";
	}

	@Override
	public void main() {
		scan = new Scanner(System.in);
		execucao = true;
		listaClientes = new ArrayList<Usuario>();

		System.out.println("-------Cadastro-------");
		while (execucao) {
			int opcao = menu();
			if (opcao == 1) {
				cadastrar();
			} else if (opcao == 2) {
				listarCadastros();
			} else if (opcao == 3) {
				execucao = false;
			} else {
				System.out.println("Opção Inválida \n");
			}
		}

	}

	@Override
	public int menu() {
		System.out.println("Selecione a opção:");
		System.out.println("1 - Novo cadastro");
		System.out.println("2 - Listar cadastros");
		System.out.println("3 - Sair");

		return scan.nextInt();

	}

	@Override
	public void cadastrar() {
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("--Cadastro de Dados do Usuario--");

			Usuario user = new Usuario();
			user.setNome(input("Digite o nome: "));
			user.setEmail(input("Digite o e-mail:"));

			System.out.println("--Cadastro de Login--");
			user.setLogin(input("Digite o Login de acesso: "));
			user.setSenha(input("Digite a Senha de acesso: "));

			String cadastrar = input("Confirmar cadastro (S/N)");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro realizado com sucesso.");
				listaClientes.add(user);
			} else if (cadastrar.equalsIgnoreCase("n")) {
				System.out.println("Cadastro negado.");
			} else {
				System.out.println("Opção inválida.");
			}

			String continuar = input("Deseja cadastrar mais um usuário (S/N) ?");
			if (continuar.equalsIgnoreCase("s")) {

			} else if (continuar.equalsIgnoreCase("n")) {
				cadastrando = false;
			} else {
				System.out.println("Opção inválida.");
				cadastrando = false;
			}

		}

	}

	@Override
	public void listarCadastros() {
		if (listaClientes.size() == 0) {
			System.out.println("Não existe usuários cadastrados.");
		} else {
			System.out.println("Lista de Clientes");
			for (int i = 0; i < listaClientes.size(); i++) {
				Usuario user = ((ArrayList<Usuario>) listaClientes).get(i);
				System.out.println("Id: " + i);
				System.out.println("Nome: " + user.getNome());
				System.out.println("Login: " + user.getLogin());

			}
			System.out.println();
		}

	}

	@Override
	public String input(String text) {
		System.out.println(text);
		return scan.nextLine();
	}

}
