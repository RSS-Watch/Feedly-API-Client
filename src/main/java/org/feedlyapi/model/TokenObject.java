package org.feedlyapi.model;

import com.google.gson.annotations.SerializedName;

public class TokenObject {
    @SerializedName("id")
    private String userId;
    private String access_token;
    private String refresh_token;
    private long expires_in;
    private String token_type;
    private String plan;
    private String state;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccessToken(String access_token) {
        this.access_token = access_token;
    }

    public String getRefreshToken() {
        return refresh_token;
    }

    public void setRefreshToken(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public long getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getTokenType() {
        return token_type;
    }

    public void setTokenType(String token_type) {
        this.token_type = token_type;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
