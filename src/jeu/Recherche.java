package jeu;

import java.util.ArrayList;

/**
 * Classe de recherche de resolution du type A*
 */
public class Recherche {
	
	/**
	 * Liste des etats ouverts
	 */
	private ArrayList<Etat> ouvert;
	
	/**
	 * Liste des etats fermes
	 */
	private ArrayList<Etat> fermee;
	
	/**
	 * Liste des commandes pour atteindre la resolution
	 */
	private ArrayList<String> listeCommande;
	
	/**
	 * Constructeur a partir du premier etat sur lequel on effectue la recherche
	 * @param e Premier etat de la recherche
	 */
	public Recherche(Etat e){
		this.ouvert = new ArrayList<Etat>();
		this.ouvert.add(e);
		this.fermee = new ArrayList<Etat>();
		this.listeCommande = new ArrayList<String>();
	}
	
	/**
	 * Methode de recherche A*
	 * @return La liste des commandes pour atteindre l etat de resolution
	 */
	public ArrayList<String> recherche(){
		boolean trouvee = false;
		while(!this.ouvert.isEmpty() && !trouvee){
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
	
	/**
	 * Methode privee permettant d obtenir l etat dans la liste ouverte qui a le plus faible cout total
	 * @return L etat avec le cout total le plus faible
	 */
	private Etat ouvertChoix(){
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