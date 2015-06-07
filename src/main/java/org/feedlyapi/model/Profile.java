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

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public URL getPicture() {
        return picture;
    }

    public void setPicture(URL picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTwitterUserId() {
        return twitterUserId;
    }

    public void setTwitterUserId(String twitterUserId) {
        this.twitterUserId = twitterUserId;
    }

    public String getFacebookUserId() {
        return facebookUserId;
    }

    public void setFacebookUserId(String facebookUserId) {
        this.facebookUserId = facebookUserId;
    }

    public String getWordPressId() {
        return wordPressId;
    }

    public void setWordPressId(String wordPressId) {
        this.wordPressId = wordPressId;
    }

    public String getWindowsLiveId() {
        return windowsLiveId;
    }

    public void setWindowsLiveId(String windowsLiveId) {
        this.windowsLiveId = windowsLiveId;
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Calendar getProductExpiration() {
        return productExpiration;
    }

    public void setProductExpiration(Calendar productExpiration) {
        this.productExpiration = productExpiration;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public boolean isEvernoteConnected() {
        return isEvernoteConnected;
    }

    public boolean isPocketConnected() {
        return isPocketConnected;
    }

    public void setIsEvernoteConnected(boolean isEvernoteConnected) {
        this.isEvernoteConnected = isEvernoteConnected;
    }

    public void setIsPocketConnected(boolean isPocketConnected) {
        this.isPocketConnected = isPocketConnected;
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
