package batalhaNaval;


import java.util.Scanner;

public class Jogador {
	
	private String nome;
	private boolean turno = false;
	private Tabuleiro board = new Tabuleiro();
	
	public String getNome() {
		return nome;
	}

	Jogador(String nome){
		this.nome = nome;
	}
								
	public Tabuleiro getBoard() {
		return board;
	}
	
	public void setBoard(Tabuleiro tabuleiro) {
		this.board = tabuleiro;
	}
	
	public void validaPosicao(Navio navio,int l, int c) {
		try {
			if((l < 0 || l > 9) || (c < 0 || c > 9)) {throw new Exception();}
			if(this.board.naoTemEspaco(navio.getTamanho(), c, l)) {throw new Exception();}
			this.posicionaNavio(navio, l, c);
		}catch(Exception e) {
			System.out.println("Coordenada invalida");
			this.pegaPosicao(navio);
		}
		
	}
	
	public void pegaPosicao(Navio navio) {
		int linha, coluna;
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe a coordenada da linha do canhao de " + navio.getTamanho() + " canhões:");
		linha = sc.nextInt()- 1;
		System.out.println("Informe a coordenada da coluna do canhao de " + navio.getTamanho() + " canhões:");
		coluna = sc.nextInt()- 1;
		this.validaPosicao(navio,linha, coluna);
	}

	public void posicionaNavio(Navio navio,int linha, int coluna) {
			for(int i = 0; i < navio.getTamanho();i++) {
				this.board.posiciona(coluna+i, linha);
			}
	}
	public static void ataca(Jogador jogador) {
		int linha, coluna;
		System.out.println("Informe as coordenadas do ataque");
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe a coordenada da linha do navio");
		linha = sc.nextInt()- 1;
		System.out.println("Informe a coordenada da coluna do navio");
		coluna = sc.nextInt()- 1;
		if(jogador.getBoard().getTabuleiro(coluna, linha) == 'N') {
			jogador.getBoard().setTiles(coluna, linha, 'O');
		}else {
			jogador.getBoard().setTiles(coluna, linha, 'X');
		}
			
		
	}
	
}

