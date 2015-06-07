package org.feedlyapi.model.requests;

import java.util.List;

public class MarkArticlesAsUnreadRequest extends ActionRequest {

    private List<String> entryIds;

    public MarkArticlesAsUnreadRequest(List<String> entryIds) {
        super("keepUnread", "entries");
        this.entryIds = entryIds;
    }
}
