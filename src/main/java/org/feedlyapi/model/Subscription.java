package org.feedlyapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Subscription {

    public Subscription(String feedId, String title) {
        this.setFeedId(feedId);
        this.setTitle(title);
    }

    @SerializedName("id")
    private String feedId;
    private String title;
    private List<Category> categories;

    public String getFeedId() {
        return feedId;
    }

    public String getTitle() {
        return title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setFeedId(String feedId) {
        this.feedId = !feedId.startsWith("feed/") ? feedId : "feed/" + feedId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        return feedId.equals(that.feedId);

    }
}
