package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Volante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private List<String> numeros;
	private int pontuacao;

	// Construtores.
	public Volante(String id) {
		this.id = id;
		this.numeros = new ArrayList<String>();
		this.pontuacao = 0;
	}

	public Volante(String id, ArrayList<String> numeros, int pontuacao) {
		this.id = id;
		this.numeros = numeros;
		this.pontuacao = pontuacao;
	}

	// Gets e Sets	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<String> dezenas) {
		this.numeros = dezenas;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	// Equals e Hashcode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeros == null) ? 0 : numeros.hashCode());
		result = prime * result + pontuacao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Volante other = (Volante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numeros == null) {
			if (other.numeros != null)
				return false;
		} else if (!numeros.equals(other.numeros))
			return false;
		if (pontuacao != other.pontuacao)
			return false;
		return true;
	}


}
