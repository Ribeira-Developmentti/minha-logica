package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import modelo.Volante;

public class Util {
	
	public static final String[] FINAL_VOLANTES = { "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", "24", "25" };
	
	public static final String[] COMECO_CINCO_NUMEROS = {"01", "02", "03", "04", "05"}; 
	
	private static Random random = new Random();
	
	public static int ids = 1;
	
	public static List<Volante> sortearVolanteFechamento(int idVolante, String[] comecoVolante, 
												  String[] finalVolante, int quantidadeNumerosParaSortear,
												  int quantidadeTrocaFechamento){
		
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
		Volante volanteSorteado = new Volante(idVolante);
	    Util.ids++; //Ao gerar um volante aumenta-se o último id;
		for (String numero : numerosSorteados) {
			volanteSorteado.getNumeros().add(numero);
		}
		inserirComeco(volanteSorteado, comecoVolante);
		ordenarVolante(volanteSorteado);
		volantesGerados.add(volanteSorteado);
		
		// Instanciando o volante fechado.
		
		// Trocando números.
		for(int i = 1; i <= quantidadeTrocaFechamento; i++) {
			int indiceNumeroSerTrocado = random.nextInt(finalVolanteLista.size());
			String numeroTroca = finalVolanteLista.get(indiceNumeroSerTrocado);
			finalVolanteLista.remove(indiceNumeroSerTrocado);
			numerosSorteados.remove(indiceNumeroSerTrocado);
			numerosSorteados.add(numeroTroca);
		}
		
		Volante volanteFechado = new Volante(Util.ids);
		Util.ids++; //Ao gerar um volante aumenta-se o último id;
		for (String numero : numerosSorteados) {
			volanteFechado.getNumeros().add(numero);
		}
		inserirComeco(volanteFechado, comecoVolante);
		ordenarVolante(volanteFechado);
		volantesGerados.add(volanteFechado);
		
		return volantesGerados;		
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
}
