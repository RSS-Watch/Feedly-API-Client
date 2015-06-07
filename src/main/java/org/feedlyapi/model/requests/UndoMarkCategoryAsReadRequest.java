package org.feedlyapi.model.requests;

import java.util.Calendar;
import java.util.List;

public class UndoMarkCategoryAsReadRequest extends ActionRequest {

    private List<String> categoryIds;

    public UndoMarkCategoryAsReadRequest(String lastReadEntryId, List<String> categoryIds) {
        super("UndoMarkAsRead", "categories");
        this.categoryIds = categoryIds;
    }
}
