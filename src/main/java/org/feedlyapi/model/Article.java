package org.feedlyapi.model;

import java.util.Calendar;

@SuppressWarnings("unused")
public class Article {

    private String id;
    private String title;
    private Content content;
    private Content summary;
    private boolean unread;
    private String originId;
    private Calendar published;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        if (content != null)
            return content.getContent();
        else
            return null;
    }

    public String getSummary() {
        if (summary != null)
            return summary.getContent();
        else
            return null;
    }

    public boolean isUnread() {
        return unread;
    }

    public String getOriginId() {
        return originId;
    }

    public Calendar getPublished() {
        return published;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return id.equals(article.id);

    }

    class Content {

        private String content;

        public String getContent() {
            return content;
        }
    }
}