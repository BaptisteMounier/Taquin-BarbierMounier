package jeu;

import java.util.Scanner;

public class Jeu {
	
	private Plateau plateau;
	private int taille;
	
	public Jeu(){
		this.plateau = null;
	}
	
	public void initialisation(){
		this.taille = 4;
		Tuile[][] tuiles = new Tuile[4][4];
		tuiles[0][0] = new Tuile(1);
		tuiles[0][1] = new Tuile(2);
		tuiles[0][2] = new Tuile(3);
		tuiles[0][3] = new Tuile(4);
		tuiles[1][0] = new Tuile(5);
		tuiles[1][1] = new Tuile(6);
		tuiles[1][2] = new Tuile(7);
		tuiles[1][3] = new Tuile(8);
		tuiles[2][0] = new Tuile(9);
		tuiles[2][1] = new Tuile(10);
		tuiles[2][2] = new Tuile(11);
		tuiles[2][3] = new Tuile(12);
		tuiles[3][0] = new Tuile(13);
		tuiles[3][1] = new Tuile(14);
		tuiles[3][2] = new Tuile(15);
		tuiles[3][3] = new Tuile(16);
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