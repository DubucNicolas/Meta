package fr.bibop.commons;

/**
 * Scanner Exception
 * @author N Dubuc
 *
 */
public class SecurityException extends Exception {
	private static final long serialVersionUID = 1L;

	public SecurityException() {

	}

	public SecurityException(String arg0) {
		super(arg0);

	}

	public SecurityException(Throwable arg0) {
		super(arg0);

	}

	public SecurityException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}
}
