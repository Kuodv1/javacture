package controller;

import javafx.scene.layout.Pane;

public class ControllerEditableAgencement {

	
	private Pane cadreImageToEdit;
	
	public ControllerEditableAgencement() {
		
	}
	
	public void initialize() {
		System.out.println("Initialisze ControllerEditableAgencement Check !");
	}
	
	public void setCadreImageToEdit(Pane cadreImageToEdit) {
		this.cadreImageToEdit = cadreImageToEdit;
	}
}
