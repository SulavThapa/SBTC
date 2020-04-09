package com.teser.sbtc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GpsData {

    @SerializedName("channel")
    @Expose
    public Channel channel;

    @SerializedName("temprature_graph")
    public ArrayList<Feeds> feeds ;
    int size = feeds.size();

}
