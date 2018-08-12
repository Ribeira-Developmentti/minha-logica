package fim;

import java.util.ArrayList;
import java.util.List;

import modelo.Comeco;
import modelo.Volante;
import util.Util;

public class FimUm {

	private List<Volante> volantesGerados;
	private int quantidadeTrocaFechamento;
	private int quantidadeNumerosSortear;
	private List<Comeco> comecos;

	private String[] comeco01 = { "01" };
	private String[] comeco02 = { "02" };
	private String[] comeco03 = { "03" };
	private String[] comeco04 = { "04" };
	private String[] comeco05 = { "05" };

	// Construtor.
	public FimUm() {
		this.volantesGerados = new ArrayList<Volante>();
		this.setQuantidadeNumerosSortear(14);
		this.setQuantidadeTrocaFechamento(5);

		this.comecos = new ArrayList<>();
		this.comecos.add(new Comeco(comeco01));
		this.comecos.add(new Comeco(comeco02));
		this.comecos.add(new Comeco(comeco03));
		this.comecos.add(new Comeco(comeco04));
		this.comecos.add(new Comeco(comeco05));
	}

	public List<Volante> gerarVolantes() {
		setVolantesGerados(Util.sortearVolanteFechamentoMatriz(Util.ids, this.comecos, Util.FINAL_VOLANTES,
				getQuantidadeNumerosSortear(), getQuantidadeTrocaFechamento()));
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
