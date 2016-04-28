package jeu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import exceptions.WinException;

public class Jeu {
	
	private Plateau plateau;
	private int taille;
	private int nbMelange;
	private int nbCoups;
	private Ai ai;
	private Joueur joueur;
	private Sauvegarde save;
	
	public Jeu(){
		this.plateau = null;
		this.taille = 3; // temporaire
		this.nbMelange = 10;
		this.nbCoups = 0;
		this.joueur = new Joueur("Joueur 1");
		this.ai = new Ai();
	}
	
	public Jeu(Jeu jeu){
		this.plateau = null;
		this.taille = jeu.getTaille();
		this.nbMelange = jeu.getNbMelange();
		this.nbCoups = jeu.getNbCoup();
		this.ai = jeu.getAi();
		this.joueur = jeu.getJoueur();
		this.plateau = new Plateau(jeu.plateau);
		this.save = new Sauvegarde(this);
	}
	
	public Jeu(Plateau plateau, int taille, int nbMelange, int nbCoups, Ai ai, Joueur joueur){
		this.plateau = plateau;
		this.taille = taille;
		this.nbMelange = nbMelange;
		this.nbCoups = nbCoups;
		this.ai = ai;
		this.joueur = joueur;
	}

	public void initialisation(){
		this.plateau = new Plateau(this.taille, this.nbMelange);
		this.plateau.initialisation();
		this.nbCoups = 0;
		this.joueur.initialisation();
		this.ai.initialisation();
		this.save = new Sauvegarde(this);
		this.affiche();
	}
	
	public void charger(Jeu jeu){
		this.plateau = null;
		this.taille = jeu.getTaille();
		this.nbMelange = jeu.getNbMelange();
		this.nbCoups = jeu.getNbCoup();
		this.ai = jeu.getAi();
		this.joueur = jeu.getJoueur();
		this.plateau = new Plateau(jeu.plateau);
		this.save = new Sauvegarde(this);
	}
	
	public void pas() throws WinException{
		String com = this.joueur.pas();
		this.commande(com);
		this.affiche();
		this.end();
	}
	
	public void commande(String string){
		String[] commande = string.split(" ");
		switch(commande[0]){
		case "z":
			if(this.plateau.moveUp())
				this.nbCoups++;
			break;
		case "s":
			if(this.plateau.moveDown())
				this.nbCoups++;
			break;
		case "q":
			if(this.plateau.moveLeft())
				this.nbCoups++;
			break;
		case "d":
			if(this.plateau.moveRight())
				this.nbCoups++;
			break;
		case "ai":
			ArrayList<String> listeCommande = new ArrayList<String>();
			listeCommande = this.ai.aide(this.plateau);
			int nbCoups = Integer.parseInt(commande[1]);
			if(nbCoups == 0){
				for(String cmd : listeCommande){
					this.commande(cmd);
				}
			}else{
				for(int i = 0;i < nbCoups;i++){
					this.commande(listeCommande.get(i));
				}
			}
			break;
		case "save":
			this.save.sauvegarder(commande[1]);
			break;
		case "load":
			this.charger(this.save.charger(commande[1]));
			break;
		}
	}
	
	public void end() throws WinException{
		if(this.plateau.resolu())
			throw new WinException();
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public Ai getAi() {
		return this.ai;
	}

	public int getNbCoup() {
		return this.nbCoups;
	}

	public int getNbMelange() {
		return this.nbMelange;
	}

	public int getTaille() {
		return this.taille;
	}

	public Plateau getPlateau() {
		return this.plateau;
	}

	public int getNbCoups() {
		return this.nbCoups;
	}
	
	public void affiche(){
		System.out.println("==========");
		System.out.println("Nombre de coup : "+this.nbCoups);
		System.out.println("Joueur : "+this.joueur.getNom());
		System.out.println("Score : "+this.joueur.getScore());
		System.out.println(this.plateau.affiche());
	}

}