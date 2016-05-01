package jeu;

/**
 * Classe represantant le Plateau
 */
public class Plateau {
	
	/**
	 * Les tuiles du plateau
	 */
	private Tuile[][] tuiles;
	
	/**
	 * La taille du plateau
	 */
	private int taille;
	
	/**
	 * Le nombre de melange fait pour mélanger les tuiles
	 */
	private int nbMelange;
	
	/**
	 * L indice maximum des tuiles, permet de retrouver plus facilement l emplacement vide de tuile
	 */
	private int indiceMax;

	/**
	 * Constructeur a partir de la taille et du nombre de melange
	 * @param taille La taille du Plateau
	 * @param nbMelange Le nombre de melange du Plateau
	 */
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

	/**
	 * Constructeur de copie de Pableau
	 * @param plateau Plateau a copier
	 */
	public Plateau(Plateau plateau) {
		this.taille = plateau.getTaille();
		this.indiceMax = this.taille * this.taille;
		this.nbMelange = plateau.getNbMelange();
		this.tuiles = new Tuile[this.taille][this.taille];
		for (int i=0;i < this.taille;i++){
			for (int j=0; j < this.taille; j++){
				int indice = plateau.getTuiles()[i][j].getIndice();
				this.tuiles[i][j]= new Tuile(indice,plateau.getTuiles()[i][j].getIObjectif(),plateau.getTuiles()[i][j].getJObjectif());
			}
		}
	}
	
	/**
	 * Constructeur a partir de tous les elements d un Plateau
	 * @param tuiles Les tuiles du Plateau
	 * @param taille La taille du Plateau
	 * @param nbMelange Le nombre demelange du Plateau
	 * @param indiceMax L indice maximum du Plateau
	 */
	public Plateau(Tuile[][] tuiles, int taille, int nbMelange, int indiceMax){
		this.tuiles = tuiles;
		this.taille = taille;
		this.nbMelange = nbMelange;
		this.indiceMax = indiceMax;
	}

	/**
	 * Methode d initialisation du Plateau
	 */
	public void initialisation() {
		this.melanger();
	}

	/**
	 * Methode qui melange le Plateau
	 */
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

	/**
	 * Methode qui calcule la somme des distances de manhattan des tuiles du Plateau entre leur position actuelle et celle desire
	 * @return La somme des distances de manhattan
	 */
	public int manhattan() {
		int manhattan = 0;
		for(int i = 0;i < this.taille;i++){
			for(int j = 0;j < this.taille;j++){
				manhattan += Math.abs(i-this.tuiles[i][j].getIObjectif()) + Math.abs(j-this.tuiles[i][j].getJObjectif());
			}
		}
		return manhattan;
	}

	/**
	 * Methode de calcule du nombre de tuile encore mal placee
	 * @return Le nombre de tuile mal placee
	 */
	public int malPlacee() {
		int malPlacee = 0;
		for(int i = 0;i < this.taille;i++){
			for(int j = 0;j < this.taille;j++){
				if(i != this.tuiles[i][j].getIObjectif() || j != this.tuiles[i][j].getJObjectif())
					malPlacee++;
			}
		}
		return malPlacee;
	}
	
	/**
	 * Methode qui regarde si le PLateau est resolu
	 * @return
	 */
	public boolean resolu(){
		boolean res = true;
		for(int i = 0;i < this.taille;i++){
			for(int j = 0;j < this.taille;j++){
				if(i != this.tuiles[i][j].getIObjectif() || j != this.tuiles[i][j].getJObjectif())
					res = false;
			}
		}
		return res;
	}
	
	/**
	 * Methode qui inverse les positions de deux tuiles
	 * @param i_a La position en i de la 1ere tuile
	 * @param j_a La position en j de la 1ere tuile
	 * @param i_b La position en i de la 2nde tuile
	 * @param j_b La position en j de la 2nde tuile
	 */
	public void switchTuiles(int i_a, int j_a, int i_b, int j_b){
		Tuile temporaire = this.tuiles[i_a][j_a];
		this.tuiles[i_a][j_a] = this.tuiles[i_b][j_b];
		this.tuiles[i_b][j_b] = temporaire;
	}

	/**
	 * Methode qui pousse la tuile vers le haut (recherche de la seule tuile pouvant se deplacer dans cette direction et renvois Vrai si le deplacement est possible
	 * @return Vrai si le deplacement a eu lieu, faux sinon
	 */
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
	
	/**
	 * Methode qui pousse la tuile vers le bas (recherche de la seule tuile pouvant se deplacer dans cette direction et renvois Vrai si le deplacement est possible
	 * @return Vrai si le deplacement a eu lieu, faux sinon
	 */
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

	/**
	 * Methode qui pousse la tuile vers la gauche (recherche de la seule tuile pouvant se deplacer dans cette direction et renvois Vrai si le deplacement est possible
	 * @return Vrai si le deplacement a eu lieu, faux sinon
	 */
	public boolean moveLeft() {
		boolean possible = false;
		for(int i = 0;i < this.taille && !possible;i++){
			for(int j = 0;j < this.taille-1 && !possible;j++){
				if(this.tuiles[i][j].getIndice() == 0){
					this.switchTuiles(i, j, i, j+1);
					possible = true;
				}
			}
		}
		return possible;
	}

	/**
	 * Methode qui pousse la tuile vers la droite (recherche de la seule tuile pouvant se deplacer dans cette direction et renvois Vrai si le deplacement est possible
	 * @return Vrai si le deplacement a eu lieu, faux sinon
	 */
	public boolean moveRight() {
		boolean possible = false;
		for(int i = 0;i < this.taille && !possible;i++){
			for(int j = 1;j < this.taille && !possible;j++){
				if(this.tuiles[i][j].getIndice() == 0){
					this.switchTuiles(i, j, i, j-1);
					possible = true;
				}
			}
		}
		return possible;
	}
	
	/**
	 * Getteur des tuiles
	 * @return Les tuiles
	 */
	public Tuile[][] getTuiles(){
		return this.tuiles;
	}
	
	/**
	 * Getteur de la taille du Plateau
	 * @return La taille
	 */
	public int getTaille(){
		return this.taille;
	}
	
	/**
	 * Getteur du nombre de melange effectue
	 * @return Le nombre de melange
	 */
	public int getNbMelange(){
		return this.nbMelange;
	}

	/**
	 * Getteur de l indice maximum des tuiles
	 * @return L indice maximum
	 */
	public int getIndiceMax() {
		return this.indiceMax;
	}
	
	/**
	 * Methode de comparaison avec un autre Plateau
	 * @param p Autre Plateau avec qui on compare
	 */
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
	
	/**
	 * Methode qui renvois un String contenant l'affichage du Plateau
	 * @return
	 */
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