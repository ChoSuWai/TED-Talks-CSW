package com.chosuwai.ted.talks.csw.network;

import com.chosuwai.ted.talks.csw.network.responses.GetTEDTalksResponses;
import com.chosuwai.ted.talks.csw.utils.TEDConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TalkApi {

    @FormUrlEncoded
    @POST(TEDConstants.GET_TED_TALKS)
    Call<GetTEDTalksResponses> loadTalkList(
            @Field(TEDConstants.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(TEDConstants.PARAM_PAGE) int page);

}
