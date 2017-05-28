package io.github.gingeraebi.study2;

import io.realm.RealmObject;

/**
 * Created by gingeraebi on 2017. 5. 28..
 */

public class Contents extends RealmObject {
    private String imageUrl;

    public Contents() {

    }

    public Contents(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
