package application;

import java.net.URL;
import java.util.ResourceBundle;

import exceptions.WinException;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import jeu.Jeu;

public class GameViewController implements Initializable {
	
		@FXML
	    private String score;
	    @FXML
	    private GridPane grille;
	    @FXML
	    private Pane fond;
	    

	    private Jeu jeu;
	    private Pane[] tuile;
	    private int selection; 
	    private boolean select;
	    private Label[] labels;
	    private double tailleCase;
		


	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        this.jeu = new Jeu();
	        this.jeu.initialisation();
	        this.tailleCase = 397/4;
	        this.creaLabels();
	        this.creaTuile();
	        this.creaVue();
	    }
	    
	    public Jeu getJeu(){
	    	return this.jeu;
	    }
	    
	    public void setJeu(Jeu jeu){
	    	this.jeu=jeu;
	    }
	    
	    public void creaLabels(){
	    	int taille = this.jeu.getTaille();
	    	labels = new Label[taille*taille];
	    	String chiffreCase;
	    	for(int i=0;i<taille;i++){
	            for(int j=0;j<taille;j++){
	            	chiffreCase = Integer.toString(this.jeu.getPlateau().getTuiles()[i][j].getIndice());
	            	if( chiffreCase == "0")
	            		this.labels[i*taille+j]=new Label(" ");
	            	else
	            		this.labels[i*taille+j]=new Label(""+chiffreCase);
	            }
	    	}
	    }
	    
	    
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
	    public void creaVue(){
	    	int taille = this.jeu.getTaille();
	    	for(int i=0;i<tuile.length;i++){
	            tuile[i].getStyleClass().add("tuile"); 
	            labels[i].getStyleClass().add("tuile");
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
	        //score.setText(Integer.toString(this.jeu.getJoueur().getScore()));
	    }
	    
	    @FXML
	    public void newGame(){
	    	this.jeu = new Jeu();
	        this.jeu.initialisation();
	        this.tailleCase = 397/4;
	        this.creaLabels();
	        this.creaTuile();
	        this.creaVue();
	    }

	    @FXML
	    private void start(MouseEvent event) {
	        System.out.println("Clic de souris sur le bouton start");
	        this.jeu= new Jeu();
	    }
	    
	    @FXML
	    public void keyPressed(KeyEvent ke) {
	       String touche = ke.getText();
	       try {
			jeu.commande(touche);
		} catch (WinException e) {
			e.printStackTrace();
		}
        updateVuePlateau();
	    Thread th = new Thread();
	    th.setDaemon(true);
	    th.start();

	    }

	        
	}
