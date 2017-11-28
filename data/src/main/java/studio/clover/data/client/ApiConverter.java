package studio.clover.data.client;

import studio.clover.data.apimodel.ApiLoginResponse;
import studio.clover.data.model.LoginResult;

public interface ApiConverter {

    LoginResult convertToLoginResult(ApiLoginResponse response);
}
