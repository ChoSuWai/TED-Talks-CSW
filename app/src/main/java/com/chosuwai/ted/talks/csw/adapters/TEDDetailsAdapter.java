package com.chosuwai.ted.talks.csw.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chosuwai.ted.talks.csw.R;
import com.chosuwai.ted.talks.csw.delegates.TEDDetailsDelegate;
import com.chosuwai.ted.talks.csw.viewholders.TEDDetailsViewHolder;

public class TEDDetailsAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

        View view=layoutInflater.inflate(R.layout.view_holder_ted_details, parent, false);

        return new TEDDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
