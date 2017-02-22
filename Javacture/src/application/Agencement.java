package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class Agencement {

	final URL fxmlURL = getClass().getResource("FXML_test.fxml");
	final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	
	public Agencement() {
		
	}
}
