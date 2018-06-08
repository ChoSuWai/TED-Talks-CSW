package com.chosuwai.ted.talks.csw.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chosuwai.ted.talks.csw.R;
import com.chosuwai.ted.talks.csw.delegates.TEDDelegate;
import com.chosuwai.ted.talks.csw.viewholders.TEDTalksViewHolder;

public class TEDTalksAdapter extends RecyclerView.Adapter {
    private TEDDelegate mTEDDelegate;

    public TEDTalksAdapter(TEDDelegate tedDelegate){mTEDDelegate=tedDelegate;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

        View view=layoutInflater.inflate(R.layout.view_holder_ted_talks, parent, false);
                return new TEDTalksViewHolder(view,mTEDDelegate);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
