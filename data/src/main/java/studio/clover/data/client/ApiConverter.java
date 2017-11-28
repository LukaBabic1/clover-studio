package studio.clover.data.client;

import studio.clover.data.apimodel.ApiLoginResponse;
import clover.studio.domain.model.LoginResult;

public interface ApiConverter {

    LoginResult convertToLoginResult(ApiLoginResponse response);
}
