package clover.studio.domain.model;

public final class AccessToken {

    public static final AccessToken EMPTY = new AccessToken("");

    public final String value;

    public AccessToken(final String value) {
        this.value = value;
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

        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "value='" + value + '\'' +
                '}';
    }
}
