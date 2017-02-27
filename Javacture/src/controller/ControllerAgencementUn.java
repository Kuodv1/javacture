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

public class ControllerAgencementUn extends ControllerAgencementAbstract {

	
	
	@FXML
	public Node cadreUn;
	
	@FXML
	public Node cadreDeux;
	
	@FXML
	public Node cadreTrois;
	
	
	public ControllerAgencementUn() {
		super();
	}
	
	public void initialize() {
		this.setRectangle((Pane)cadreUn, new Rectangle(400,120,Color.ORANGE));
		this.setRectangle((Pane) cadreDeux, new Rectangle(400,120,Color.ORANGE));
		this.setRectangle((Pane)cadreTrois, new Rectangle(400,120,Color.ORANGE));
	}
	
}
