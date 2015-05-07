package org.feedlyapi;

import org.feedlyapi.help.FormatHelper;
import org.feedlyapi.model.Article;
import org.feedlyapi.retrofit.FeedlyApiProvider;

@SuppressWarnings("WeakerAccess")
public class Main {

    public static void main(String[] args) {
        FeedManager api = new FeedManager(FeedlyApiProvider.getApi(args[0]));
        for (Article article : api.getLatestArticles()) {
            System.out.println(article.getTitle() + " (" + FormatHelper.formatDateTime(article.getPublished()) + ")");
        }
    }
}
