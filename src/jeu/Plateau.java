package jeu;

public class Plateau {
	
	private Tuile[][] tuiles;
	private int taille;
	private int nbMelange;
	private int indiceMax;

	public Plateau(int taille, int nbMelange) {
		this.taille = taille;
		this.indiceMax = this.taille * this.taille;
		this.nbMelange = nbMelange;
		this.tuiles = new Tuile[this.taille][this.taille];
		int id = 1;
		for (int i=0; i < this.taille; i++){
			for (int j=0; j < this.taille; j++){
				if(id == taille*taille)
					this.tuiles[i][j]= new Tuile(0,i,j);
				else
					this.tuiles[i][j]= new Tuile(id,i,j);
				id++;
			}
		}
	}

	public Plateau(Plateau plateau) {
		this.taille = plateau.getTaille();
		this.indiceMax = this.taille * this.taille;
		this.nbMelange = plateau.getNbMelange();
		this.tuiles = new Tuile[this.taille][this.taille];
		for (int i=0;i < this.taille;i++){
			for (int j=0; j < this.taille; j++){
				int indice = plateau.getTuiles()[i][j].getIndice();
				this.tuiles[i][j]= new Tuile(indice,plateau.getTuiles()[i][j].getXObjectif(),plateau.getTuiles()[i][j].getYObjectif());
			}
		}
	}
	
	public Plateau(Tuile[][] tuiles, int taille, int nbMelange, int indiceMax){
		this.tuiles = tuiles;
		this.taille = taille;
		this.nbMelange = nbMelange;
		this.indiceMax = indiceMax;
	}

	public void initialisation() {
		this.melanger();
	}

	private void melanger() {
		int i = 0;
		while(i < this.nbMelange){
			int alea = (int)(Math.random()*4);
			switch (alea){
				case 0:
					if(this.moveUp())
						i++;
					break;
				case 1:
					if(this.moveDown())
						i++;
					break;
				case 2:
					if(this.moveLeft())
						i++;
					break;
				case 3:
					if(this.moveRight())
						i++;
					break;
			}
		}
	}

	public int manhattan() {
		int manhattan = 0;
		for(int i = 0;i < this.taille;i++){
			for(int j = 0;j < this.taille;j++){
				manhattan += Math.abs(i-this.tuiles[i][j].getXObjectif()) + Math.abs(j-this.tuiles[i][j].getYObjectif());
			}
		}
		return manhattan;
	}

	public int malPlacee() {
		int malPlacee = 0;
		for(int i = 0;i < this.taille;i++){
			for(int j = 0;j < this.taille;j++){
				if(i != this.tuiles[i][j].getXObjectif() || j != this.tuiles[i][j].getYObjectif())
					malPlacee++;
			}
		}
		return malPlacee;
	}
	
	public boolean resolu(){
		boolean res = true;
		for(int i = 0;i < this.taille;i++){
			for(int j = 0;j < this.taille;j++){
				if(i != this.tuiles[i][j].getXObjectif() || j != this.tuiles[i][j].getYObjectif())
					res = false;
			}
		}
		return res;
	}
	
	public void switchTuiles(int x_a, int y_a, int x_b, int y_b){
		Tuile temporaire = this.tuiles[x_a][y_a];
		this.tuiles[x_a][y_a] = this.tuiles[x_b][y_b];
		this.tuiles[x_b][y_b] = temporaire;
	}

	public boolean moveUp() {
		boolean possible = false;
		for(int i = 0;i < this.taille-1 && !possible;i++){
			for(int j = 0;j < this.taille && !possible;j++){
				if(this.tuiles[i][j].getIndice() == 0){
					this.switchTuiles(i, j, i+1, j);
					possible = true;
				}
			}
		}
		return possible;
	}

	public boolean moveDown() {
		boolean possible = false;
		for(int i = 1;i < this.taille && !possible;i++){
			for(int j = 0;j < this.taille && !possible;j++){
				int tempo = this.tuiles[i][j].getIndice();
				if(this.tuiles[i][j].getIndice() == 0){
					this.switchTuiles(i, j, i-1, j);
					possible = true;
				}
			}
		}
		return possible;
	}

	public boolean moveLeft() {
		boolean possible = false;
		for(int i = 0;i < this.taille && !possible;i++){
			for(int j = 0;j < this.taille-1 && !possible;j++){
				if(this.tuiles[i][j].getIndice() == 0){
					this.switchTuiles(i, j, i, j-1);
					possible = true;
				}
			}
		}
		return possible;
	}

	public boolean moveRight() {
		boolean possible = false;
		for(int i = 0;i < this.taille && !possible;i++){
			for(int j = 1;j < this.taille && !possible;j++){
				if(this.tuiles[i][j].getIndice() == 0){
					this.switchTuiles(i, j, i, j+1);
					possible = true;
				}
			}
		}
		return possible;
	}
	
	public Tuile[][] getTuiles(){
		return this.tuiles;
	}
	
	public int getTaille(){
		return this.taille;
	}
	
	public int getNbMelange(){
		return this.nbMelange;
	}

	public int getIndiceMax() {
		return this.indiceMax;
	}
	
	public boolean equals(Object p){
		boolean identique = true;
		for(int i = 0;i < this.taille && identique;i++){
			for(int j = 0;j < this.taille-1 && identique;j++){
				if(this.tuiles[i][j].getIndice() != ((Plateau)(p)).getTuiles()[i][j].getIndice())
					identique = false;
			}
		}		
		return identique;
	}
	
	public String affiche(){
		String string = "";
		for(int i = 0;i < this.tuiles.length;i++){
			for(int j = 0;j < this.tuiles[i].length;j++){
				string += this.tuiles[i][j].toString()+" ";
			}
			if(i < this.tuiles.length-1)
				string += "\n";
		}
		return string;
	}

}