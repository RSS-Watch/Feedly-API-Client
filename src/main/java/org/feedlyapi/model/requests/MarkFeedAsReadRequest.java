package org.feedlyapi.model.requests;

import java.util.Calendar;
import java.util.List;

public class MarkFeedAsReadRequest extends ActionRequest {

    private String lastReadEntryId;
    private Calendar asOf;
    private List<String> feedIds;

    public MarkFeedAsReadRequest(String lastReadEntryId, List<String> feedIds) {
        super("markAsRead", "feeds");
        this.lastReadEntryId = lastReadEntryId;
        this.feedIds = feedIds;
    }

    public MarkFeedAsReadRequest(Calendar asOf, List<String> feedIds) {
        super("markAsRead", "feeds");
        this.asOf = asOf;
        this.feedIds = feedIds;
    }
}
