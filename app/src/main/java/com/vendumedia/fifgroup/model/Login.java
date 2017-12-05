package com.vendumedia.fifgroup.model;

/**
 * Created by aldimaulana on 12/6/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Login {

    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("status")
    @Expose
    private Long status;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("shortUsername")
    @Expose
    private String shortUsername;
    @SerializedName("accessType")
    @Expose
    private String accessType;
    @SerializedName("currentTime")
    @Expose
    private Long currentTime;
    @SerializedName("timeToLive")
    @Expose
    private Long timeToLive;
    @SerializedName("validUntil")
    @Expose
    private Long validUntil;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Login withTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Login withStatus(Long status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Login withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Login withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Login withPath(String path) {
        this.path = path;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Login withToken(String token) {
        this.token = token;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Login withRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Login withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getShortUsername() {
        return shortUsername;
    }

    public void setShortUsername(String shortUsername) {
        this.shortUsername = shortUsername;
    }

    public Login withShortUsername(String shortUsername) {
        this.shortUsername = shortUsername;
        return this;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public Login withAccessType(String accessType) {
        this.accessType = accessType;
        return this;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public Login withCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    public Long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Login withTimeToLive(Long timeToLive) {
        this.timeToLive = timeToLive;
        return this;
    }

    public Long getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Long validUntil) {
        this.validUntil = validUntil;
    }

    public Login withValidUntil(Long validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("timestamp", timestamp).append("status", status).append("error", error).append("message", message).append("path", path).append("token", token).append("refreshToken", refreshToken).append("username", username).append("shortUsername", shortUsername).append("accessType", accessType).append("currentTime", currentTime).append("timeToLive", timeToLive).append("validUntil", validUntil).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(error).append(status).append(validUntil).append(refreshToken).append(timeToLive).append(currentTime).append(message).append(timestamp).append(username).append(token).append(path).append(shortUsername).append(accessType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Login) == false) {
            return false;
        }
        Login rhs = ((Login) other);
        return new EqualsBuilder().append(error, rhs.error).append(status, rhs.status).append(validUntil, rhs.validUntil).append(refreshToken, rhs.refreshToken).append(timeToLive, rhs.timeToLive).append(currentTime, rhs.currentTime).append(message, rhs.message).append(timestamp, rhs.timestamp).append(username, rhs.username).append(token, rhs.token).append(path, rhs.path).append(shortUsername, rhs.shortUsername).append(accessType, rhs.accessType).isEquals();
    }

}
