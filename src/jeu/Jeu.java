package jeu;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.WinException;

public class Jeu {
	
	private Plateau plateau;
	private int taille;
	private ArrayList<Integer> idTuiles;
	private int nb_tuile_x;
	private int nb_tuile_y;
	
	public Jeu(){
		this.plateau = null;
		this.taille = 4;
		this.nb_tuile_x = this.taille;
		this.nb_tuile_y = this.taille;
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
		this.affiche();
	}
	
	public void Pas() throws WinException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel déplacement souhaitez-vous ?");
		String com = sc.nextLine();
		this.commande(com);
		this.affiche();
		this.end();
	}
	
	public void commande(String c){
		boolean find = false;
		switch(c){
		case "z":
			for(int i = 0;i < this.nb_tuile_x && !find;i++){
				for(int j = 0;j < this.nb_tuile_y-1 && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.nb_tuile_x*this.nb_tuile_y){
						this.plateau.switchTuiles(i, j, i, j+1);
						find = true;
					}
				}
			}
			break;
		case "s":
			for(int i = 0;i < this.nb_tuile_x && !find;i++){
				for(int j = 1;j < this.nb_tuile_y && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.nb_tuile_x*this.nb_tuile_y){
						this.plateau.switchTuiles(i, j, i, j-1);
						find = true;
					}
				}
			}
			break;
		case "q":
			for(int i = 0;i < this.nb_tuile_x-1 && !find;i++){
				for(int j = 0;j < this.nb_tuile_y && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.nb_tuile_x*this.nb_tuile_y){
						this.plateau.switchTuiles(i, j, i+1, j);
						find = true;
					}
				}
			}
			break;
		case "d":
			for(int i = 1;i < this.nb_tuile_x && !find;i++){
				for(int j = 0;j < this.nb_tuile_y && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.nb_tuile_x*this.nb_tuile_y){
						this.plateau.switchTuiles(i, j, i-1, j);
						find = true;
					}
				}
			}
			break;
		case "ai":
			break;
		case "aiFull":
			break;
		case "cheat":
			break;
		default:
			break;
		}
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
	
	public int getTailleX(){
		return this.nb_tuile_x;
	}
	
	public int getTailleY(){
		return this.nb_tuile_y;
	}
	
	public void end() throws WinException{
		boolean gagne = true;
		int cpt = 1;
		Tuile[][] tuiles = this.getTuiles();
		for(int i = 0;i < tuiles.length;i++){
			for(int j = 0;j < tuiles[i].length;j++){
				if(tuiles[j][i].getIndice()!=cpt)
					gagne = false;
				cpt++;
			}
		}
		if(gagne)
			throw new WinException();
	}
	
	public void affiche(){
		Tuile[][] tuiles = this.getTuiles();
		for(int i = 0;i < tuiles.length;i++){
			for(int j = 0;j < tuiles[i].length;j++){
				System.out.print(tuiles[j][i]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("==========\n");
	}

}