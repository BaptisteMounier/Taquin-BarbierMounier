package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import jeu.*;

public class TestManhattan {

	@Test
	public void test01_manhattan(){
		Tuile[][] tuiles = new Tuile[2][2];
		tuiles[0][0]= new Tuile(1,0,0);
		tuiles[0][1]= new Tuile(2,0,1);
		tuiles[1][1]= new Tuile(3,1,0);
		tuiles[1][0]= new Tuile(4,1,1);
		Plateau plateau = new Plateau(tuiles);
		int manhattan = plateau.manhattan();
		assertTrue("La distance Manhattan devrait être 2 et non "+manhattan,manhattan == 2);
	}

	@Test
	public void test02_manhattan(){
		Tuile[][] tuiles = new Tuile[4][4];
		tuiles[0][0]= new Tuile(1,0,0);
		tuiles[1][0]= new Tuile(2,1,0);
		tuiles[2][0]= new Tuile(3,2,0);
		tuiles[3][0]= new Tuile(4,3,0);
		tuiles[0][1]= new Tuile(5,0,1);
		tuiles[1][1]= new Tuile(6,1,1);
		tuiles[2][1]= new Tuile(7,2,1);
		tuiles[3][1]= new Tuile(8,3,1);
		tuiles[0][2]= new Tuile(9,0,2);
		tuiles[1][2]= new Tuile(10,1,2);
		tuiles[2][2]= new Tuile(16,3,3);
		tuiles[3][2]= new Tuile(11,2,2);
		tuiles[0][3]= new Tuile(13,0,3);
		tuiles[1][3]= new Tuile(14,1,3);
		tuiles[2][3]= new Tuile(15,2,3);
		tuiles[3][3]= new Tuile(12,3,2);
		Plateau plateau = new Plateau(tuiles);
		int manhattan = plateau.manhattan();
		assertTrue("La distance Manhattan devrait être 4 et non "+manhattan,manhattan == 4);
	}

}