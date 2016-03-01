package jeu;

public class Jeu {
	
	private Plateau plateau;
	
	public Jeu(){
		this.plateau = null;
	}
	
	public int TAILLE_PLATEAU_X = 4;

	public int TAILLE_PLATEAU_Y = 4;
	
	public void initialisation(){
		int n=1;
		Tuile[][] tuiles = new Tuile[TAILLE_PLATEAU_X][TAILLE_PLATEAU_Y];
		for (int i=0; i < TAILLE_PLATEAU_X; i++){
			for (int j=0; j < TAILLE_PLATEAU_Y; j++){
				tuiles[i][j]= new Tuile(n);
				n++;
			}
		}
		
		//tuiles[0][0] = new Tuile(1);
		//tuiles[0][1] = new Tuile(2);
		//tuiles[0][2] = new Tuile(3);
		//tuiles[0][3] = new Tuile(4);
		//tuiles[1][0] = new Tuile(5);
		//tuiles[1][1] = new Tuile(6);
		//tuiles[1][2] = new Tuile(7);
		//tuiles[1][3] = new Tuile(8);
		//tuiles[2][0] = new Tuile(9);
		//tuiles[2][1] = new Tuile(10);
		//tuiles[2][2] = new Tuile(11);
		//tuiles[2][3] = new Tuile(12);
		//tuiles[3][0] = new Tuile(13);
		//tuiles[3][1] = new Tuile(14);
		//tuiles[3][2] = new Tuile(15);
		//tuiles[3][3] = new Tuile(16);
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
