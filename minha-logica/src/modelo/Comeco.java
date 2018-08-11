package modelo;

import java.util.Arrays;

public class Comeco {
	
	private String[] numeros;

	public Comeco() {
		super();
	}

	public Comeco(String[] numeros) {
		super();
		this.numeros = numeros;
	}

	public String[] getNumeros() {
		return numeros;
	}

	public void setNumeros(String[] numeros) {
		this.numeros = numeros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(numeros);
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
		Comeco other = (Comeco) obj;
		if (!Arrays.equals(numeros, other.numeros))
			return false;
		return true;
	}

	
	
}
