package exceptions;

/**
 * Classe d'exception lancee lors de la victoire du joueur
 */
public class WinException extends Exception {
	
	/**
	 * Constructeur de WinException
	 * @param message Message affichee en cas de victoire
	 */
	public WinException() {
		super("Victoire !");
	}
}
