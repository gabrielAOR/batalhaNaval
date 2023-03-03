package batalhaNaval;


import java.util.Scanner;

public class Jogador {
	
	private String nome;
	private int solved = 0;
	private Tabuleiro board = new Tabuleiro();
	
	public int getSolved(){
		return this.solved;
	}

	public String getNome() {
		return nome;
	}
	int j = 1;
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
			this.getBoard().posicionaNavio(navio, l, c);
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

	public void ataca(Jogador jogador) {
		int linha, coluna;
		System.out.println(this.getNome() + " informe as coordenadas do ataque");
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe a coordenada da linha do navio");
		linha = sc.nextInt() - 1;
		System.out.println("Informe a coordenada da coluna do navio");
		coluna = sc.nextInt() - 1;
		if(jogador.getBoard().getTile(coluna, linha) == 'N') {
			jogador.getBoard().setTiles(coluna, linha, 'O');
			this.solved = this.solved + 1;
		}else {
			jogador.getBoard().setTiles(coluna, linha, 'X');
		}
		jogador.getBoard().imprimeTabuleiro();		
		
	}
	public Jogador ataque(Jogador jogador) {
		while(true){
			this.ataca(jogador);
			if(this.getSolved() == 4) { return this;}
			jogador.ataca(this);
			if(jogador.getSolved() == 4) { return jogador;}
		}
	}
}