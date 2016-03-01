package jeu;

public class Jeu {
	
	private Plateau plateau;
	
	public Jeu(){
		this.plateau = null;
	}
	
	public int NB_TUILE_X = 4;
	
	public int NB_TUILE_Y = 4;
	
	public void initialisation(){
		int n=1;
		Tuile[][] tuiles = new Tuile[NB_TUILE_X][NB_TUILE_Y];
		for (int i=0; i < NB_TUILE_X; i++){
			for (int j=0; j < NB_TUILE_Y; j++){
				tuiles[i][j]= new Tuile(n);
				n++;
			}
		}
		this.plateau = new Plateau(tuiles);
	}
	
	public void Pas(){
		
	}
	
	public Plateau getPlateau(){
		return this.plateau;
	}
	
	public Tuile[][] getTuiles(){
		return this.plateau.GetTuiles();
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

}
