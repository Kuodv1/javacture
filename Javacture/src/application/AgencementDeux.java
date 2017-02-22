package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class AgencementDeux {

	final URL fxmlURL = getClass().getResource("FXML_test.fxml");
	final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	
	public AgencementDeux() {
		/*try {
			fxmlLoader.load();
		} catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }*/
	}
}
