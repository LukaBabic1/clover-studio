package studio.clover.data.network.apimodel;

import com.google.gson.annotations.SerializedName;

public final class ApiSendMessageRequest {

    @SerializedName("targetType")
    public final int targetType;

    @SerializedName("messageType")
    public final int messageType;

    @SerializedName("target")
    public final String target;

    @SerializedName("message")
    public final String message;

    public ApiSendMessageRequest(final int targetType, final int messageType, final String target, final String message) {
        this.targetType = targetType;
        this.messageType = messageType;
        this.target = target;
        this.message = message;
    }
}
