package funcoes;


import java.io.Serializable;
import java.util.Scanner;

public class Jogador implements Serializable{
	
	private String nome;
	private int solved = 0;
	private int solution = 0;
	private float tempo = 0;
	private Tabuleiro board = new Tabuleiro();
	
	public float getTempo() {
		return tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}
	
	
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
			System.out.println("Informe a coordenada da linha do navio de " + navio.getTamanho() + " canhões:");
			linha = sc.nextInt();
			System.out.println("Informe a coordenada da coluna do navio de " + navio.getTamanho() + " canhões:");
			coluna = sc.nextInt();
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

	public void ataca(Jogador atacado) {
		int linha, coluna;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("TURNO DE ATAQUE \n \n \n");
			System.out.println("Tabuleiro de: " + atacado.getNome());
			atacado.getBoard().imprimeTabuleiroAtaque();
			System.out.println("\n \n \n \n");
			
			System.out.println("Tabuleiro de: " + this.getNome());
			this.getBoard().imprimeTabuleiroAtaque();
			System.out.println("\n \n" + this.getNome() + ", sua vez de atacar");
			
			System.out.println("Informe a coordenada da linha do ataque");
			linha = sc.nextInt();
			System.out.println("Informe a coordenada da	coluna do ataque");
			coluna = sc.nextInt();
			if(!(this.getBoard().validaPosicaoAtaque(atacado, linha, coluna))) {
				System.out.println("Posicão invalida");
				this.ataca(atacado);
			}
			if(atacado.getBoard().getTile(coluna, linha) == 'N') {
				atacado.getBoard().setTiles(coluna, linha, 'O');
				this.solved = this.solved + 1;
			}else {
				atacado.getBoard().setTiles(coluna, linha, 'X');
			}
			atacado.getBoard().imprimeTabuleiroAtaque();
		}catch(Exception e){
			System.out.println("Coordenada invalida");
			this.ataca(atacado);
		}
	}
	public void pegaCoordP() {
		int linha, coluna;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Informe a coordenada da linha do porta-aviões");
			linha = sc.nextInt();
			System.out.println("Informe a coordenada da coluna do porta-aviões");
			coluna = sc.nextInt();
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