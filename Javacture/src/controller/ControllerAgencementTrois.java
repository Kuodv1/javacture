package controller;

import java.io.IOException;
import java.net.URL;

import application.CadreValues;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControllerAgencementTrois extends ControllerAgencementAbstract {

	
	
	@FXML
	public Node cadreUn;
	
	@FXML
	public Node cadreDeux;
	
	@FXML
	public Node cadreTrois;
	
	@FXML
	public Node cadreQuatre;
	
	
	public ControllerAgencementTrois() {
		
	}
	
	public void initialize() {
		this.setRectangle((Pane)cadreUn, new Rectangle(400,200,Color.ORANGE));
		this.setRectangle((Pane)cadreDeux, new Rectangle(100,200,Color.ORANGE));
		this.setRectangle((Pane)cadreTrois, new Rectangle(100,200,Color.ORANGE));
		this.setRectangle((Pane)cadreQuatre, new Rectangle(400,200,Color.ORANGE));
	}
}
