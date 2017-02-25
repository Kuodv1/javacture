package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Goketsu et Kuod
 * Classe qui permet d'interagir avec les elements d'une image
 * Permet de modifier le fond et la bordure
 *
 */
public class ControllerEditableAgencement {

	/**
	 * Le cadre de l'image que l'on veut modifier
	 */
	private Pane cadreImageToEdit;
	
	/**
	 * Un color picker pour modifier la couleur de bordure
	 */
	@FXML
	private ColorPicker _ColorPicker;
	/**
	 * Un color picker pour modifer la couleur du fond
	 */
	@FXML
	private ColorPicker _ColorFontPicker;
	
	
	@FXML
	private Label _labelWidthBorder;
	
	@FXML
	private Label _labelTypeBorder;
	
	@FXML
	private Label _labelCornerBorder;
	
	@FXML
	private Label _labelColorBorder;
	
	@FXML
	private Pane _paneColorBorder;
	
	@FXML
	private Pane _paneBackgroundColor;
	
	@FXML
	private Label _labelBackgroundColor;
	
	@FXML
	private Slider _sliderCornerBorder;
	
	/**
	 * Parametre css pour gerer la couleur du fond
	 */
	private final String stringBackgroundColor =  "-fx-background-color: ";
	/**
	 * Parametre locale qui permet de connaitre la couleur du fond
	 */
	private String fontColor = "white";
	
	/**
	 * Parametre css pour gerer la couleur de bordure
	 */
	private final String stringBorderColor = "-fx-border-color: ";
	/**
	 * Parametre locale qui permet de connaitre la couleur de bordure
	 */
	private String borderColor = "white";
	
	/**
	 * Parametre css pour gerer le style de bordure (normal / point / trait)
	 */
	private final String stringBorderStyle = "-fx-border-style: ";
	/**
	 * Parametre locale qui permet de connaitre le style de bordure
	 */
	private String borderStyle = "solid";

	/**
	 * Parametre css pour gerer le style de bordure (rond / normal)
	 */
	private final String stringBorderRadius = "-fx-border-radius: ";
	/**
	 * Parametre locale qui permet de connaitre le style de bordure
	 */
	private String borderRadius = "1";	
	
	/**
	 * Curseur pour gerer l'epaisseur de la bordure
	 */
	@FXML
	Slider _sliderWidthBorder;
	
	/**
	 * Parametre css pour gerer l'epaisseur de bordure
	 */
	private final String stringBorderWidth = "-fx-border-width: ";
	/**
	 * Parametre locale qui permet de connaitre l'epaisseur de bordure
	 */
	private String widthBorder = "1";
	
	/**
	 * Constructeur vide
	 */
	public ControllerEditableAgencement() {
		
	}
	
	/**
	 * Initialisation du controlleur
	 */
	public void initialize() {
		System.out.println("Initialisze ControllerEditableAgencement Check !");
		initialize_slider_width_border();
		initialize_slider_corner_border();
	}
	
	/**
	 * Fonction qui permet de recuperer le style css actuel du cadre
	 * @param style : la chaine de caractere qui contient le code css
	 */
	public void reloadParam(String style) {
		int startBackgroundColor = style.indexOf(stringBackgroundColor); 
		if(startBackgroundColor>=0)
			fontColor = reloadValue(style,stringBackgroundColor,startBackgroundColor);
		
		int startBorderColor = style.indexOf(stringBorderColor);
		if(startBorderColor>=0)
			borderColor = reloadValue(style,stringBorderColor,startBorderColor);
		
		int startBorderWidth = style.indexOf(stringBorderWidth);
		if(startBorderWidth>=0)
			widthBorder = reloadValue(style,stringBorderWidth,startBorderWidth);
		
		int startBorderStyle = style.indexOf(stringBorderStyle);
		if(startBorderStyle>=0) 
			borderStyle = reloadValue(style,stringBorderStyle,startBorderStyle);
		
		int startBorderRadius = style.indexOf(stringBorderRadius);
		if(startBorderRadius>=0)
			borderRadius = reloadValue(style,stringBorderRadius,startBorderRadius);
		
		applyStyle();
		
	}
	
	/**
	 * Fonction pour decouper la chaine de caractere en parametres
	 * @param style : la chaine de caractere qui contient le code css
	 * @param stringType
	 * @param valueOccurence
	 * @return
	 */
	public String reloadValue(String style, String stringType, int valueOccurence) {
		return style.substring(valueOccurence+stringType.length(), style.indexOf(';',valueOccurence));
	}
	
	/**
	 * Initialise le cadre de l'image
	 * @param cadreImageToEdit
	 */
	public void setCadreImageToEdit(Pane cadreImageToEdit) {
		this.cadreImageToEdit = cadreImageToEdit;
		this.reloadParam(cadreImageToEdit.getStyle());
	}
	
	/**
	 * Initialise le curseur pour modifier l'epaisseur de la bordure
	 */
	public void initialize_slider_width_border() {
		_sliderWidthBorder.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    changeWidthBorder(new_val.intValue());
            }
        });
	}
	
	public void initialize_slider_corner_border() {
		_sliderCornerBorder.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    setBorderRadius(new_val.intValue()+"");
            }
        });
	}
	
	/**
	 * Permet de changer l'epaisseur de la bordure en fonction de la valeur du curseur
	 * @param widthBorderInt : epaisseur de la bordure
	 */
	public void changeWidthBorder(int widthBorderInt){
		this.widthBorder = ""+widthBorderInt;
		applyStyle();
	}
	
	/**
	 * Applique les proprietes du cadre au css
	 */
	public void applyStyle() {
		cadreImageToEdit.styleProperty().setValue("-fx-background-color: "+fontColor+";"+
				" -fx-border-color: "+borderColor+";"
				+ "-fx-border-width: "+widthBorder+";"
				+  "-fx-border-style: "+borderStyle+"; "
				+	"-fx-border-radius: "+borderRadius+";");
		
		refreshAffichage();
	}
	
	public void refreshAffichage() {
		this._labelColorBorder.setText(borderColor);
		this._paneColorBorder.styleProperty().setValue("-fx-background-color: "+borderColor);
		
		this._labelBackgroundColor.setText(fontColor);
		this._paneBackgroundColor.styleProperty().setValue("-fx-background-color: "+fontColor);
		
		
        _labelWidthBorder.setText(widthBorder);
        _sliderWidthBorder.setValue(Integer.parseInt(widthBorder));
        
        
        _labelCornerBorder.setText(borderRadius);
        _sliderCornerBorder.setValue(Integer.parseInt(borderRadius));
	}
	
	/**
	 * Permet de changer le style de bordure
	 * @param border : style de bordure (solid/dotted/dashed)
	 */
	public void setBorderStyle(String border){
		borderStyle = border;
		applyStyle();
	}
	
	/**
	 * Permet de modifier la courbe des coins du cadre
	 * @param border : le degres de courbur du cadre
	 */
	public void setBorderRadius(String border){
		borderRadius = border;
		applyStyle();
	}
	
	/**
	 * Change le style de bordure en point
	 * @param e
	 */
	public void click_point_border(ActionEvent e){
		setBorderStyle("dotted");
		this._labelTypeBorder.setText("Point");
	}
	
	/**
	 * Change le style de bordure en trait
	 * @param e
	 */
	public void click_dash_border(ActionEvent e){
		setBorderStyle("dashed");
		this._labelTypeBorder.setText("Trait");
	}
	
	/**
	 * Change le style de borudure en normal
	 * @param e
	 */
	public void click_plein_border(ActionEvent e){
		setBorderStyle("solid");
		this._labelTypeBorder.setText("Classique");
	}
	
	/**
	 * Change la couleur de bordure en fonction du color picker
	 * @param e
	 */
	public void click_color(ActionEvent e){
		borderColor = "#"+_ColorPicker.getValue().toString().substring(2);
		System.out.println("couleur : "+borderColor);
		applyStyle();
	}
	
	/**
	 * Change la couleur de fond en fonction du color picker
	 * @param e
	 */
	public void click_font_color(ActionEvent e){
		fontColor = "#"+_ColorFontPicker.getValue().toString().substring(2);
		System.out.println("couleur : "+fontColor);
		applyStyle();
	}
}
