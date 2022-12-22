package batalhaNaval;
import java.util.Scanner;

public class Tabuleiro {
	
	static char[][] tabuleiro;
	
	public static void main(String[] args) {
		tabuleiro = new char[10][10];
		posicionaNavios("gabriel");
	}
	
	public static void posicionaNavios(String nome) {
		int linha = 0, coluna = 0;
		Scanner input = new Scanner(System.in);
		
		for(int i = 1; i <= 4; i++) {
			pegaCoord(i, nome, linha, coluna,"1 canhão");
		}
		
		for(int i = 1; i <= 3; i++) {
			pegaCoord(i, nome, linha, coluna,"2 canhões");
			tabuleiro[linha][coluna+1] = 'N';
		}
		for(int i = 1; i <= 2; i++) {
			pegaCoord(i, nome, linha, coluna, "3 canhões");
			tabuleiro[linha][coluna+1] = 'N';
			tabuleiro[linha][coluna+2] = 'N';
		}
		System.out.println(nome + " Informe a posição da linha do navio de 4 canhões");
		linha = input.nextInt();
		System.out.println(nome + " Informe a posição da coluna do navio de 4 canhões");
		coluna = input.nextInt();
		tabuleiro[linha][coluna+1] = 'N';
		tabuleiro[linha][coluna+2] = 'N';
		tabuleiro[linha][coluna+3] = 'N';
		input.close();
		
	}
	// pega as coordenadas e posiciona os navios
	public static void pegaCoord(int i, String nome, int linha, int coluna, String canhao) {
		Scanner input = new Scanner(System.in);
		System.out.println(nome + " Informe a posição da linha do " + i + "º navio de " + canhao );
		linha = input.nextInt();
		System.out.println(nome + " Informe a posição da coluna do " + i + "º navio de " + canhao);
		coluna = input.nextInt();
		tabuleiro[linha][coluna] = 'N';
	}
}	

