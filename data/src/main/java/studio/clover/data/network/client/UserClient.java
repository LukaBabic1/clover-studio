package studio.clover.data.network.client;

import rx.Single;
import clover.studio.domain.model.LoginResult;

public interface UserClient {

    Single<LoginResult> loginUser(String organization, String username, String password);
}
