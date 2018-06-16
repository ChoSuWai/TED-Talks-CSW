package com.chosuwai.ted.talks.csw.data.vos;

import java.util.List;

public class PodcastVO {

    private String podcastId;
    private String podcastTitle;
    private String podcastImage;
    private String podcastDescription;
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
