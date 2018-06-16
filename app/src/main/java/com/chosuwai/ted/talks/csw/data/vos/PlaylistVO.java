package com.chosuwai.ted.talks.csw.data.vos;

import java.util.List;

public class PlaylistVO {

    private String playlistId;
    private String playlistTitle;
    private String playlistImage;
    private String totalTalks;
    private String playlistDescription;
    private List<TalkVO> talksInPlaylist;

    public String getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistTitle() {
        return playlistTitle;
    }

    public String getPlaylistImage() {
        return playlistImage;
    }

    public String getTotalTalks() {
        return totalTalks;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public List<TalkVO> getTalksInPlaylist() {
        return talksInPlaylist;
    }
}
