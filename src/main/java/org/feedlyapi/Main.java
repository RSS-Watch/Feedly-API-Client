package org.feedlyapi;

import org.feedlyapi.help.FormatHelper;
import org.feedlyapi.model.Article;
import org.feedlyapi.model.Stream;
import org.feedlyapi.retrofit.FeedlyApiProvider;

@SuppressWarnings("WeakerAccess")
public class Main {

    public static void main(String[] args) {
        FeedManager api = new FeedManager(FeedlyApiProvider.getApi(args[0]));
        for (Article article : api.getLatestArticles(3).getItems()) {
            System.out.println(article.getTitle() + " (" + FormatHelper.formatDateTime(article.getPublished()) + ")");
        }

        Stream stream = api.getLatestArticlesOfCategory(api.getApiInterface().getCategories().get(0), 5);

        System.out.println("----------- Part 1 ----------");
        for (Article article : stream.getItems()) {
            System.out.println(article.getTitle() + " (" + FormatHelper.formatDateTime(article.getPublished()) + ")");
        }

        stream = api.getLatestArticles(5, stream.getContinuation());
        System.out.println("----------- Part 2 ----------");
        for (Article article : stream.getItems()) {
            System.out.println(article.getTitle() + " (" + FormatHelper.formatDateTime(article.getPublished()) + ")");
        }

//        FeedlyInterface api = FeedlyApiProvider.getApi(args[0]);
//        System.out.println(api.deleteCategory("user/5edaf963-b660-479b-af5d-6fd66d937f15/category/global.all").getStatus());

//        System.out.println(api.getApiInterface().getProfile());
    }
}
