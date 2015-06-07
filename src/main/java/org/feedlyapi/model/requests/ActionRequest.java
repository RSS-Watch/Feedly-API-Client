package org.feedlyapi.model.requests;

public abstract class ActionRequest {
    private String action;
    private String type;

    public ActionRequest(String action, String type) {
        this.action = action;
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public String getType() {
        return type;
    }
}
