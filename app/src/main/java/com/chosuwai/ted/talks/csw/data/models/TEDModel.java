package com.chosuwai.ted.talks.csw.data.models;

import com.chosuwai.ted.talks.csw.network.HttpUrlConnectionDataAgentImpl;
import com.chosuwai.ted.talks.csw.network.TEDDataAgent;

public class TEDModel {

    private static final String DUMMY_ACCESS_TOKEN="b002c7e1a528b7cb460933fc2875e916";

    private static TEDModel objInstance;

    private TEDDataAgent mDataAgent;

    private TEDModel(){
       mDataAgent=HttpUrlConnectionDataAgentImpl.getObjInstance();
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

}
