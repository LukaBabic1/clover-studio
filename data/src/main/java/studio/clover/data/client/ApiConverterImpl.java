package studio.clover.data.client;

import clover.studio.domain.StringUtils;
import clover.studio.domain.model.AccessToken;
import clover.studio.domain.model.User;
import studio.clover.data.apimodel.ApiLoginResponse;
import studio.clover.data.apimodel.ApiUser;
import studio.clover.data.model.LoginResult;

public final class ApiConverterImpl implements ApiConverter {

    private final StringUtils stringUtils;

    public ApiConverterImpl(final StringUtils stringUtils) {
        this.stringUtils = stringUtils;
    }

    @Override
    public LoginResult convertToLoginResult(final ApiLoginResponse response) {
        if (response == null) {
            throw new IllegalArgumentException("API response is null.");
        }

        return new LoginResult(convertToAccessToken(response.accessToken),
                               convertToUser(response.user));
    }

    private AccessToken convertToAccessToken(String accessToken) {
        return stringUtils.isEmpty(accessToken) ? AccessToken.EMPTY : new AccessToken(accessToken);
    }

    private User convertToUser(final ApiUser user) {
        return new User(user.id, user.userId, user.name, user.description);
    }
}
