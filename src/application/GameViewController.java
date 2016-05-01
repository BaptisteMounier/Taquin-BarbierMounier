package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.WinException;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import jeu.*;

/**
 * Controleur de la fenetre de jeu
 */
public class GameViewController implements Initializable {
	
		/**
		 * variable du fichier .fxml
		 */
	    @FXML
	    private GridPane grille;
	    @FXML
	    private Pane fond;
	    @FXML
	    private Button newgame;
	    @FXML
	    private Label move;
	    
	    /**
	     * variables globale hors .fxml
	     */
	    private Jeu jeu;
	    private Pane[] tuile;
	    private int selection; 
	    private boolean select;
	    private Label[] labels;
	    private double tailleCase;
		

	    /**
	     * Intialisation de la vue
	     */
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        this.jeu = new Jeu();
	        this.jeu.initialisation();
	        this.tailleCase = 397/4;
	        this.creaLabels();
	        this.creaTuile();
	        this.creaVue();
	    }
	    
	    /**
	     * retourne le jeu du controller
	     * @return jeu Le Jeu
	     */
	    public Jeu getJeu(){
	    	return this.jeu;
	    }
	    
	    /**
	     * reaffection du jeu
	     * @param jeu Le Jeu
	     */
	    public void setJeu(Jeu jeu){
	    	this.jeu=jeu;
	    }
	    
	    /**
	     * Initialisation des labels des cases
	     */
	    
	    public void creaLabels(){
	    	int taille = this.jeu.getTaille();
	    	labels = new Label[taille*taille];
	    	int chiffreCase;
	    	String labelCase;
	    	for(int i=0;i<taille;i++){
	            for(int j=0;j<taille;j++){
	            	chiffreCase = this.jeu.getPlateau().getTuiles()[i][j].getIndice();
	            	if(chiffreCase == 0){
	            		this.labels[i*taille+j]=new Label(" ");
	            		this.labels[i*taille+j].setTextAlignment(TextAlignment.CENTER);
	            		this.labels[i*taille+j].setPrefWidth(tailleCase);
	            		this.labels[i*taille+j].setPrefHeight(tailleCase);
	            	}else{
		            	labelCase = Integer.toString(chiffreCase);
	            		this.labels[i*taille+j]=new Label(labelCase);
	            		this.labels[i*taille+j].setTextAlignment(TextAlignment.CENTER);
	            		this.labels[i*taille+j].setPrefWidth(tailleCase);
	            		this.labels[i*taille+j].setPrefHeight(tailleCase);
	            	}
	            }
	    	}
	    }
	    
	    /**
	     * Initialisation du tableau des tuiles
	     */
	    public void creaTuile(){
	    	int taille = this.jeu.getTaille();
	    	tuile = new Pane[taille*taille];
	    	for(int i =0;i<taille*taille;i++){
	    		this.tuile[i]=new Pane();
	    		this.tuile[i].setPrefSize(tailleCase,tailleCase);
	    		this.tuile[i].setOnMouseClicked(new EventHandler<MouseEvent>()
	            {
	                @Override
	                public void handle(MouseEvent t) {
	                	Label l = (Label)((Pane)t.getSource()).getChildren().get(0);
	                	if(l.getText() != " "){
	                    	selection = Integer.parseInt(l.getText());
	                    	select=true;
	                	}
	                }
	            });
	    		this.tuile[i].setOnMouseExited(new EventHandler<MouseEvent>()
	            {
	                @Override
	                public void handle(MouseEvent t) {
	                	select=false;
	                }
	            });
	    	}
	    }
	    
	    /**
	     * placement des tuiles et leur affichage
	     */
	    public void creaVue(){
	    	int taille = this.jeu.getTaille();
	    	this.move.setVisible(true);
	    	this.move.setText(Integer.toString(this.jeu.getNbCoups()));
	    	for(int i=0;i<tuile.length;i++){
	            tuile[i].getStyleClass().add("tuile"); 
	            labels[i].getStyleClass().add("pane");
	            grille.getStyleClass().add("gridpane");
	            fond.getChildren().add(tuile[i]);
	            tuile[i].getChildren().add(labels[i]);
	    	}
	    	for(int l=0;l<taille;l++){
	            for(int c=0;c<taille;c++){
	            	int numCase = l*taille+c;
	            	tuile[numCase].setLayoutX(24+tailleCase*c);
	            	tuile[numCase].setLayoutY(191+tailleCase*l);
	            	tuile[numCase].setVisible(true);
	                labels[numCase].setVisible(true);

	            }
	    	}
	    }
	    
	    /**
	     * actualisation de la vue pour afficher les modifications des coups jouer
	     */
	    public void updateVuePlateau(){
	    	int taille = this.jeu.getTaille();
	    	int chiffreCase;
	    	for(int i=0;i<taille;i++){
	            for(int j=0;j<taille;j++){
	            	chiffreCase = this.jeu.getPlateau().getTuiles()[i][j].getIndice();
	            	if (chiffreCase==0){
	            		this.labels[i*taille+j].setText(" "); // si c'est la case 0 ou dite vide, laisse un texte vide
	            	}
	            	else {
	            		this.labels[i*taille+j].setText(""+chiffreCase); // sinon le label est le contenu de la case
	            	}
	            }
	    	}
	        this.move.setText(Integer.toString(this.jeu.getNbCoups()));
	    }
	    
	    /**
	     * remise a zero du jeu
	     */
	    @FXML
	    public void newGame(){
	    	this.jeu = new Jeu();
	        this.jeu.initialisation();
	        this.tailleCase = 397/4;
	        this.creaLabels();
	        this.creaTuile();
	        this.creaVue();
			this.updateVuePlateau();
	    }

	    /**
	     * Methode appelee lors du clique sur le bouton start
	     */
	    @FXML
	    private void buttonStart(MouseEvent event) {
	    	this.newGame();
	    }

	    /**
	     * Methode appelee lors du clique sur le bouton help
	     * @throws InterruptedException 
	     */
	    @FXML
	    private void buttonHelp(MouseEvent event) throws InterruptedException {
	    	try {
	    		this.jeu.commande("ai 1");
				this.updateVuePlateau();
			} catch (WinException e) {
		    	this.newGame();
			}
	    }

	    /**
	     * Methode appelee lors du clique sur le bouton full help
	     * @throws InterruptedException 
	     */
	    @FXML
	    private void buttonFullHelp(MouseEvent event) throws InterruptedException {
	    	try {
				//this.jeu.commande("ai 0");
				//this.updateVuePlateau();
				Ai ai = new Ai();
				ArrayList<String> listeCommande = new ArrayList<String>();
				listeCommande = ai.aide(this.jeu.getPlateau());
				for(String cmd : listeCommande){
					this.jeu.commande(cmd);
					this.jeu.getJoueur().updateScore(-1);
					this.updateVuePlateau();
					Thread.sleep(1000);
				}
			} catch (WinException e) {
		    	this.newGame();
			}
	    }
	    
	    /**
	     * gestion du mouvement des tuiles.
	     * recuperation de la touche presser
	     * appel commande mouvement
	     * @param ke touche pressee
	     * @throws InterruptedException 
	     */
	    @FXML
	    public void keyPressed(KeyEvent ke) throws InterruptedException {
	       String touche = ke.getText();
	       try {
	    	   jeu.commande(touche);
	    	   }catch (WinException e){
	    		   this.newGame();
	    		   }
	       updateVuePlateau();
	       Thread th = new Thread();
	       th.setDaemon(true);
	       th.start();
	      }

	        
	}
