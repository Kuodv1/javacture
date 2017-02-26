package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import application.CadreValues;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerImageDeux {
	
	@FXML
	private Pane _cadreImage;
	
	private Rectangle ra;
	
	private CadreValues rectangleValues;
	
	private String fontColor = "white";
	private String borderColor = "white";
	private String widthBorder = "1";
	
	public ControllerImageDeux() {}
	
	public void initialize() {
		ra = new Rectangle(_cadreImage.getPrefWidth(),_cadreImage.getPrefHeight(),Color.ORANGE);
		rectangleValues = new CadreValues(ra);
		//ra.setX(5);
		//ra.setY(5);

		rectangleValues.setCoulorCadre(Color.BLACK);
		rectangleValues.setWidthCadre(5);
		//ra.setStrokeType(StrokeType.OUTSIDE);
		
		_cadreImage.getChildren().add(ra);
	}
	
	@FXML
	public void onMouseClick(MouseEvent e) {
		System.out.println("Test click ?");
		if(e.getButton()==MouseButton.PRIMARY)
			onMouseClickLeft(e);
		else if(e.getButton()==MouseButton.SECONDARY)
			onMouseClickRight(e);
		else
			System.out.println("Aucune correspondance trouvé");

	}
	
	@FXML
	public void onMouseClickAnchorPane(MouseEvent e) {
		if(e.getButton()==MouseButton.SECONDARY)
			onMouseClickRightAnchorPane(e);
		else
			System.out.println("Aucune correspondance trouvé");
	}
	
	public void onMouseClickRightAnchorPane(MouseEvent e) {
		System.out.println("Click droit sur le panel");
	}
	
	public void onMouseClickLeft(MouseEvent e) {
		uploadImage();
	}
	
	public void onMouseClickRight(MouseEvent e) {
		
		
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
    	URL fxmlURL = getClass().getResource("/fxml_folder/FXML_editableAgencement.fxml");//Vue contenant les 3 agencements
    	FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    	VBox root = new VBox();
        try {
			root.getChildren().add(fxmlLoader.load());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ControllerEditableAgencement cea = fxmlLoader.getController();
        cea.setRectangleToEdit(rectangleValues);
        Scene scene = new Scene(root, 240, 280);
        stage.setScene(scene);
        stage.setTitle("Edition de cadre");
        stage.show();
	}
	
	public void uploadImage(){
		FileFilter imagesFilter = new FileNameExtensionFilter("Images (*.jpg, *.jpeg, *.png)","jpg", "jpeg", "png");
		JFileChooser dialogue = new JFileChooser(new File("."));
		dialogue.setAcceptAllFileFilterUsed(false);
		dialogue.setDialogTitle("Choisir une image");
		dialogue.setFileFilter(imagesFilter);
		File fichier;
		
		if (dialogue.showOpenDialog(null)== 
		    JFileChooser.APPROVE_OPTION) {
		    fichier = dialogue.getSelectedFile();
			System.out.println(fichier.getPath());
			Image imageTmp = new Image("file:///"+fichier.getPath()); 
			ra.setFill(new ImagePattern(imageTmp));
		}	
	}
	
	public void changeColor(String color){
		fontColor = color;
		_cadreImage.styleProperty().setValue("-fx-background-color: "+color+"; -fx-border-color: "+borderColor+";"
				+ "-fx-border-width: "+widthBorder+"");
	}
	
	public void changeColorBorder(String color){
		borderColor = color;
		_cadreImage.styleProperty().setValue("-fx-background-color: "+fontColor+"; -fx-border-color: "+color+";"
				+ "-fx-border-width: "+widthBorder+"");
	}
	
	public void changeWidthBorder(String width){
		widthBorder = width;
		_cadreImage.styleProperty().setValue("-fx-background-color: "+fontColor+"; -fx-border-color: "+borderColor+";"
				+ "-fx-border-width: "+width+"");
	}
}
