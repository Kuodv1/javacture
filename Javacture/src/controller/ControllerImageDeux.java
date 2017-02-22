package controller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControllerImageDeux {

	@FXML
	private ImageView _imageView2Control;
	@FXML
	private Pane _cadreImage;
	
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
		/*
		FileFilter imagesFilter = new FileNameExtensionFilter("Images (*.jpg, *.jpeg, *.png)","jpg", "jpeg", "png");
		JFileChooser dialogue = new JFileChooser(new File("."));
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
		*/
	}
	
	public void onMouseClickRight(MouseEvent e) {
		ContextMenu ctxMenu = new ContextMenu();
		MenuItem mniChargeImage = new MenuItem("Charger une image");
		MenuItem mniChangeColor = new MenuItem("Changer la couleur de fond");
		ctxMenu.getItems().add(mniChargeImage);
		ctxMenu.getItems().add(mniChangeColor);
		mniChargeImage.setOnAction(event -> {
			System.out.println("je veux charger une image");
			//ctxMenu.setImpl_showRelativeToWindow(false);
			ctxMenu.hide();
			uploadImage();
		});
		mniChangeColor.setOnAction(event -> {
			System.out.println(""+_cadreImage.styleProperty().getValue());
			_cadreImage.styleProperty().setValue("-fx-background-color: blue;");		
		});

		ctxMenu.setImpl_showRelativeToWindow(true);
		ctxMenu.show(_imageView2Control,e.getScreenX(),e.getScreenY());
	}
	
	public void uploadImage(){
		FileFilter imagesFilter = new FileNameExtensionFilter("Images (*.jpg, *.jpeg, *.png)","jpg", "jpeg", "png");
		JFileChooser dialogue = new JFileChooser(new File("."));
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
}
