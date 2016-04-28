package jeu;

import java.util.ArrayList;

public class Recherche {
	
	private ArrayList<Etat> ouvert;
	private ArrayList<Etat> fermee;
	private ArrayList<String> listeCommande;
	
	public Recherche(Etat e){
		this.ouvert = new ArrayList<Etat>();
		this.ouvert.add(e);
		this.fermee = new ArrayList<Etat>();
		this.listeCommande = new ArrayList<String>();
	}
	
	public ArrayList<String> recherche(){
		boolean trouvee = false;
		int cpt = 0;
		while(!this.ouvert.isEmpty() && !trouvee){
			// temporaire
			System.out.println("compteur : "+cpt);
			cpt++;
			// temporaire
			Etat actuel = this.ouvertChoix();
			this.listeCommande = actuel.getListCommande();
			trouvee = actuel.resolu();
			if(!trouvee){
				ArrayList<Etat> listeSuccesseur = actuel.successeur();
				for(Etat successeur : listeSuccesseur){
					if(!this.ouvert.contains(successeur)){
						if(!this.fermee.contains(successeur)){
							this.ouvert.add(successeur);
						}else{
							Etat old = this.fermee.get(this.fermee.indexOf(successeur));
							if(successeur.getCout() < old.getCout()){
								this.fermee.remove(old);
								this.ouvert.add(successeur);
							}
						}
					}else{
						Etat old = this.ouvert.get(this.ouvert.indexOf(successeur));
						if(successeur.getCout() < old.getCout()){
							this.ouvert.remove(old);
							this.ouvert.add(successeur);
						}
					}
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
			if(e.getCout() < mini.getCout())
				mini = e;
		}
		this.ouvert.remove(mini);
		this.fermee.add(mini);
		return mini;
	}

}