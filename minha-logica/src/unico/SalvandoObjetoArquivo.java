package unico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SalvandoObjetoArquivo {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("João");
		p.setIdade(34);
		p.setProfissao("Pedreiro");
		
		
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("pessoa.obj"))){
			out.writeObject(p);
			System.out.println("Objeto Salvo Com Sucesso.");
		} catch (IOException e) {
			System.err.println("Erro ao salvar ao objeto" + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
