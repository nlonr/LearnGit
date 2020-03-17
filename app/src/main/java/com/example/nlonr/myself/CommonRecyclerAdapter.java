package com.example.nlonr.myself;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class CommonRecyclerAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    //数据怎么办？
    private List<T> mData;
    // 布局怎么办？
    private int mLayoutId;
    // 多布局支持
    private MultiTypeSupport mMultiTypeSupport;

    private CommonRecyclerAdapter(Context context, List<T> data, int layoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mData = data;
        this.mLayoutId = layoutId;
    }

    /**
     * 多布局支持
     */
    public CommonRecyclerAdapter(Context context, List<T> data, MultiTypeSupport<T> multiTypeSupport) {
        this(context, data, -1);
        this.mMultiTypeSupport = multiTypeSupport;
    }

    /**
     * 根据当前位置获取不同的viewType
     */
    @Override
    public int getItemViewType(int position) {
        // 多布局支持
        if (mMultiTypeSupport != null) {
            return mMultiTypeSupport.getLayoutId(mData.get(position), position);
        }
        return super.getItemViewType(position);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 多布局支持
        if (mMultiTypeSupport != null) {
            mLayoutId = viewType;
        }
        // 先inflate数据
        View itemView = mInflater.inflate(mLayoutId, parent, false);
        // 返回ViewHolder

        return new CommonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {
        // 设置点击和长按事件
        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(position);
                }
            });
        }
        if (mLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mLongClickListener.onItemLongClick(position);
                }
            });
        }

        // 绑定怎么办？回传出去
        convert(holder, mData.get(position));
    }

    /**
     * 利用抽象方法回传出去，每个不一样的Adapter去设置
     *
     * @param item 当前的数据
     */
    public abstract void convert(CommonViewHolder holder, T item);

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /***************
     * 设置条目点击和长按事件
     *********************/
    public OnItemClickListener mItemClickListener;
    public OnItemLongClickListener mLongClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.mLongClickListener = longClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick( int position);
    }

    public  interface OnItemLongClickListener{
        boolean onItemLongClick( int position);
    }

//    static class ViewHolder extends RecyclerView.ViewHolder{
//        //这些控件都可以设置监听事件
//        View fView;
//        ImageView imageView;
//        TextView textView;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            fView = itemView.findViewById(R.id.card_view);
//            imageView = itemView.findViewById(R.id.fruit_image);
//            textView = itemView.findViewById(R.id.fruit_name);
//        }
//    }


}
