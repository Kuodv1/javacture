package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

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

public class MainControl {
	
	@FXML
	public VBox _VBoxCentral;
	@FXML
	public ColorPicker _ColorPicker;
	
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void click_export_png(ActionEvent e) {
		System.out.println("Export png !");
		WritableImage snapshot = _VBoxCentral.snapshot(null, null);
		BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
		save_image(bImage,"png");		
	}
	/*
	_ColorPicker.setOnAction(new EventHandler() {
		public void handle(Event e) {
			// TODO Auto-generated method stub
			System.out.println("Couleur "+_ColorPicker.getValue());
			//Color c = _ColorPicker.getValue();
			//_VBoxCentral.styleProperty().setValue("");
			//_VBoxCentral.setFill(_ColorPicker.getValue());
		}
    });*/
	
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
	
	/*
	_ColorPicker.setOnAction(new EventHandler() {
        public void handle(Event t) {
            text.setFill(colorPicker.getValue());               
        }
    });*/
}
