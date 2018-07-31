package unico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Teste3 {

	public static void main(String[] args) {
		
		String[] mails = {"joao@joao.com", "maria@maria.com", "ricardo@ricardo.com"};
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("emails.txt", true))){
			 
			for (String mail : mails) {
				writer.write(mail);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Não conseguiu gravar o arquivo." + e.getMessage());
		} 
		
		try(PrintStream writer = new PrintStream("emails.txt")){
			 
			for (String mail : mails) {
				writer.println(mail);
			}
		} catch (IOException e) {
			System.out.println("Não conseguiu gravar o arquivo." + e.getMessage());
		}

		
	}

}
