package clover.studio.domain.model;

public final class User {

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
}
