package application;
	
import java.net.URL;

import controller.MainControl;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	final URL fxmlURL = getClass().getResource("/fxml_folder/FXML_main.fxml");//Vue contenant les 3 agencements
	final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			//BorderPane root = new BorderPane();
			VBox root = new VBox();
			
			Scene scene = new Scene(root,600,400);
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
