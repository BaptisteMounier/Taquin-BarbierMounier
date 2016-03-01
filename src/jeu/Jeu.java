package jeu;

import java.util.Scanner;

public class Jeu {
	
	private Plateau plateau;
	private int taille;
	
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
		this.plateau = new Plateau(tuiles);
	}
	
	public void Pas(){
		this.affiche();
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel déplacement souhaitez-vous ?");
		String com = sc.nextLine();
		this.commande(com);
	}
	
	public void commande(String c){
		
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
	
	public void affiche(){
		Tuile[][] tuiles = this.getTuiles();
		for(int i = 0;i < tuiles.length;i++){
			for(int j = 0;j < tuiles[i].length;j++){
				System.out.print(tuiles[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("==========\n");
	}

}