package studio.clover.data.network.converter;

import studio.clover.data.network.apimodel.ApiLoginResponse;
import clover.studio.domain.model.LoginResult;

public interface ApiConverter {

    LoginResult convertToLoginResult(ApiLoginResponse response);
}
