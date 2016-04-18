package jeu;

import java.util.Stack;

public class Ai extends Joueur{
	
	private Stack listeComplete;

	public Plateau aidePartielle(Plateau plateau, int nb) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Plateau aideComplete(Plateau plateau){
		return plateau;
	}
	
	public void setListeComplete(Stack stack){
		this.listeComplete = stack;
	}
	
	public Stack getListeComplete(){
		return this.listeComplete;
	}

	public void aide(Jeu jeu, int nb) {
		if(nb == 0){
			
		}else{
			for(int iteration = 0;iteration < nb;iteration++){
				int base = jeu.getPlateau().manhattan();
				String commande = "stop";
				boolean end = false;
				String[] commandeListe = {"z","s","q","d","stop"};
				int i = 0;
				while(!end){
					Jeu j = new Jeu(jeu);
					j.commande(commandeListe[i]);
					if(base > j.getPlateau().manhattan() || commandeListe[i].equals("stop")){
						commande = commandeListe[i];
						end = true;
					}else
						i++;
				}
				jeu.commande(commande);
			}
		}
	}

}
