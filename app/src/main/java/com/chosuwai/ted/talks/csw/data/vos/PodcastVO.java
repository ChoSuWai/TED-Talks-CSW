package com.chosuwai.ted.talks.csw.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PodcastVO {

    @SerializedName("podcast_id")
    private String podcastId;

    @SerializedName("title")
    private String podcastTitle;

    @SerializedName("imageUrl")
    private String podcastImage;

    @SerializedName("description")
    private String podcastDescription;

     @SerializedName("segments")
    private List<SegmentVO> podcastSegments;

    public String getPodcastId() {
        return podcastId;
    }

    public String getPodcastTitle() {
        return podcastTitle;
    }

    public String getPodcastImage() {
        return podcastImage;
    }

    public String getPodcastDescription() {
        return podcastDescription;
    }

    public List<SegmentVO> getPodcastSegments() {
        return podcastSegments;
    }
}
