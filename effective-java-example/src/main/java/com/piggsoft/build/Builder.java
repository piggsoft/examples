package com.piggsoft.build;

/**
 * Created by piggs on 2016/11/19.
 */
public class Builder {
    private String username;
    private String password;
    private boolean isCheck;
    private boolean url;

    public Builder addUsername(String username) {
        this.username = username;
        return this;
    }

    public Settings build() {
        Settings settings = new Settings();
        return settings;
    }
}
