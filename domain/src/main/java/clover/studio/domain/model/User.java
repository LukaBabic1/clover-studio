package clover.studio.domain.model;

public final class User {

    public static final User EMPTY = new User("", "", "", "");

    public final String id;
    public final String userId;
    public final String name;
    public final String description;

    public User(final String id, final String userId, final String name, final String description) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) {
            return false;
        }
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return description != null ? description.equals(user.description) : user.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
