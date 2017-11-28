package clover.studio.domain.model;

public final class LoginResult {

    public final AccessToken accessToken;
    public final User user;

    public LoginResult(final AccessToken accessToken, final User user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginResult that = (LoginResult) o;

        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) {
            return false;
        }
        return user != null ? user.equals(that.user) : that.user == null;

    }

    @Override
    public int hashCode() {
        int result = accessToken != null ? accessToken.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "accessToken=" + accessToken +
                ", user=" + user +
                '}';
    }
}
