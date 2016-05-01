package jeu;

/**
 * Classe representant une tuile
 */
public class Tuile {
	
	/**
	 * Indice de la tuile
	 */
	private int indice;
	
	/**
	 * Objectif de position suivant i
	 */
	private int iObjectif;
	
	/**
	 * Objectif de position suivant j
	 */
	private int jObjectif;
	
	/**
	 * Constructeur a partir de l indice, l objectif de position suivant i et suivant j
	 * @param i indice de la tuile
	 * @param io Objectif de position suiant i
	 * @param jo Objectif de position suiant j
	 */
	public Tuile(int i, int io, int jo){
		this.indice = i;
		this.iObjectif = io;
		this.jObjectif = jo;
	}
	
	/**
	 * Methode d affichage de la tuile
	 */
	public String toString(){
		if(this.indice == 0)
			return "  ";
		if(this.indice >= 10)
			return Integer.toString(this.indice);
		else
			return "0"+Integer.toString(this.indice);
	}
	
	/**
	 * Getteur de l indice de la tuile
	 * @return Indice de la tuile
	 */
	public int getIndice(){
		return this.indice;
	}

	/**
	 * Getteur de l objetif suivant i
	 * @return Objectif suivant i
	 */
	public int getIObjectif() {
		return this.iObjectif;
	}

	/**
	 * Getteur de l objectif suivant j
	 * @return Objectif suivant j
	 */
	public int getJObjectif() {
		return this.jObjectif;
	}

}
