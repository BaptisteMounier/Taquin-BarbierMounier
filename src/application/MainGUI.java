package application;
import java.io.File;
import java.io.IOException;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainGUI extends Application{
	
	public Scene construitScene() throws IOException{
		java.net.URL fxmlURL = getClass().getResource("GameView.fxml");
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		final Scene node = fxmlLoader.load();
		return node;

	}
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
         
        Scene scene = new Scene(root);
        boolean add = scene.getStylesheets().add("css/styles.css");
        stage.setScene(scene);
        stage.show();
	}
     	
     	public static void main(String[] args) {
     		launch(args);
     	}
     		
     }