package jeu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import exceptions.WinException;

/**
 * Classe qui gere le jeu
 */
public class Jeu {
	
	/**
	 * Le Plateau associe au jeu
	 */
	private Plateau plateau;
	
	/**
	 * La taille du plateau
	 */
	private int taille;
	
	/**
	 * Le nombre de melange a faire pour l initialisation du plateau
	 */
	private int nbMelange;
	
	/**
	 * Le nombre de coups effectues
	 */
	private int nbCoups;
	
	/**
	 * L'intelligence artificiel
	 */
	private Ai ai;
	
	/**
	 * Le joueur
	 */
	private Joueur joueur;
	
	/**
	 * La sauvegarde
	 */
	private Sauvegarde save;
	
	/**
	 * Constructeur vide, cree un Jeu avec des valeurs de base
	 */
	public Jeu(){
		this.plateau = null;
		this.taille = 4;
		this.nbMelange = 75;
		this.nbCoups = 0;
		this.joueur = new Joueur("Joueur 1");
		this.ai = new Ai();
	}
	
	/**
	 * Constructeur qui cree un Jeu a partir d un autre Jeu
	 * @param jeu Jeu a copier
	 */
	public Jeu(Jeu jeu){
		this.plateau = null;
		this.taille = jeu.getTaille();
		this.nbMelange = jeu.getNbMelange();
		this.nbCoups = jeu.getNbCoups();
		this.ai = jeu.getAi();
		this.joueur = jeu.getJoueur();
		this.plateau = new Plateau(jeu.plateau);
		this.save = new Sauvegarde(this);
	}
	
	/**
	 * Constructeur qui cree un Jeu a partir de toutes les donnees d un autre Jeu
	 * @param plateau Le Plateau a copier
	 * @param taille La taille a copier
	 * @param nbMelange Le nombre de melange a copier
	 * @param nbCoups Le nombre de coups a copier
	 * @param ai L intelligence artificiel a copier
	 * @param joueur Le Joueur a copier
	 */
	public Jeu(Plateau plateau, int taille, int nbMelange, int nbCoups, Ai ai, Joueur joueur){
		this.plateau = plateau;
		this.taille = taille;
		this.nbMelange = nbMelange;
		this.nbCoups = nbCoups;
		this.ai = ai;
		this.joueur = joueur;
	}

	/**
	 * Methode permettant d initialiser le Jeu
	 */
	public void initialisation(){
		this.plateau = new Plateau(this.taille, this.nbMelange);
		this.plateau.initialisation();
		this.nbCoups = 0;
		this.save = new Sauvegarde(this);
		this.affiche();
	}
	
	/**
	 * Methode qui permet de charger un Jeu
	 * @param jeu Jeu a charger
	 */
	public void charger(Jeu jeu){
		this.plateau = null;
		this.taille = jeu.getTaille();
		this.nbMelange = jeu.getNbMelange();
		this.nbCoups = jeu.getNbCoups();
		this.ai = jeu.getAi();
		this.joueur = jeu.getJoueur();
		this.plateau = new Plateau(jeu.plateau);
		this.save = new Sauvegarde(this);
	}
	
	/**
	 * Methode d un pas de jeu (tour de jeu de la part du joueur)
	 * @throws WinException Exception levee lors que le taquin est reussi
	 */
	public void pas() throws WinException{
		String com = this.joueur.pas();
		this.commande(com);
	}
	
	/**
	 * Methode executant la commande rentree
	 * @param string Chaine correspondant a la commande
	 * @throws WinException Exception levee lors que le taquin est reussi
	 */
	public void commande(String string) throws WinException{
		String[] commande = string.split(" ");
		switch(commande[0]){
		case "z":
			if(this.plateau.moveUp()){
				this.nbCoups++;
				this.affiche();
				this.end();
			}
			break;
		case "s":
			if(this.plateau.moveDown()){
				this.nbCoups++;
				this.affiche();
				this.end();
			}
			break;
		case "q":
			if(this.plateau.moveLeft()){
				this.nbCoups++;
				this.affiche();
				this.end();
			}
			break;
		case "d":
			if(this.plateau.moveRight()){
				this.nbCoups++;
				this.affiche();
				this.end();
			}
			break;
		case "ai":
			ArrayList<String> listeCommande = new ArrayList<String>();
			listeCommande = this.ai.aide(this.plateau);
			int nbCoups = Integer.parseInt(commande[1]);
			if(nbCoups == 0){
				for(String cmd : listeCommande){
					this.commande(cmd);
					this.end();
				}
				this.affiche();
			}else{
				for(int i = 0;i < nbCoups;i++){
					this.commande(listeCommande.get(i));
					this.end();
				}
				
			}
			break;
		case "save":
			this.save.sauvegarder(commande[1]);
			this.affiche();
			this.end();
			break;
		case "load":
			this.charger(this.save.charger(commande[1]));
			this.affiche();
			this.end();
			break;
		}
	}
	
	/**
	 * Methode qui test si le jeu est reussi ou non, leve une WinException si reussi
	 * @throws WinException Exception levee lors que le taquin est reussi
	 */
	public void end() throws WinException{
		if(this.plateau.resolu())
			throw new WinException();
	}

	/**
	 * Getteur du Joueur
	 * @return Le Joueur
	 */
	public Joueur getJoueur() {
		return this.joueur;
	}

	/**
	 * Getteur de l'intelligence artificiel
	 * @return L'Ai
	 */
	public Ai getAi() {
		return this.ai;
	}

	/**
	 * Getteur du nombre de melange a faire
	 * @return Le nombre de melange
	 */
	public int getNbMelange() {
		return this.nbMelange;
	}

	/**
	 * Getteur de la taille du Plateau
	 * @return La taille du Plateau
	 */
	public int getTaille() {
		return this.taille;
	}

	/**
	 * Getteur du Plateau
	 * @return Le Plateau
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}

	/**
	 * Getteur du nombre de coups
	 * @return
	 */
	public int getNbCoups() {
		return this.nbCoups;
	}

	/**
	 * Setteur du Plateau
	 * @param plateau
	 */
	public void setPlateau(Plateau plateau){
		this.plateau = new Plateau(plateau);
	}
	
	/**
	 * Methode permettant d afficher le Jeu dans la console de facon lisible
	 */
	public void affiche(){
		System.out.println("==========");
		System.out.println("Nombre de coup : "+this.nbCoups);
		System.out.println("Joueur : "+this.joueur.getNom());
		System.out.println("Score : "+this.joueur.getScore());
		System.out.println(this.plateau.affiche());
	}

}