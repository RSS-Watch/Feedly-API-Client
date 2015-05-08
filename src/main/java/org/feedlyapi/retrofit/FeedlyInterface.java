package org.feedlyapi.retrofit;

import org.feedlyapi.model.Stream;
import org.feedlyapi.model.Subscription;
import retrofit.client.Response;
import retrofit.http.*;

import java.util.List;

public interface FeedlyInterface {

    //region Subscriptions module
    @GET("/subscriptions")
    List<Subscription> getSubscriptions();

    @POST("/subscriptions")
    Response addSubscription(@Body Subscription subscription);

    @POST("/subscriptions")
    Response updateSubscription(@Body Subscription subscription);

    @DELETE("/subscriptions/{feedId}")
    Response deleteSubscription(@Path("feedId") String feedId);
    //endregion

    //region Stream module
    @GET("/streams/{id}/ids")
    Stream getStreamEntries(@Path("id") String id, @Query("count") Integer count, @Query("ranked") String ranked,
                            @Query("unreadOnly") Boolean unreadOnly, @Query("newerThan") Long newerThan,
                            @Query("continuation") String continuation);

    @GET("/streams/{id}/contents")
    Stream getStreamContent(@Path("id") String id, @Query("count") Integer count, @Query("ranked") String ranked,
                            @Query("unreadOnly") Boolean unreadOnly, @Query("newerThan") Long newerThan,
                            @Query("continuation") String continuation);
    //endregion
}
