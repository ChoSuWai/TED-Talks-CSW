package com.chosuwai.ted.talks.csw.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chosuwai.ted.talks.csw.R;
import com.chosuwai.ted.talks.csw.data.vos.SpeakerVO;
import com.chosuwai.ted.talks.csw.data.vos.TalkVO;
import com.chosuwai.ted.talks.csw.delegates.TEDDelegate;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TEDTalksViewHolder extends RecyclerView.ViewHolder {

    private TEDDelegate mTEDDelegate;
    private TalkVO mTalk;
    private SpeakerVO aboutSpeaker;

    @BindView(R.id.text_brief)
    TextView textBrief;

    @BindView(R.id.tv_name)
    TextView tvSpeakerName;

    @BindView(R.id.picture)
    ImageView ivPicture;

    @BindView(R.id.tv_time)
    TextView tvDuratiionInSec;

    public TEDTalksViewHolder(View itemView, TEDDelegate TEDDelegate) {

        super(itemView);
        ButterKnife.bind(this,itemView);

        mTEDDelegate=TEDDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTEDDelegate.onTapImage(mTalk);
            }
        });
    }

    public void setTalkData(TalkVO talk){
        mTalk = talk;
        textBrief.setText(talk.getTalkTitle());

        Glide.with(ivPicture.getContext())
                .load(mTalk.getTalkImage())
                .into(ivPicture);


        tvSpeakerName.setText(mTalk.getSpeaker().getSpeakerName());
        tvDuratiionInSec.setText(mTalk.getTalkDuration());


    }
}
