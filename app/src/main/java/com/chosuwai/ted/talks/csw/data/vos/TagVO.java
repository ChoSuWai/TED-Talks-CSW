package com.chosuwai.ted.talks.csw.data.vos;

import com.google.gson.annotations.SerializedName;

public class TagVO {

    @SerializedName("tag_id")
    private String tagId;

    @SerializedName("tag")
    private String tag;

    @SerializedName("description")
    private String tagDescription;

    public String getTagId() {
        return tagId;
    }

    public String getTag() {
        return tag;
    }

    public String getTagDescription() {
        return tagDescription;
    }
}
