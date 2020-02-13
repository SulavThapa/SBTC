package com.teser.sbtc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class V {

    @SerializedName("$numberInt")
    @Expose
    public String $numberInt;

    public String get$numberInt() {
        return $numberInt;
    }

    public void set$numberInt(String $numberInt) {
        this.$numberInt = $numberInt;
    }

}
