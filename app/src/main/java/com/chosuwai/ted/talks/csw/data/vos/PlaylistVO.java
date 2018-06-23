package com.chosuwai.ted.talks.csw.data.vos;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PlaylistVO {

    @SerializedName("playlist_id")
    private String playlistId;

    @SerializedName("title")
    private String playlistTitle;

    @SerializedName("imageUrl")
    private String playlistImage;

    @SerializedName("totalTalks")
    private String totalTalks;

    @SerializedName("description")
    private String playlistDescription;

    @SerializedName("talksInPlaylist")
    private List<TalkVO> talksInPlaylist;

    public String getPlaylistId() {
        return playlistId;
    }

    public String getTitle() {
        return playlistTitle;
    }

    public String getImageUrl() {
        return playlistImage;
    }

    public String getTotalTalks() {
        return totalTalks;
    }

    public String getDescription() {
        return playlistDescription;
    }

    public List<TalkVO> getTalksInPlaylist() {
        return talksInPlaylist;
    }
}
