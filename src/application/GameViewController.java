package application;

import java.net.URL;
import java.util.ResourceBundle;

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
	    private Pane pane;
	    @FXML
	    private Pane fond;
	    

	    private Jeu jeu;
	    private Pane[] tuile;
	    private int selection; 
	    private boolean select;
	    private Label[] labels;
	    
	    
	    
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        this.jeu = new Jeu();
	        creaTuile();
	        
	        
	        
	    	
	    }
	    public void creaTuile(){
	    	int taille = jeu.getTaille();
	    	tuile = new Pane[taille*taille];
	    	for(int i =0;i<taille*taille;i++){
	    		this.tuile[i]=new Pane();
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
	    	for(int i=0;i<tuile.length;i++){
	            tuile[i].getStyleClass().add("tuile"); 
	            labels[i].getStyleClass().add("tuile");
	            grille.getStyleClass().add("gridpane");
	            fond.getChildren().add(tuile[i]);
	            tuile[i].getChildren().add(labels[i]);
	    	} 
	    	this.jeu.melanger();
	    }
	    @FXML
	    public void newGame(){
	    	this.jeu= new Jeu();
	    }

	    @FXML
	    public void keyPressed(KeyEvent ke) {
	       String touche = ke.getText();
	       jeu.commande(touche);
	    //Thread th = new Thread();
	    //th.setDaemon(true);
	    //th.start();

	    }
}