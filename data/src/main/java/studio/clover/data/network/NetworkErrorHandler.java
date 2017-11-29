package studio.clover.data.network;

public interface NetworkErrorHandler {

    Throwable handleLoginError(Throwable throwable);

    final class ApiInvalidCredentialsException extends Exception {

    }

    final class ApiUnknownLoginErrorException extends Exception {

    }
}
