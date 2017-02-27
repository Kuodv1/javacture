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
 * Classe de l'agencement 3
 * @author Benjamin et Louis
 *
 */
public class ControllerAgencementTrois extends ControllerAgencementAbstract {

	
	/**
	 * Premier cadre
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
	 * Quatrieme cadre
	 */
	@FXML
	public Node cadreQuatre;
	
	/**
	 * Constructeur vide
	 */
	public ControllerAgencementTrois() {
		
	}
	
	/**
	 * Initialise les quatres cadres
	 */
	public void initialize() {
		this.setRectangle((Pane)cadreUn, new Rectangle(400,200,Color.ORANGE));
		this.setRectangle((Pane)cadreDeux, new Rectangle(100,200,Color.ORANGE));
		this.setRectangle((Pane)cadreTrois, new Rectangle(100,200,Color.ORANGE));
		this.setRectangle((Pane)cadreQuatre, new Rectangle(400,200,Color.ORANGE));
	}
}
