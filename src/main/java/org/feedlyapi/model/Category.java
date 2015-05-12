package org.feedlyapi.model;

/**
 * Created by Dennis on 12.05.2015.
 */
public class Category {

    private String id;
    private String label;

    public Category(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
