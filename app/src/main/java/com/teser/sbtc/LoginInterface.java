package com.teser.sbtc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginInterface {
    @POST("api/client/v2.0/app/testapp-oujem/service/Login/incoming_webhook/userData")
    Call<List<Login>> getLoginData();

}
