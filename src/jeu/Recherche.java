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
		while(!this.ouvert.isEmpty() && !trouvee){
			Etat actuel = this.ouvertChoix();
			this.ouvert.remove(actuel);
			this.fermee.add(actuel);
			trouvee = actuel.resolu();
			if(!trouvee){
				ArrayList<Etat> listeSuccesseur = actuel.successeur();
				for(Etat successeur : listeSuccesseur){
					this.ouvert.add(successeur);
				}
			}else{
				this.listeCommande = actuel.getListCommande();
			}
		}
		return this.listeCommande;	
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