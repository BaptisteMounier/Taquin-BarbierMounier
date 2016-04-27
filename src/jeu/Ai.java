package jeu;

import java.util.Stack;

import exceptions.WinException;

public class Ai extends Joueur{
	
	private Stack listeComplete;
	
	public Plateau aideComplete(Plateau plateau){
		return plateau;
	}
	
	public void setListeComplete(Stack stack){
		this.listeComplete = stack;
	}
	
	public Stack getListeComplete(){
		return this.listeComplete;
	}

	public void aide(Jeu jeu, int nb) throws WinException {
		if(nb == 0){
			
		}else{
			for(int iteration = 0;iteration < nb;iteration++){
				int base = jeu.getPlateau().manhattan();
				String commande = "stop";
				boolean find = false;
				String[] commandeListe = {"z","s","q","d","stop"};
				int i = 0;
				while(!find){
					Jeu j = new Jeu(jeu);
					j.commande(commandeListe[i]);
					if(base > j.getPlateau().manhattan() || commandeListe[i].equals("stop")){
						commande = commandeListe[i];
						find = true;
					}else
						i++;
				}
				jeu.commande(commande);
				jeu.affiche();
				jeu.end();
			}
		}
	}

}
