package co.com.foo.test.memory.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 3831624553507661438L;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
