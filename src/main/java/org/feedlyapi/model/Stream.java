package org.feedlyapi.model;

import java.util.List;

@SuppressWarnings("unused")
public class Stream {

    private String id;
    private List<String> ids;
    private String title;

    private String continuation;

    private List<Article> items;

    public String getId() {
        return id;
    }

    public List<String> getIds() {
        return ids;
    }

    public String getTitle() {
        return title;
    }

    public String getContinuation() {
        return continuation;
    }

    public List<Article> getItems() {
        return items;
    }
}
