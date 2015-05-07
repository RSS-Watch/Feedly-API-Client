package org.feedlyapi.model;

import java.util.List;

@SuppressWarnings("unused")
public class Stream {

    private String id;
    private String title;
    private List<Article> items;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Article> getItems() {
        return items;
    }
}
