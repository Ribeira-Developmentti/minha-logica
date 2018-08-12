package fim;

import java.util.ArrayList;
import java.util.List;
import modelo.Volante;
import util.Util;

public class FimCinco {

	private List<Volante> volantesGerados;
	private int quantidadeTrocaFechamento;
	private int quantidadeNumerosSortear;
	
	// Construtor.
	public FimCinco() {
		this.volantesGerados = new ArrayList<Volante>();
		this.setQuantidadeNumerosSortear(10);
		this.setQuantidadeTrocaFechamento(3);
	}
	
	public List<Volante> gerarVolantes() {
		setVolantesGerados(Util.sortearVolanteFechamento(Util.ids, Util.COMECO_CINCO_NUMEROS, 
		Util.FINAL_VOLANTES, getQuantidadeNumerosSortear(), getQuantidadeTrocaFechamento()));
		
		return volantesGerados; 
	}
	
	

	// Gets e Sets	
	public List<Volante> getVolantesGerados() {
		return volantesGerados;
	}

	public void setVolantesGerados(List<Volante> volantesGerados) {
		this.volantesGerados = volantesGerados;
	}

	public int getQuantidadeTrocaFechamento() {
		return quantidadeTrocaFechamento;
	}

	public void setQuantidadeTrocaFechamento(int quantidadeTrocaFechamento) {
		this.quantidadeTrocaFechamento = quantidadeTrocaFechamento;
	}

	public int getQuantidadeNumerosSortear() {
		return quantidadeNumerosSortear;
	}

	public void setQuantidadeNumerosSortear(int quantidadeNumerosSortear) {
		this.quantidadeNumerosSortear = quantidadeNumerosSortear;
	}
			
}
