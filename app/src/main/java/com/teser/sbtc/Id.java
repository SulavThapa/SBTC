package com.teser.sbtc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id {

    @SerializedName("$oid")
    @Expose
    public String $oid;

    public String get$oid() {
        return $oid;
    }

    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

}
