package com.chosuwai.ted.talks.csw.events;

import com.chosuwai.ted.talks.csw.data.vos.TalkVO;

import java.util.List;

public class SuccessGetTEDTalksEvent {

    private List<TalkVO> talkList;

    public SuccessGetTEDTalksEvent(List<TalkVO> talkList) {
        this.talkList = talkList;
    }

    public List<TalkVO> getTalkList() {
        return talkList;
    }
}
