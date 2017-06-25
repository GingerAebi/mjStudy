package io.github.gingeraebi.study2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gingeraebi on 2017. 6. 18..
 */

public class User {
    @SerializedName("userId")
    public String id;
    public String password;


    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
