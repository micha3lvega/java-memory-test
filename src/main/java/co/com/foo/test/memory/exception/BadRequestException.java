package co.com.foo.test.memory.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -5289246978495305052L;

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
