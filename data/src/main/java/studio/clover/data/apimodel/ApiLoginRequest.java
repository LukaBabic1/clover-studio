package studio.clover.data.apimodel;

import com.google.gson.annotations.SerializedName;

public final class ApiLoginRequest {

    @SerializedName("organization")
    public final String organization;

    @SerializedName("username")
    public final String username;

    @SerializedName("password")
    public final String password;

    public ApiLoginRequest(final String organization, final String username, final String password) {
        this.organization = organization;
        this.username = username;
        this.password = password;
    }
}
