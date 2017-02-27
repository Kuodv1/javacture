package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.CadreValues;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Classe abstraite pour gérer les agencements
 * @author Benjamin et Louis
 *
 */
public abstract class ControllerAgencementAbstract {
	
	/**
	 * Consturcteur vide
	 */
	public ControllerAgencementAbstract() {}
	
	public void initialize() {
	}
	
	/**
	 * Modifie le rectangle
	 * @param cadre Le cadre qui contient le rectangle
	 * @param rect le rectangle
	 */
	public void setRectangle(Pane cadre, Rectangle rect) {
		CadreValues rectangleValues = new CadreValues(rect);
		rect.setX(10);
		rect.setY(10);
		createNode(cadre,rectangleValues);
	}
	
	/**
	 * Creer la vue qui contient les images
	 * @param cadre le cadre
	 * @param rectangleValuesToAdd les parametres du rectangle
	 */
	public void createNode(Pane cadre, CadreValues rectangleValuesToAdd) {
		URL fxmlURL = getClass().getResource("/fxml_folder/FXML_agencement.fxml");//Vue contenant les 3 agencements
    	FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    	
        try {
			cadre.getChildren().add(fxmlLoader.load());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ControllerCadre cid = fxmlLoader.getController();
		cid.setRectangleValues(rectangleValuesToAdd);
	}
}
