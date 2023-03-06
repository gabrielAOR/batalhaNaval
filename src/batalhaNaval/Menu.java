package batalhaNaval;

import java.util.Scanner;

import funcoes.Jogador;

public class Menu {

    private Jogador player1;
    private Jogador player2;


    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opção:" + '\n');
        System.out.println("Batalha Naval");
        System.out.println("1- Jogar");
        System.out.println("2- Sair");

    }
    
}