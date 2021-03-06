package com.example.nlonr.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nlonr.R;
import com.example.nlonr.entity.Goods;

import java.util.List;

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHolder> {

    private Context mContext;
    private List<Goods> list;
    private OnItemClickListener mItemClick;

    public FirstAdapter(Context mContext, List<Goods> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClick = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.common_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Goods g = list.get(position);
        holder.img.setImageResource(g.getImg());
        holder.tvTitle.setText(g.getTitle());
        holder.tvContent.setText(g.getContent());
        if (!TextUtils.isEmpty(g.getDesc())) {
            holder.tvDesc.setText(g.getDesc());
        } else {
            holder.tvDesc.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(g.getExtra())) {
            holder.tvExtra.setText(g.getExtra());
        } else {
            holder.tvExtra.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClick!=null){
                    mItemClick.onItemClick(v,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTitle, tvContent, tvDesc, tvExtra;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_icon);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvDesc = itemView.findViewById(R.id.tv_describe);
            tvExtra = itemView.findViewById(R.id.tv_extra);

        }

    }


}
