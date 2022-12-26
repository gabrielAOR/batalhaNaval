package batalhaNaval;
import java.util.Scanner;

public class Tabuleiro {
	
	static char[][] tabuleiro;
	
	public static void main(String[] args) {
		criaTabuleiro();
		posicionaNavios("gabriel");
	}
	
	public static void criaTabuleiro() {
		tabuleiro = new char[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				tabuleiro[i][j] = '.';
			}
		}
	}
	
	public static void posicionaNavios(String nome) {
		int linha = 0, coluna = 0;
		Scanner input = new Scanner(System.in);
		
		for(int i = 1; i <= 4; i++) {
			System.out.println("Informe as coordenadas do " + i + "º navio de 1 canhão");
			pegaCoord(linha, coluna);
			tabuleiro[linha][coluna] = 'N';
		}
		
		for(int i = 1; i <= 3; i++) {
			System.out.println("Informe a posição do " + i + "º navio de 2 canhões");
			pegaCoord(linha, coluna);
			tabuleiro[linha][coluna] = 'N';
			tabuleiro[linha][coluna+1] = 'N';
		}
		for(int i = 1; i <= 2; i++) {
			System.out.println("Informe a posição do " + i + "º navio de 3 canhões");
			pegaCoord(linha, coluna);
			tabuleiro[linha][coluna] = 'N';
			tabuleiro[linha][coluna+1] = 'N';
			tabuleiro[linha][coluna+2] = 'N';
		}
		System.out.println("Informe a posição do navio de 4 canhões");
		pegaCoord(linha, coluna);
		tabuleiro[linha][coluna] = 'N';
		tabuleiro[linha][coluna+1] = 'N';
		tabuleiro[linha][coluna+2] = 'N';
		tabuleiro[linha][coluna+3] = 'N';
		input.close();
	}
	// pega as coordenadas e posiciona os navios
	public static void pegaCoord(int linha, int coluna) {
		boolean terminou = false;
		while(!terminou) {
			try{
				Scanner input = new Scanner(System.in);
				System.out.print("linha:");
				linha = input.nextInt();
				System.out.println("");
				System.out.print("Coluna:");
				coluna = input.nextInt();
				if((linha < 1 || linha > 10) || (coluna < 1 || coluna > 10)) {
					throw new Exception();
				}
			}catch(Exception e) {
				System.out.println("Coordenada invalida passe um numero entre 1-10");
			}
		}
	}
	public static void validaEspaco() {
		
	}
}	

