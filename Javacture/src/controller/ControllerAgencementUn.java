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

public class ControllerAgencementUn {

	
	
	@FXML
	public Node cadreUn;
	
	@FXML
	public Node cadreDeux;
	
	@FXML
	public Node cadreTrois;
	
	
	public ControllerAgencementUn() {
		
	}
	
	public void initialize() {
		System.out.println("Agencement 1 coucou");
		if(cadreUn==null)
			System.out.println("Cadre null");
		
		System.out.println(cadreUn.toString());
		Pane test = (Pane)cadreUn;
		
		Rectangle ra = new Rectangle(100,50,Color.ORANGE);
		CadreValues rectangleValues = new CadreValues(ra);
		ra.setX(50);
		ra.setY(80);

		rectangleValues.setCoulorCadre(Color.BLACK);
		rectangleValues.setWidthCadre(5);
		
		createNode(test,rectangleValues);
		
		Pane bpCadreDeux = (Pane)cadreDeux;
		Rectangle ra2 = new Rectangle(100,50,Color.ORANGE);
		CadreValues rectangleValues2 = new CadreValues(ra2);
		ra.setX(50);
		ra.setY(80);

		rectangleValues2.setCoulorCadre(Color.BLACK);
		rectangleValues2.setWidthCadre(5);
		
		createNode(bpCadreDeux,rectangleValues2);
		
		
		Rectangle ra3 = new Rectangle(100,50,Color.ORANGE);
		CadreValues rectangleValues3 = new CadreValues(ra3);
		ra.setX(50);
		ra.setY(80);

		rectangleValues3.setCoulorCadre(Color.BLACK);
		rectangleValues3.setWidthCadre(5);
		Pane bpCadreTrois = (Pane)cadreTrois;
		createNode(bpCadreTrois,rectangleValues3);
	}
	
	public void createNode(Pane cadre, CadreValues rectangleValuesToAdd) {
		URL fxmlURL = getClass().getResource("/fxml_folder/FXML_agencement.fxml");//Vue contenant les 3 agencements
    	FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    	
        try {
			cadre.getChildren().add(fxmlLoader.load());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ControllerImageDeux cid = fxmlLoader.getController();
		cid.setRectangleValues(rectangleValuesToAdd);
	}
	
}