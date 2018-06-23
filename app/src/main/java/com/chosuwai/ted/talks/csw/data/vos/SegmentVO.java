package com.chosuwai.ted.talks.csw.data.vos;

import com.google.gson.annotations.SerializedName;

public class SegmentVO {

     @SerializedName("segment_id")
    private String segmentId;

     @SerializedName("title")
    private String segmentTitle;

      @SerializedName("imageUrl")
    private String segmentImage;

    public String getSegmentId() {
        return segmentId;
    }

    public String getSegmentTitle() {
        return segmentTitle;
    }

    public String getSegmentImage() {
        return segmentImage;
    }
}
