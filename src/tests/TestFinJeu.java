package tests;

import org.junit.Before;
import org.junit.Test;

import exceptions.WinException;
import jeu.*;

public class TestFinJeu {

	Jeu jeu;
	int nb_tuile_x;
	int nb_tuile_y;

	@Before
	public void initialisation(){
		this.jeu = new Jeu();
		this.nb_tuile_x = jeu.getTailleX();
		this.nb_tuile_y = jeu.getTailleY();
	}

	@Test(expected = WinException.class)
	public void test01_finDeJeu_vitoire() throws WinException {
		Tuile[][] tuiles = new Tuile[nb_tuile_x][nb_tuile_y];
		int ind = 1;
		for (int i=0; i < nb_tuile_x; i++){
			for (int j=0; j < nb_tuile_y; j++){
				tuiles[j][i]= new Tuile(ind,i,j);
				ind++;
			}
		}
		this.jeu.setPlateau(new Plateau(tuiles));
		this.jeu.end();
	}	

}