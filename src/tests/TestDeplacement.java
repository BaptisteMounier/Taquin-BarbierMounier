package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import jeu.*;

public class TestDeplacement {

	Jeu jeu;
	int nb_tuile_x;
	int nb_tuile_y;

	@Before
	public void initialisation(){
		this.jeu = new Jeu();
		this.nb_tuile_x = jeu.getTailleX();
		this.nb_tuile_y = jeu.getTailleY();
		Tuile[][] tuiles = new Tuile[nb_tuile_x][nb_tuile_y];
		tuiles[0][0]= new Tuile(1);
		tuiles[1][0]= new Tuile(2);
		tuiles[2][0]= new Tuile(3);
		tuiles[3][0]= new Tuile(4);
		tuiles[0][1]= new Tuile(5);
		tuiles[1][1]= new Tuile(16);
		tuiles[2][1]= new Tuile(7);
		tuiles[3][1]= new Tuile(8);
		tuiles[0][2]= new Tuile(9);
		tuiles[1][2]= new Tuile(10);
		tuiles[2][2]= new Tuile(11);
		tuiles[3][2]= new Tuile(12);
		tuiles[0][3]= new Tuile(13);
		tuiles[1][3]= new Tuile(14);
		tuiles[2][3]= new Tuile(15);
		tuiles[3][3]= new Tuile(6);
		this.jeu.setPlateau(new Plateau(tuiles));
	}

	@Test
	public void test01_deplacement_haut(){
		this.jeu.commande("z");
		assertTrue("La tuile d'indice 16 devrait �tre en [1][2]",this.jeu.getPlateau().GetTuiles()[1][2].getIndice() == 16);
		assertTrue("La tuile d'indice 10 devrait �tre en [1][1]",this.jeu.getPlateau().GetTuiles()[1][1].getIndice() == 10);
	}

	@Test
	public void test02_deplacement_bas(){
		this.jeu.commande("s");
		assertTrue("La tuile d'indice 16 devrait �tre en [1][0]",this.jeu.getPlateau().GetTuiles()[1][0].getIndice() == 16);
		assertTrue("La tuile d'indice 2 devrait �tre en [1][1]",this.jeu.getPlateau().GetTuiles()[1][1].getIndice() == 2);
	}	

	@Test
	public void test03_deplacement_droite(){
		this.jeu.commande("d");
		assertTrue("La tuile d'indice 16 devrait �tre en [0][1]",this.jeu.getPlateau().GetTuiles()[0][1].getIndice() == 16);
		assertTrue("La tuile d'indice 5 devrait �tre en [1][1]",this.jeu.getPlateau().GetTuiles()[1][1].getIndice() == 5);
	}	

	@Test
	public void test04_deplacement_gauche(){
		this.jeu.commande("q");
		assertTrue("La tuile d'indice 16 devrait �tre en [2][1]",this.jeu.getPlateau().GetTuiles()[2][1].getIndice() == 16);
		assertTrue("La tuile d'indice 7 devrait �tre en [1][1]",this.jeu.getPlateau().GetTuiles()[1][1].getIndice() == 7);
	}	

}