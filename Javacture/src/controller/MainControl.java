package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;

public class MainControl {
	
	@FXML
	public VBox _VBoxCentral;
	
	public Scene scene;
	
	final URL fxmlURLAgencementUn = getClass().getResource("/fxml_folder/FXML_central_agencement_un.fxml");//Vue contenant les 3 agencements
	final URL fxmlURLAgencementDeux = getClass().getResource("/fxml_folder/FXML_central_agencement_deux.fxml");//Vue contenant les 3 agencements
	
	public void initialize() {
		System.out.println("MainControl : init test ?");
		if(_VBoxCentral==null)
			System.out.println("_VBoxCentral=null");
		
		loaderFXML(fxmlURLAgencementUn);
	}
	
	public void init_scene(Scene scene) {
		this.scene = scene;
	}
	
	public void loaderFXML(URL fxmlURL) {
		this._VBoxCentral.getChildren().clear();
		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		try {
			_VBoxCentral.getChildren().add(fxmlLoader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void click_agencement_un(ActionEvent e) {
		System.out.println("Choix agencement un");
		//central.choixAgencementUn();
		loaderFXML(fxmlURLAgencementUn);
	}
	
	public void click_agencement_deux(ActionEvent e) {
		System.out.println("Choix agencement deux");
		//central.choixAgencementDeux();
		loaderFXML(fxmlURLAgencementDeux);
	}
	
	public void save_image(BufferedImage bImage, String type) {
		File imFile = new File("saveTest."+type);
		try {
			if(!ImageIO.write(bImage, type, imFile))
				System.out.println("Erreur lors de la sauvegarde");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur lors de la sauvegarde de l'image");
			e.printStackTrace();
		}
	}
	
	public void click_export_jpeg(ActionEvent e) {
		System.out.println("Export jpeg !");
		WritableImage snapshot = _VBoxCentral.snapshot(null, null);
		BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
		BufferedImage bImage2 = new BufferedImage(bImage.getWidth(), bImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		bImage2.getGraphics().drawImage(bImage, 0, 0, null);
		save_image(bImage2,"jpeg");
	}
	
	public void click_export_bmp(ActionEvent e) {
		System.out.println("Export bmp !");
		WritableImage snapshot = _VBoxCentral.snapshot(null, null);
		BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
		BufferedImage bImage2 = new BufferedImage(bImage.getWidth(), bImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		bImage2.getGraphics().drawImage(bImage, 0, 0, null);
		save_image(bImage2,"bmp"); //besoin d'enlever le composant A de RGBA (de même pour jpeg)
	}

	public void click_export_png(ActionEvent e) {
		System.out.println("Export png !");
		WritableImage snapshot = _VBoxCentral.snapshot(null, null);
		BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
		save_image(bImage,"png");		
	}
}
