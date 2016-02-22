package jeu;

public class Tuile {
	
	private int indice;
	
	public Tuile(int i){
		this.indice = i;
	}
	
	public String toString(){
		return Integer.toString(this.indice);
	}

}
