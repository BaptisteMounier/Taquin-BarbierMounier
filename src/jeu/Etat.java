package jeu;

import java.util.ArrayList;

/**
 * Classe correspondant a un etat pour l algorithme de recherche
 */
public class Etat {
	
	/**
	 * Plateau de l etat actuel
	 */
	private Plateau plateau;
	
	/**
	 * Cout pour aller jusqu a cet etat
	 */
	private int coutParcours;
	
	/**
	 * Cout estimee pour atteindre l objectif
	 */
	private int coutHeuristiques;
	
	/**
	 * Cout total
	 */
	private int cout;
	
	/**
	 * Liste des commandes necessaire pour atteindre l etat actuel
	 */
	private ArrayList<String> listCommande;
	
	/**
	 * Constructeur a partir d un Plateau, du cout pour atteindre cet etat
	 * @param p Plateau associe a l etat
	 * @param c Cout pour atteindre cet etat
	 * @param lC Liste des commandes pour atteindre cet etat
	 */
	public Etat(Plateau p, int c, ArrayList<String> lC){
		this.plateau = p;
		this.coutParcours = c;
		this.listCommande = lC;
		this.coutHeuristiques = this.plateau.manhattan()+ this.plateau.malPlacee();
		this.cout = this.coutParcours + this.coutHeuristiques;
	}
	
	/**
	 * Methode pour obtenir les etats successeurs
	 * @return La liste des etats successeurs a l etat actuel
	 */
	public ArrayList<Etat> successeur(){
		ArrayList<Etat> successeur = new ArrayList<Etat>();
		Plateau successeurUp = new Plateau(this.plateau);
		if(successeurUp.moveUp()){
			ArrayList<String> listeCommandeSuccesseur = new ArrayList<String>();
			for(String s : this.listCommande)
				listeCommandeSuccesseur.add(s);
			listeCommandeSuccesseur.add("z");
			int coutParcoursNew = this.coutParcours+1;
			Etat e = new Etat(successeurUp, coutParcoursNew, listeCommandeSuccesseur);
			successeur.add(e);
		}
		Plateau successeurDown = new Plateau(this.plateau);
		if(successeurDown.moveDown()){
			ArrayList<String> listeCommandeSuccesseur = new ArrayList<String>();
			for(String s : this.listCommande)
				listeCommandeSuccesseur.add(s);
			listeCommandeSuccesseur.add("s");
			int coutParcoursNew = this.coutParcours+1;
			Etat e = new Etat(successeurDown, coutParcoursNew, listeCommandeSuccesseur);
			successeur.add(e);
		}
		Plateau successeurLeft = new Plateau(this.plateau);
		if(successeurLeft.moveLeft()){
			ArrayList<String> listeCommandeSuccesseur = new ArrayList<String>();
			for(String s : this.listCommande)
				listeCommandeSuccesseur.add(s);
			listeCommandeSuccesseur.add("q");
			int coutParcoursNew = this.coutParcours+1;
			Etat e = new Etat(successeurLeft, coutParcoursNew, listeCommandeSuccesseur);
			successeur.add(e);
		}
		Plateau successeurRight = new Plateau(this.plateau);
		if(successeurRight.moveRight()){
			ArrayList<String> listeCommandeSuccesseur = new ArrayList<String>();
			for(String s : this.listCommande)
				listeCommandeSuccesseur.add(s);
			listeCommandeSuccesseur.add("d");
			int coutParcoursNew = this.coutParcours+1;
			Etat e = new Etat(successeurRight, coutParcoursNew, listeCommandeSuccesseur);
			successeur.add(e);
		}
		return successeur;
	}

	/**
	 * Methode qui calcule si l etat actuel correspond a l etat recherche
	 * @return Vrai si l etat actuel est l etat recherche, Faux sinon
	 */
	public boolean resolu() {
		return this.plateau.resolu();
	}
	
	/**
	 * Getteur de la liste des commandes pour atteindre cet etat
	 * @return La liste des commandes
	 */
	public ArrayList<String> getListCommande(){
		return this.listCommande;
	}
	
	/**
	 * Getteur du plateau de l etat
	 * @return Le plateau
	 */
	public Plateau getPlateau(){
		return this.plateau;
	}
	
	/**
	 * Getteur du cout total de l etat
	 * @return Le cout
	 */
	public int getCout(){
		return this.cout;
	}
	
	/**
	 * Getteur du cout du atteindre l etat
	 * @return Le cout
	 */
	public int getCoutParcours(){
		return this.coutParcours;
	}
	
	/**
	 * Getteur du cout estime pour atteindre l etat recherche
	 * @return Le cout estime
	 */
	public int getCoutHeuristiques(){
		return this.coutHeuristiques;
	}
	
	/**
	 * Methode equals permettant de comparer l etat actuel avec un autre etat
	 * @param e Etat de la comparaison
	 */
	public boolean equals(Object e){
		return this.plateau.equals(((Etat)(e)).getPlateau());
	}

}
