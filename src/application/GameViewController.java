package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameViewController implements Initializable {

		
		@FXML
	    private Label score;
	    @FXML
	    private GridPane grille;
	    @FXML
	    private Pane fond;
	    private final Pane p = new Pane();
	    
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        p.getStyleClass().add("pane");
	        grille.getStyleClass().add("gridpane");
	        fond.getChildren().add(p);

	    }

	    @FXML
	    public void keyPressed(KeyEvent ke) {
	        System.out.println("touche appuyée");
	        String touche = ke.getText();
	        if (touche.compareTo("q") == 0) { // utilisateur appuie sur "q" pour envoyer la tuile vers la gauche
	            if (objectifx > 24) { // possible uniquement si on est pas dans la colonne la plus à gauche
	                objectifx -= (int) 397 / 4; // on définit la position que devra atteindre la tuile en abscisse (modèle). Le thread se chargera de mettre la vue à jour
	                score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1)); // mise à jour du compteur de mouvement
	            }
	        } else if (touche.compareTo("d") == 0) { // utilisateur appuie sur "d" pour envoyer la tuile vers la droite
	            if (objectifx < (int) 445 - 2 * 397 / 4 - 24) { // possible uniquement si on est pas dans la colonne la plus à droite (taille de la fenêtre - 2*taille d'une case - taille entre la grille et le bord de la fenêtre)
	                objectifx += (int) 397 / 4;
	                score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1));
	            }
	        }
	        System.out.println("objectifx=" + objectifx);
	        Task task = new Task<Void>() { // on définit une tâche parallèle pour mettre à jour la vue
	            @Override
	            public Void call() throws Exception { // implémentation de la méthode protected abstract V call() dans la classe Task
	                while (x != objectifx) { // si la tuile n'est pas à la place qu'on souhaite attendre en abscisse
	                    if (x < objectifx) {
	                        x += 1; // si on va vers la droite, on modifie la position de la tuile pixel par pixel vers la droite
	                    } else {
	                        x -= 1; // si on va vers la gauche, idem en décrémentant la valeur de x
	                    }
	                    
	                    Platform.runLater(new Runnable() { // classe anonyme
	                        @Override
	                        public void run() {
	                            //javaFX operations should go here
	                            p.relocate(x, y); // on déplace la tuile d'un pixel sur la vue, on attend 5ms et on recommence jusqu'à atteindre l'objectif
	                            p.setVisible(true);    
	                        }
	                    }
	                    );
	                    Thread.sleep(5);
	                } // end while
	                return null; // la méthode call doit obligatoirement retourner un objet. Ici on n'a rien de particulier à retourner. Du coup, on utilise le type Void (avec un V majuscule) : c'est un type spécial en Java auquel on ne peut assigner que la valeur null
	            } // end call

	        };
	        Thread th = new Thread(task); // on crée un contrôleur de Thread
	        th.setDaemon(true); // le Thread s'exécutera en arrière-plan (démon informatique)
	        th.start(); // et on exécute le Thread pour mettre à jour la vue (déplacement continu de la tuile horizontalement)
	    }
	}
