package teste;

import java.util.List;

import fim.cinco.FimUm;
import modelo.Volante;

public class Testes {

	public static void main(String[] args) {
		FimUm fu = new FimUm();
		
		List<Volante> lista = fu.gerarVolantes();
		for(Volante v : lista) {
			System.out.println(v.getId());
		}
	}

}
