package unico;

import java.util.List;

import fim.cinco.FimCinco;
import modelo.Volante;
import util.Util;

public class Teste2 {

	public static void main(String[] args) {
		FimCinco f = new FimCinco();
		
		List<Volante> list = f.gerarVolantes();
		String[] resultado = {"01", "02", "03", "04", "05", "09", "11", "12", "13", "17", "18", "19", "20",
							  "23", "24"};
		
		for (Volante v : list) {
			Util.conferirVolante(v, resultado);
			System.out.println("Id> " + v.getId());
			System.out.println("Pontuação> " + v.getPontuacao());
			for (String s : v.getNumeros()) {
				System.out.print(s + " ");
			}
			
			System.out.println("");
			System.out.println("--------------------------------------------");
		}
		
		
	}
	
}
