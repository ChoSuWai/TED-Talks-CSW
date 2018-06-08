package com.chosuwai.ted.talks.csw.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chosuwai.ted.talks.csw.delegates.TEDDelegate;

public class TEDTalksViewHolder extends RecyclerView.ViewHolder {

    private TEDDelegate mTEDDelegate;
    public TEDTalksViewHolder(View itemView, TEDDelegate TEDDelegate) {

        super(itemView);
        mTEDDelegate=TEDDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTEDDelegate.onTapImage();
            }
        });
    }
}
