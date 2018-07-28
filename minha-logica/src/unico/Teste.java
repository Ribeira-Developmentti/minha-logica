package unico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import util.Util;



public class Teste {

	public static void main(String[] args) {
		
		String[] comecoCincoNumeros = Util.COMECO_CINCO_NUMEROS; 
		String[] restoCincoNumeros = Util.FINAL_VOLANTES;
		
		List<String> resto = new ArrayList<>();
		for(int i=0; i<restoCincoNumeros.length; i++) {
			resto.add(restoCincoNumeros[i]);
		}
		
		int indice;
		Random r = new Random();
		List<String> escolhidos = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			indice = r.nextInt(resto.size());
			escolhidos.add(resto.get(indice));
			resto.remove(indice);
		}
		
		List<String> volante01 = new ArrayList<>();
		List<String> volante02 = new ArrayList<>();
		
		for (String string : escolhidos) {
			volante01.add(string);
		}
		
		// comando para trocar pedras
		for(int i = 1; i <= 6; i++) {
			int indEscolhido = r.nextInt(resto.size());
			String numeroTroca = resto.get(indEscolhido);
			resto.remove(indEscolhido);
			escolhidos.remove(indEscolhido);
			escolhidos.add(numeroTroca);
		}
		
		for (String string : escolhidos) {
			volante02.add(string);
		}
		
		for (String string : comecoCincoNumeros) {
			volante01.add(string);
		}
		for (String string : comecoCincoNumeros) {
			volante02.add(string);
		}
		
		
		
		Collections.sort(volante01);
		Collections.sort(volante02);
		
		for (String string : volante01) {
			System.out.print(string + " - ");
		}
		System.out.println();
		for (String string : volante02) {
			System.out.print(string + " - ");
		}
		
		
	}

}

