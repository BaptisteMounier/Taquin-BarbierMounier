package jeu;

import java.util.Scanner;

/**
 * Classe representant un Joueur
 */
public class Joueur {
	
	/**
	 * Nom du joueur
	 */
	private String nom;
	
	/**
	 * Score du joueur
	 */
	private int score;
	
	/**
	 * Meilleur score du joueur
	 */
	private int top;
	
	/**
	 * Constructeur a partir du nom a donner au joueur
	 * @param n Nom a donenr au joueur
	 */
	public Joueur(String n){
		this.nom = n;
		this.score = 0;
	}
	
	/**
	 * Constructeur a partir des differentes donnes d un joueur (utilisee notamment pour copier un joueur)
	 * @param nom Nom a donenr au joueur
	 * @param score Score a donner au joueur
	 * @param top Top score a donner au joueur
	 */
	public Joueur(String nom, int score, int top){
		this.nom = nom;
		this.score = score;
		this.top = top;
	}
	
	/**
	 * Methode de procedure d un pas, d un tour de jeu du joueur
	 * @return La commande du joueur
	 */
	public String pas() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========");
		System.out.println("Que souhaitez-vous faire ? (z/s/q/d/ai 0 (resolution complete)/ai nombrePas/save nomFichier/load nomFichier)");
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
	
	public int getTop(){
		return this.top;
	}

}
