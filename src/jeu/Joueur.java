package jeu;

import java.util.Scanner;

public class Joueur {
	
	private String nom;
	private int score;
	private int top;
	
	public Joueur(){
		this.score = 0;
	}
	
	public String pas() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel déplacement souhaitez-vous ?");
		String com = sc.nextLine();
		this.score++;
		return com;
	}

}
