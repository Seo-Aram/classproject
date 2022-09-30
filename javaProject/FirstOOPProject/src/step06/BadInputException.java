package step06;

public class BadInputException extends Exception {

	public BadInputException(String message) {
		super(message);
	}

	public BadInputException() {
		super("BadInputException");
	}

	public BadInputException(String message, Throwable cause) {
		super(message, cause);
	}
}
