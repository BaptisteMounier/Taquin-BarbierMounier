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
		Tuile[][] tuiles = new Tuile[2][2];
		tuiles[1][1]= new Tuile(1,0,0);
		tuiles[0][1]= new Tuile(2,0,1);
		tuiles[0][0]= new Tuile(3,1,0);
		tuiles[1][0]= new Tuile(4,1,1);
		Plateau plateau = new Plateau(tuiles);
		int manhattan = plateau.manhattan();
		assertTrue("La distance Manhattan devrait être 4 et non "+manhattan,manhattan == 4);
	}

}