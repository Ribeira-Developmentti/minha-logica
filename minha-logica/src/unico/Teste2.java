package unico;

import java.util.List;

import fim.cinco.FimCinco;
import modelo.Volante;

public class Teste2 {

	public static void main(String[] args) {
		FimCinco f = new FimCinco();
		
		List<Volante> list = f.gerarVolantes();

		for (Volante v : list) {
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
