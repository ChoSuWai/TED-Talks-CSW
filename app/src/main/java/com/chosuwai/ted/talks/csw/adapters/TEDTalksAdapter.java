package com.chosuwai.ted.talks.csw.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chosuwai.ted.talks.csw.R;
import com.chosuwai.ted.talks.csw.data.vos.TalkVO;
import com.chosuwai.ted.talks.csw.delegates.TEDDelegate;
import com.chosuwai.ted.talks.csw.viewholders.TEDTalksViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TEDTalksAdapter extends RecyclerView.Adapter<TEDTalksViewHolder> {
    private TEDDelegate mTEDDelegate;
    private List<TalkVO> mTalkList;

    public TEDTalksAdapter(TEDDelegate tedDelegate){
        mTEDDelegate=tedDelegate;
        mTalkList=new ArrayList<>();
    }

    @NonNull
    @Override
    public TEDTalksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

        View view=layoutInflater.inflate(R.layout.view_holder_ted_talks, parent, false);
                return new TEDTalksViewHolder(view,mTEDDelegate);

    }

    @Override
    public void onBindViewHolder(@NonNull TEDTalksViewHolder holder, int position) {
        holder.setTalkData(mTalkList.get(position));
    }


    @Override
    public int getItemCount() {
        return mTalkList.size();
    }

    public void setTalkList(List<TalkVO> talkList){
        mTalkList=talkList;
        notifyDataSetChanged();
    }
}
