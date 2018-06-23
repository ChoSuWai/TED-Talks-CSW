package com.chosuwai.ted.talks.csw.data.vos;

import com.google.gson.annotations.SerializedName;

public class SearchResultVO {

    @SerializedName("search_result_id")
    private String searchResultId;

     @SerializedName("title")
    private String searchTitle;

     @SerializedName("description")
    private String searchDescription;

     @SerializedName("imageUrl")
    private String searchImage;

     @SerializedName("result_type")
    private String resultType;

    @SerializedName("result_id")
    private String resultId;

    public String getSearchResultId() {
        return searchResultId;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public String getSearchDescription() {
        return searchDescription;
    }

    public String getSearchImage() {
        return searchImage;
    }

    public String getResultType() {
        return resultType;
    }

    public String getResultId() {
        return resultId;
    }
}
