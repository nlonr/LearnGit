package com.example.activity.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.activity.R;

public class ImageUtils {

    public void loadImageView(Context context, ImageView image, String url){
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .override(1000,800)
                .fitCenter()
                .centerCrop()
                .circleCrop()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .priority(Priority.HIGH);
        Glide.with(context).load(url).apply(options).into(image);

    }

}
