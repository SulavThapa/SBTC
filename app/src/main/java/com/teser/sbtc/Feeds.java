package com.teser.sbtc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feeds {

    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("entry_id")
    @Expose
    public Integer entryId;
    @SerializedName("field1")
    @Expose
    public String field1;
    @SerializedName("field2")
    @Expose
    public String field2;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

}