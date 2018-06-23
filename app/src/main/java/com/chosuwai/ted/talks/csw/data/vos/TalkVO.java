package com.chosuwai.ted.talks.csw.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TalkVO {

    @SerializedName("talk_id")
    private String talkId;

    @SerializedName("title")
    private String talkTitle;

    @SerializedName("speaker")
    private SpeakerVO speaker;

    @SerializedName("imageUrl")
    private String talkImage;

    @SerializedName("durationInSec")
    private String talkDuration;

    @SerializedName("description")
    private String talkDescription;

    @SerializedName("tag")
    private List<String> tag;

    public String getTalkId() {
        return talkId;
    }

    public String getTalkTitle() {
        return talkTitle;
    }

    public SpeakerVO getSpeaker() {
        return speaker;
    }

    public String getTalkImage() {
        return talkImage;
    }

    public String getTalkDuration() {
        return talkDuration;
    }

    public String getTalkDescription() {
        return talkDescription;
    }

    public List<String> getTag() {
        return tag;
    }
}
