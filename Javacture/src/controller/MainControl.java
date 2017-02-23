package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class MainControl {
	
	@FXML
	public VBox _VBoxCentral;
	
	
	final URL fxmlURLAgencementUn = getClass().getResource("/fxml_folder/FXML_central_agencement_un.fxml");//Vue contenant les 3 agencements
	final URL fxmlURLAgencementDeux = getClass().getResource("/fxml_folder/FXML_central_agencement_deux.fxml");//Vue contenant les 3 agencements
	
	public void initialize() {
		System.out.println("MainControl : init test ?");
		if(_VBoxCentral==null)
			System.out.println("_VBoxCentral=null");
		
		loaderFXML(fxmlURLAgencementUn);
	}
	
	public void loaderFXML(URL fxmlURL) {
		this._VBoxCentral.getChildren().clear();
		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		try {
			_VBoxCentral.getChildren().add(fxmlLoader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void click_agencement_un(ActionEvent e) {
		System.out.println("Choix agencement un");
		//central.choixAgencementUn();
		loaderFXML(fxmlURLAgencementUn);
	}
	
	public void click_agencement_deux(ActionEvent e) {
		System.out.println("Choix agencement deux");
		//central.choixAgencementDeux();
		loaderFXML(fxmlURLAgencementDeux);
	}

}
