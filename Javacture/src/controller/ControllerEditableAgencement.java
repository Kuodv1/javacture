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
	

	private final String stringBackgroundColor =  "-fx-background-color: ";
	private String fontColor = "white";
	
	private final String stringBorderColor = "-fx-border-color: ";
	private String borderColor = "blue";
	
	private final String stringBorderStyle = "-fx-border-style: ";
	private String borderStyle = "solid";

	private final String stringBorderRadius = "-fx-border-radius: ";
	private String borderRadius = "1";	
	
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
		
	}
	
	public String reloadValue(String style, String stringType, int valueOccurence) {
		return style.substring(valueOccurence+stringType.length(), style.indexOf(';',valueOccurence));
	}
	
	public void setCadreImageToEdit(Pane cadreImageToEdit) {
		this.cadreImageToEdit = cadreImageToEdit;
		
		this.reloadParam(cadreImageToEdit.getStyle());
		
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
				+ "-fx-border-width: "+widthBorder+";"
				+  "-fx-border-style: "+borderStyle+"; "
				+	"-fx-border-radius: "+borderRadius+";");
	}
	
	public void setBorderStyle(String border){
		borderStyle = border;
		applyStyle();
	}
	
	public void setBorderRadius(String border){
		borderRadius = border;
		applyStyle();
	}
	
	public void click_point_border(ActionEvent e){
		setBorderStyle("dotted");
	}
	
	public void click_dash_border(ActionEvent e){
		setBorderStyle("dashed");
	}
	
	public void click_plein_border(ActionEvent e){
		setBorderStyle("solid");
	}
	
	public void click_round_border(ActionEvent e){
		setBorderRadius("12");
	}
	
	public void click_normal_border(ActionEvent e){
		setBorderRadius("1");
	}
}
