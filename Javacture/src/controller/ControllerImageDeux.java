package controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerImageDeux {

	@FXML
	private ImageView _imageView2Control;
	
	public ControllerImageDeux() {}
	
	@FXML
	public void onMouseClick(MouseEvent e) {
		System.out.println("Test click ?");
		/*FileFilter imagesFilter = new FileNameExtensionFilter("Images (*.jpg, *.jpeg, *.png)","jpg", "jpeg", "png");
		JFileChooser dialogue = new JFileChooser(new File("."));
		dialogue.setDialogTitle("Choisir une image");
		dialogue.setFileFilter(imagesFilter);
		File fichier;
		
		if (dialogue.showOpenDialog(null)== 
		    JFileChooser.APPROVE_OPTION) {
		    fichier = dialogue.getSelectedFile();
			System.out.println(fichier.getPath());
			URL imageURL;
			imageURL = getClass().getResource(fichier.getPath());
			Image imageTmp = new Image(imageURL.toExternalForm()); 
			_imageView2Control.setImage(imageTmp);
		}*/
	}
}
