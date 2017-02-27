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
 * Classe de l'agencement 1
 * @author Benjamin et Louis
 *
 */
public class ControllerAgencementUn extends ControllerAgencementAbstract {

	
	/**
	 * Le premier cadre
	 */
	@FXML
	public Node cadreUn;
	/**
	 * Le deuxieme cadre
	 */
	@FXML
	public Node cadreDeux;
	/**
	 * Le troisieme cadre
	 */
	@FXML
	public Node cadreTrois;
	
	/**
	 * Constructeur vide
	 */
	public ControllerAgencementUn() {
		super();
	}
	
	/**
	 * Initialise les trois cadres
	 */
	public void initialize() {
		this.setRectangle((Pane)cadreUn, new Rectangle(400,120,Color.ORANGE));
		this.setRectangle((Pane) cadreDeux, new Rectangle(400,120,Color.ORANGE));
		this.setRectangle((Pane)cadreTrois, new Rectangle(400,120,Color.ORANGE));
	}
	
}
