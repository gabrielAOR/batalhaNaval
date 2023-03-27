package funcoes;


import java.util.Scanner;

public class Jogador{
	
	private String nome;
	private int solved = 0;
	private int solution = 0;
	private Tabuleiro board = new Tabuleiro();
	
	public int getSolution() {
		return solution;
	}
	
	public void increaseSolution(int tamanho) {
		this.solution = this.solution + tamanho;
	}
	
	public Jogador(String nome){
		this.nome = nome;
	}
				
	public int getSolved(){
		return this.solved;
	}

	public String getNome() {
		return nome;
	}
				
	public Tabuleiro getBoard() {
		return board;
	}
	
	public void pegaCoord(Navio navio) {
		int linha, coluna;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Informe a coordenada da linha do canhao de " + navio.getTamanho() + " canhões:");
			linha = sc.nextInt()- 1;
			System.out.println("Informe a coordenada da coluna do canhao de " + navio.getTamanho() + " canhões:");
			coluna = sc.nextInt()- 1;
			if(!(this.getBoard().validaPosicao(navio, linha, coluna))) {
				System.out.println("Posicão preenchida ou fora do tabuleiro");
				this.pegaCoord(navio);
			}else {
				this.getBoard().posicionaNavio(navio, linha, coluna);
			}
			
		}catch(Exception e){
			System.out.println("Coordenadas invalidas");
			this.pegaCoord(navio);
		}
	}

	public void ataca(Jogador jogador) {
		int linha, coluna;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Informe a coordenada da linha do ataque");
			linha = sc.nextInt()- 1;
			System.out.println("Informe a coordenada da	coluna do ataque");
			coluna = sc.nextInt()- 1;
			if(!(this.getBoard().validaPosicaoAtaque(jogador, linha, coluna))) {
				System.out.println("Posicão invalida");
				this.ataca(jogador);
			}
			if(jogador.getBoard().getTile(coluna, linha) == 'N') {
				jogador.getBoard().setTiles(coluna, linha, 'O');
				this.solved = this.solved + 1;
			}else {
				jogador.getBoard().setTiles(coluna, linha, 'X');
			}
			jogador.getBoard().imprimeTabuleiroAtaque();
		}catch(Exception e){
			System.out.println("Coordenada invalida");
			this.ataca(jogador);
		}
	}
	public void pegaCoordP() {
		int linha, coluna;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Informe a coordenada da linha do porta-aviões");
			linha = sc.nextInt()- 1;
			System.out.println("Informe a coordenada da coluna do porta-aviões");
			coluna = sc.nextInt()- 1;
			if(!(this.getBoard().validaAviao(linha, coluna))) {
				System.out.println("Posicão preenchida ou fora do tabuleiro");
				this.pegaCoordP();
			}else {
				this.getBoard().posicionaAviao(linha, coluna);
			}
			
		}catch(Exception e){
			System.out.println("Coordenadas invalidas");
			this.pegaCoordP();
		}
	}
}