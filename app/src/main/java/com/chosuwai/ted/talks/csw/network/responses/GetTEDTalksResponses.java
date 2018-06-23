package com.chosuwai.ted.talks.csw.network.responses;

import com.chosuwai.ted.talks.csw.data.vos.TalkVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTEDTalksResponses {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("ted_talks")
    private List<TalkVO> tedTalks;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TalkVO> getTedTalks() {
        return tedTalks;
    }

    public boolean isResponseOk(){
        return (code == 200 && tedTalks!=null);
    }
}
