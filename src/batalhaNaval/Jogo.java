package batalhaNaval;
import java.util.Scanner;

import excecoes.OpcaoException;
import funcoes.Jogador;
import funcoes.Navio;
import funcoes.PortaAvioes;

public class Jogo {
	
	public static void main(String[] args) {
		menu();
		
	}
	public static void posicionaDefesa(Jogador jogador, Navio navio) {
		for(int i = 0; i < navio.getQuantidade();i++) {
			System.out.println(jogador.getNome() + " posicione sua defesa");
			jogador.getBoard().imprimeTabuleiroDefesa();
			jogador.pegaCoord(navio);
			cls();
		}
		jogador.increaseSolution(navio.getTamanho() * navio.getQuantidade());
		jogador.getBoard().imprimeTabuleiroDefesa();
	}
	
	public static void posicionaPortaAviao(Jogador jogador, int quantidade) {
		jogador.increaseSolution(quantidade * 5);
		for(int i = 0; i < quantidade;i++) {
			jogador.getBoard().imprimeTabuleiroDefesa();
			jogador.pegaCoordP();
		}
	}	
	
	public static void escolheNavio(Jogador jogador, int tamanho) {
		int quantidade;
		Scanner sc = new Scanner(System.in);
		quantidade = sc.nextInt();
		posicionaDefesa(jogador, new Navio(tamanho,quantidade));
	}
	
	public static Jogador ataque(Jogador jogador1, Jogador jogador2) {
		while(true){
			jogador1.ataca(jogador2);
			if(jogador1.getSolved() == jogador1.getSolution()) { return jogador1;}
			jogador2.ataca(jogador1);
			if(jogador2.getSolved() == jogador2.getSolution()) { return jogador2;}
		}
	}	
	public static void posicionaCustom(Jogador jogador) {
		int quantidade;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha a quantidade de porta-aviões");
		quantidade = sc.nextInt();
		posicionaPortaAviao(jogador, quantidade);
		
		System.out.println("Escolha a quantidade de navios de 1 canhão");
		escolheNavio(jogador, 1);
		
		System.out.println("Escolha a quantidade de navios de 2 canhões");
		escolheNavio(jogador, 2);
		
		System.out.println("Escolha a quantidade de navios de 3 canhões");
		escolheNavio(jogador, 3);
		
		System.out.println("Escolha a quantidade de navios de 4 canhões");
		escolheNavio(jogador, 4);
	}
	
	public static void jogoCustom() {
		Jogador jogador1 = new Jogador("Player1");
		Jogador jogador2 = new Jogador("Player2");
		Jogador ganhador;
		
		jogador1.getBoard().preencheTabuleiro();
		jogador2.getBoard().preencheTabuleiro();
		
		System.out.println("Sua vez " + jogador1.getNome());
		posicionaCustom(jogador1);
		
		System.out.println("Sua vez " + jogador2.getNome());
		posicionaCustom(jogador2);
		
		ganhador = ataque(jogador1,jogador2);
		System.out.println("Parabens " + ganhador.getNome() + " Você foi o ganhador");
	}
		
	public static void jogoNormal() {
		Jogador jogador1 = new Jogador("Player1");
		Jogador jogador2 = new Jogador("Player2");
		Jogador ganhador;
		
		jogador1.getBoard().preencheTabuleiro();
		jogador2.getBoard().preencheTabuleiro();
		
		System.out.println("Sua vez " + jogador1.getNome());
		posicionaDefesa(jogador1, new Navio(1,4));
		posicionaDefesa(jogador1, new Navio(2,3));
		posicionaDefesa(jogador1, new Navio(3,2));
		posicionaDefesa(jogador1, new Navio(4,1));
		cls();
		posicionaDefesa(jogador2, new Navio(1,4));
		posicionaDefesa(jogador2, new Navio(2,3));
		posicionaDefesa(jogador2, new Navio(3,2));
		posicionaDefesa(jogador2, new Navio(4,1));
		cls();
		ganhador = ataque(jogador1,jogador2);
		System.out.println("Parabens " + ganhador.getNome() + " Você foi o ganhador");
	}

	public static void menu() {
		System.out.println("Escolha a opção:");
		System.out.println("1 - Batalha Naval");
		System.out.println("2 - Batalha Naval Custom");
		validaMenu();
	}
	
	public static void validaMenu() {
		Scanner sc = new Scanner(System.in);
		try {
			int opcao = sc.nextInt();
			if(opcao != 1 && opcao != 2) {throw new OpcaoException(); }
			if(opcao == 1) {jogoNormal();}
			if(opcao == 2) {jogoCustom();}
		
		}catch(OpcaoException e) {
			System.out.println("Não há essa opção informe a correta");
			validaMenu();
		}catch(Exception e) {
			System.out.println("Apenas numeros são validos nas opções");
			validaMenu();
		}
	}
	
	public static void cls() {
		System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
	}
}
