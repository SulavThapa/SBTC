package com.teser.sbtc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datedata {

    @SerializedName("$date")
    @Expose
    private com.teser.sbtc.$date $date;

    public com.teser.sbtc.$date get$date() {
        return $date;
    }

    public void set$date(com.teser.sbtc.$date $date) {
        this.$date = $date;
    }
}
