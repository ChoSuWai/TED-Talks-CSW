package com.chosuwai.ted.talks.csw.data.models;

import com.chosuwai.ted.talks.csw.data.vos.TalkVO;
import com.chosuwai.ted.talks.csw.events.SuccessGetTEDTalksEvent;
import com.chosuwai.ted.talks.csw.network.HttpUrlConnectionDataAgentImpl;
import com.chosuwai.ted.talks.csw.network.OkHttpDataAgentImpl;
import com.chosuwai.ted.talks.csw.network.RetrofitDataAgentImpl;
import com.chosuwai.ted.talks.csw.network.TEDDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class TEDModel {

    private static final String DUMMY_ACCESS_TOKEN="b002c7e1a528b7cb460933fc2875e916";

    private static TEDModel objInstance;

    private TEDDataAgent mDataAgent;
    private Map<String, TalkVO> mTalkMap;

    private TEDModel(){
       //mDataAgent=HttpUrlConnectionDataAgentImpl.getObjInstance();
       //mDataAgent= OkHttpDataAgentImpl.getInstance();
       mDataAgent= RetrofitDataAgentImpl.getInstance();

       mTalkMap=new HashMap<>();

        EventBus.getDefault().register(this);
    }

    public static TEDModel getObjInstance(){
        if(objInstance==null){
            objInstance=new TEDModel();
        }
        return objInstance;
    }

    public  void loadPlayList(){
        mDataAgent.loadPlayList(1, DUMMY_ACCESS_TOKEN);
    }

    public TalkVO getTalkById(String talkId){
        return mTalkMap.get(talkId);
    }

    @Subscribe(threadMode= ThreadMode.BACKGROUND)
    public void onSuccessGetTalks(SuccessGetTEDTalksEvent event){

        for(TalkVO talks:event.getTalkList()){
            mTalkMap.put(talks.getTalkId(), talks);
        }
    }

}
