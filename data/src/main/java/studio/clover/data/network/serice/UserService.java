package studio.clover.data.network.serice;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Single;
import studio.clover.data.network.apimodel.ApiLoginRequest;
import studio.clover.data.network.apimodel.ApiLoginResponse;

public interface UserService {

    @POST("signin/")
    Single<ApiLoginResponse> loginUser(@Header("Content-Type") String contentType, @Header("apikey") String apiKey, @Body ApiLoginRequest request);
}
