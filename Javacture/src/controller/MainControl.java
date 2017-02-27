package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import application.DialogMessage;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controlleur de la fenetre principale pour gerer les menus
 * @author Goketsu et Kuod
 *
 */
public class MainControl {
	
	/**
	 * La boite centrale qui contient les cadres
	 */
	@FXML
	public VBox _VBoxCentral;
	
	/**
	 * La scene principale
	 */
	public Scene scene;
	
	/**
	 * La lien du premier agencement 
	 */
	final URL fxmlURLAgencementUn = getClass().getResource("/fxml_folder/FXML_central_agencement_un.fxml");//Vue contenant les 3 agencements
	/**
	 * Le lien du deuxieme agencement
	 */
	final URL fxmlURLAgencementDeux = getClass().getResource("/fxml_folder/FXML_central_agencement_deux.fxml");//Vue contenant les 3 agencements
	/**
	 * Le lien du troisieme agencement
	 */
	final URL fxmlURLAgencementTrois = getClass().getResource("/fxml_folder/FXML_central_agencement_trois.fxml");//Vue contenant les 3 agencements
	
	/**
	 * Initialise la fenetre principale avec le premier agencement
	 */
	public void initialize() {
		if(_VBoxCentral==null)
			System.out.println("_VBoxCentral=null");
		
		loaderFXML(fxmlURLAgencementUn);
	}
	
	/**
	 * Initialise la scene
	 * @param scene
	 */
	public void init_scene(Scene scene) {
		this.scene = scene;
	}
	
	/**
	 * Charge un agencement en fonction de son lien
	 * @param fxmlURL
	 */
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
	
	/**
	 * Gere un clic sur le sous-menu agencement 1
	 * @param e
	 */
	public void click_agencement_un(ActionEvent e) {
		System.out.println("Choix agencement un");
		//central.choixAgencementUn();
		loaderFXML(fxmlURLAgencementUn);
	}
	
	/**
	 * Gere un clic sur le sous-menu agencement 2
	 * @param e
	 */
	public void click_agencement_deux(ActionEvent e) {
		System.out.println("Choix agencement deux");
		//central.choixAgencementDeux();
		loaderFXML(fxmlURLAgencementDeux);
	}

	
	/**
	 * Gere un clic sur le sous-menu agencement 3
	 * @param e
	 */
	public void click_agencement_trois(ActionEvent e) {
		System.out.println("Choix agencement trois");
		//central.choixAgencementDeux();
		loaderFXML(fxmlURLAgencementTrois);
	}
	
	/**
	 * Sauvegarde l'image
	 * @param bImage
	 * @param type
	 * @param path
	 */
	public void save_image(BufferedImage bImage, String type, File path) {

		try {
			if(!ImageIO.write(bImage, type, path))
				DialogMessage.ErrorDialogMessage("Erreur de sauvegarde...",
						"Une erreur est survenu lors de la sauvegarde.\nLe fichier n'a pas été sauvegardé.");
			else
				DialogMessage.SuccessDialogMessage("Sauvegarde réussit", "Le fichier a bien été sauvegardé.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception lors de la sauvegarde de l'image : "+e.toString());
			e.printStackTrace();
		}
	}
	
	/**
	 * Gere un clicsur le sous-menu pour exporter l'image en jpeg
	 * @param e
	 */
	public void click_export_jpeg(ActionEvent e) {
		System.out.println("Export jpeg !");
		String type = "jpeg";
		File path = getFileChooser(type);
		if(path!=null) {
			WritableImage snapshot = _VBoxCentral.snapshot(null, null);
			BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
			BufferedImage bImage2 = new BufferedImage(bImage.getWidth(), bImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
			bImage2.getGraphics().drawImage(bImage, 0, 0, null);
			save_image(bImage2,type,path);
		}
	}

	
	/**
	 * Gere un clicsur le sous-menu pour exporter l'image en bmp
	 * @param e
	 */
	public void click_export_bmp(ActionEvent e) {
		System.out.println("Export bmp !");
		String type = "bmp";
		File path = getFileChooser(type);
		if(path!=null) {
			WritableImage snapshot = _VBoxCentral.snapshot(null, null);
			BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
			BufferedImage bImage2 = new BufferedImage(bImage.getWidth(), bImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
			bImage2.getGraphics().drawImage(bImage, 0, 0, null);
			save_image(bImage2,type,path); //besoin d'enlever le composant A de RGBA (de même pour jpeg)
		}
	}

	
	/**
	 * Gere un clicsur le sous-menu pour exporter l'image en png
	 * @param e
	 */
	public void click_export_png(ActionEvent e) {
		System.out.println("Export png !");
		String type = "png";
		File path = getFileChooser(type);
		if(path!=null) {
			WritableImage snapshot = _VBoxCentral.snapshot(null, null);
			BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
			save_image(bImage,type,path);
		}
	}
	
	/**
	 * Recupere l'image que l'on veut inclure
	 * @param type
	 * @return
	 */
	public File getFileChooser(String type) {
		JFileChooser fc = new JFileChooser();
		FileFilter imagesFilter = new FileNameExtensionFilter("Images (*."+type+")",type);
		fc.setAcceptAllFileFilterUsed(false);
		fc.setFileFilter(imagesFilter);
		File file = null;
		
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = new File(fc.getSelectedFile().getAbsolutePath()+"."+type);
        }
		return file;
	}
	
	/**
	 * Gere le changement de couleur de fond via le sous-menu approprié
	 * @param e
	 */
	public void click_change_color(ActionEvent e){
		System.out.println(" test couleur");
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        //Label modalityLabel = new Label("Bonjour tout le monde...!");
        VBox root = new VBox();
        ColorPicker colorPicker = new ColorPicker();
        root.getChildren().add(colorPicker);
        Scene scene = new Scene(root, 200, 100);
        
        colorPicker.setOnAction(event -> {
            System.out.println("couleur : "+colorPicker.getValue().toString().substring(1,8));
            //colorPicker.getValue().toString().substring(1):
            _VBoxCentral.styleProperty().setValue("-fx-background-color: #"+colorPicker.getValue().toString().substring(2));
            //text.setFill(colorPicker.getValue());               
        });
        
        stage.setScene(scene);
        stage.show();
	}
	
	/**
	 * Gere le clic sur le sous-menu close
	 * @param e
	 */
	public void click_close(ActionEvent e) {
		System.exit(0);
	}
}
