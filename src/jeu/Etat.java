package jeu;

import java.util.ArrayList;

public class Etat {
	
	private Plateau plateau;
	private int cout;
	private int manhattan;
	private int malPlacee;
	private int mini;
	private ArrayList<String> listCommande;
	
	public Etat(Plateau p, int c, ArrayList<String> lC){
		this.plateau = p;
		this.cout = c;
		this.listCommande = lC;
		this.manhattan = this.plateau.manhattan();
		this.malPlacee = this.plateau.malPlacee();
		this.mini = this.cout + this.manhattan + this.malPlacee;
	}
	
	public int getMini(){
		return this.mini;
	}
	
	public ArrayList<Etat> successeur(){
		ArrayList<Etat> successeur = new ArrayList<Etat>();
		Plateau successeurUp = new Plateau(this.plateau);
		if(successeurUp.moveUp()){
			ArrayList<String> listeCommandeSuccesseur = new ArrayList<String>();
			listeCommandeSuccesseur = this.listCommande;
			listeCommandeSuccesseur.add("z");
			successeur.add(new Etat(successeurUp, this.cout+1, listeCommandeSuccesseur));
		}
		Plateau successeurDown = new Plateau(this.plateau);
		if(successeurDown.moveDown()){
			ArrayList<String> listeCommandeSuccesseur = new ArrayList<String>();
			listeCommandeSuccesseur = this.listCommande;
			listeCommandeSuccesseur.add("s");
			successeur.add(new Etat(successeurDown, this.cout+1, listeCommandeSuccesseur));
		}
		Plateau successeurLeft = new Plateau(this.plateau);
		if(successeurLeft.moveLeft()){
			ArrayList<String> listeCommandeSuccesseur = new ArrayList<String>();
			listeCommandeSuccesseur = this.listCommande;
			listeCommandeSuccesseur.add("q");
			successeur.add(new Etat(successeurLeft, this.cout+1, listeCommandeSuccesseur));
		}
		Plateau successeurRight = new Plateau(this.plateau);
		if(successeurRight.moveRight()){
			ArrayList<String> listeCommandeSuccesseur = new ArrayList<String>();
			listeCommandeSuccesseur = this.listCommande;
			listeCommandeSuccesseur.add("d");
			successeur.add(new Etat(successeurRight, this.cout+1, listeCommandeSuccesseur));
		}
		return successeur;
	}

	public boolean resolu() {
		return this.plateau.resolu();
	}
	
	public boolean coutPlusFaible(int n){
		return false;
	}
	
	public ArrayList<String> getListCommande(){
		return this.listCommande;
	}

}
