package application;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

/**
 * 
 * @author Goketsu et Kuod
 *
 */
public class Central {

	@FXML
	private Agencement cadreUn;
	
	@FXML
	private Agencement cadreDeux;
	
	public Central() {

	}
	
	public void initialize() {
		System.out.println("Central UP");//Jamais appelé
	}
}
