package org.feedlyapi.retrofit;

import org.feedlyapi.model.*;
import retrofit.client.Response;
import retrofit.http.*;

import java.util.List;

public interface FeedlyInterface {

    //region Category module

    /**
     * Gets a list of all user categories. The global categories all and uncategorized will not be returned
     * by this method. Global.must will only be returned if at least one feed is in this category.
     *
     * (Authorization is <b>required</b>)
     *
     * @return Empty list when user has no categories.
     * @see Category
     */
    @GET("/categories")
    List<Category> getCategories();

    /**
     * Updates the label of a given category.
     * Note: System categories cannot be re-labeled.
     *
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
     * Deletes a category.
     * Feeds with no category left will be moved to the "global.uncategorized" category automatically.
     * System categories cannot be deleted.
     *
     * (Authorization is <b>required</b>)
     *
     * @param categoryId ID of the category
     * @return HTTP 200 OK
     * @throws retrofit.RetrofitError: 400 Bad Request when trying to delete system categories.
     */
    @DELETE("/categories/{categoryId}")
    Response deleteCategory(@Path("categoryId") String categoryId);
    //endregion

    //region Feeds module
    @GET("/feeds/{feedId}")
    Feed getFeedMetadata(@Path("feedId") String feedId);

    @POST("/feeds/.mget")
    List<Feed> getFeedsMetadata(@Body List<String> feedIds);
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
    //endregion

    //region Subscriptions module
    /* Users can subscribe to feeds and organize their subscriptions into categories. The best practice is to first
    call the feeds module to determine if the feed contains RSS data. The feeds module will also return the feed title
    (which is customizable by the user), and the website.
     */

    /**
     * Gets a list of all user subscriptions.
     *
     * (Authorization is <b>required</b>)
     *
     * @return Empty list if there are no active user subscriptions.
     * @see Subscription
     */
    @GET("/subscriptions")
    List<Subscription> getSubscriptions();

    /**
     * Creates an active subscription to a feed for the user.
     * Only the <b>feedId</b> field is mandatory. If <b>title</b> is not present, the feed title will be used.
     * If <b>categories</b> is missing, the feed will automatically be added to the global uncategorized category
     * (ID: "global.uncategorized"). Global categories are automatically assigned.
     *
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
     * Updates an existing subscription.
     * This call will overwrite the subscription, not merge the content. If <b>title</b> is omitted, it will be
     * replaced with the feed title.
     *
     * (Authorization is <b>required</b>)
     *
     * @param subscription Subscription object containing the feed ID and the updated title.
     * @return HTTP/200 - OK
     * @see Subscription
     */
    @POST("/subscriptions")
    Response updateSubscription(@Body Subscription subscription);

    /**
     * Deletes an existing subscription.
     *
     * (Authorization is <b>required</b>)
     *
     * @param feedId ID of the subscription
     * @return HTTP/200 - OK
     */
    @DELETE("/subscriptions/{feedId}")
    Response deleteSubscription(@Path("feedId") String feedId);
    //endregion
}
