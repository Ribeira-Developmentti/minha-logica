package adm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import fim.cinco.FimCinco;
import modelo.Volante;
import util.Util;

public class Menu {

	private static List<Volante> todosVolantes = new ArrayList<>();
	private static Scanner in = new Scanner(System.in); 
	
	public static void main(String[] args) {
		controlador();
	}
	
	public static void controlador() {
		String opcao = menuInicial();
		
		if (opcao.equalsIgnoreCase("1")) {
			gerarTodosVolantes();
			imprimirTodosVolantes();
			
			System.out.println("+ s. Salvar Volantes                           +");
			System.out.println("+ m. Menu Inicial                              +");		
			
			
			String comando = null;
			boolean exibirMensagem = false;
			do {
				if (exibirMensagem == true) {
					System.out.println("Opção inválida.");
				}
				
				comando =  in.next();		
				exibirMensagem = true;
			} while ((comando == null) || (!comando.equalsIgnoreCase("s") && !comando.equalsIgnoreCase("m"))); 
				
			if(comando.equalsIgnoreCase("s")) {
				Util.salvarVolantes(todosVolantes);
				controlador();
			} else if(comando.equalsIgnoreCase("m")) {
				controlador();
			}
		} else if (opcao.equalsIgnoreCase("2")) {
			if(Util.carregarTodosVolantes().isEmpty()) {
				System.out.println("Nenhum volante salvo.");
				controlador();
			} else {
				todosVolantes = Util.carregarTodosVolantes();
				imprimirTodosVolantes();
				
				System.out.println("+ m. Menu Inicial                              +");		
				System.out.println("+ i. Imprimir TXT                              +");
				
				String comando = null;
				boolean exibirMensagem = false;
				do {
					if (exibirMensagem == true) {
						System.out.println("Opção inválida.");
					}
					
					comando =  in.next();		
					exibirMensagem = true;
				} while ((comando == null) || (!comando.equalsIgnoreCase("m") && !comando.equalsIgnoreCase("i"))); 
					
				if(comando.equalsIgnoreCase("m")) {
					controlador();
				} else if (comando.equalsIgnoreCase("i")) {
					Util.imprimirVolantesTXT(todosVolantes);
					controlador();
				}
				
					
			}
		} else if (opcao.equalsIgnoreCase("3")) {
			
		} else if (opcao.equalsIgnoreCase("4")) {
			
		} else if (opcao.equalsIgnoreCase("5")) {
			
		} 
	}
	
	private static void imprimirTodosVolantes() {
		System.out.println("================================================");
		for(Volante v : todosVolantes) {
			System.out.print(v.getId() + ": ");
			for(String numero : v.getNumeros()) {
				System.out.print(numero + " ");
			}
			System.out.println("");
		}
		System.out.println("================================================");
	}
	
	private static void gerarTodosVolantes() {
		FimCinco fc = new FimCinco();
		List<Volante> volantesComecoCinco = fc.gerarVolantes();
		for(Volante v : volantesComecoCinco) {
			todosVolantes.add(v);
		}				
	}
	
	private static String menuInicial() {
		todosVolantes = new ArrayList<>();
		
		String opcao = null;
		boolean exibirMensagem = false;
		
		System.out.println("+================ Minha Lógica ================+");
		System.out.println("+ 1. Gerar Volantes                            +");
		System.out.println("+ 2. Carregar Volantes                         +");
		System.out.println("+ 3. Conferir Volantes                         +");
		System.out.println("+ 4. Inserir Sorteio                           +");
		System.out.println("+ 5. Iprimir Volantes \"TXT\"                    +");
		System.out.println("+==============================================+");
		
		do {
			if (exibirMensagem == true) {
				System.out.println("Opção inválida.");
			}
			
			opcao =  in.next();		
			exibirMensagem = true;
		} while ((opcao == null) || (!opcao.equalsIgnoreCase("1") && !opcao.equalsIgnoreCase("2")
				&& !opcao.equalsIgnoreCase("3") && !opcao.equalsIgnoreCase("4")
				&& !opcao.equalsIgnoreCase("5"))); 
			
		return opcao;
	}
}
