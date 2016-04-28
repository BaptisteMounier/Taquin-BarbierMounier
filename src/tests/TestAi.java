package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import exceptions.WinException;
import jeu.*;

public class TestAi {

	@Test
	public void test01_manhattan(){
		Tuile[][] tuiles = new Tuile[4][4];
		tuiles[0][0]= new Tuile(1,0,0);
		tuiles[0][1]= new Tuile(2,0,1);
		tuiles[0][2]= new Tuile(3,0,2);
		tuiles[0][3]= new Tuile(4,0,3);
		tuiles[1][0]= new Tuile(5,1,0);
		tuiles[1][1]= new Tuile(6,1,1);
		tuiles[1][2]= new Tuile(7,1,2);
		tuiles[1][3]= new Tuile(8,1,3);
		tuiles[2][0]= new Tuile(9,2,0);
		tuiles[2][1]= new Tuile(10,2,1);
		tuiles[2][2]= new Tuile(11,2,2);
		tuiles[2][3]= new Tuile(15,3,2);
		tuiles[3][0]= new Tuile(13,3,0);
		tuiles[3][1]= new Tuile(14,3,1);
		tuiles[3][2]= new Tuile(0,3,3);
		tuiles[3][3]= new Tuile(12,2,3);
		Plateau plateau = new Plateau(tuiles, 4, 0, 16);
		int manhattan = plateau.manhattan();
		assertTrue("La distance Manhattan devrait être 4 et non "+manhattan,manhattan == 4);
	}

	@Test
	public void test02_mal_placee(){
		Tuile[][] tuiles = new Tuile[4][4];
		tuiles[0][0]= new Tuile(1,0,0);
		tuiles[0][1]= new Tuile(2,0,1);
		tuiles[0][2]= new Tuile(3,0,2);
		tuiles[0][3]= new Tuile(4,0,3);
		tuiles[1][0]= new Tuile(5,1,0);
		tuiles[1][1]= new Tuile(6,1,1);
		tuiles[1][2]= new Tuile(7,1,2);
		tuiles[1][3]= new Tuile(8,1,3);
		tuiles[2][0]= new Tuile(9,2,0);
		tuiles[2][1]= new Tuile(10,2,1);
		tuiles[2][2]= new Tuile(11,2,2);
		tuiles[2][3]= new Tuile(15,3,2);
		tuiles[3][0]= new Tuile(13,3,0);
		tuiles[3][1]= new Tuile(14,3,1);
		tuiles[3][2]= new Tuile(0,3,3);
		tuiles[3][3]= new Tuile(12,2,3);
		Plateau plateau = new Plateau(tuiles, 4, 0, 16);
		int malPlacee = plateau.malPlacee();
		assertTrue("Le nombre de tuile mal placée devrait être 3 et non "+malPlacee,malPlacee == 3);
	}

	@Test(expected = WinException.class)
	public void test03_resolution() throws WinException{
		Jeu jeu = new Jeu();
		jeu.initialisation();
		jeu.commande("ai 0");
	}

}