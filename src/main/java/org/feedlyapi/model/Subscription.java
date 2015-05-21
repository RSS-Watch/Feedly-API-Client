package org.feedlyapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Subscription {

    @SerializedName("id")
    private String feedId;
    private String title;
    private List<Category> categories;

    public Subscription(String feedId, String title) {
        this.setFeedId(feedId);
        this.setTitle(title);
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = !feedId.startsWith("feed/") ? feedId : "feed/" + feedId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategories() {
        return categories;
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
