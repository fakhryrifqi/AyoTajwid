package com.example.ayotajwid;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Adapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for random question in parent
                Intent intent = new Intent(viewGroup.getContext(), QuizActivity.class);
                viewGroup.getContext().startActivity(intent);
            }
        });
        return view;
    }
}
