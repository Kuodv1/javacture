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

/**
 * Clase de l'agencement 2
 * @author Benjamin et Louis
 *
 */
public class ControllerAgencementDeux extends ControllerAgencementAbstract {

	
	/**
	 * Prmeier cadre
	 */
	@FXML
	public Node cadreUn;
	/**
	 * Deuxieme cadre
	 */
	@FXML
	public Node cadreDeux;
	/**
	 * Troisieme cadre
	 */
	@FXML
	public Node cadreTrois;
	
	/**
	 * Constructeur vide
	 */
	public ControllerAgencementDeux() {
		super();
	}
	
	/**
	 * Initialisation des trois cadres
	 */
	public void initialize() {
		this.setRectangle((Pane)cadreUn, new Rectangle(300,430,Color.ORANGE));
		this.setRectangle((Pane)cadreDeux, new Rectangle(250,250,Color.ORANGE));
		this.setRectangle((Pane)cadreTrois, new Rectangle(250,150,Color.ORANGE));		
	}
}
