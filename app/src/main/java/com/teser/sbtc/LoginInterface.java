package com.teser.sbtc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginInterface {
    @GET("channels/1021842/fields/1&2.json?api_key=LIN8G7PKND7MMP6E&results=1")
    Call<MainChannel> getGpsData();

}
