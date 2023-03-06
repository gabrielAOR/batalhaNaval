package funcoes;

public class Navio {

	private int tamanhox;
	private int quantidade;
	
	public Navio(int tamanho, int quantidade) {
		this.tamanhox = tamanho;
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public int getTamanho() {
		return tamanhox;
	}
}
