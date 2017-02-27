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

/**
 * Classe qui permet de gerer un cadre
 * @author Benjamin et Louis
 *
 */
public class ControllerCadre {
	
	/**
	 * Le cadre qui contient l'image
	 */
	@FXML
	private Pane _cadreImage;
	
	/**
	 * Un rectangle, emplacement de la futur image
	 */
	private Rectangle ra;
	
	/**
	 * Les parametre du cadre
	 */
	private CadreValues rectangleValues;
	
	/**
	 * La couleur de fond du cadre
	 */
	private String fontColor = "white";
	/**
	 * La couleur de bordure du cadre
	 */
	private String borderColor = "white";
	/**
	 * L'epaisseur de bordure du cadre
	 */
	private String widthBorder = "1";
	
	/**
	 * Un constructeur vide
	 */
	public ControllerCadre() {}
	
	/**
	 * Initialise les composants pour le cadre
	 */
	public void initialize() {

	}
	
	/**
	 * Modifie les parametre du rectangle
	 * @param rectangleValues les parametre voulu pour le rectangle
	 */
	public void setRectangleValues(CadreValues rectangleValues) {
		this.rectangleValues = rectangleValues;
		ra = rectangleValues.getRectangleToEdit();
		_cadreImage.getChildren().clear();
		_cadreImage.getChildren().add(rectangleValues.getRectangleToEdit());
	}
	
	/**
	 * Gere l'evenement d'un clic souris
	 * @param e l'evenement declencher par une action de l'utilisateur
	 */
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
	
	/**
	 * Gere un clic gauche de la souris pour faire apparaitre une nouvelle fenetre pour
	 * charger une nouvelle image
	 * @param e l'evenement declencher par une action de l'utilisateur
	 */
	public void onMouseClickLeft(MouseEvent e) {
		uploadImage();
	}
	
	/**
	 * Gere un clic droit de la souris pour faire apparaitre une nouvelle fenetre pour modifier 
	 * les parametre du cadre
	 * @param e l'evenement declencher par une action de l'utilisateur
	 */
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
	
	/**
	 * Charge une nouvelle image
	 */
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
	
	/**
	 * Modifie la couleur du fond
	 * @param color la couleur du fond
	 */
	public void changeColor(String color){
		fontColor = color;
		_cadreImage.styleProperty().setValue("-fx-background-color: "+color+"; -fx-border-color: "+borderColor+";"
				+ "-fx-border-width: "+widthBorder+"");
	}
	
	/**
	 * Modifie la couleur de la bordure
	 * @param color la couleur de la bordure
	 */
	public void changeColorBorder(String color){
		borderColor = color;
		_cadreImage.styleProperty().setValue("-fx-background-color: "+fontColor+"; -fx-border-color: "+color+";"
				+ "-fx-border-width: "+widthBorder+"");
	}
	
	/**
	 * Modifie l'epaisseur de la bordure
	 * @param width l'epaisseur de la bordure
	 */
	public void changeWidthBorder(String width){
		widthBorder = width;
		_cadreImage.styleProperty().setValue("-fx-background-color: "+fontColor+"; -fx-border-color: "+borderColor+";"
				+ "-fx-border-width: "+width+"");
	}
}
