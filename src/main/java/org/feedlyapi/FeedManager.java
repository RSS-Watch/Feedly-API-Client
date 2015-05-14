package org.feedlyapi;

import org.feedlyapi.model.Category;
import org.feedlyapi.model.Stream;
import org.feedlyapi.retrofit.FeedlyInterface;

@SuppressWarnings("WeakerAccess")
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

    /**
     * Gets the latest articles of the global.all category.
     *
     * @param count Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestArticles(Integer count) {
        return this.getLatestArticles(count, null);
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
    public Stream getLatestArticles(Integer count, String continuation) {
        String globalAllCategoryId = "user/" + api.getProfile().getId() + "/category/global.all";

        return api.getStreamContent(globalAllCategoryId, count, null, null, null, continuation);
    }

    /**
     * Gets the latest articles of the specified category.
     *
     * @param category Category object containing information about the specified category.
     * @param count    Number of articles. Default is 20 (when null), max is 10,000.
     * @return Stream object containing article entries and other information about the Stream.
     * @see Stream
     */
    public Stream getLatestArticlesOfCategory(Category category, Integer count) {
        return getLatestArticlesOfCategory(category, count, null);
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
    public Stream getLatestArticlesOfCategory(Category category, Integer count, String continuation) {
        return api.getStreamContent(category.getId(), count, null, null, null, continuation);
    }
}
