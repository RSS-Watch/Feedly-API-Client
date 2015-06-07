package org.feedlyapi.model.requests;

import java.util.List;

public class MarkArticlesAsUnsavedRequest extends ActionRequest {

    private List<String> entryIds;

    public MarkArticlesAsUnsavedRequest(List<String> entryIds) {
        super("markAsUnsaved", "entries");
        this.entryIds = entryIds;
    }
}
