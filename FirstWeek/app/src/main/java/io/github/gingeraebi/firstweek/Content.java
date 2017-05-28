package io.github.gingeraebi.firstweek;

import io.realm.RealmObject;

/**
 * Created by gingeraebi on 2017. 5. 21..
 */

public class Content {
    public String timeAgo;
    public String alarmConent;
    public String time;
    public String contentImgUrl;

    public Content(String timeAgo, String alarmConent, String time) {
        this.timeAgo = timeAgo;
        this.alarmConent = alarmConent;
        this.time = time;
    }

    public Content setConentImgUrl(String contentImgUrl) {
        this.contentImgUrl = contentImgUrl;
        return this;
    }
}
