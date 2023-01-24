package batalhaNaval;


public class Jogador {
	
	private String nome;
	private boolean turno = false;
	private Tabuleiro board = new Tabuleiro();
	
	Jogador(String nome){
		this.nome = nome;
	}
								
	public Tabuleiro getBoard() {
		return board;
	}
	
	public void setBoard(Tabuleiro tabuleiro) {
		this.board = tabuleiro;
	}
	
	public boolean validaPosicao(int linha, int coluna) {
		return  (coluna <= 10 && coluna >= 0) && (linha <= 10 && linha >= 0);
	}
	
	public void posicionaNavio(int linha, int coluna) {
		if(validaPosicao(linha,coluna)) {
			this.board.posiciona(coluna, linha);
		}
		
		
	}
	
}

