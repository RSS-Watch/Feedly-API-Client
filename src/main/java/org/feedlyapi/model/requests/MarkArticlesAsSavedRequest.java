package org.feedlyapi.model.requests;

import java.util.List;

public class MarkArticlesAsSavedRequest extends ActionRequest {

    private List<String> entryIds;

    public MarkArticlesAsSavedRequest(List<String> entryIds) {
        super("markAsSaved", "entries");
        this.entryIds = entryIds;
    }
}
