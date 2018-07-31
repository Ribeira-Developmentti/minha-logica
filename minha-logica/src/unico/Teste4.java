package unico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Teste4 {

	public static void main(String[] args) {
	
		try(BufferedReader reader = new BufferedReader(new FileReader("emails.txt"))){
			
			String email = null;
			while ((email = reader.readLine()) != null) {
				System.out.println(email);
			}
		} catch (IOException e) {
			System.out.println("Não foi possível ler o arquivo." + e.getMessage());
		}

	}

}
