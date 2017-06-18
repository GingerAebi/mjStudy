package io.github.gingeraebi.study2;

import com.google.gson.JsonObject;

/**
 * Created by gingeraebi on 2017. 6. 18..
 */

public class APIResponse {
    public String rspCode;
    public String rspMsg;
    public JsonObject data;

    @Override
    public String toString() {
        return "APIResponse{" +
                "rspCode='" + rspCode + '\'' +
                ", rspMsg='" + rspMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getRspCode() {
        return rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }
}
