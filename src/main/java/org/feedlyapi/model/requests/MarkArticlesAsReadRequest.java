package org.feedlyapi.model.requests;

import java.util.List;

public class MarkArticlesAsReadRequest extends ActionRequest {

    private List<String> entryIds;

    public MarkArticlesAsReadRequest(List<String> entryIds) {
        super("markAsRead", "entries");
        this.entryIds = entryIds;
    }
}
