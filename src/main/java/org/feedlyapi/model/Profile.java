package org.feedlyapi.model;

import java.net.URL;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Dennis on 13.05.2015.
 */
public class Profile {

    private String id;
    private String email;
    private String givenName;
    private String familyName;
    private String fullName;
    private URL picture;
    private String gender;
    private Locale locale;
    private String google;
    private String reader;
    private String twitter;
    private String twitterUserId;
    private String facebookUserId;
    private String wordPressId;
    private String windowsLiveId;
    private String wave;
    private String client;
    private String source;
    private Calendar created;

    // Pro Accounts only
    private String product;
    private Calendar productExpiration;
    private String subscriptionStatus;
    private boolean isEvernoteConnected;
    private boolean isPocketConnected;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFullName() {
        return fullName;
    }

    public URL getPicture() {
        return picture;
    }

    public String getGender() {
        return gender;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getGoogle() {
        return google;
    }

    public String getReader() {
        return reader;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getTwitterUserId() {
        return twitterUserId;
    }

    public String getFacebookUserId() {
        return facebookUserId;
    }

    public String getWordPressId() {
        return wordPressId;
    }

    public String getWindowsLiveId() {
        return windowsLiveId;
    }

    public String getWave() {
        return wave;
    }

    public String getClient() {
        return client;
    }

    public String getSource() {
        return source;
    }

    public Calendar getCreated() {
        return created;
    }

    public String getProduct() {
        return product;
    }

    public Calendar getProductExpiration() {
        return productExpiration;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public boolean isEvernoteConnected() {
        return isEvernoteConnected;
    }

    public boolean isPocketConnected() {
        return isPocketConnected;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
