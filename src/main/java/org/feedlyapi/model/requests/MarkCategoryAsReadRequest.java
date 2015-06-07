package org.feedlyapi.model.requests;

import java.util.Calendar;
import java.util.List;

public class MarkCategoryAsReadRequest extends ActionRequest {

    private String lastReadEntryId;
    private Calendar asOf;
    private List<String> categoryIds;

    public MarkCategoryAsReadRequest(String lastReadEntryId, List<String> categoryIds) {
        super("markAsRead", "categories");
        this.lastReadEntryId = lastReadEntryId;
        this.categoryIds = categoryIds;
    }

    public MarkCategoryAsReadRequest(Calendar asOf, List<String> categoryIds) {
        super("markAsRead", "categories");
        this.asOf = asOf;
        this.categoryIds = categoryIds;
    }
}
