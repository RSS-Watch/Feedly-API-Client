package org.feedlyapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {

    @SerializedName("id")
    private String feedId;
    private String title;
    private String language;
    private boolean sponsored;
    private boolean featured;
    private int subscribers;
    private float velocity;
    private String website;
    private List<String> topics;

    public Feed(String feedId) {
        this.feedId = feedId;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "feedId='" + feedId + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", sponsored=" + sponsored +
                ", featured=" + featured +
                ", subscribers=" + subscribers +
                ", velocity=" + velocity +
                ", website='" + website + '\'' +
                ", topics=" + topics +
                '}';
    }
}
