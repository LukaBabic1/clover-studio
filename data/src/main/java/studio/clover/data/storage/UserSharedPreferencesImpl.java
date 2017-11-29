package studio.clover.data.storage;

import android.content.Context;
import android.content.SharedPreferences;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.model.User;

public final class UserSharedPreferencesImpl implements UserSharedPreferences {

    private static final String FILE_NAME = "user_shared_prefs";

    private static final String KEY_USER_ACCESS_TOKEN = "key_user_access_token";

    private static final String KEY_USER_ID = "key_user_id";
    private static final String KEY_USER_USER_ID = "key_user_user_id";
    private static final String KEY_USER_NAME = "key_user_name";
    private static final String KEY_USER_DESCRIPTION = "key_user_description";

    private final SharedPreferences preferences;

    public static UserSharedPreferencesImpl create(final Context context) {
        return new UserSharedPreferencesImpl(context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE));
    }

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

    @Override
    public void saveUser(final User user) {
        preferences.edit()
                   .putString(KEY_USER_ID, user.id)
                   .putString(KEY_USER_USER_ID, user.userId)
                   .putString(KEY_USER_NAME, user.name)
                   .putString(KEY_USER_DESCRIPTION, user.description)
                   .apply();
    }
}
