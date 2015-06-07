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

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        if (content != null)
            return content.getContent();
        else
            return null;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getSummary() {
        if (summary != null)
            return summary.getContent();
        else
            return null;
    }

    public void setSummary(Content summary) {
        this.summary = summary;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public Calendar getPublished() {
        return published;
    }

    public void setPublished(Calendar published) {
        this.published = published;
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