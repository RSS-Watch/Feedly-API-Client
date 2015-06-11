package org.feedlyapi;

import org.feedlyapi.help.FormatHelper;
import org.feedlyapi.model.Article;
import org.feedlyapi.model.Category;
import org.feedlyapi.model.Stream;
import org.feedlyapi.retrofit.FeedlyApiProvider;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Main {

    public static void main(String[] args) {
        final FeedManager api = new FeedManager(FeedlyApiProvider.getApi());
        FeedlyApiProvider.setAccessToken(args[0]);

        api.getLatestArticles(3, new Callback<Stream>() {
            @Override
            public void success(Stream stream, Response response) {
                for (Article article : stream.getItems()) {
                    System.out.println(article.getTitle() + " (" + FormatHelper.formatDateTime(article.getPublished()) + ")");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });

        api.getCategories(new Callback<List<Category>>() {
            @Override
            public void success(List<Category> categories, Response response) {
                listArticles(categories, api);
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    private static void listArticles(List<Category> categories, final FeedManager api) {
        api.getLatestArticlesOfCategory(categories.get(0), 5, new Callback<Stream>() {
            @Override
            public void success(Stream stream, Response response) {
                System.out.println("----------- Part 1 ----------");
                for (Article article : stream.getItems()) {
                    System.out.println(article.getTitle() + " (" + FormatHelper.formatDateTime(article.getPublished()) + ")");
                }

                listNextArticles(stream, api);
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    private static void listNextArticles(Stream stream, FeedManager api) {
        api.getLatestArticles(5, stream.getContinuation(), new Callback<Stream>() {
            @Override
            public void success(Stream stream, Response response) {
                System.out.println("----------- Part 2 ----------");
                for (Article article : stream.getItems()) {
                    System.out.println(article.getTitle() + " (" + FormatHelper.formatDateTime(article.getPublished()) + ")");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }
}
