package batalhaNaval;
public class Jogo {
	
	
	public static void main(String[] args) {
		Jogador jogador1 = new Jogador("Gabriel");
		Jogador jogador2 = new Jogador("Lucas");
		Jogador ganhador;
		Navio navio1 = new Navio(1,4);
		Navio navio2 = new Navio(2,3);
		Navio navio3 = new Navio(3,2);
		Navio navio4 = new Navio(4,1);
		PortaAvioes porta = new PortaAvioes(3,1);
		
		jogador1.getBoard().preencheTabuleiro();
		jogador2.getBoard().preencheTabuleiro();
		posicionaPortaAviao(jogador1);
		posicionaDefesa(jogador1,navio1);
		posicionaDefesa(jogador1,navio2);
		posicionaDefesa(jogador1,navio3);
		posicionaDefesa(jogador1,navio4);
		System.out.println("Sua vez " + jogador2.getNome());
		posicionaDefesa(jogador2,navio1);
		posicionaDefesa(jogador2,navio2);
		posicionaDefesa(jogador2,navio3);
		posicionaDefesa(jogador2,navio4);
		ganhador = ataque(jogador1,jogador2);
		System.out.println("Parabens " + ganhador.getNome() + " Você foi o ganhador");
	}
	
	public static void posicionaDefesa(Jogador jogador, Navio navio) {
		for(int i = 0; i < navio.getQuantidade();i++) {
			System.out.println(jogador.getNome() + " posicione sua defesa");
			jogador.getBoard().imprimeTabuleiro();
			jogador.pegaCoord(navio);
		}
		jogador.getBoard().imprimeTabuleiro();
	}
	public static Jogador ataque(Jogador jogador1, Jogador jogador2) {
		while(true){
			jogador1.ataca(jogador2);
			if(jogador1.getSolved() == 4) { return jogador1;}
			jogador2.ataca(jogador1);
			if(jogador2.getSolved() == 4) { return jogador2;}
		}
	}
	public static void posicionaPortaAviao(Jogador jogador) {
		jogador.getBoard().imprimeTabuleiro();
		jogador.pegaCoordP();
		jogador.getBoard().imprimeTabuleiro();
	}
}