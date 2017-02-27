package application;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Classe qui contient les parametres du rectangle ou on affiche l'image
 * @author Benjamin et Louis
 *
 */
public class CadreValues {

	/**
	 * La couleur du cadre
	 */
	protected Color colorCadre;
	
	/**
	 * La couleur de base du rectangle
	 */
	protected Color colorBack;
	
	/**
	 * La largeur du cadre
	 */
	protected int widthCadre;
	
	/**
	 * Le degr� de courbure de la bordure
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
		this.rectangleToEdit = rectangleToEdit;
		img = null;
		defaultRectangle();
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
	 * @return le rectangle de reference
	 */
	public Rectangle getRectangleToEdit() {
		return this.rectangleToEdit;
	}
	
	/**
	 * Modifie la couleur du cadre
	 * @param colorCadre la couleur qu'on veut pour le cadre
	 */
	public void setColorCadre(Color colorCadre) {
		this.colorCadre = colorCadre;
		this.rectangleToEdit.setStroke(colorCadre);
	}
	
	/**
	 * Recupere la couleur du cadre
	 * @return le couleur de fond du cadre
	 */
	public Color getColorCadre() {
		return this.colorCadre;
	}
	
	/**
	 * Modifie la couluer de base du rectangle
	 * @param colorBack la couleur de base vous pour le rectangle
	 */
	public void setColorBack(Color colorBack) {
		this.colorBack = colorBack;
		this.rectangleToEdit.setFill(colorBack);
	}
	
	/**
	 * Recupere la couleur de base du rectangle
	 * @return la couleur de base du rectangle
	 */
	public Color getColorBack() {
		return this.colorBack;
	}
	
	/**
	 * Modifie la largeur du cadre
	 * @param widthCadre l'epaisseur voulu pour la bordure
	 */
	public void setWidthCadre(int widthCadre) {
		this.widthCadre = widthCadre;
		this.rectangleToEdit.setStrokeWidth(widthCadre);
	}
	
	/**
	 * Recupere la largeur du cadre
	 * @return l'epaisseur de la bordure
	 */
	public int getWidthCadre() {
		return this.widthCadre;
	}
	
	/**
	 * Modifie le degr� de courbure de la bordure
	 * @param radiusCadre le degr� de courbure voulu de la bordure
	 */
	public void setRadiusCadre(int radiusCadre) {
		this.radiusCadre = radiusCadre;
		this.rectangleToEdit.setArcWidth((radiusCadre*0.01)*rectangleToEdit.getWidth());
		this.rectangleToEdit.setArcHeight((radiusCadre*0.01)*rectangleToEdit.getHeight());
	}
	
	/**
	 * Recupere le degr� de courbure de la bordure
	 * @return le debgr� de courbure de la bordure
	 */
	public int getRadiusCadre() {
		return this.radiusCadre;
	}
	
	/**
	 * Recupere l'image
	 * @return l'image
	 */
	public Image getImage() {
		return img;
	}
	
	/**
	 * Modifie l'image
	 * @param img l'image voulu dans le cadre
	 */
	public void setImage(Image img) {
		this.img = img;
		rectangleToEdit.setFill(new ImagePattern(img));
	}
	
	/**
	 * Recupere le style du cadre
	 * @return le style du cadre
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
	 * Modifie le style du cadre en pointill�
	 */
	public void setStyleCadrePointill�() {
		styleCadre = "Pointill�";
		rectangleToEdit.getStrokeDashArray().addAll(10d);
	}
	
	/**
	 * Initialise les parametres de base du rectangle
	 */
	public void defaultRectangle() {
		this.setColorCadre(Color.BLACK);
		this.setWidthCadre(1);
		this.setRadiusCadre(1);
		this.setStyleCadrePointill�();
		this.setColorBack(Color.ORANGE);
	}
}

