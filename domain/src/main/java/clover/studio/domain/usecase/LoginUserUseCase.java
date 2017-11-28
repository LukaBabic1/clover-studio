package clover.studio.domain.usecase;

public interface LoginUserUseCase {

    final class Request {

        public final String username;
        public final String password;

        public Request(final String username, final String password) {
            this.username = username;
            this.password = password;
        }
    }
}
