package jeu;

public class Tuile {
	
	private int indice;
	private int largeur; //largeur tuile
	private int hauteur;// hauteur tuile
	
	public Tuile(int i){
		this.indice = i;
	}
	
	public String toString(){
		if(this.indice >= 10)
			return Integer.toString(this.indice);
		else
			return "0"+Integer.toString(this.indice);
	}

	public int get_largeur() {
		return largeur;
	}

	public void set_largeur(int x) {
		this.largeur = x;
	}

	public int get_hauteur() {
		return hauteur;
	}

	public void set_hauteur(int y) {
		this.hauteur = y;
	}
	
	public int getIndice(){
		return this.indice;
	}

}
