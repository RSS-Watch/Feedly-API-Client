package org.feedlyapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

public class ReadOperations {

    private List<Marker> feeds;
    private List<String> entries;
    private List<String> unread;

    public List<Marker> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Marker> feeds) {
        this.feeds = feeds;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }

    public List<String> getUnread() {
        return unread;
    }

    public void setUnread(List<String> unread) {
        this.unread = unread;
    }

    class Marker {

        private Calendar asOf;
        @SerializedName("id")
        private String feedId;

        public Calendar getAsOf() {
            return asOf;
        }

        public void setAsOf(Calendar asOf) {
            this.asOf = asOf;
        }

        public String getFeedId() {
            return feedId;
        }

        public void setFeedId(String feedId) {
            this.feedId = feedId;
        }
    }
}
