package clover.studio.domain.usecase.login;

import rx.Single;

public interface IsUserLoggedInUseCase {

    Single<Boolean> execute();
}
