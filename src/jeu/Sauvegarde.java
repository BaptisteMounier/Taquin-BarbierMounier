package jeu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sauvegarde {
	
	private String extension;
	private String path;
	private Jeu jeu;
	private final static String SEPARATOR =":";
	private final static String NEWLINE = System.getProperty("line.separator" );

	public Sauvegarde(Jeu jeu) {
		this.extension = ".taquin";
		this.path = "saves/";
		this.jeu = jeu;
		this.createContent();
	}

	public void sauvegarder(String string) {
		File file = new File(this.path+string+this.extension);		
		FileOutputStream fos = null;
		      try {
		    	  if (!file.exists())
		    		  file.createNewFile();
		         fos = new FileOutputStream(file);
		         byte[] bytes = this.createContent().getBytes();
		         fos.write(bytes);
		         fos.flush();
		         fos.close();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } finally {
		         try {
		            if (fos != null)
		               fos.close();
		         } catch (IOException e) {
		            e.printStackTrace();
		         }
		      }		
	}

	public Jeu charger(String string) {
		File file = new File(this.path+string+this.extension);		
		FileInputStream fis = null;
		String content = "";
		try {
			fis = new FileInputStream(file);
			int c;
			while((c = fis.read()) != -1)
				content += (char)c;
			System.out.println(content);
		      } catch (IOException e) {
		         e.printStackTrace();
		      } finally {
		         try {
		            if (fis != null)
		               fis.close();
		         } catch (IOException e) {
		            e.printStackTrace();
		         }
		      }
		this.createJeu(content);
		return this.jeu;
	}
	
	private String createContent(){

		String content = "";
		
		Joueur joueur = this.jeu.getJoueur();
		String nomJoueur = joueur.getNom();
		int scoreJoueur = joueur.getScore();
		int topJoueur = joueur.getTop();
		
		content += nomJoueur+this.SEPARATOR+scoreJoueur+this.SEPARATOR+topJoueur+this.NEWLINE;
		
		Ai ai = this.jeu.getAi();
		String nomAi = ai.getNom();
		int scoreAi = ai.getScore();
		int topAi = ai.getTop();
		
		content += nomAi+this.SEPARATOR+scoreAi+this.SEPARATOR+topAi+this.NEWLINE;
		
		Plateau plateau = this.jeu.getPlateau();
		Tuile[][] tuiles = plateau.getTuiles();
		int indiceMax = plateau.getIndiceMax();
		int taille = this.jeu.getTaille();
		int nbMelange = this.jeu.getNbMelange();
		int nbCoups = this.jeu.getNbCoups();
		
		for(int i = 0;i < taille;i++){
			for(int j =0;j < taille;j++){
				content += tuiles[i][j].toString();
			}
		}
		content += this.NEWLINE;
		content += indiceMax+this.SEPARATOR+taille+this.SEPARATOR+nbMelange+this.SEPARATOR+nbCoups+this.NEWLINE;
		return content;
	}
	
	private void createJeu(String c){
		
		String[] content = c.split(Sauvegarde.NEWLINE);
		
		String[] contentJoueur = content[0].split(Sauvegarde.SEPARATOR);
		String[] contentAi = content[1].split(Sauvegarde.SEPARATOR);
		String contentTuiles = content[2];
		String[] contentJeu = content[3].split(Sauvegarde.SEPARATOR);
		
		int indiceMax = Integer.parseInt(contentJeu[0]);
		int taille = Integer.parseInt(contentJeu[1]);
		int nbMelange = Integer.parseInt(contentJeu[2]);
		int nbCoups = Integer.parseInt(contentJeu[3]);
		Tuile[][] tuiles = new Tuile[taille][taille];
		int index = 0;
		for(int i = 0;i < taille;i++){
			for(int j = 0;j < taille;j++){
				String indiceString = contentTuiles.substring(index, index+2);
				int indice;
				if(indiceString.equals("  "))
					indice = 0;
				else
					indice = Integer.parseInt(indiceString);
				boolean find = false;
				int cpt = 0;
				for(int io = 0;io < taille && !find;io++){
					for(int jo = 0;jo < taille && !find;jo++){
						cpt++;
						if(cpt == taille*taille)
							cpt = 0;
						if(indice == cpt){
							find = true;
							tuiles[i][j] = new Tuile(indice,io,jo);
							index += 2;
						}
					}
				}
			}
		}
		String nomJoueur = contentJoueur[0];
		int scoreJoueur = Integer.parseInt(contentJoueur[1]);
		int topJoueur = Integer.parseInt(contentJoueur[2]);
		String nomAi = contentAi[0];
		int scoreAi = Integer.parseInt(contentAi[1]);
		int topAi = Integer.parseInt(contentAi[2]);
		
		Plateau plateau = new Plateau(tuiles,taille,nbMelange,indiceMax);
		Joueur joueur = new Joueur(nomJoueur, scoreJoueur, topJoueur);
		Ai ai = new Ai(nomAi, scoreAi, topAi);
		this.jeu = new Jeu(plateau, taille, nbMelange, nbCoups, ai, joueur);
		
	}

}
