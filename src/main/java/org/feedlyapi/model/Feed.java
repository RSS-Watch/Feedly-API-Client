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

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public boolean isFeatured() {
        return featured;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public float getVelocity() {
        return velocity;
    }

    public String getWebsite() {
        return website;
    }

    public List<String> getTopics() {
        return topics;
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
