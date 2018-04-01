package apresentacao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import negocio.Administrador;
import negocio.Cliente;
import negocio.Usuario;

public class Teste {

	private static Map<String, Usuario> mapUsers;
	private static Long somaId = 0L;
	private static Scanner scan;

	static {
		mapUsers = new HashMap<String, Usuario>();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {

		boolean execucao = true;

		System.out.println("-------Cadastro-------");
		while (execucao) {
			int opcao = menu();
			if (opcao == 1) {
				cadastrar();
			} else if (opcao == 2) {
				listarCadastros();
			} else if (opcao == 3) {
				execucao = false;
			} else if (opcao == 4) {
				Usuario usuarioLogado = login();
				if (usuarioLogado != null) {
					if (usuarioLogado instanceof Administrador) {
						// menuAdministrador
					} else {
						// menuCliente
					}
				}
			} else {
				System.out.println("Opção Inválida \n");
			}
		}
	}

	public static int menu() {
		System.out.println("Selecione a opção:");
		System.out.println("1 - Novo cadastro");
		System.out.println("2 - Listar cadastros");
		System.out.println("3 - Sair");
		System.out.println("4 - Login");

		int nextInt = scan.nextInt();
		scan.nextLine();// consumir o \n causado pelo nextInt (referencia:
						// https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input)
		return nextInt;

	}

	private static Usuario login() {
		String login = input("Digite seu login:");
		String senha = input("Digite sua senha:");

		Usuario usuario = mapUsers.get(login);
		if (usuario.getSenha().equals(senha)) {
			return usuario;
		} else {
			return null;
		}
	}

	public static void cadastrar() {
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("--Cadastro de Dados do Usuario--");

			String nome = input("Digite o nome:");
			String email = input("Digite o e-mail:");

			Usuario user = new Usuario();
			user.setNome(nome);
			user.setEmail(email);

			System.out.println("--Cadastro de Login--");
			user.setLogin(input("Digite o Login de acesso: "));
			user.setSenha(input("Digite a Senha de acesso: "));

			String cadastrar = input("Confirmar cadastro (S/N)");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro realizado com sucesso.");
				user.setId(somaId++);

				if (somaId == 0) {
					Administrador admin = new Administrador();
					mapUsers.put(user.getLogin(), admin);
				}

				mapUsers.put(user.getLogin(), new Cliente());

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

	public static void listarCadastros() {
		if (mapUsers.size() == 0) {
			System.out.println("Não existe usuários cadastrados.");
		} else {

			Iterator<Entry<String, Usuario>> iterator = mapUsers.entrySet().iterator();

			System.out.println("Lista de Clientes");

			while (iterator.hasNext()) {
				Entry<String, Usuario> userMap = iterator.next();
				Usuario user = userMap.getValue();
				System.out.println("Id: " + user.getId());
				System.out.println("Nome: " + user.getNome());
				System.out.println("Login: " + user.getLogin());
				System.out.println();
			}
			System.out.println("---");
		}

	}

	public static String input(String text) {
		System.out.print(text);
		return scan.nextLine();
	}
}
