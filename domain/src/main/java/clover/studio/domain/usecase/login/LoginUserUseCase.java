package clover.studio.domain.usecase.login;

import rx.Completable;

public interface LoginUserUseCase {

    Completable execute(Request request);

    final class Request {

        public final String username;
        public final String password;

        public Request(final String username, final String password) {
            this.username = username;
            this.password = password;
        }
    }
}
