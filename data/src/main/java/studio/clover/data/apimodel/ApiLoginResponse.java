package studio.clover.data.apimodel;

import com.google.gson.annotations.SerializedName;

public final class ApiLoginResponse {

    @SerializedName("access-token")
    public String accessToken;

    @SerializedName("user")
    public ApiUser user;
}
