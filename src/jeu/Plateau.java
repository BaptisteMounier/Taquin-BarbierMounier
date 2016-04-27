package jeu;

public class Plateau {
	
	private Tuile[][] tuiles;
	private int indiceMax;

	public Plateau(Tuile[][] tuiles) {
		this.tuiles = tuiles;
		this.indiceMax = this.tuiles.length * this.tuiles[0].length;
	}

	public Plateau(Plateau plateau) {
		this.tuiles = plateau.GetTuiles();
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
	
	public boolean resolu(){
		boolean res = true;
		for(int j = 0;j < this.tuiles.length;j++){
			for(int i = 0;i < this.tuiles.length;i++){
				if(i != this.tuiles[i][j].getXObjectif() || j != this.tuiles[i][j].getYObjectif())
					res = false;
			}
		}
		return res;
	}
	
	public int getTaille(){
		return this.tuiles.length;
	}

	public int manhattan() {
		int manhattan = 0;
		for(int j = 0;j < this.tuiles.length;j++){
			for(int i = 0;i < this.tuiles.length;i++){
				manhattan += Math.abs(i-this.tuiles[i][j].getXObjectif()) + Math.abs(j-this.tuiles[i][j].getYObjectif());
			}
		}
		return manhattan;
	}

	public int malPlacee() {
		int malPlacee = 0;
		for(int j = 0;j < this.tuiles.length;j++){
			for(int i = 0;i < this.tuiles.length;i++){
				if(i != this.tuiles[i][j].getXObjectif() || j != this.tuiles[i][j].getYObjectif())
					malPlacee++;
			}
		}
		return malPlacee;
	}

	public boolean moveUp() {
		boolean possible = false;
		for(int j = 0;j < this.tuiles.length-1;j++){
			for(int i = 0;i < this.tuiles.length;i++){
				if(this.tuiles[i][j].getIndice() == this.indiceMax){
					this.switchTuiles(i, j, i, j+1);
					possible = true;
				}
			}
		}
		return possible;
	}

	public boolean moveDown() {
		boolean possible = false;
		for(int j = 1;j < this.tuiles.length;j++){
			for(int i = 0;i < this.tuiles.length;i++){
				if(this.tuiles[i][j].getIndice() == this.indiceMax){
					this.switchTuiles(i, j, i, j-1);
					possible = true;
				}
			}
		}
		return possible;
	}

	public boolean moveLeft() {
		boolean possible = false;
		for(int j = 0;j < this.tuiles.length;j++){
			for(int i = 0;i < this.tuiles.length-1;i++){
				if(this.tuiles[i][j].getIndice() == this.indiceMax){
					this.switchTuiles(i, j, i+1, j);
					possible = true;
				}
			}
		}
		return possible;
	}

	public boolean moveRight() {
		boolean possible = false;
		for(int j = 0;j < this.tuiles.length;j++){
			for(int i = 1;i < this.tuiles.length;i++){
				if(this.tuiles[i][j].getIndice() == this.indiceMax){
					this.switchTuiles(i, j, i-1, j);
					possible = true;
				}
			}
		}
		return possible;
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