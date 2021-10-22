package co.com.foo.test.memory.exception;

public class NotResultException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotResultException(String message) {
        super(message);
    }

    public NotResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotResultException(Throwable cause) {
        super(cause);
    }
}