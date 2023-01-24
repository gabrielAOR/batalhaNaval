package batalhaNaval;

public class Navio {

	private int tamanho;
	private int quantidade;
	
	public Navio(int tamanho, int quantidade) {
		this.tamanho = tamanho;
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public int getTamanho() {
		return tamanho;
	}
}
