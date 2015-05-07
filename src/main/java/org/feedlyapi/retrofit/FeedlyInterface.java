package org.feedlyapi.retrofit;

import org.feedlyapi.model.Stream;
import org.feedlyapi.model.Subscription;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

public interface FeedlyInterface {

    @GET("/subscriptions")
    List<Subscription> getSubscriptions();

    @GET("/streams/{id}/contents?count=3")
    Stream getStream(@Path("id") String id);
}
