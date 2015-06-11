package org.feedlyapi.model.requests;

public class RefreshTokenRequest {
    private String refresh_token;
    private String client_id;
    private String client_secret;
    private String grant_type;

    public RefreshTokenRequest(String refreshToken, String clientId, String clientSecret) {
        this.refresh_token = refreshToken;
        this.client_id = clientId;
        this.client_secret = clientSecret;

        this.grant_type = "refresh_token";
    }
}
