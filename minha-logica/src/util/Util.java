package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import modelo.Resultado;
import modelo.Volante;

public class Util {

	public static final String[] FINAL_VOLANTES = { "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", "24", "25" };

	public static final String[] COMECO_CINCO_NUMEROS = { "01", "02", "03", "04", "05" };

	private static Random random = new Random();

	public static int ids = 1;

	public static List<Volante> sortearVolanteFechamento(int idVolante, String[] comecoVolante, String[] finalVolante,
			int quantidadeNumerosParaSortear, int quantidadeTrocaFechamento) {

		List<Volante> volantesGerados = new ArrayList<>();
		List<String> numerosSorteados = new ArrayList<>();
		List<String> finalVolanteLista = new ArrayList<>();
		int indiceNumeroEscolhido = 0;

		// Transformando o final dos volantes array em lista.
		for (String numero : finalVolante) {
			finalVolanteLista.add(numero);
		}

		// Sorteando a quantidade de números desejados para o fim do volante.
		for (int i = 1; i <= quantidadeNumerosParaSortear; i++) {
			indiceNumeroEscolhido = random.nextInt(finalVolanteLista.size());
			numerosSorteados.add(finalVolanteLista.get(indiceNumeroEscolhido));
			finalVolanteLista.remove(indiceNumeroEscolhido);
		}

		// Instanciando o volante sorteado.
		Volante volanteSorteado = new Volante(idVolante + "A");
		for (String numero : numerosSorteados) {
			volanteSorteado.getNumeros().add(numero);
		}
		inserirComeco(volanteSorteado, comecoVolante);
		ordenarVolante(volanteSorteado);
		volantesGerados.add(volanteSorteado);

		// Instanciando o volante fechado.

		// Trocando números.
		for (int i = 1; i <= quantidadeTrocaFechamento; i++) {
			int indiceNumeroSerTrocado = random.nextInt(finalVolanteLista.size());
			String numeroTroca = finalVolanteLista.get(indiceNumeroSerTrocado);
			finalVolanteLista.remove(indiceNumeroSerTrocado);
			numerosSorteados.remove(indiceNumeroSerTrocado);
			numerosSorteados.add(numeroTroca);
		}

		Volante volanteFechado = new Volante(idVolante + "B");
		Util.ids++; // Ao gerar um volante aumenta-se o último id;
		for (String numero : numerosSorteados) {
			volanteFechado.getNumeros().add(numero);
		}
		inserirComeco(volanteFechado, comecoVolante);
		ordenarVolante(volanteFechado);
		volantesGerados.add(volanteFechado);

		return volantesGerados;
	}

	public static void conferirVolante(Volante v, Resultado resultado) {
		for (String numero : resultado.getNumeros()) {
			for (String numero2 : v.getNumeros()) {
				if (numero.equals(numero2)) {
					int pontuacaoVolante = v.getPontuacao();
					pontuacaoVolante++;
					v.setPontuacao(pontuacaoVolante);
				}
			}
		}
	}

	private static Volante ordenarVolante(Volante v) {
		Collections.sort(v.getNumeros());
		return v;
	}

	private static Volante inserirComeco(Volante v, String[] comeco) {
		for (String numero : comeco) {
			v.getNumeros().add(numero);
		}
		return v;
	}

	public static void salvarVolantes(List<Volante> listaVolantes) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("volantes.obj"))) {
			out.writeObject(listaVolantes);
			System.out.println("+ Volantes salvos com sucesso.                 +");
		} catch (IOException e) {
			System.err.println("+ Erro ao salvar volantes.                     +" + e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Volante> carregarTodosVolantes() {
		List<Volante> volantes = new ArrayList<>();
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("volantes.obj"))) {
			volantes = (List<Volante>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			//e.printStackTrace();
			return volantes;
		}
		return volantes;
	}

	public static void imprimirVolantesTXT(List<Volante> todosVolantes) {
		try(PrintStream writer = new PrintStream("volantes_impressos.txt")){
			
			writer.println("++++++++++ Volantes Impressos em TXT +++++++++++");
			for (Volante vol : todosVolantes) {
				writer.println();
				String id = vol.getId();
				writer.print(id + ": ");
				for(String num : vol.getNumeros()) {
					writer.print(num + " ");
				}
				
			}
			writer.println();
			writer.println();
			writer.println("++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+ Volantes impressos com sucesso.              +");
		} catch (IOException e) {
			System.out.println("+ Não conseguiu gravar o arquivo.              +" + e.getMessage());
		}
	}
	
	public static void salvarResultado(Resultado r) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("resultado.obj"))) {
			out.writeObject(r);
			System.out.println("+ Resultado salvo com sucesso.                 +");
		} catch (IOException e) {
			System.err.println("+ Erro ao salvar resultado.                    +" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Resultado carregarResultado() {
		Resultado result = null; 
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("resultado.obj"))) {
			result = (Resultado) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			//e.printStackTrace();
			return result;
		}
		return result;
	}
	
}
