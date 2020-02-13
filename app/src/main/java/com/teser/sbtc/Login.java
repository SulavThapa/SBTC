package com.teser.sbtc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("_id")
    @Expose
    public Id id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("class")
    @Expose
    public String _class;
    @SerializedName("busNum")
    @Expose
    public String busNum;
    @SerializedName("date")
    @Expose
    public Datedata date;
    @SerializedName("__v")
    @Expose
    public V v;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getBusNum() {
        return busNum;
    }

    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public Datedata getDate() {
        return date;
    }

    public void setDate(Datedata date) {
        this.date = date;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

}