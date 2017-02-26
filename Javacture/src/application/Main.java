package application;
	
import java.net.URL;

import controller.MainControl;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * 
 * @author Goketsu et Kuod
 * La classe qui gere la fenetre principale de l'application
 *
 */
public class Main extends Application {
	
	/**
	 * URL qui fait reference a un fichier fxml pour les composants graphiques
	 */
	final URL fxmlURL = getClass().getResource("/fxml_folder/FXML_main.fxml");//Vue contenant les 3 agencements
	/**
	 * Charge une hierarchie d'objets depuis l'url
	 */
	final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	
	/**
	 * Methode appelee apres la methode init et qui permet de demarrer l'application
	 */
	@Override
	public void start(Stage primaryStage) {
		
		try {
			//BorderPane root = new BorderPane();
			VBox root = new VBox();
			primaryStage.setResizable(false);
			Scene scene = new Scene(root,690,450);
			root.getChildren().add(fxmlLoader.load());
			
			MainControl mc = fxmlLoader.getController();
			mc.init_scene(scene);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		launch(args);
	}*/
}
