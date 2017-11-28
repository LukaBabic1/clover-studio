package studio.clover.data.serice;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Single;
import studio.clover.data.apimodel.ApiLoginRequest;
import studio.clover.data.apimodel.ApiLoginResponse;

public interface UserService {

    @POST("signin/")
    Single<ApiLoginResponse> loginUser(@Header("Content-Type") String contentType, @Body ApiLoginRequest request);
}
