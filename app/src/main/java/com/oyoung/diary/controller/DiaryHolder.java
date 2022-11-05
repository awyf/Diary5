package com.oyoung.diary.controller;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.oyoung.diary.R;
import com.oyoung.diary.model.Diary;

public class DiaryHolder extends RecycleViewHolder<Diary>{
    private View.OnLongClickListener mOnLongClickListener;
    public DiaryHolder(@NonNull ViewGroup parent) {
        super(parent, R.layout.list_diary_item);
    }
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;

    }

    @Override
    public void onBindView(Diary diary) {
        super.onBindView(diary);
        TextView title = itemView.findViewById(R.id.title);
        title.setText(diary.getTitle());
        TextView desc = itemView.findViewById(R.id.desc);
        desc.setText(diary.getDescription());
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return mOnLongClickListener != null && mOnLongClickListener.onLongClick(view);
            }
        });
    }
}