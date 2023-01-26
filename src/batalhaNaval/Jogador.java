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
	
	public void validaPosicao(Navio navio,String l, String c) {
		int coluna, linha;
		try {
			coluna = Integer.parseInt(c);
			linha = Integer.parseInt(l);
			if((linha < 0 || linha > 10) || (coluna < 0 || coluna > 10)) {throw new Exception();}
			// LINHA ABAIXO COM ERRO
			if(this.board.naoTemEspaco(navio.getTamanho(), coluna, linha)) {throw new Exception();}
			this.posicionaNavio(navio, linha, coluna);
		}catch(Exception e) {
			System.out.println("Coordenada invalida");
			this.pegaPosicao(navio);
		}
		
	}
	
	public void pegaPosicao(Navio navio) {
		String linha = "", coluna = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe a coordenada da linha:");
		linha = sc.next();
		System.out.println("Informe a coordenada da coluna:");
		coluna = sc.next();
		this.validaPosicao(navio,linha, coluna);
	}

	public void posicionaNavio(Navio navio,int linha, int coluna) {
			for(int i = 0; i < navio.getTamanho();i++) {
				this.board.posiciona(coluna+i, linha);
			}
	}
	
}

