package tests;

import org.junit.Before;
import org.junit.Test;

import exceptions.WinException;
import jeu.*;

public class TestFinJeu {

	Jeu jeu;
	int nb_tuile;

	@Before
	public void initialisation(){
		this.jeu = new Jeu();
		this.nb_tuile = jeu.getTaille();
	}

	@Test(expected = WinException.class)
	public void test01_finDeJeu_vitoire() throws WinException {
		Tuile[][] tuiles = new Tuile[nb_tuile][nb_tuile];
		int ind = 1;
		for (int i=0; i < nb_tuile; i++){
			for (int j=0; j < nb_tuile; j++){
				tuiles[i][j]= new Tuile(ind,i,j);
				ind++;
			}
		}
		this.jeu.setPlateau(new Plateau(tuiles, nb_tuile, 0, nb_tuile*nb_tuile));
		this.jeu.end();
	}	

}