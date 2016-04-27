package jeu;

import java.util.ArrayList;

import exceptions.WinException;

public class Ai extends Joueur{
	
	public Ai(){
		super("IA");
	}

	public ArrayList<String> aide(Plateau plateau, int nb) throws WinException {
		Etat depart = new Etat(plateau,0 ,new ArrayList<String>());
		Recherche recherche = new Recherche(depart);
		return recherche.recherche();
	}

}
