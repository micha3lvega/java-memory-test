package co.com.foo.test.memory.exception;

public class CallDatabaseException extends RuntimeException {

	public CallDatabaseException() {
	}

	public CallDatabaseException(String message) {
		super(message);
	}

	public CallDatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public CallDatabaseException(Throwable cause) {
		super(cause);
	}
}