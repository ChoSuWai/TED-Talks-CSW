package com.chosuwai.ted.talks.csw.data.vos;

import java.util.List;

public class TalkVO {

    private String talkId;
    private String talkTitle;
    private SpeakerVO speaker;
    private String talkImage;
    private String talkDuration;
    private String talkDescription;
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
