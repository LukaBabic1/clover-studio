package studio.clover.data.network.client;

import rx.Single;
import studio.clover.data.network.NetworkErrorHandler;
import studio.clover.data.network.apimodel.ApiLoginRequest;
import clover.studio.domain.model.LoginResult;
import studio.clover.data.network.converter.ApiConverter;
import studio.clover.data.network.serice.UserService;

public final class UserClientImpl implements UserClient {

    private static final String CONTENT_TYPE_VALUE = "application/json; charset=utf-8";

    private static final String API_KEY = "GMUwQIHielm7b1ZQNNJYMAfCC508Giof";

    private final ApiConverter apiConverter;
    private final NetworkErrorHandler networkErrorHandler;
    private final UserService userService;

    public UserClientImpl(final ApiConverter apiConverter, final NetworkErrorHandler networkErrorHandler, final UserService userService) {
        this.apiConverter = apiConverter;
        this.networkErrorHandler = networkErrorHandler;
        this.userService = userService;
    }

    @Override
    public Single<LoginResult> loginUser(final String organization, final String username, final String password) {
        return userService.loginUser(CONTENT_TYPE_VALUE, API_KEY, new ApiLoginRequest(organization, username, password))
                          .map(apiConverter::convertToLoginResult)
                          .onErrorResumeNext(throwable -> Single.error(networkErrorHandler.handleLoginError(throwable)));
    }
}
