package com.bytedance.androidcamp.network.dou.api;

import com.google.gson.annotations.SerializedName;

public class PostVideoResponse {
    @SerializedName("url")public String url;
    @SerializedName("success")public boolean success;
}
