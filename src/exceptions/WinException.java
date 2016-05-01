package exceptions;

/**
 * Classe d'exception lancee lors de la victoire du joueur
 */
public class WinException extends Exception {

	/**
	 * Constructeur de WinException
	 */
	public WinException() {
		super("Victoire !");
	}
}
