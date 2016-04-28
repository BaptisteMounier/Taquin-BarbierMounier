package jeu;

import java.util.ArrayList;

public class Etat {
	
	private Plateau plateau;
	private int coutParcours;
	private int coutHeuristiques;
	private int cout;
	private ArrayList<String> listCommande;
	
	public Etat(Plateau p, int c, ArrayList<String> lC){
		this.plateau = p;
		this.coutParcours = c;
		this.listCommande = lC;
		this.coutHeuristiques = this.plateau.manhattan()+ this.plateau.malPlacee();
		this.cout = this.coutParcours + this.coutHeuristiques;
	}
	
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

	public boolean resolu() {
		return this.plateau.resolu();
	}
	
	public ArrayList<String> getListCommande(){
		return this.listCommande;
	}
	
	public Plateau getPlateau(){
		return this.plateau;
	}
	
	public int getCout(){
		return this.cout;
	}
	
	public int getCoutParcours(){
		return this.coutParcours;
	}
	
	public int getCoutHeuristiques(){
		return this.coutHeuristiques;
	}
	
	public boolean equals(Object e){
		return this.plateau.equals(((Etat)(e)).getPlateau());
	}

}
