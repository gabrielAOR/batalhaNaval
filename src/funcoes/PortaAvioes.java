package funcoes;

public class PortaAvioes extends Navio {
	
	private int tamanhoy = 2;
	
	public int getTamanhoy() {
		return tamanhoy;
	}

	public PortaAvioes(int tamanho, int quantidade) {
		super(tamanho, quantidade);
	}
	
}
