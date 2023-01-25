package batalhaNaval;
public class Jogo {
	
	
	public static void main(String[] args) {
		int linha, coluna;
		Jogador jogador = new Jogador("Gabriel");
		Navio navio1 = new Navio(1,4);
		Navio navio2 = new Navio(2,3);
		Navio navio3 = new Navio(3,2);
		Navio navio4 = new Navio(4,1);
		
		jogador.getBoard().preencheTabuleiro();
		jogador.getBoard().imprimeTabuleiro();
		
		linha = jogador.pegaPosicao();
		coluna = jogador.pegaPosicao();
		jogador.getBoard().imprimeTabuleiro();
		
	}
}
