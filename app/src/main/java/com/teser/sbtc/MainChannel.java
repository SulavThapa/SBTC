package com.teser.sbtc;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainChannel {

    @SerializedName("channel")
    @Expose
    public Channel channel;
    @SerializedName("feeds")
    @Expose
    public List<Feeds> feeds ;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Feeds> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feeds> feeds) {
        this.feeds = feeds;
    }

}