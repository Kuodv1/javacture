package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class AgencementUn extends VBox {

	final URL fxmlURL = getClass().getResource("FXML_base.fxml");
	final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	
	public AgencementUn() {
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	}
}
