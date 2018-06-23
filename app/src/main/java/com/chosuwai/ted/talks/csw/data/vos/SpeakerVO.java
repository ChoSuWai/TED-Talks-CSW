package com.chosuwai.ted.talks.csw.data.vos;

import com.google.gson.annotations.SerializedName;

public class SpeakerVO {

    @SerializedName("speaker_id")
    private String speakerId;

    @SerializedName("name")
    private String speakerName;

    public String getSpeakerId() {
        return speakerId;
    }

    public String getSpeakerName() {
        return speakerName;
    }
}
