package unico;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class DescerialzandoObjeto {

	public static void main(String[] args) {
		
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("pessoa.obj"))){
			Pessoa p = (Pessoa) in.readObject();
			System.out.println("NOME: " + p.getNome());
			System.out.println("IDADE: " + p.getIdade());
			System.out.println("PROFISSÃO: " + p.getProfissao());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
