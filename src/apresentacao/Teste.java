package apresentacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import persistencia.Usuario;

public class Teste {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.main();
		
		/*Usuario usuario1 = new Usuario();
		usuario1.setNome("José");
		usuario1.setEmail("jose@gmail.com");
		usuario1.setLogin("jose123");
		usuario1.setSenha(123);
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("Maria");
		usuario2.setEmail("maria@gmail.com");
		usuario2.setLogin("maria123");
		usuario2.setSenha(123);
		
		Collection<Usuario> clientes = new ArrayList<>();
		clientes.add(usuario1);
		clientes.add(usuario2);
		
		Iterator<Usuario> it = clientes.iterator();
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}*/
	}

}
