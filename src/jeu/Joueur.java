package jeu;

import java.util.Scanner;

public class Joueur {
	
	private String nom;
	private int score;
	private int top;
	
	public Joueur(String n){
		this.nom = n;
		this.score = 0;
	}
	
	public String pas() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel déplacement souhaitez-vous ?");
		String com = sc.nextLine();
		return com;
	}

	public void initialisation() {
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public int getScore(){
		return this.score;
	}

}
