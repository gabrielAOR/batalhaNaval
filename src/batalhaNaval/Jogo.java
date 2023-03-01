package batalhaNaval;
public class Jogo {
	
	
	public static void main(String[] args) {
		Jogador jogador1 = new Jogador("Gabriel");
		Jogador jogador2 = new Jogador("Lucas");
		Navio navio1 = new Navio(1,4);
		Navio navio2 = new Navio(2,3);
		Navio navio3 = new Navio(3,2);
		Navio navio4 = new Navio(4,1);
		
		jogador1.getBoard().preencheTabuleiro();
		posicionaDefesa(jogador1,navio1);
		posicionaDefesa(jogador1,navio2);
		posicionaDefesa(jogador1,navio3);
		posicionaDefesa(jogador1,navio4);
		jogador2.getBoard().preencheTabuleiro();
		System.out.println("Sua vez " + jogador2.getNome());
		posicionaDefesa(jogador2,navio1);
		posicionaDefesa(jogador2,navio2);
		posicionaDefesa(jogador2,navio3);
		posicionaDefesa(jogador2,navio4);
		
	}
	
	public static void posicionaDefesa(Jogador jogador, Navio navio) {
		for(int i = 0; i < navio.getQuantidade();i++) {
			System.out.println(jogador.getNome() + " posicione sua defesa");
			jogador.getBoard().imprimeTabuleiro();
			jogador.pegaPosicao(navio);
		}
		jogador.getBoard().imprimeTabuleiro();
	}
	
}
