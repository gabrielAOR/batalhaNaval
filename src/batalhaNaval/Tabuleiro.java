package batalhaNaval;
public class Tabuleiro {
	
	private char[][] tabuleiro = new char[10][10];

	public void setTiles(int c, int l, char tile) {
		this.tabuleiro[c][l] = tile;
	}
	
	public char getTile(int c, int l) {
		return tabuleiro[c][l];
	}
	
	public boolean naoTemEspaco(int tamanho, int c, int l) {
		for(int i = 0; i < tamanho;i++) {
			if(this.tabuleiro[c][l] == 'N') {return true;}
		}
		return false;
	}
	
	public void preencheTabuleiro() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				this.tabuleiro[i][j] = '.';
			}
		}
	}
	
	public void imprimeTabuleiro() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(this.tabuleiro[j][i]);
			}
			System.out.println();
		}
	}
	
	public void posicionaNavio(Navio navio,int l, int c) {
		for(int i = 0; i < navio.getTamanho();i++) {
			this.tabuleiro[c][l] = 'N';
		}
	}
	
	public boolean validaEspaco(int c, int l) {
		return (this.tabuleiro[c][l] == 'X') || (this.tabuleiro[c][l] == 'O');
	}
	
}	