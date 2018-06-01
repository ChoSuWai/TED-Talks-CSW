package com.chosuwai.ted.talks.csw;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.chosuwai.ted.talks.csw.adapters.TEDTalksAdapter;

public class TEDMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvted=findViewById(R.id.rv_ted_talks);
        TEDTalksAdapter tedTalksAdapter=new TEDTalksAdapter();
        rvted.setAdapter(tedTalksAdapter);
        rvted.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }
}
