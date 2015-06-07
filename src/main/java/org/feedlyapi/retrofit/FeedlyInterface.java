package org.feedlyapi.retrofit;

import org.feedlyapi.model.*;
import org.feedlyapi.model.requests.*;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.*;

import java.util.List;

public interface FeedlyInterface {

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
    @GET("/categories")
    List<Category> getCategories();

    /**
     * @see #getCategories()
     */
    @GET("/categories")
    void getCategoriesAsync(Callback<List<Category>> callback);

    /**
     * Updates the label of a given category.
     * Note: System categories cannot be re-labeled.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param categoryId ID of the category
     * @return HTTP 200 OK
     * @throws retrofit.RetrofitError: 400 Bad Request when passing a non-existent category ID.
     * @see Category
     */
    @POST("/categories/{categoryId}")
    Response updateCategoryLabel(@Path("categoryId") String categoryId, @Body Category category);

    /**
     * @see #updateCategoryLabel(String, Category)
     */
    @POST("/categories/{categoryId}")
    void updateCategoryLabelAsync(@Path("categoryId") String categoryId, @Body Category category, Callback<Response> callback);

    /**
     * Deletes a category.
     * Feeds with no category left will be moved to the "global.uncategorized" category automatically.
     * System categories cannot be deleted.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param categoryId ID of the category
     * @return HTTP 200 OK
     * @throws retrofit.RetrofitError: 400 Bad Request when trying to delete system categories.
     */
    @DELETE("/categories/{categoryId}")
    Response deleteCategory(@Path("categoryId") String categoryId);

    /**
     * @see #deleteCategory(String)
     */
    @DELETE("/categories/{categoryId}")
    void deleteCategoryAsync(@Path("categoryId") String categoryId, Callback<Response> callback);
    //endregion

    //region Feeds module
    @GET("/feeds/{feedId}")
    Feed getFeedMetadata(@Path("feedId") String feedId);

    /**
     * @see #getFeedMetadata(String)
     */
    @GET("/feeds/{feedId}")
    void getFeedMetadataAsync(@Path("feedId") String feedId, Callback<Feed> callback);

    @POST("/feeds/.mget")
    List<Feed> getFeedsMetadata(@Body List<String> feedIds);

    /**
     * @see #getFeedsMetadata(List)
     */
    @POST("/feeds/.mget")
    void getFeedsMetadataAsync(@Body List<String> feedIds, Callback<List<Feed>> callback);
    //endregion

    //region Marker module

    /**
     * Gets the unread counts for every feed and category in the account (unless a streamId is passed).
     * Unread counts are capped at 1,000 for each individual feed (the server will stop counting once it reaches this
     * number). The total unread count will appear in the global.all category.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param autorefresh Let's the server know if this is a background auto-refresh or not. In case of very high load
     *                    on the service, the server can deny access to background requests and give priority
     *                    to user facing operations.
     * @param newerThan   Timestamp used as a lower time limit, instead of the default 30 days.
     * @param streamId    A user or system category can be passed to restrict the unread count response to feeds in this
     *                    category.
     * @return UnreadCount object containing the id, updated timestamp and actual count number.
     * @see UnreadCount
     */
    @GET("/markers/counts")
    List<UnreadCount> getUnreadCounts(@Query("autorefresh") Boolean autorefresh, @Query("newerThan")Long newerThan, @Query("streamId") String streamId);

    /**
     * @see #getUnreadCounts(Boolean, Long, String)
     */
    @GET("/markers/counts")
    void getUnreadCountsAsync(@Query("autorefresh") Boolean autorefresh, @Query("newerThan") Long newerThan, @Query("streamId") String streamId, Callback<List<UnreadCount>> callback);

    /**
     * Marks one or more articles as read.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param request Request object containing the entry IDs (article IDs).
     * @return HTTP/200 - OK
     * @see MarkArticlesAsReadRequest
     */
    @POST("/markers")
    Response markArticlesAsRead(@Body MarkArticlesAsReadRequest request);

    /**
     * @see #markArticlesAsRead(MarkArticlesAsReadRequest)
     */
    @POST("/markers")
    void markArticlesAsReadAsync(@Body MarkArticlesAsReadRequest request, Callback<Response> callback);

    /**
     * Marks one or more articles as unread and keeps them unread until the user explicitly marks them as read.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param request Request object containing the entry IDs (article IDs).
     * @return HTTP/200 - OK
     * @see MarkArticlesAsUnreadRequest
     */
    @POST("/markers")
    Response markArticlesAsUnread(@Body MarkArticlesAsUnreadRequest request);

    /**
     * @see #markArticlesAsUnread(MarkArticlesAsUnreadRequest)
     */
    @POST("/markers")
    void markArticlesAsUnreadAsync(@Body MarkArticlesAsUnreadRequest request, Callback<Response> callback);

    /**
     * Marks one or more feeds as read.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param request Request object containing the feed IDs.
     * @return HTTP/200 - OK
     * @see MarkFeedAsReadRequest
     */
    @POST("/markers")
    Response markFeedAsRead(@Body MarkFeedAsReadRequest request);

    /**
     * @see #markFeedAsRead(MarkFeedAsReadRequest)
     */
    @POST("/markers")
    void markFeedAsReadAsync(@Body MarkFeedAsReadRequest request, Callback<Response> callback);

    /**
     * Marks one or more categories as read.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param request Request object containing the category IDs.
     * @return HTTP/200 - OK
     * @see MarkCategoryAsReadRequest
     */
    @POST("/markers")
    Response markCategoryAsRead(@Body MarkCategoryAsReadRequest request);

    /**
     * @see #markCategoryAsRead(MarkCategoryAsReadRequest)
     */
    @POST("/markers")
    void markCategoryAsReadAsync(@Body MarkCategoryAsReadRequest request, Callback<Response> callback);

    /**
     * @see #undoMarkFeedAsRead(UndoMarkFeedAsReadRequest)
     * @param request Request object containing the category IDs.
     * @return HTTP/200 - OK
     */
    @POST("/markers")
    Response undoMarkCategoryAsRead(@Body UndoMarkCategoryAsReadRequest request);

    /**
     * @see #undoMarkFeedAsRead(UndoMarkFeedAsReadRequest)
     * @param request Request object containing the category IDs.
     */
    @POST("/markers")
    void undoMarkCategoryAsReadAsync(@Body UndoMarkCategoryAsReadRequest request, Callback<Response> callback);

    /**
     * This is a one-time undo operation. It will revert to the previous mark-as-read marker, if there is one, for the specified feeds.
     *
     * Example sequence:
     *
     * <pre>
     - Add a feed
     - Mark feed as read to entry #1
     - Undo mark as read for feed: no change (because there is no history)
     - Mark feed as read to entry #2
     - Mark all as read to entry #3
     - Undo mark as read for feed: reverts marker to entry #2
     - Undo mark as read for feed again: no change (because there is no previous record)
     </pre>
     * @param request Request object containing the feed IDs.
     * @return HTTP/200 - OK
     * @see UndoMarkFeedAsReadRequest
     */
    @POST("/markers")
    Response undoMarkFeedAsRead(@Body UndoMarkFeedAsReadRequest request);

    /**
     * @see #undoMarkFeedAsRead(UndoMarkFeedAsReadRequest)
     */
    @POST("/markers")
    void undoMarkFeedAsReadAsync(@Body UndoMarkFeedAsReadRequest request);

    /**
     * Marks one or more articles as saved for later. This is an alternative to POST /v3/tags.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param request Request object containing the article IDs (entry IDs).
     * @return HTTP/200 - OK
     * @see MarkArticlesAsSavedRequest
     */
    @POST("/markers")
    Response markArticleAsSaved(@Body MarkArticlesAsSavedRequest request);

    /**
     * @see #markArticleAsSaved(MarkArticlesAsSavedRequest)
     */
    @POST("/markers")
    void markArticlesAsSavedAsync(@Body MarkArticlesAsSavedRequest request, Callback<Response> callback);

    /**
     * Marks one or more articles as unsaved.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param request Request object containing the article IDs (entry IDs).
     * @return HTTP/200 - OK
     * @see MarkArticlesAsUnreadRequest
     */
    @POST("/markers")
    Response markArticlesAsUnsaved(@Body MarkArticlesAsUnsavedRequest request);

    /**
     * @see #markArticlesAsUnsaved(MarkArticlesAsUnsavedRequest)
     */
    @POST("/markers")
    void markArticlesAsUnsavedAsync(@Body MarkArticlesAsUnsavedRequest request, Callback<Response> callback);

    /**
     * Gets the latest read operations (to sync local cache).
     * @param timestamp Timestamp in ms. Default is 30 days.
     * @return ReadOperations object containing a list of read feeds, read entries and entries marked as unread.
     * @see ReadOperations
     */
    @GET("/markers/reads")
    ReadOperations getLatestReadOperations(@Query("timestamp") Long timestamp);

    /**
     * @see #getLatestReadOperations(Long)
     */
    @GET("/markers/reads")
    void getLatestReadOperationsAsync(@Query("timestamp") Long timestamp, Callback<ReadOperations> callback);

    //endregion

    //region Profile module
    /* Once a user is authenticated, a profile is attached to her. Feedly captures basic information such as name,
    email, locale, etc. Applications can access that profile information and update parts of it.
     */

    /**
     * Gets the profile of the authenticated user.
     *
     * @return Profile object containing user information.
     * @see Profile
     */
    @GET("/profile")
    Profile getProfile();

    /**
     * @see #getProfile()
     */
    @GET("/profile")
    void getProfileAsync(Callback<Profile> callback);
    //endregion

    //region Stream module

    /**
     * Gets Entry IDs of a stream.
     * <p>
     * (Authorization is <b>optional</b>; it is required for category and tag streams)
     *
     * @param id           A feed ID, category ID, tag ID or a system category ID can be used as stream ID.
     * @param count        Number of entries to return. Default is 20, max is 10,000.
     * @param ranked       Oldest or Newest articles first. Default is newest.
     * @param unreadOnly   Unread articles only. Default is false.
     * @param newerThan    Timestamp in ms.
     * @param continuation A continuation ID used to page through the entry IDs.
     * @return A Stream object containing the continuation string and the entry IDs.
     * @see Stream
     */
    @GET("/streams/{id}/ids")
    Stream getStreamEntries(@Path("id") String id, @Query("count") Integer count, @Query("ranked") String ranked,
                            @Query("unreadOnly") Boolean unreadOnly, @Query("newerThan") Long newerThan,
                            @Query("continuation") String continuation);

    /**
     * @see #getStreamEntries(String, Integer, String, Boolean, Long, String)
     */
    @GET("/streams/{id}/ids")
    void getStreamEntriesAsync(@Path("id") String id, @Query("count") Integer count, @Query("ranked") String ranked,
                               @Query("unreadOnly") Boolean unreadOnly, @Query("newerThan") Long newerThan,
                               @Query("continuation") String continuation, Callback<Stream> callback);

    /**
     * Gets Articles of a stream.
     * <p>
     * (Authorization is <b>optional</b>; it is required for category and tag streams)
     *
     * @param id           A feed ID, category ID, tag ID or a system category ID can be used as stream ID.
     * @param count        Number of entries to return. Default is 20, max is 10,000.
     * @param ranked       Oldest or Newest articles first. Default is newest.
     * @param unreadOnly   Unread articles only. Default is false.
     * @param newerThan    Timestamp in ms.
     * @param continuation A continuation ID used to page through the entry IDs.
     * @return A Stream object containing the stream ID, updated timestamp, continuation string, title, direction,
     * alternate and a list of articles.
     * @see Stream
     */
    @GET("/streams/{id}/contents")
    Stream getStreamContent(@Path("id") String id, @Query("count") Integer count, @Query("ranked") String ranked,
                            @Query("unreadOnly") Boolean unreadOnly, @Query("newerThan") Long newerThan,
                            @Query("continuation") String continuation);

    /**
     * @see #getStreamContent(String, Integer, String, Boolean, Long, String)
     */
    @GET("/streams/{id}/contents")
    void getStreamContentAsync(@Path("id") String id, @Query("count") Integer count, @Query("ranked") String ranked,
                               @Query("unreadOnly") Boolean unreadOnly, @Query("newerThan") Long newerThan,
                               @Query("continuation") String continuation, Callback<Stream> callback);
    //endregion

    //region Subscriptions module
    /* Users can subscribe to feeds and organize their subscriptions into categories. The best practice is to first
    call the feeds module to determine if the feed contains RSS data. The feeds module will also return the feed title
    (which is customizable by the user), and the website.
     */

    /**
     * Gets a list of all user subscriptions.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @return Empty list if there are no active user subscriptions.
     * @see Subscription
     */
    @GET("/subscriptions")
    List<Subscription> getSubscriptions();

    /**
     * @see #addSubscription(Subscription)
     */
    @GET("/subscriptions")
    void getSubscriptionsAsync(Callback<List<Subscription>> callback);

    /**
     * Creates an active subscription to a feed for the user.
     * Only the <b>feedId</b> field is mandatory. If <b>title</b> is not present, the feed title will be used.
     * If <b>categories</b> is missing, the feed will automatically be added to the global uncategorized category
     * (ID: "global.uncategorized"). Global categories are automatically assigned.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param subscription Subscription object containing feedId, title and categories.
     * @return HTTP/200 - OK
     * @throws retrofit.RetrofitError: 400 Bad Request when passing global categories.
     * @see Subscription
     */
    @POST("/subscriptions")
    Response addSubscription(@Body Subscription subscription);

    /**
     * @see #addSubscription(Subscription)
     */
    @POST("/subscriptions")
    void addSubscriptionAsync(@Body Subscription subscription, Callback<Response> callback);

    /**
     * Updates an existing subscription.
     * This call will overwrite the subscription, not merge the content. If <b>title</b> is omitted, it will be
     * replaced with the feed title.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param subscription Subscription object containing the feed ID and the updated title.
     * @return HTTP/200 - OK
     * @see Subscription
     */
    @POST("/subscriptions")
    Response updateSubscription(@Body Subscription subscription);

    /**
     * @see #updateSubscription(Subscription)
     */
    @POST("/subscriptions")
    void updateSubscriptionAsync(@Body Subscription subscription, Callback<Response> callback);

    /**
     * Deletes an existing subscription.
     * <p>
     * (Authorization is <b>required</b>)
     *
     * @param feedId ID of the subscription
     * @return HTTP/200 - OK
     */
    @DELETE("/subscriptions/{feedId}")
    Response deleteSubscription(@Path("feedId") String feedId);

    /**
     * @see #deleteSubscription(String)
     */
    @DELETE("/subscriptions/{feedId}")
    void deleteSubscriptionAsync(@Path("feedId") String feedId, Callback<Response> callback);
    //endregion
}
