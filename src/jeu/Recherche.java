package jeu;

import java.util.ArrayList;

public class Recherche {
	
	private Etat etat;
	private ArrayList<Etat> ouvert;
	private ArrayList<Etat> fermee;
	private ArrayList<String> listeCommande;
	
	public Recherche(Etat e){
		this.etat = e;
		this.ouvert = new ArrayList<Etat>();
		this.ouvert.add(this.etat);
		this.fermee = new ArrayList<Etat>();
		this.listeCommande = new ArrayList<String>();
	}
	
	public ArrayList<String> recherche(){
		boolean trouvee = false;
		while(!this.ouvert.isEmpty() || trouvee){
			Etat actuel = this.ouvertChoix();
			trouvee = actuel.resolu();
			for(Etat successeur : actuel.successeur()){
				if(!this.ouvert.contains(successeur) || !this.fermee.contains(successeur)){
					this.ouvert.add(successeur);
					
				}else if(true){
					if(this.fermee.contains(successeur)){
						this.ouvert.add(successeur);
						this.fermee.remove(successeur);
					}
				}
			}
		}
		return listeCommande;	
	}
	
	public Etat ouvertChoix(){
		Etat mini = this.ouvert.get(0);
		for(Etat e : this.ouvert){
			if(e.getMini() < mini.getMini())
				mini = e;
		}
		this.ouvert.remove(mini);
		this.fermee.add(mini);
		return mini;
	}

}
