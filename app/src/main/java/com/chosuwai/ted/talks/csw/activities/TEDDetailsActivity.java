package com.chosuwai.ted.talks.csw.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.chosuwai.ted.talks.csw.R;
import com.chosuwai.ted.talks.csw.adapters.TEDDetailsAdapter;
import com.chosuwai.ted.talks.csw.delegates.TEDDetailsDelegate;

public class TEDDetailsActivity extends BaseActivity
implements TEDDetailsDelegate{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_details);

        RecyclerView rvteddetails=findViewById(R.id.rv_ted_details);
        TEDDetailsAdapter tedDetailsAdapter=new TEDDetailsAdapter();
        rvteddetails.setAdapter(tedDetailsAdapter);
        rvteddetails.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

    }


    @Override
    public void onTapvideo() {

    }

    @Override
    public void onTapVideoName() {

    }
}
