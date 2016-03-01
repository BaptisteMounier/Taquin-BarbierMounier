package jeu;

public class Tuile {
	
	private int indice;
	
	public Tuile(int i){
		this.indice = i;
	}
	
	public String toString(){
		if(this.indice >= 10)
			return Integer.toString(this.indice);
		else
			return "0"+Integer.toString(this.indice);
	}

}
