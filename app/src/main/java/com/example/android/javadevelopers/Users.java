package com.example.android.javadevelopers;

/**
 * Created by Mifere on 6/13/2017.
 */

public class Users {
    public String html_url;
    public String avatar_url;
    public String login;

    public Users(String serverProfilePicUrl, String userName, String dUrl) {
        this.avatar_url = serverProfilePicUrl;
        this.login = userName;
        this.html_url = dUrl;
    }

}
