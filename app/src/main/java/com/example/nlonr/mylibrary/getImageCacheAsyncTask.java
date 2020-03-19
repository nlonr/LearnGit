package com.example.nlonr.mylibrary;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.File;
import java.lang.ref.WeakReference;

public  class getImageCacheAsyncTask extends AsyncTask<String, Void, File> {
//    private ImageView img;
    private WeakReference<Activity> mWeakReference;
    public getImageCacheAsyncTask(Activity activity,ImageView img) {
//        this.img = img;
        mWeakReference=new WeakReference<>(activity);
    }
//
    @Override
    protected File doInBackground(String... params) {
        String imgUrl =  params[0];
        try {
//            return Glide.with(mWeakReference.get())
//                    .load(imgUrl)
//                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                    .get();
            return null;
        } catch (Exception ex) {
            return null;
        }
    }
//
    @Override
    protected void onPostExecute(File result) {
//        if (result == null) {
//            return;
//        }
//        //此path就是对应文件的缓存路径
//        String path = result.getPath();
//        Log.e("path", path);
//        Bitmap bmp= BitmapFactory.decodeFile(path);
//        img.setImageBitmap(bmp);
    }
}
