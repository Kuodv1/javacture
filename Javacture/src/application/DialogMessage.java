package application;

import javax.swing.JOptionPane;

public class DialogMessage {
	
	public static void SuccessDialogMessage(String titleBox, String texte) {
		JOptionPane.showMessageDialog(null,
			    texte,
			    titleBox,
			    JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void ErrorDialogMessage(String titleBox, String texte) {
		JOptionPane.showMessageDialog(null,
			    texte,
			    titleBox,
			    JOptionPane.ERROR_MESSAGE);
	}
}
