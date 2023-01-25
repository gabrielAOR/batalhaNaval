package batalhaNaval;


import java.util.Scanner;

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
	
	public int validaPosicao(String coord) {
		int valor = 0;
		try {
			valor = Integer.parseInt(coord);
			if(valor <= 0 && valor >= 10) {throw new Exception();}
			return valor;
		}catch(Exception e) {
			System.out.println("Coordenada invalida");
			this.pegaPosicao();
		}return 0;
	}
	
	public int pegaPosicao() {
		String coord = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe a coord:");
		coord = sc.next();
		return this.validaPosicao(coord);
	}

	public void posicionaNavio(Navio navio,int linha, int coluna) {
			for(int i = 0; i < navio.getTamanho();i++) {
				this.board.posiciona(coluna+i, linha);
			}
	}
	
}

