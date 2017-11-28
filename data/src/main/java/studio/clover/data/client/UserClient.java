package studio.clover.data.client;

import rx.Single;
import studio.clover.data.model.LoginResult;

public interface UserClient {

    Single<LoginResult> loginUser(String organization, String username, String password);
}
