package studio.clover.app.utils;

public final class UnimplementedMethodException extends RuntimeException {

    public UnimplementedMethodException() {

    }

    public UnimplementedMethodException(final String message) {
        super(message);
    }
}
