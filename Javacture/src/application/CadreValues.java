package application;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class CadreValues {

	protected Color colorCadre;
	
	protected int widthCadre;
	
	protected int radiusCadre;
	
	protected Rectangle rectangleToEdit;
	
	protected Image img;
	
	protected String styleCadre;
	
	public CadreValues(Rectangle rectangleToEdit) {
		colorCadre = Color.WHITE;
		widthCadre = 1;
		radiusCadre = 1;
		this.rectangleToEdit = rectangleToEdit;
		img = null;
		styleCadre="Plein";
	}
	
	public void setRectangleToEdit(Rectangle rectangleToEdit) {
		this.rectangleToEdit = rectangleToEdit;
	}
	
	public Rectangle getRectangleToEdit() {
		return this.rectangleToEdit;
	}
	
	public void setCoulorCadre(Color colorCadre) {
		this.colorCadre = colorCadre;
		this.rectangleToEdit.setStroke(colorCadre);
	}
	
	public Color getColorCadre() {
		return this.colorCadre;
	}
	
	public void setWidthCadre(int widthCadre) {
		this.widthCadre = widthCadre;
		this.rectangleToEdit.setStrokeWidth(widthCadre);
	}
	
	public int getWidthCadre() {
		return this.widthCadre;
	}
	
	public void setRadiusCadre(int radiusCadre) {
		this.radiusCadre = radiusCadre;
		this.rectangleToEdit.setArcWidth(radiusCadre);
		this.rectangleToEdit.setArcHeight(radiusCadre);
	}
	
	public int getRadiusCadre() {
		return this.radiusCadre;
	}
	
	public Image getImage() {
		return img;
	}
	
	public void setImage(Image img) {
		this.img = img;
		rectangleToEdit.setFill(new ImagePattern(img,50,80,100,100,false));
	}
	
	public String getStyleCadre() {
		return styleCadre;
	}
	
	public void setStyleCadrePlein() {
		styleCadre = "Plein";
		rectangleToEdit.getStrokeDashArray().removeAll(rectangleToEdit.getStrokeDashArray());
	}
	
	public void setStyleCadrePointillé() {
		styleCadre = "Pointillé";
		rectangleToEdit.getStrokeDashArray().addAll(10d);
	}
}

