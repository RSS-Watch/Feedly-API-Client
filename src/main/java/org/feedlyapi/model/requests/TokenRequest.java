package org.feedlyapi.model.requests;

public class TokenRequest {
    private String code;
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String state;
    private String grant_type;

    public TokenRequest(String code, String clientId, String clientSecret, String redirectUri) {
        this.code = code;
        this.client_id = clientId;
        this.client_secret = clientSecret;
        this.redirect_uri = redirectUri;

        this.state = "";
        this.grant_type = "authorization_code";
    }

    public TokenRequest(String code, String clientId, String clientSecret, String redirectUri, String state) {
        this.code = code;
        this.client_id = clientId;
        this.client_secret = clientSecret;
        this.redirect_uri = redirectUri;
        this.state = state;

        this.grant_type = "authorization_code";
    }
}
