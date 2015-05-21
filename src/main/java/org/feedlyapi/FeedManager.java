package org.feedlyapi;

import org.feedlyapi.model.*;
import org.feedlyapi.retrofit.FeedlyInterface;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
/**
 * This class is used for wrapping the API calls of the FeedlyInterface to provide easier access to its functions.
 *
 * @author Dennis Effing
 * @author Sebastian Schiller
 */
public class FeedManager {

    private final FeedlyInterface api;

    public FeedManager(FeedlyInterface api) {
        this.api = api;
    }

    /**
     * Returns the API interface used by this FeedManager instance.
     *
     * @return API Interface
     * @see FeedlyInterface
     */
    public FeedlyInterface getApiInterface() {
        return api;
    }

    //region Category module

    /**
     * Gets a list of all user categories. The global categories all and uncategorized will not be returned
     * by this method. Global.must will only be returned if at least one feed is in this category.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @return Empty list when user has no own categories and global.must has no feeds.
     * @see Category
     */
    public void getCategories(Callback<List<Category>> callback) {
        api.getCategoriesAsync(callback);
    }
    //endregion

    //region Feeds module

    /**
     * Gets information about a specified feed.
     * The feedId field is mandatory.
     *
     * @param feed {@link Feed} object with feedId field.
     * @return {@link Feed} object containing information (title, language, number of subscribers etc.)
     */
    public void getFeedMetadata(Feed feed, Callback<Feed> callback) {
        api.getFeedMetadataAsync(feed.getFeedId(), callback);
    }

    /**
     * Gets information about a list of specified feeds.
     * The feedId field of every {@link Feed} object is mandatory.
     *
     * @param feeds List of {@link Feed} objects with feedId field.
     * @return List of {@link Feed} objects containing information (title, language, number of subscribers etc.)
     */
    public void getFeedsMetadata(List<Feed> feeds, Callback<List<Feed>> callback) {
        List<String> feedIds = new LinkedList<>();

        for (Feed feed : feeds) {
            feedIds.add(feed.getFeedId());
        }

        api.getFeedsMetadataAsync(feedIds, callback);
    }
    //endregion

    //region Profile module

    /**
     * Gets the profile of the authenticated user.
     *
     * @return Profile object containing user information.
     * @see Profile
     */
    public Profile getProfile() {
        return api.getProfile();
    }
    //endregion

    //region Stream module
    //region Get articles from global categories

    /**
     * Gets the latest articles of the global.all category.
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestArticles(Integer count, Callback<Stream> callback) {
        this.getLatestArticles(count, null, callback);
    }

    /**
     * Works like {@link #getLatestArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestArticles(final Integer count, final String continuation, final Callback<Stream> callback) {
        api.getProfileAsync(new Callback<Profile>() {
            @Override
            public void success(Profile profile, Response response) {
                String globalAllCategoryId = "user/" + profile.getId() + "/category/global.all";
                api.getStreamContentAsync(globalAllCategoryId, count, null, null, null, continuation, callback);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }

    /**
     * Gets the latest articles of the global.read category.
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestReadArticles(Integer count, Callback<Stream> callback) {
        getLatestReadArticles(count, null, callback);
    }

    /**
     * Works like {@link #getLatestReadArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestReadArticles(final Integer count, final String continuation, final Callback<Stream> callback) {
        api.getProfileAsync(new Callback<Profile>() {
            @Override
            public void success(Profile profile, Response response) {
                String globalReadCategoryId = "user/" + profile.getId() + "/category/global.read";
                api.getStreamContentAsync(globalReadCategoryId, count, null, null, null, continuation, callback);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }

    /**
     * Gets the latest articles of the global.saved category.
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestSavedArticles(Integer count, Callback<Stream> callback) {
        getLatestSavedArticles(count, null, callback);
    }

    /**
     * Works like {@link #getLatestSavedArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestSavedArticles(final Integer count, final String continuation, final Callback<Stream> callback) {
        api.getProfileAsync(new Callback<Profile>() {
            @Override
            public void success(Profile profile, Response response) {
                String globalSavedCategoryId = "user/" + profile.getId() + "/category/global.saved";
                api.getStreamContentAsync(globalSavedCategoryId, count, null, null, null, continuation, callback);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }

    /**
     * Gets the latest uncategorized articles (global.uncategorized category).
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestUncategorizedArticles(Integer count, Callback<Stream> callback) {
        getLatestUncategorizedArticles(count, null, callback);
    }

    /**
     * Works like {@link #getLatestUncategorizedArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestUncategorizedArticles(final Integer count, final String continuation, final Callback<Stream> callback) {
        api.getProfileAsync(new Callback<Profile>() {
            @Override
            public void success(Profile profile, Response response) {
                String globalUncategorizedCategoryId = "user/" + profile.getId() + "/category/global.uncategorized";
                api.getStreamContentAsync(globalUncategorizedCategoryId, count, null, null, null, continuation, callback);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }

    /**
     * Gets the latest must read articles (global.must category).
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestMustReadArticles(Integer count, Callback<Stream> callback) {
        getLatestMustReadArticles(count, null, callback);
    }

    /**
     * Works like {@link #getLatestMustReadArticles(Integer)} but considers a continuation string when fetching articles.
     *
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestMustReadArticles(final Integer count, final String continuation, final Callback<Stream> callback) {
        api.getProfileAsync(new Callback<Profile>() {
            @Override
            public void success(Profile profile, Response response) {
                String globalMustReadCategoryId = "user/" + profile.getId() + "/category/global.must";
                api.getStreamContentAsync(globalMustReadCategoryId, count, null, null, null, continuation, callback);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }
    //endregion
    //region Get articles from Feeds, Subscriptions and user categories

    /**
     * Gets the latest articles of the specified category.
     *
     * @param category Category object containing the category ID.
     * @param count    Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestArticlesOfCategory(Category category, Integer count, Callback<Stream> callback) {
        getLatestArticlesOfCategory(category, count, null, callback);
    }

    /**
     * Works like {@link #getLatestArticlesOfCategory(Category, Integer)} but considers a continuation string when
     * fetching articles.
     *
     * @param category     Category object containing information about the specified category.
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public void getLatestArticlesOfCategory(Category category, Integer count, String continuation, Callback<Stream> callback) {
        api.getStreamContentAsync(category.getId(), count, null, null, null, continuation, callback);
    }

    /**
     * Gets the latest articles of the specified subscription.
     *
     * @param subscription Subscription object containing the feed ID.
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the stream.
     * @see Stream
     */
    public void getLatestArticlesOfSubscription(Subscription subscription, Integer count, Callback<Stream> callback) {
        getLatestArticlesOfSubscription(subscription, count, null, callback);
    }

    /**
     * Works like {@link #getLatestArticlesOfSubscription(Subscription, Integer)} but considers a continuation
     * String when fetching articles.
     *
     * @param subscription Subscription object containing the feed ID.
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the stream.
     * @see Stream
     */
    public void getLatestArticlesOfSubscription(Subscription subscription, Integer count, String continuation, Callback<Stream> callback) {
        api.getStreamContentAsync(subscription.getFeedId(), count, null, null, null, continuation, callback);
    }

    /**
     * Gets the latest articles of the specified feed.
     *
     * @param feed  Feed object containing the feed ID.
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the stream.
     * @see Stream
     */
    public void getLatestArticlesOfFeed(Feed feed, Integer count, Callback<Stream> callback) {
        getLatestArticlesOfFeed(feed, count, null, callback);
    }

    /**
     * Works like {@link #getLatestArticlesOfFeed(Feed, Integer)} but considers a continuation String when fetching
     * articles.
     *
     * @param feed         Feed object containing the feed ID.
     * @param count        Number of articles. Default is 20 (when null), max is 10,000.
     * @param continuation Continuation String of the last call. This ID guarantees that no entry will be duplicated
     *                     in a stream.
     * @return Stream object containing article entries and other information about the stream.
     * @see Stream
     */
    public void getLatestArticlesOfFeed(Feed feed, Integer count, String continuation, Callback<Stream> callback) {
        api.getStreamContentAsync(feed.getFeedId(), count, null, null, null, continuation, callback);
    }
    //endregion
    //endregion

    //region Subscription module

    /**
     * Gets a list of all user subscriptions. (Authorization is <b>required</b>)     *
     *
     * @return Empty list if there are no active user subscriptions.
     * @see Subscription
     */
    public void getSubscriptions(Callback<List<Subscription>> callback) {
        api.getSubscriptionsAsync(callback);
    }
    //endregion
}
