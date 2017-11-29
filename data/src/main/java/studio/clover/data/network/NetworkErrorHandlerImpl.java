package studio.clover.data.network;

import com.annimon.stream.Optional;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

public final class NetworkErrorHandlerImpl implements NetworkErrorHandler {

    private static final String EMPTY = "";

    private static final String PASSWORD_ERROR_MESSAGE = "Wrong username or password";

    @Override
    public Throwable handleLoginError(final Throwable throwable) {
        if (!(throwable instanceof HttpException)) {
            return throwable;
        }

        return Optional.ofNullable(throwable)
                       .map(HttpException.class::cast)
                       .map(this::getErrorBodyString)
                       .map(this::mapLoginErrorText)
                       .orElse(new ApiUnknownLoginErrorException());
    }

    private Throwable mapLoginErrorText(final String errorText) {
        if (PASSWORD_ERROR_MESSAGE.equals(errorText)) {
            return new ApiInvalidCredentialsException();
        } else {
            return new ApiUnknownLoginErrorException();
        }
    }

    private String getErrorBodyString(final HttpException httpException) {
        final Response response = httpException.response();
        if (response == null) {
            return EMPTY;
        }

        final ResponseBody errorBody = response.errorBody();
        if (errorBody != null) {
            try {
                return errorBody.string();

            } catch (final IOException e) {
                return EMPTY;

            } finally {
                errorBody.close();
            }
        }

        return EMPTY;
    }
}
