package org.feedlyapi.model.requests;

import java.awt.*;
import java.util.Calendar;
import java.util.List;

public class UndoMarkFeedAsReadRequest extends ActionRequest {

    private List<String> feedIds;

    public UndoMarkFeedAsReadRequest(String lastReadEntryId, List<String> feedIds) {
        super("undoMarkAsRead", "feeds");
        this.feedIds = feedIds;
    }
}
