package jeu;

import java.util.ArrayList;

import exceptions.WinException;

/**
 * Classe de l'intelligence artificiel de resolution du taquin
 * Extends depuis la classe Joueur
 */
public class Ai extends Joueur{
	
	/**
	 * Constructeur vide creant une intelligence-joueur du nom de "IA"
	 */
	public Ai(){
		super("IA");
	}
	
	/**
	 * Constructeur a partir du nom, du score et du top score (principalement utilisee pour copier une idee)
	 * @param nom Nom a donner a l ia
	 * @param score Score actuel de l ia
	 * @param top Top score de l ia
	 */
	public Ai(String nom, int score, int top){
		super(nom,score,top);
	}

	/**
	 * Methode de resolution de la partie a partir du plateau en creant la recherche
	 * @param plateau Plateau a resoudre
	 */
	public ArrayList<String> aide(Plateau plateau){
		Etat depart = new Etat(plateau,0 ,new ArrayList<String>());
		Recherche recherche = new Recherche(depart);
		return recherche.recherche();
	}

}
