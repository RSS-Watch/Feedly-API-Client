package org.feedlyapi.retrofit;

import com.google.gson.*;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import java.lang.reflect.Type;
import java.util.Calendar;

public class FeedlyApiProvider {

    private static FeedlyInterface api;
    private static String accessToken = "";

    private static FeedlyInterface create() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://sandbox.feedly.com/v3")
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("Authorization", "OAuth " + accessToken);
                    }
                })
//                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(createConverter())
                .build();
        return adapter.create(FeedlyInterface.class);
    }

    private static GsonConverter createConverter() {
        final GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Calendar.class, new JsonDeserializer<Calendar>() {

            @Override
            public Calendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                final Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(json.getAsNumber().longValue());
                return calendar;
            }
        });
        return new GsonConverter(builder.create());
    }

    public static FeedlyInterface getApi() {
        if (api == null) {
            api = create();
        }
        return api;
    }

    public static void setAccessToken(String _accessToken) {
        accessToken = _accessToken;
    }
}
