package application;
import java.awt.Dimension;

import javax.swing.JFrame;

import application.*;
import jeu.*;

public class Main {
	
	public final static int WIDTH = Constante.TAILLE_PLATEAU_X;
	
	public final static int HEIGHT = Constante.TAILLE_PLATEAU_Y;

	public static void main(String[] args) {
		if(args.length == 0){
			MainGUI.main(args);
		}else{
			System.out.println("Lancement du programme sans GUI");
		}
	}

}
