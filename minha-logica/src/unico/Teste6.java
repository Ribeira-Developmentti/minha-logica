package unico;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.List;

import modelo.Volante;
import util.Util;

public class Teste6 {

	public static void main(String[] args) {
		String[] resultado = {"01", "02", "03", "04", "05", "09", "11", "12", "13", "17", "18", "19", "20",
				  "23", "24"};
		
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("volantes.obj"))){
			@SuppressWarnings("unchecked")
			List<Volante> volantes = (List<Volante>) in.readObject();
			
			for (Volante v : volantes) {
				
				Util.conferirVolante(v, resultado);
				System.out.println("Id> " + v.getId());
				System.out.println("Pontuação> " + v.getPontuacao());
				for (String s : v.getNumeros()) {
					System.out.print(s + " ");
				}
				
				System.out.println("");
				System.out.println("--------------------------------------------");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
