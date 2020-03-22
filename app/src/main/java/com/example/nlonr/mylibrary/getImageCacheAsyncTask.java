package com.example.nlonr.mylibrary;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.example.nlonr.utils.DataCacheKey;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

public  class getImageCacheAsyncTask extends AsyncTask<String, Void, File> {
    private ImageView img;
    private WeakReference<Activity> mWeakReference;


    public getImageCacheAsyncTask(Activity activity,ImageView img) {
        this.img = img;
        mWeakReference=new WeakReference<>(activity);
    }

//
    @Override
    protected File doInBackground(String... params) {
        String imgUrl =  params[0];
        try {
            FutureTarget<File> future =
                    Glide.with(mWeakReference.get()).load(imgUrl)
                            .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);

            return  future.get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(File result) {
        if (result == null) {
            return;
        }
        //此path就是对应文件的缓存路径
        String path = result.getAbsolutePath();
        Log.e("path", path);
        Bitmap bmp= BitmapFactory.decodeFile(path);
        img.setImageBitmap(bmp);
    }
}
