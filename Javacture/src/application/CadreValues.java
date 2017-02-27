package application;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Classe qui contient les parametres du rectangle ou on affiche l'image
 * @author Goketsu et Kuod
 *
 */
public class CadreValues {

	/**
	 * La couleur du cadre
	 */
	protected Color colorCadre;
	
	/**
	 * La largeur du cadre
	 */
	protected int widthCadre;
	
	/**
	 * 
	 */
	protected int radiusCadre;
	
	/**
	 * Le rectangle du cadre
	 */
	protected Rectangle rectangleToEdit;
	
	/**
	 * L'image dans le cadre
	 */
	protected Image img;
	
	/**
	 * Le style du cadre
	 */
	protected String styleCadre;
	
	/**
	 * Constructeur des paramatres en fonction d'un rectangle
	 * @param rectangleToEdit le rectangle de reference
	 */
	public CadreValues(Rectangle rectangleToEdit) {
		colorCadre = Color.WHITE;
		widthCadre = 1;
		radiusCadre = 1;
		this.rectangleToEdit = rectangleToEdit;
		img = null;
		styleCadre="Plein";
	}
	
	/**
	 * Modifie la valeur du rectangle
	 * @param rectangleToEdit le rectangle de reference
	 */
	public void setRectangleToEdit(Rectangle rectangleToEdit) {
		this.rectangleToEdit = rectangleToEdit;
	}
	
	/**
	 * Recupere le rectangle
	 * @return
	 */
	public Rectangle getRectangleToEdit() {
		return this.rectangleToEdit;
	}
	
	/**
	 * Modifie la couleur du cadre
	 * @param colorCadre
	 */
	public void setCoulorCadre(Color colorCadre) {
		this.colorCadre = colorCadre;
		this.rectangleToEdit.setStroke(colorCadre);
	}
	
	/**
	 * Recupere la couleur du cadre
	 * @return
	 */
	public Color getColorCadre() {
		return this.colorCadre;
	}
	
	/**
	 * Modifie la largeur du cadre
	 * @param widthCadre
	 */
	public void setWidthCadre(int widthCadre) {
		this.widthCadre = widthCadre;
		this.rectangleToEdit.setStrokeWidth(widthCadre);
	}
	
	/**
	 * Recupere la largeur du cadre
	 * @return
	 */
	public int getWidthCadre() {
		return this.widthCadre;
	}
	
	/**
	 * Modifie ...
	 * @param radiusCadre
	 */
	public void setRadiusCadre(int radiusCadre) {
		this.radiusCadre = radiusCadre;
		this.rectangleToEdit.setArcWidth(radiusCadre);
		this.rectangleToEdit.setArcHeight(radiusCadre);
	}
	
	/**
	 * Recupere ...
	 * @return
	 */
	public int getRadiusCadre() {
		return this.radiusCadre;
	}
	
	/**
	 * Recupere l'image
	 * @return
	 */
	public Image getImage() {
		return img;
	}
	
	/**
	 * Modifie l'image
	 * @param img
	 */
	public void setImage(Image img) {
		this.img = img;
		rectangleToEdit.setFill(new ImagePattern(img,50,80,100,100,false));
	}
	
	/**
	 * Recupere le style du cadre
	 * @return
	 */
	public String getStyleCadre() {
		return styleCadre;
	}
	
	/**
	 * Modifie le style du cadre en trait plein
	 */
	public void setStyleCadrePlein() {
		styleCadre = "Plein";
		rectangleToEdit.getStrokeDashArray().removeAll(rectangleToEdit.getStrokeDashArray());
	}
	
	/**
	 * Modifie le style du cadre en pointillé
	 */
	public void setStyleCadrePointillé() {
		styleCadre = "Pointillé";
		rectangleToEdit.getStrokeDashArray().addAll(10d);
	}
}

