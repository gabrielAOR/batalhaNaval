package batalhaNaval;
public class Tabuleiro {
	
	private char[][] tabuleiro = new char[10][10];

	public void setTiles(int c, int l, char tile) {
		this.tabuleiro[c][l] = tile;
	}
	
	public char getTile(int c, int l) {
		return tabuleiro[c][l];
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
			this.tabuleiro[c+i][l] = 'N';
		}
	}
	
	public void posicionaAviao(int l, int c) {
		for(int i = 0; i < 3;i++) {
			this.tabuleiro[c+i][l] = 'N';
		}
		this.tabuleiro[c+1][l+1] = 'N';
		this.tabuleiro[c+1][l+2] = 'N';
	}
	
	public boolean validaEspaco(int c, int l) {
		return (this.tabuleiro[c][l] == 'X') || (this.tabuleiro[c][l] == 'O');
	}
	
	public boolean naoTemEspaco(int tamanho, int c, int l) {
		for(int i = 0; i < tamanho;i++) {
			if(this.tabuleiro[c+i][l] == 'N') {return true;}
		}
		return false;
	}
	
	public boolean validaPosicao(Navio navio,int l, int c) {
		if((l < 0 || l > 9) || (c < 0 || c > 9)) {return false;}
		if(this.naoTemEspaco(navio.getTamanho(), c, l)) {return false;}
		return true;
	}
	public boolean validaPosicaoAtaque(Jogador jogador, int l, int c) {
		if((l < 0 || l > 9) || (c < 0 || c > 9)) { return false;}
		if(jogador.getBoard().getTile(c, l) == 'O') { return false;}
		if(jogador.getBoard().getTile(c, l) == 'X') { return false;}
		return true;
	}
	public boolean validaAviao(int c, int l) {
		boolean valido = true;
		for(int i = 0; i < 3;i++) {
			if(this.tabuleiro[c+i][l] == 'N') {valido = false;}
		}
		if((this.tabuleiro[c+1][l+1] == 'N') || (this.tabuleiro[c+1][l+2] == 'N')) { valido = false;}
		return valido;
	}
}	