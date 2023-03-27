package batalhaNaval;

import java.util.Scanner;

import funcoes.Jogador;
import funcoes.Navio;
import funcoes.PortaAvioes;

public class Jogo {
	
	int solucao1 = 0;
	int solucao2 = 0;
	
	public static void main(String[] args) {
		int quantidade = 0;
		Jogador jogador1 = new Jogador("Player1");
		Jogador jogador2 = new Jogador("Player2");
		Jogador ganhador;
		
		jogador1.getBoard().preencheTabuleiro();
		jogador2.getBoard().preencheTabuleiro();
		System.out.println("Sua vez " + jogador1.getNome());
		System.out.println("Quantos aviões de 1 cano você quer posicionar?");
		escolheNavio(jogador1,1);
		System.out.println("Quantos aviões de 2 cano você quer posicionar?");
		escolheNavio(jogador1,2);
		System.out.println("Quantos aviões de 3 cano você quer posicionar?");
		escolheNavio(jogador1,3);
		System.out.println("Quantos aviões de 4 cano você quer posicionar?");
		escolheNavio(jogador1,4);
		posicionaPortaAviao(jogador1);
		

		System.out.println("Sua vez " + jogador1.getNome());
		System.out.println("Quantos aviões de 1 cano você quer posicionar?");
		escolheNavio(jogador1,1);
		System.out.println("Quantos aviões de 2 cano você quer posicionar?");
		escolheNavio(jogador1,2);
		System.out.println("Quantos aviões de 3 cano você quer posicionar?");
		escolheNavio(jogador1,3);
		System.out.println("Quantos aviões de 4 cano você quer posicionar?");
		escolheNavio(jogador1,4);
		
		ganhador = ataque(jogador1,jogador2);
		System.out.println("Parabens " + ganhador.getNome() + " Você foi o ganhador");
	}
	
	public static void posicionaDefesa(Jogador jogador, Navio navio) {
		for(int i = 0; i < navio.getQuantidade();i++) {
			System.out.println(jogador.getNome() + " posicione sua defesa");
			jogador.getBoard().imprimeTabuleiroDefesa();
			jogador.pegaCoord(navio);
		}
		jogador.getBoard().imprimeTabuleiroDefesa();
	}
	
	public static Jogador ataque(Jogador jogador1, Jogador jogador2) {
		while(true){
			jogador1.ataca(jogador2);
			if(jogador1.getSolved() == jogador1.getSolution()) { return jogador1;}
			jogador2.ataca(jogador1);
			if(jogador2.getSolved() == jogador2.getSolution()) { return jogador2;}
		}
	}
	
	public static void posicionaPortaAviao(Jogador jogador) {
		System.out.println(jogador.getNome() + " Sua vez:");
		jogador.getBoard().imprimeTabuleiroDefesa();
		jogador.pegaCoordP();
	}
	
	public static void escolheNavio(Jogador jogador, int tamanho) {
		int quantidade;
		Scanner sc = new Scanner(System.in);
		jogador.increaseSolution(tamanho);
		quantidade = sc.nextInt();
		posicionaDefesa(jogador, new Navio(tamanho,quantidade));
	}
}