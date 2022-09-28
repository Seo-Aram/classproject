package chapter10;

public class BadIdInputException extends Exception {

	public BadIdInputException(String message) {
		super(message);
	}

	public BadIdInputException() {
		super("BadInputException");
	}

	public BadIdInputException(String message, Throwable cause) {
		super(message, cause);
	}
}
