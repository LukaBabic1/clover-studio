package studio.clover.data.storage;

import android.content.SharedPreferences;

import clover.studio.domain.model.AccessToken;

public final class UserSharedPreferencesImpl implements UserSharedPreferences {

    private static final String KEY_USER_ACCESS_TOKEN = "key_user_access_token";

    private final SharedPreferences preferences;

    public UserSharedPreferencesImpl(final SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public void saveAccessToken(final AccessToken token) {
        preferences.edit()
                   .putString(KEY_USER_ACCESS_TOKEN, token.value)
                   .apply();
    }

    @Override
    public AccessToken getAccessToken() {
        return new AccessToken(preferences.getString(KEY_USER_ACCESS_TOKEN, AccessToken.EMPTY.value));
    }
}
