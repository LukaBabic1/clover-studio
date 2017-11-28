package studio.clover.data.network.apimodel;

import com.google.gson.annotations.SerializedName;

public final class ApiUser {

    @SerializedName("_id")
    public String id;

    @SerializedName("userId")
    public String userId;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;
}
