package adm;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fim.cinco.FimCinco;
import modelo.Resultado;
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
					System.out.println("+ Opção inválida.                              +");
				}

				comando = in.next();
				exibirMensagem = true;
			} while ((comando == null) || (!comando.equalsIgnoreCase("s") && !comando.equalsIgnoreCase("m")));

			if (comando.equalsIgnoreCase("s")) {
				Util.salvarVolantes(todosVolantes);
				controlador();
			} else if (comando.equalsIgnoreCase("m")) {
				controlador();
			}
		} else if (opcao.equalsIgnoreCase("2")) {
			if (Util.carregarTodosVolantes().isEmpty()) {
				System.out.println("+ Nenhum volante salvo.                        +");
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
						System.out.println("+ Opção inválida.                              +");
					}

					comando = in.next();
					exibirMensagem = true;
				} while ((comando == null) || (!comando.equalsIgnoreCase("m") && !comando.equalsIgnoreCase("i")));

				if (comando.equalsIgnoreCase("m")) {
					controlador();
				} else if (comando.equalsIgnoreCase("i")) {
					Util.imprimirVolantesTXT(todosVolantes);
					controlador();
				}

			}
		} else if (opcao.equalsIgnoreCase("3")) {
			Resultado resultado = Util.carregarResultado();
			if (resultado == null) {
				System.out.println("+ Nenhum sorteio salvo na base de dados.       +");
				controlador();
			} else {
				todosVolantes = Util.carregarTodosVolantes();
				
				if(todosVolantes.isEmpty()) {
					System.out.println("+ Nenhum volante para conferir.                +");
					controlador();
				} else {
					int p11 = 0;
					int p12 = 0;
					int p13 = 0;
					int p14 = 0;
					int p15 = 0;
					for (Volante v : todosVolantes) {
						Util.conferirVolante(v, resultado);
						if (v.getPontuacao() == 11) {
							p11++;
						}
						if (v.getPontuacao() == 12) {
							p11++;
						}
						if (v.getPontuacao() == 13) {
							p11++;
						}
						if (v.getPontuacao() == 14) {
							p11++;
						}
						if (v.getPontuacao() == 15) {
							p11++;
						}
					}
					System.out.println("================================================");
					imprimirVolantePontuacao();
					System.out.println("================================================");
					System.out.println("+ Relatório de pontuação                       +");
					System.out.println("+ 11 pontos: " + p11 + "                                 +");
					System.out.println("+ 12 pontos: " + p12 + "                                 +");
					System.out.println("+ 13 pontos: " + p13 + "                                 +");
					System.out.println("+ 14 pontos: " + p14 + "                                 +");
					System.out.println("+ 15 pontos: " + p15 + "                                 +");
					System.out.println("================================================");
	
					System.out.println("+ m. Menu Inicial                              +");
					System.out.println("+ i. Imprimir TXT                              +");
	
					String comando = null;
					boolean exibirMensagem = false;
					do {
						if (exibirMensagem == true) {
							System.out.println("+ Opção inválida.                              +");
						}
	
						comando = in.next();
						exibirMensagem = true;
					} while ((comando == null) || (!comando.equalsIgnoreCase("m") && !comando.equalsIgnoreCase("i")));
	
					if (comando.equalsIgnoreCase("m")) {
						controlador();
					} else if (comando.equalsIgnoreCase("i")) {
						try (PrintStream writer = new PrintStream("relatorio.txt")) {
	
							writer.println("Relat. de Pontos");
							writer.println();
							writer.println("11 pontos: " + p11);
							writer.println("12 pontos: " + p12);
							writer.println("13 pontos: " + p13);
							writer.println("14 pontos: " + p14);
							writer.println("15 pontos: " + p15);
	
							System.out.println("+ Relatório impresso com sucesso.              +");
						} catch (IOException e) {
							System.out.println("+ Não conseguiu gravar o arquivo.              +" + e.getMessage());
						}
						controlador();
					}
				}

			}

		} else if (opcao.equalsIgnoreCase("4")) {

			Resultado resultado = new Resultado();
			System.out.println("+ Concurso:                                    +");
			resultado.setId(in.next());
			System.out.println("+ Números do concurso:                         +");
			while (resultado.getNumeros().size() != 15) {
				System.out.println(
						"+ Falta " + (15 - resultado.getNumeros().size()) + " números.                            +");
				resultado.getNumeros().add(in.next());
			}
			System.out.println("================= DETALHAMENTO =================");
			System.out.println("+ Concurso: " + resultado.getId() + "                                  +");
			for (String s : resultado.getNumeros()) {
				System.out.print(s + " ");
			}
			System.out.println();

			System.out.println("+ m. Menu Inicial                              +");
			System.out.println("+ s. Salvar Resultado                          +");

			String comando = null;
			boolean exibirMensagem = false;
			do {
				if (exibirMensagem == true) {
					System.out.println("+ Opção inválida.                              +");
				}

				comando = in.next();
				exibirMensagem = true;
			} while ((comando == null) || (!comando.equalsIgnoreCase("m") && !comando.equalsIgnoreCase("s")));

			if (comando.equalsIgnoreCase("m")) {
				controlador();
			} else if (comando.equalsIgnoreCase("s")) {
				Util.salvarResultado(resultado);
				controlador();
			}

		} else if (opcao.equalsIgnoreCase("5")) {
			List<Volante> volantes = Util.carregarTodosVolantes();
			if (volantes.isEmpty()) {
				System.out.println("+ Nenhum volante para imprimir.                +");
				controlador();
			} else {
				Util.imprimirVolantesTXT(volantes);
				controlador();
			}
		}
	}

	private static void imprimirVolantePontuacao() {
		for (Volante v : todosVolantes) {
			System.out.print(v.getId() + ": ");
			for (String numero : v.getNumeros()) {
				System.out.print(numero + " ");
			}
			System.out.println(": " + v.getPontuacao() + "pts");
		}
	}

	private static void imprimirTodosVolantes() {
		System.out.println("================================================");
		for (Volante v : todosVolantes) {
			System.out.print(v.getId() + ": ");
			for (String numero : v.getNumeros()) {
				System.out.print(numero + " ");
			}
			System.out.println("");
		}
		System.out.println("================================================");
	}

	private static void gerarTodosVolantes() {
		FimCinco fc = new FimCinco();
		List<Volante> volantesComecoCinco = fc.gerarVolantes();
		for (Volante v : volantesComecoCinco) {
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

			opcao = in.next();
			exibirMensagem = true;
		} while ((opcao == null) || (!opcao.equalsIgnoreCase("1") && !opcao.equalsIgnoreCase("2")
				&& !opcao.equalsIgnoreCase("3") && !opcao.equalsIgnoreCase("4") && !opcao.equalsIgnoreCase("5")));

		return opcao;
	}
}
