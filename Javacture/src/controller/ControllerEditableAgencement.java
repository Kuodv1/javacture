package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

public class ControllerEditableAgencement {

	
	private Pane cadreImageToEdit;
	
	@FXML
	private Pane _cadreImage;
	
	private String borderStyle = "solid";
	private String borderRadius = "1";
	
	private final String stringBackgroundColor =  "-fx-background-color: ";
	private String fontColor = "white";
	
	private final String stringBorderColor = "-fx-border-color: ";
	private String borderColor = "blue";
	
	
	@FXML
	Slider _sliderWidthBorder;
	
	private final String stringBorderWidth = "-fx-border-width: ";
	private String widthBorder = "1";
	
	public ControllerEditableAgencement() {
		
	}
	
	public void initialize() {
		System.out.println("Initialisze ControllerEditableAgencement Check !");
		initialize_slider_width_border();
	}
	
	public void reloadParam(String style) {
		int startBackgrounColor = style.indexOf(stringBackgroundColor); 
		if(startBackgrounColor>=0)
			fontColor = style.substring(startBackgrounColor+stringBackgroundColor.length(), style.indexOf(';', startBackgrounColor));
		
		int startBorderColor = style.indexOf(stringBorderColor);
		if(startBorderColor>=0)
			borderColor = style.substring(startBorderColor+stringBorderColor.length(), style.indexOf(';', startBorderColor));
		
		int startBorderWidth = style.indexOf(stringBorderWidth);
		if(startBorderWidth>=0)
			widthBorder = style.substring(startBorderWidth+stringBorderWidth.length(), style.indexOf(';', startBorderWidth));
		
	}
	
	public void setCadreImageToEdit(Pane cadreImageToEdit) {
		this.cadreImageToEdit = cadreImageToEdit;
		
		this.reloadParam(cadreImageToEdit.getStyle());
		
		/*cadreImageToEdit.styleProperty().setValue(" -fx-border-color: "+"blue"+";"
				+ "-fx-border-width: "+5+";");*/
		
		System.out.println(cadreImageToEdit.getStyle());
				
	}
	
	
	public void initialize_slider_width_border() {
		_sliderWidthBorder.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    changeWidthBorder(new_val.intValue());
            }
        });
	}
	
	
	public void changeWidthBorder(int widthBorderInt){
		this.widthBorder = ""+widthBorderInt;
		applyStyle();
	}
	
	public void applyStyle() {
		cadreImageToEdit.styleProperty().setValue("-fx-background-color: "+fontColor+";"+
				" -fx-border-color: "+borderColor+";"
				+ "-fx-border-width: "+widthBorder+";");
		System.out.println("apply?");
		System.out.println(cadreImageToEdit.getStyle());
	}
	
	public void setBorderStyle(String border){
		borderStyle = border;
		cadreImageToEdit.styleProperty().setValue("-fx-border-color: black;"
				+ "-fx-border-width: 1; -fx-border-style: "+border+"; "
						+ "-fx-border-radius: "+borderRadius+";");
	}
	
	public void setBorderRadius(String border){
		borderRadius = border;
		cadreImageToEdit.styleProperty().setValue("-fx-border-color: black;"
				+ "-fx-border-width: 1; -fx-border-style: "+borderStyle+"; "
						+ "-fx-border-radius: "+border+";");
	}
	
	public void click_point_border(ActionEvent e){
		setBorderStyle("dotted");
		System.out.println("bordure pointille "+cadreImageToEdit.styleProperty().getValue());
	}
	
	public void click_dash_border(ActionEvent e){
		setBorderStyle("dashed");
		System.out.println("bordure pointille "+cadreImageToEdit.styleProperty().getValue());
	}
	
	public void click_plein_border(ActionEvent e){
		setBorderStyle("solid");
		System.out.println("bordure pleine "+cadreImageToEdit.styleProperty().getValue());
	}
	
	public void click_round_border(ActionEvent e){
		setBorderRadius("12");
		System.out.println("bordure pleine "+cadreImageToEdit.styleProperty().getValue());
	}
	
	public void click_normal_border(ActionEvent e){
		setBorderRadius("1");
		System.out.println("bordure pleine "+cadreImageToEdit.styleProperty().getValue());
	}
}
