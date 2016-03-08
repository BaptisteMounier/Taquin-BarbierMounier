package jeu;

public class Plateau {
	
	private Tuile[][] tuiles;

	public Plateau(Tuile[][] tuiles) {
		this.tuiles = tuiles;
	}
	
	public Tuile[][] GetTuiles(){
		return this.tuiles;
	}
	
	public void SetTuiles(Tuile[][] tuiles){
		this.tuiles = tuiles;
	}
	
	public void switchTuiles(int x_a, int y_a, int x_b, int y_b){
		Tuile temporaire = this.tuiles[x_a][y_a];
		this.tuiles[x_a][y_a] = this.tuiles[x_b][y_b];
		this.tuiles[x_b][y_b] = temporaire;
	}
	
	public String toString(){
		String string = "";
		for(int i = 0;i < this.tuiles.length;i++){
			for(int j = 0;j < this.tuiles[i].length;j++){
				string += this.tuiles[i][j].toString();
			}
			string += "\n";
		}
		return string;
	}

}