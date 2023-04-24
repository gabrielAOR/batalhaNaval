package batalhaNaval;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import excecoes.OpcaoException;
import funcoes.Jogador;
import funcoes.Navio;

public class Jogo {
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
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
		jogador.getBoard().imprimeTabuleiroDefesa();
		quantidade = sc.nextInt();
		posicionaDefesa(jogador, new Navio(tamanho,quantidade));
	}
	
	public static Jogador ataque(Jogador jogador1, Jogador jogador2) {
		while(true){
			jogador1.ataca(jogador2);
			cls();
			if(jogador1.getSolved() == jogador1.getSolution()) { return jogador1;}
			jogador2.ataca(jogador1);
			if(jogador2.getSolved() == jogador2.getSolution()) { return jogador2;}
		}
	}	
	public static void posicionaCustom(Jogador jogador) {
		int quantidade;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha a quantidade de porta-aviões");
		jogador.getBoard().imprimeTabuleiroDefesa();
		quantidade = sc.nextInt();
		posicionaPortaAviao(jogador, quantidade);
		cls();
		System.out.println("Sua vez " + jogador.getNome());
		System.out.println("Escolha a quantidade de navios de 1 canhão");
		escolheNavio(jogador, 1);
		cls();
		
		for(int i = 2; i < 4;i++) {
			System.out.println("Sua vez " + jogador.getNome());
			System.out.println("Escolha a quantidade de navios de " + i + " canhões");
			escolheNavio(jogador, i);
			cls();
		}
	}
	
	public static void jogoCustom() throws FileNotFoundException, IOException, ClassNotFoundException {
		Jogador jogador1 = new Jogador("Player1");
		Jogador jogador2 = new Jogador("Player2");
		Jogador ganhador;
		
		jogador1.getBoard().preencheTabuleiro();
		jogador2.getBoard().preencheTabuleiro();
		
		System.out.println("Sua vez " + jogador1.getNome());
		posicionaCustom(jogador1);
		
		System.out.println("Sua vez " + jogador2.getNome());
		posicionaCustom(jogador2);
		
		long start = System.currentTimeMillis();
		ganhador = ataque(jogador1,jogador2);
		long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F;
		
		ganhador.setTempo(sec);		
		System.out.println("Parabens " + ganhador.getNome() + " Você foi o ganhador");
		System.out.println("Seu tempo foi de: " + sec);
		salvaRecorde(ganhador);
	}
		
	public static void jogoNormal() throws FileNotFoundException, IOException, ClassNotFoundException {
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
		
		long start = System.currentTimeMillis();
		ganhador = ataque(jogador1,jogador2);
		long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F;
		
		ganhador.setTempo(sec);
		salvaRecorde(ganhador);		
		System.out.println("Parabens " + ganhador.getNome() + " Você foi o ganhador");
		System.out.println("Seu tempo foi de: " + sec);
	}

	public static void menu() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Escolha a opção:");
		System.out.println("1 - Batalha Naval");
		System.out.println("2 - Batalha Naval Custom");
		System.out.println("3 - Recorde");
		validaMenu();
	}
	
	public static void validaMenu() throws FileNotFoundException, ClassNotFoundException, IOException {
		int opcao= 0;
		Scanner sc = new Scanner(System.in);
		try {
			opcao = sc.nextInt();
			if(opcao != 1 && opcao != 2 && opcao != 3) {throw new OpcaoException(); }
		}catch(OpcaoException e) {
			System.out.println("Não há essa opção informe a correta");
			validaMenu();
		}catch(Exception e) {
			System.out.println("Apenas numeros são validos nas opções");
			validaMenu();
		}
		if(opcao == 1) {jogoNormal();}
		if(opcao == 2) {jogoCustom();}
		if(opcao == 3) {recorde();}
	}
	
	private static void recorde() throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		ArrayList<Jogador> listaRecorde = new ArrayList<>();
		try {
        	ObjectInputStream in = new ObjectInputStream(new FileInputStream("recorde.txt"));
    		listaRecorde = (ArrayList<Jogador>) in.readObject();
		}catch(Exception e) {
		
		}
		System.out.println("    NOME        TEMPO");
		for(int i = 0; i < listaRecorde.size();i++) {
			System.out.println(i+1 + "- " + listaRecorde.get(i).getNome() + "    " + listaRecorde.get(i).getTempo() );
		}
		
		System.out.println("\n \n \n \n \n \n \n \n \n 1 - VOLTA PARA O MENU");
		int volta = sc.nextInt();
		if(volta == 1) {menu();}
	}
	
	@SuppressWarnings("unchecked")
	public static void salvaRecorde(Jogador ganhador) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Jogador> listaRecorde = new ArrayList<>();
		try {
        	ObjectInputStream in = new ObjectInputStream(new FileInputStream("recorde.txt"));
    		listaRecorde = (ArrayList<Jogador>) in.readObject();
    		listaRecorde.add(ganhador);
    		Collections.sort(listaRecorde, Comparator.comparing(Jogador::getTempo));
    		System.out.println(listaRecorde);
        }catch(Exception e) {
        	listaRecorde.add(ganhador);
        }
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("recorde.txt"));
		out.writeObject(listaRecorde);
		out.close();
	}
	
	public static void cls() {
		System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
	}
	
}
