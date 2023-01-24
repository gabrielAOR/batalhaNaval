package batalhaNaval;
import java.util.Scanner;
public class Jogo {
	
	
	public static void main(String[] args) {
		int linha, coluna;
		Jogador jogador = new Jogador("Gabriel");
		Scanner sc = new Scanner(System.in);
		
		jogador.getBoard().preencheTabuleiro();
		jogador.getBoard().imprimeTabuleiro();
		
		System.out.println("Informe a coord da linha");
		linha = sc.nextInt();
		System.out.println("Informe a coord da coluna");
		coluna = sc.nextInt();
		
		jogador.posicionaNavio(linha-1, coluna-1);
		jogador.getBoard().imprimeTabuleiro();
		
	}
}
