package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Central {

	@FXML
	private AgencementDeux cadreUn;
	
	@FXML
	private AgencementDeux cadreDeux;

	final URL fxmlURL = getClass().getResource("FXML_centralDeux.fxml");
	final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	
	public Central() {
		/*try {
			fxmlLoader.load();
		} catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }*/
	}
	
	public void initialize() {
		System.out.println("Central UP");
	}
}
