package com.chosuwai.ted.talks.csw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.chosuwai.ted.talks.csw.R;
import com.chosuwai.ted.talks.csw.adapters.TEDTalksAdapter;
import com.chosuwai.ted.talks.csw.data.models.TEDModel;
import com.chosuwai.ted.talks.csw.data.vos.TalkVO;
import com.chosuwai.ted.talks.csw.delegates.TEDDelegate;
import com.chosuwai.ted.talks.csw.events.SuccessGetTEDTalksEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity
        implements TEDDelegate{

    private TEDTalksAdapter mTalksAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar =findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        RecyclerView rvted=findViewById(R.id.rv_ted_talks);
        mTalksAdapter=new TEDTalksAdapter(this);
        rvted.setAdapter(mTalksAdapter);
        rvted.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        TEDModel.getObjInstance().loadPlayList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetTalk(SuccessGetTEDTalksEvent event){
        Log.d("onSuccessGetTalk", "onSuccessGetTalks : "+ event.getTalkList());
        mTalksAdapter.setTalkList(event.getTalkList());
    }

    @Override
    public void onTapImage(TalkVO mTalk) {
        Intent intent=new Intent(getApplicationContext(), TEDDetailsActivity.class);
        intent.putExtra("talksId", mTalk.getTalkId());
        startActivity(intent);
    }
}
