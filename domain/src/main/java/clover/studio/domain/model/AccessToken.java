package clover.studio.domain.model;

public final class AccessToken {

    public final String accessToken;

    public AccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AccessToken that = (AccessToken) o;

        return accessToken != null ? accessToken.equals(that.accessToken) : that.accessToken == null;

    }

    @Override
    public int hashCode() {
        return accessToken != null ? accessToken.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                '}';
    }
}
