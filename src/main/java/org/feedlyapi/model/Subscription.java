package org.feedlyapi.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Subscription {

    @SerializedName("id")
    private String feedId;
    private String title;

    public String getFeedId() {
        return feedId;
    }

    public String getTitle() {
        return title;
    }
}
