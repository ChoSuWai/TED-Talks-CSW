package com.chosuwai.ted.talks.csw.network;

import com.chosuwai.ted.talks.csw.events.ApiErrorEvent;
import com.chosuwai.ted.talks.csw.events.SuccessGetTEDTalksEvent;
import com.chosuwai.ted.talks.csw.network.responses.GetTEDTalksResponses;
import com.chosuwai.ted.talks.csw.utils.TEDConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements TEDDataAgent {

    private static RetrofitDataAgentImpl sObjInstance;

    private TalkApi mTheApi;

    private RetrofitDataAgentImpl(){
        final OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(TEDConstants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mTheApi=retrofit.create(TalkApi.class);
    }

    public static RetrofitDataAgentImpl getInstance(){
        if(sObjInstance==null){
            sObjInstance=new RetrofitDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadPlayList(int page, String accessToken) {
        Call<GetTEDTalksResponses> loadNewsCall=mTheApi.loadTalkList(accessToken, page);
        loadNewsCall.enqueue(new Callback<GetTEDTalksResponses>() {
            @Override
            public void onResponse(Call<GetTEDTalksResponses> call, Response<GetTEDTalksResponses> response) {
               GetTEDTalksResponses talksResponses=response.body();


               if (talksResponses != null &&talksResponses.isResponseOk()){
                    SuccessGetTEDTalksEvent event = new SuccessGetTEDTalksEvent(talksResponses.getTedTalks());
                    EventBus.getDefault().post(event);
                }else {
                    if (talksResponses==null){
                        ApiErrorEvent event = new ApiErrorEvent(talksResponses.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }
                /*if(talksResponses !=null && talksResponses.isResponseOk()){
                    SuccessGetTEDTalksEvent event=new SuccessGetTEDTalksEvent(talksResponses.getTedTalks());
                    EventBus.getDefault().post(event);
                }else{
                    if(talksResponses==null){
                        ApiErrorEvent event=new ApiErrorEvent("Empty response in network call.");
                        EventBus.getDefault().post(event);
                    }else{
                        ApiErrorEvent event=new ApiErrorEvent(talksResponses.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }*/
            }

            @Override
            public void onFailure(Call<GetTEDTalksResponses> call, Throwable t) {
                ApiErrorEvent event=new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });
    }
    }
