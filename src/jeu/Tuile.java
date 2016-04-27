package jeu;

public class Tuile {
	
	private int indice;
	private int xObjectif;
	private int yObjectif;
	
	public Tuile(int i, int x, int y){
		this.indice = i;
		this.xObjectif = x;
		this.yObjectif = y;
	}
	
	public String toString(){
		if(this.indice == 0)
			return "  ";
		if(this.indice >= 10)
			return Integer.toString(this.indice);
		else
			return "0"+Integer.toString(this.indice);
	}
	
	public int getIndice(){
		return this.indice;
	}

	public int getXObjectif() {
		return this.xObjectif;
	}

	public int getYObjectif() {
		return this.yObjectif;
	}

}
