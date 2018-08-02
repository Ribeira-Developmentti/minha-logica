package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Resultado implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private List<String> numeros;
	
	public Resultado() {
		numeros = new ArrayList<>();
	}

	public Resultado(String id, List<String> numeros) {
		this.id = id;
		this.numeros = numeros;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getNumeros() {
		return numeros;
	}
	public void setNumeros(List<String> numeros) {
		this.numeros = numeros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeros == null) ? 0 : numeros.hashCode());
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
		Resultado other = (Resultado) obj;
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
		return true;
	}
	
	
	
}
