package application;

import javax.swing.JOptionPane;

/**
 * 
 * @author Goketsu et Kuod
 * Classe pour gerer les messages d'erreurs
 *
 */
public class DialogMessage {
	
	/**
	 * Fonction pour gerer les message de succes
	 * @param titleBox : le nom de la fenetre
	 * @param texte : le texte de succes
	 */
	public static void SuccessDialogMessage(String titleBox, String texte) {
		JOptionPane.showMessageDialog(null,
			    texte,
			    titleBox,
			    JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Fonction pour gerer les messages d'erreur
	 * @param titleBox : le nom de la fenetre
	 * @param texte : le texte d'erreur
	 */
	public static void ErrorDialogMessage(String titleBox, String texte) {
		JOptionPane.showMessageDialog(null,
			    texte,
			    titleBox,
			    JOptionPane.ERROR_MESSAGE);
	}
}
