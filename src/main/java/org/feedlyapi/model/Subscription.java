package org.feedlyapi.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Subscription {

    public Subscription(String feedId, String title) {
        this.setFeedId(feedId);
        this.setTitle(title);
    }

    @SerializedName("id")
    private String feedId;
    private String title;

    public String getFeedId() {
        return feedId;
    }

    public String getTitle() {
        return title;
    }

    public void setFeedId(String feedId) {
        this.feedId = !feedId.startsWith("feed/") ? feedId : "feed/" + feedId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        return feedId.equals(that.feedId);

    }
}
