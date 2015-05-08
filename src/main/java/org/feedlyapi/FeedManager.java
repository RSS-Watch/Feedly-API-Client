package org.feedlyapi;

import org.feedlyapi.model.Article;
import org.feedlyapi.model.Stream;
import org.feedlyapi.model.Subscription;
import org.feedlyapi.retrofit.FeedlyInterface;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class FeedManager {

    private final FeedlyInterface api;

    public FeedManager(FeedlyInterface api) {
        this.api = api;
    }

    public List<Article> getLatestArticles() {
        List<Article> articles = new LinkedList<Article>();
        for (Subscription subscription : api.getSubscriptions()) {
            Stream stream = api.getStreamContent(subscription.getFeedId(), 3, null, null, null, null);
            for (Article article : stream.getItems()) {
                articles.add(article);
            }
        }
        return articles;
    }
}
