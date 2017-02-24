package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class ControllerEditableAgencement {

	
	private Pane cadreImageToEdit;
	
	@FXML
	private Pane _cadreImage;
	
	private String borderStyle = "solid";
	private String borderRadius = "1";
	
	public ControllerEditableAgencement() {
		
	}
	
	public void initialize() {
		System.out.println("Initialisze ControllerEditableAgencement Check !");
	}
	
	public void setCadreImageToEdit(Pane cadreImageToEdit) {
		this.cadreImageToEdit = cadreImageToEdit;
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
