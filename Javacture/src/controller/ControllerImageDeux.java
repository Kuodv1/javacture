package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerImageDeux {

	@FXML
	private ImageView _imageView2Control;
	@FXML
	private Pane _cadreImage;
	
	private String fontColor = "white";
	private String borderColor = "white";
	private String widthBorder = "1";
	
	public ControllerImageDeux() {}
	
	@FXML
	public void onMouseClickImageView(MouseEvent e) {
		System.out.println("Test click ?");
		if(e.getButton()==MouseButton.PRIMARY)
			onMouseClickLeft(e);
		else if(e.getButton()==MouseButton.SECONDARY)
			onMouseClickRight(e);
		else
			System.out.println("Aucune correspondance trouvé");

	}
	/*
	@FXML
	menuColor.setOnAction(event -> {
		Platform.exit();
	});
*/
	
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
	
	public ContextMenu setMenu() {
		ContextMenu ctxMenu = new ContextMenu();
		MenuItem mniChargeImage = new MenuItem("Charger une image");
		Menu menuChangeColor = new Menu("Changer la couleur de fond");
		MenuItem mniChangeColorBlue = new MenuItem("Bleu");
		MenuItem mniChangeColorRed = new MenuItem("Rouge");
		MenuItem mniChangeColorGreen = new MenuItem("Vert");
		MenuItem mniChangeColorYellow = new MenuItem("Jaune");
		Menu menuChangeColorBorder = new Menu("Changer la couleur de la bordure");
		MenuItem mniChangeColorBorderBlue = new MenuItem("Bleu");
		MenuItem mniChangeColorBorderRed = new MenuItem("Rouge");
		MenuItem mniChangeColorBorderGreen = new MenuItem("Vert");
		MenuItem mniChangeColorBorderYellow = new MenuItem("Jaune");
		Menu menuChangeWidthBorder = new Menu("Changer l'epaisseur de la bordure");
		MenuItem mniChangeWidthOne = new MenuItem("1");
		MenuItem mniChangeWidthTwo = new MenuItem("2");
		ctxMenu.getItems().add(mniChargeImage);
		ctxMenu.getItems().add(menuChangeColor);
		menuChangeColor.getItems().add(mniChangeColorBlue);
		menuChangeColor.getItems().add(mniChangeColorRed);
		menuChangeColor.getItems().add(mniChangeColorGreen);
		menuChangeColor.getItems().add(mniChangeColorYellow);
		ctxMenu.getItems().add(menuChangeColorBorder);
		menuChangeColorBorder.getItems().add(mniChangeColorBorderBlue);
		menuChangeColorBorder.getItems().add(mniChangeColorBorderRed);
		menuChangeColorBorder.getItems().add(mniChangeColorBorderGreen);
		menuChangeColorBorder.getItems().add(mniChangeColorBorderYellow);
		ctxMenu.getItems().add(menuChangeWidthBorder);
		menuChangeWidthBorder.getItems().add(mniChangeWidthOne);
		menuChangeWidthBorder.getItems().add(mniChangeWidthTwo);
		
		
		mniChargeImage.setOnAction(event -> {
			//System.out.println("je veux charger une image");
			ctxMenu.hide();
			uploadImage();
		});
		mniChangeColorBlue.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeColor("blue");
		});
		mniChangeColorRed.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeColor("red");
		});
		mniChangeColorGreen.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeColor("green");
		});
		mniChangeColorYellow.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeColor("yellow");
		});
		mniChangeColorBorderBlue.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeColorBorder("blue");
		});
		mniChangeColorBorderRed.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeColorBorder("red");
		});
		mniChangeColorBorderGreen.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeColorBorder("green");
		});
		mniChangeColorBorderYellow.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeColorBorder("yellow");
		});
		mniChangeWidthOne.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeWidthBorder("1");
		});
		mniChangeWidthTwo.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			changeWidthBorder("2");
		});
		
		return ctxMenu;
	}
	
	public void onMouseClickRight(MouseEvent e) {
		ContextMenu ctxMenu = setMenu();
		ctxMenu.setImpl_showRelativeToWindow(true);
		ctxMenu.show(_imageView2Control,e.getScreenX(),e.getScreenY());
		
		
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Parametres Cadre"); 
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
        cea.setCadreImageToEdit(_cadreImage);
        Scene scene = new Scene(root, 240, 200);
        stage.setScene(scene);
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
			_imageView2Control.setImage(imageTmp);
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
