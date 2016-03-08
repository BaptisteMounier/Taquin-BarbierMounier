package tests;

import static org.junit.Assert.fail;

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
				tuiles[j][i]= new Tuile(ind);
				ind++;
			}
		}
		this.jeu.setPlateau(new Plateau(tuiles));
		this.jeu.end();
	}	

}





/*
 * package tests;

import java.util.ArrayList;

import exceptions.*;
import game.*;

import org.junit.Before;
import org.junit.Test;

public class TestFinJeu {

	@Before
	public void initialisation(){
		this.jeu = new Jeu();
		this.plateau = jeu.getPlateau();
		this.souris = new Souris(plateau,Constante.NORTH,10,10);
		this.chat = new Chat(plateau,Constante.SOUTH,10,9);
		ArrayList<Entite> listeEntite = new ArrayList<Entite>();
		listeEntite.add(this.souris);
		listeEntite.add(this.chat);
		this.jeu.setEntite(listeEntite);
		this.jeu.refreshFinJeu(listeEntite);
	}

	@Test(expected = WinException.class)
	public void test01_victoireSourisFusee() throws WinException, GameOverException{
		this.souris.setDirection(Constante.SOUTH);
		int posXFusee = 10;
		int posYFusee = 11;
		plateau.getCase(posXFusee, posYFusee).setCaseSpe(new Fusee());
		double nombreDeplacementNecessaire = Constante.TAILLE_CASE/Constante.SOURIS_SPEED;
		for(int i = 0;i < nombreDeplacementNecessaire+1;i++){
			souris.update();
			jeu.fin.etatJeu();
		}
	}

	@Test(expected = GameOverException.class)
	public void test02_DefaiteSourisChat() throws GameOverException{
		double nombreDeplacementNecessaire = Constante.TAILLE_CASE/Constante.SOURIS_SPEED;
		for(int i = 0;i <  nombreDeplacementNecessaire+1;i++){
			souris.update();
		}
	}

	@Test(expected = GameOverException.class)
	public void test03_DefaiteChatSouris() throws GameOverException{
		double nombreDeplacementNecessaire = Constante.TAILLE_CASE/Constante.CHAT_SPEED;
		for(int i = 0;i <  nombreDeplacementNecessaire+1;i++){
			chat.update();
		}
	}

	@Test(expected = GameOverException.class)
	public void test04_DefaiteChatFusee() throws GameOverException{
		this.chat.setDirection(Constante.NORTH);
		int posXFusee = 10;
		int posYFusee = 8;
		plateau.getCase(posXFusee, posYFusee).setCaseSpe(new Fusee());
		double nombreDeplacementNecessaire = Constante.TAILLE_CASE/Constante.CHAT_SPEED;
		for(int i = 0;i <  nombreDeplacementNecessaire+1;i++){
			chat.update();
		}
	}

}

 */

