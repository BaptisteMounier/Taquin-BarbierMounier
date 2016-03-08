package jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
	
	private Plateau plateau;
	private int taille;
	private ArrayList<Integer> idTuiles;
	private int nb_tuile_x;
	private int nb_tuile_y;
	
	public Jeu(){
		this.plateau = null;
		this.nb_tuile_x = 4;
		this.nb_tuile_y = 4;
		this.idTuiles = new ArrayList<Integer>();
		for(int i = 1;i <= this.nb_tuile_x*this.nb_tuile_y;i++){
			this.idTuiles.add(this.idTuiles.size(), i);
		}
	}
	
	public void initialisation(){
		Tuile[][] tuiles = new Tuile[nb_tuile_x][nb_tuile_y];
		for (int i=0; i < nb_tuile_x; i++){
			for (int j=0; j < nb_tuile_y; j++){
				int alea = (int) (Math.random()*this.idTuiles.size());
				int id = this.idTuiles.get(alea);
				tuiles[i][j]= new Tuile(id);
				this.idTuiles.remove(alea);
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