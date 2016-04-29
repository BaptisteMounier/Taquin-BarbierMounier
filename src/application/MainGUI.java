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
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/styles.css");
        stage.setScene(scene);
        stage.show();
	}
     	
     	public static void main(String[] args) {
     		launch(args);
     	}
     		
     }