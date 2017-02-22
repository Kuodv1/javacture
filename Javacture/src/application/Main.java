package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	final URL fxmlURL = getClass().getResource("FXML_central.fxml");
	final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			//BorderPane root = new BorderPane();
			VBox root = new VBox();
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.getChildren().add(fxmlLoader.load());
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
