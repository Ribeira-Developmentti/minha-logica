package unico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

import fim.cinco.FimCinco;
import modelo.Volante;

public class SalvandoVolantes {

	public static void main(String[] args) {
		
		FimCinco fc = new FimCinco();
		List<Volante> volantes = fc.gerarVolantes();
		
		//for (Volante v : volantes) {
			try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("volantes.obj"))) {
				out.writeObject(volantes);
			//	System.out.println(v.getId() + " Salvo");
			} catch (IOException e) {
				System.err.println("Erro ao salvar ao objeto" + e.getMessage());
				e.printStackTrace();
			} 
		//}
	}
	
}
