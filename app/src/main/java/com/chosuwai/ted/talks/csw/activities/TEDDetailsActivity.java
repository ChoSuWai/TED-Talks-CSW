package com.chosuwai.ted.talks.csw.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chosuwai.ted.talks.csw.R;
import com.chosuwai.ted.talks.csw.adapters.TEDDetailsAdapter;
import com.chosuwai.ted.talks.csw.data.models.TEDModel;
import com.chosuwai.ted.talks.csw.data.vos.TalkVO;
import com.chosuwai.ted.talks.csw.delegates.TEDDetailsDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TEDDetailsActivity extends BaseActivity
implements TEDDetailsDelegate{

    @BindView(R.id.text_brief)
    TextView tvTextBrief;

    @BindView(R.id.iv_video)
    ImageView ivVideo;

    @BindView(R.id.tv_duration)
    TextView tvDuration;

    @BindView(R.id.tv_video_speaker_name)
    TextView tvVideoSpeakerName;

    @BindView(R.id.tv_video_title)
    TextView tvVideoTitle;

    @BindView(R.id.ted_details_backdrop)
    ImageView ivBackDrop;

    @BindView(R.id.tv_speaker_name)
    TextView tvSpeakerName;

    @BindView(R.id.tv_text_details)
    TextView tvTextDetails;

    @BindView(R.id.iv_profile)
    ImageView ivProfile;

    @BindView(R.id.tv_bold_speaker_name)
    TextView tvBoldSpeakerName;

    @BindView(R.id.tv_about_speaker)
    TextView tvAboutSpeaker;

    @BindView(R.id.tv_speaker_bio)
    TextView tvSpeakerBio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_details);
       // ButterKnife.bind(this,this);

        String talkId = getIntent().getStringExtra("talkId");
        Log.d("TEDDetailsActivity", "talkId: " + talkId);

        TalkVO talks= TEDModel.getObjInstance().getTalkById(talkId);
        bindData(talks);

        RecyclerView rvteddetails=findViewById(R.id.rv_ted_details);
        TEDDetailsAdapter tedDetailsAdapter=new TEDDetailsAdapter();
        rvteddetails.setAdapter(tedDetailsAdapter);
        rvteddetails.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

    }

    private void bindData(TalkVO talks){
       // tvTextBrief.setText(talks.getTalkDescription());

       // tvSpeakerName.setText(talks.getSpeaker().getSpeakerName());

       // tvDuration.setText(talks.getTalkDuration());

        //tvTextDetails.setText(talks.getTalkDescription());

        //tvSpeakerName.setText(talks.getSpeaker().getSpeakerName());

       // tvVideoTitle.setText(talks.getTalkTitle());

        /*Glide.with(ivBackDrop.getContext())
                .load(talks.getTalkImage())
                .into(ivBackDrop);*/

    }



    @Override
    public void onTapvideo() {

    }

    @Override
    public void onTapVideoName() {

    }
}
