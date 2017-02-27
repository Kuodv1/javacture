package controller;

import application.CadreValues;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * 
 * Classe qui permet d'interagir avec les elements d'une image
 * Permet de modifier le fond et la bordure
 * @author Benjamin et Louis
 *
 */
public class ControllerEditableAgencement {
	
	/**
	 * Les parametres du cadre
	 */
	private CadreValues rectangleValues;
	
	/**
	 * Un color picker pour modifier la couleur de bordure
	 */
	@FXML
	private ColorPicker _ColorBorderPicker;
	/**
	 * Un color picker pour modifer la couleur du fond
	 */
	@FXML
	private ColorPicker _ColorFontPicker;
	
	/**
	 * Un label pour la largeur de la bordure
	 */
	@FXML
	private Label _labelWidthBorder;
	
	/**
	 * Un label pour le type de bordure
	 */
	@FXML
	private Label _labelTypeBorder;
	
	/**
	 * Un label pour type de coin
	 */
	@FXML
	private Label _labelCornerBorder;
	
	/**
	 * Un label pour la couleur de fond
	 */
	@FXML
	private Label _labelBackgroundColor;
	
	/**
	 * Un curseur pour l'arrondi de la bordure
	 */
	@FXML
	private Slider _sliderCornerBorder;

	/**
	 * Un curseur pour l'epaisseur de la bordure
	 */
	@FXML
	Slider _sliderWidthBorder;
	
	
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
	 * Fonction pour decouper la chaine de caractere en parametres
	 * @param style la chaine de caractere qui contient le code css
	 * @param stringType le type de parametre
	 * @param valueOccurence la valeur du parametre
	 * @return la chaine de caractere du tyle css
	 */
	public String reloadValue(String style, String stringType, int valueOccurence) {
		return style.substring(valueOccurence+stringType.length(), style.indexOf(';',valueOccurence));
	}
	
	/**
	 * Modifie les parametres du rectangle
	 * @param rectangleValues les parametre du rectangle
	 */
	public void setRectangleToEdit(CadreValues rectangleValues) {
		this.rectangleValues = rectangleValues;
		this.refreshAffichage();
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
	
	/**
	 * Initialise le curseur pour les coins de la bordure
	 */
	public void initialize_slider_corner_border() {
		_sliderCornerBorder.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    setBorderRadius(new_val.intValue());
            }
        });
	}
	
	/**
	 * Permet de changer l'epaisseur de la bordure en fonction de la valeur du curseur
	 * @param widthBorderInt epaisseur de la bordure
	 */
	public void changeWidthBorder(int widthBorderInt){
		rectangleValues.setWidthCadre(widthBorderInt);
		_labelWidthBorder.setText(""+widthBorderInt);
	}
	
	/**
	 * Permet de rafraichir l'affichage
	 */
	public void refreshAffichage() {
		this._ColorBorderPicker.setValue(rectangleValues.getColorCadre());
		
		_labelTypeBorder.setText(rectangleValues.getStyleCadre());
		
        _labelWidthBorder.setText(rectangleValues.getWidthCadre()+"");
        _sliderWidthBorder.setValue(rectangleValues.getWidthCadre());
        
        _labelCornerBorder.setText(rectangleValues.getRadiusCadre()+"");
        _sliderCornerBorder.setValue(rectangleValues.getRadiusCadre());
	}
	
	/**
	 * Permet de modifier la courbe des coins du cadre
	 * @param borderRadius le degres de courbur du cadre
	 */
	public void setBorderRadius(int borderRadius){
		this.rectangleValues.setRadiusCadre(borderRadius);
		_labelCornerBorder.setText(rectangleValues.getRadiusCadre()+"");
	}
	
	/**
	 * Modifie le style de bordure en point
	 * @param e l'evenement declencher par une action de l'utilisateur
	 */
	public void click_point_border(ActionEvent e){
		this.rectangleValues.setStyleCadrePointillé();
		_labelTypeBorder.setText(rectangleValues.getStyleCadre());
	}
	
	/**
	 * Modifie le style de borudure en normal
	 * @param e l'evenement declencher par une action de l'utilisateur
	 */
	public void click_plein_border(ActionEvent e){
		this.rectangleValues.setStyleCadrePlein();
		_labelTypeBorder.setText(rectangleValues.getStyleCadre());
	}
	
	/**
	 * Modifie la couleur de bordure en fonction du color picker
	 * @param e l'evenement declencher par une action de l'utilisateur
	 */
	public void click_border_color(ActionEvent e){
		Color c = _ColorBorderPicker.getValue();
		rectangleValues.setColorCadre(c);
		refreshAffichage();
	}
}
