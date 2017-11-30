package studio.clover.data.network.serice;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Single;
import studio.clover.data.network.apimodel.ApiSendMessageRequest;
import studio.clover.data.network.apimodel.ApiSendMessageResponse;

public interface MessageService {

    @POST("messages/")
    Single<ApiSendMessageResponse> sendMessage(@Header("Content-Type") String contentType, @Header("apikey") String apiKey, @Header("access-token") String accessToken,
                                               @Body ApiSendMessageRequest request);
}
