package org.feedlyapi.model;

import java.util.Calendar;

public class UnreadCount {

    private Calendar update;
    private String id;
    private int count;

    public Calendar getUpdate() {
        return update;
    }

    public void setUpdate(Calendar update) {
        this.update = update;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
