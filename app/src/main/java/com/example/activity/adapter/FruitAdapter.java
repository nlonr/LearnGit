package com.example.activity.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.activity.myself.CommonRecyclerAdapter;
import com.example.activity.myself.CommonViewHolder;
import com.example.activity.myself.MultiTypeSupport;
import java.util.List;

public class FruitAdapter extends CommonRecyclerAdapter {
    /**
     * 多布局支持
     * @param context
     * @param data
     * @param multiTypeSupport
     */
    public FruitAdapter(Context context, List data, MultiTypeSupport multiTypeSupport) {
        super(context, data, multiTypeSupport);
    }

    @Override
    public void convert(CommonViewHolder holder, Object item) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


}
