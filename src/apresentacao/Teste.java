package apresentacao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import negocio.Administrador;
import negocio.Cliente;
import negocio.Produto;
import negocio.Usuario;

public class Teste {

	private static Map<String, Usuario> mapUsers;
	private static Map<Integer, Produto> mapProdutos;
	private static int somaId = 0;
	private static Scanner scan;

	static {// instanciar as variáveis apenas quando a aplicação é iniciada
		scan = new Scanner(System.in);
		mapUsers = new HashMap<String, Usuario>();
		mapUsers.put("lucas", new Usuario(2, "Lucas", "lukasalvespod1@gmail.com", "lucas", "123"));
		mapUsers.put("ayrton", new Usuario(3, "Ayrton", "ayrton@gmail.com", "ayrton", "123"));
		mapUsers.put("jaicke", new Usuario(4, "Jaicke", "jaicke@gmail.com", "jaicke", "123"));
		mapUsers.put("matheus", new Usuario(5, "Matheus", "matheus@gmail.com", "matheus", "123"));

		mapProdutos = new HashMap<Integer, Produto>();
		mapProdutos.put(1, new Produto(1, "Bermuda Nike Dry", 74.99, "Nike", "Masculino"));
		mapProdutos.put(2, new Produto(2, "Camiseta Regata Nike Legend", 69.99, "Nike", "Masculino"));
		mapProdutos.put(3, new Produto(3, "Boné Aba Curva adidas", 44.99, "Nike", "Masculino"));
		mapProdutos.put(4, new Produto(4, "Mochila Nike Elemental", 99.99, "Nike", "Masculino"));
		mapProdutos.put(5, new Produto(5, "Tênis NIke Downshifter 7", 189.99, "Nike", "Masculino"));
		mapProdutos.put(6, new Produto(6, "Calça Legging Oxer Jogging", 39.99, "Oxer", "Feminino"));
		mapProdutos.put(7, new Produto(7, "Camiseta Oxer Cord II", 29.99, "Oxer", "Feminino"));
		mapProdutos.put(8, new Produto(8, "Tênis Oxer Agile", 59.99, "Oxer", "Feminino"));
		mapProdutos.put(9, new Produto(9, "Creatina Integralmedica - 300g", 37.90, "Integralmedica"));
		mapProdutos.put(10, new Produto(10, "Whey Protein Integralmedica Nutri - Chocolate - 1,8Kg", 79.85, "Integralmedica"));
		mapProdutos.put(11, new Produto(11, "Pré-Treino BodyAction - Uva com Blueberry - 100g", 48.58, "Integralmedica"));
		mapProdutos.put(12, new Produto(12, "Energético - Sabor Guaraná e Açaí - 30g", 2.90, "Probiótica"));
	}

	public static void main(String[] args) {

		boolean execucao = true;

		System.out.println("-------Cadastro-------");
		while (execucao) {
			int opcao = menu();
			if (opcao == 1) {
				Usuario usuarioLogado = login();
				if (usuarioLogado != null) {
					if (usuarioLogado instanceof Administrador) {
						menuAdmLogado();
					} else {
						menuClienteLogado();
					}
				}
				// cadastrar();
			} else if(opcao == 2) {
				cadastrar();
			} else if (opcao == 3) {
				listarCadastros();
			} else if (opcao == 4) {
				execucao = false;
			} else {
				System.out.println("Opção Inválida \n");
			}

		}
	}// fim do main

	public static void menuAdmLogado() {
		System.out.println("Bem-Vindo Admin.");
		cadastrar();
	}

	public static void menuClienteLogado() {
		System.out.println("Lista de Produtos");

		for (Produto key : mapProdutos.values()) {
			System.out.println("Id: " + key.getId() + "\n " + "Nome: " + key.getNome() + "\n " + " Preço: " + key.getPreco() + "\n " + "Marca: " + key.getMarca());

		}

	}

	public static int menu() {
		System.out.println("Selecione a opção:");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Usuario");
		System.out.println("3 - Listar cadastros");
		System.out.println("4 - Sair");

		int nextInt = scan.nextInt();
		scan.nextLine();// consumir o \n causado pelo nextInt (referencia:
						// https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input)
		return nextInt;

	}

	public static void cadastrar() {
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("--Cadastro de Dados do Usuario--");

			String nome = input("Digite o nome:");

			String email = input("Digite o e-mail:");

			System.out.println("--Cadastro de Login--");

			String login = input("Digite o Login de acesso: ");

			String senha = input("Digite a Senha de acesso: ");

			Usuario user = new Usuario();
			user.setNome(nome);
			user.setEmail(email);
			user.setLogin(login);
			user.setSenha(senha);

			String cadastrar = input("Confirmar cadastro (S/N)");

			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro realizado com sucesso.");

				if (somaId == 0) {
					user.setId(somaId++);
					Administrador admin = new Administrador();
					admin.setId(user.getId());
					admin.setNome(user.getNome());
					admin.setEmail(user.getEmail());
					admin.setLogin(user.getLogin());
					admin.setSenha(user.getSenha());

					mapUsers.put(user.getLogin(), admin);

				}

				user.setId(somaId++);

				Cliente cliente = new Cliente();
				cliente.setId(user.getId());
				cliente.setNome(user.getNome());
				cliente.setEmail(user.getEmail());
				cliente.setLogin(user.getLogin());
				cliente.setSenha(user.getSenha());
				mapUsers.put(user.getLogin(), cliente);

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

			System.out.println("Lista de Usuarios");

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

	private static Usuario login() {
		String login = input("Digite seu login:");
		String senha = input("Digite sua senha:");

		Usuario usuario = mapUsers.get(login);
		if (usuario.getSenha().equals(senha)) {
			return usuario;
		} else {
			System.out.println("Usuario ou senha invalido.");
			return null;
		}
	}

	public static String input(String text) {
		System.out.print(text);
		return scan.nextLine();
	}
}
