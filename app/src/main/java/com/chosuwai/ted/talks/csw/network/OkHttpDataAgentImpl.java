package com.chosuwai.ted.talks.csw.network;

import android.os.AsyncTask;
import android.text.GetChars;
import android.util.Log;

import com.chosuwai.ted.talks.csw.events.ApiErrorEvent;
import com.chosuwai.ted.talks.csw.events.SuccessGetTEDTalksEvent;
import com.chosuwai.ted.talks.csw.network.responses.GetTEDTalksResponses;
import com.chosuwai.ted.talks.csw.utils.TEDConstants;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpDataAgentImpl implements TEDDataAgent {

    private static OkHttpDataAgentImpl objInstance;
    private OkHttpClient mHttpClient;

    private OkHttpDataAgentImpl() {
        mHttpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgentImpl getInstance() {
        if (objInstance == null) {
            objInstance = new OkHttpDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadPlayList(final int page, final String accessToken) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                RequestBody formBody = new FormBody.Builder() //2.
                        .add(TEDConstants.PARAM_ACCESS_TOKEN, accessToken)
                        .add(TEDConstants.PARAM_PAGE, String.valueOf(page))
                        .build();

                Request request = new Request.Builder() //3
                        .url(TEDConstants.API_BASE+TEDConstants.GET_TED_TALKS)
                        .post(formBody)
                        .build();

                try {
                    Response response = mHttpClient.newCall(request).execute(); //4.
                    if (response.isSuccessful()) {
                        String responseString = response.body().string();
                        return responseString;
                    }
                } catch (IOException e) {
                    Log.e("loadNewsList", e.getMessage());
                }

                return null;
            }

            @Override
            protected void onPostExecute(String responseString) {
                super.onPostExecute(responseString);
                Gson gson = new Gson();
                GetTEDTalksResponses talksResponses=gson.fromJson(responseString, GetTEDTalksResponses.class);
                Log.d("onPostExecute", "News List Size :" + talksResponses.getTedTalks().size());

                if (talksResponses.isResponseOk()){
                    SuccessGetTEDTalksEvent event=new SuccessGetTEDTalksEvent(talksResponses.getTedTalks());
                    EventBus.getDefault().post(event);
                } else {
                    ApiErrorEvent event=new ApiErrorEvent(talksResponses.getMessage());
                    EventBus.getDefault().post(event);
                }
            }
        }.execute();
    }


}