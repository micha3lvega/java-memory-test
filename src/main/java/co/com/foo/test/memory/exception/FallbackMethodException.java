
package co.com.foo.test.memory.exception;

public class FallbackMethodException extends RuntimeException {

	private static final long serialVersionUID = -408817517886901384L;

	public FallbackMethodException(String message) {
		super(message);
	}

	public FallbackMethodException(Throwable cause) {
		super(cause);
	}

	public FallbackMethodException(String message, Throwable cause) {
		super(message, cause);
	}

}
