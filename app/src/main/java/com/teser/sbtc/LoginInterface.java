package com.teser.sbtc;

import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginInterface {
    @POST("api/users/login")
    Call<Login> getLoginData();

}
