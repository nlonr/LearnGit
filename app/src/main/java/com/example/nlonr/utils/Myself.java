package com.example.nlonr.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.example.nlonr.BuildConfig;
import com.example.nlonr.R;
import com.example.nlonr.application.MyApp;
import java.io.File;
import static android.content.Context.DOWNLOAD_SERVICE;

public class Myself {

    private static void startInstallActivity(Context context, String path) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri contentUri = FileProvider.getUriForFile(context,
                    BuildConfig.APPLICATION_ID + ".fileProvider", new File(path));
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public boolean checkVersion(Context context){
        boolean haveInstallPermission;
        //版本判断
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //获取是否有安装未知来源应用的权限
            haveInstallPermission = context.getPackageManager().canRequestPackageInstalls();
            return haveInstallPermission;
        }else{
            return false;
        }
    }



    public void downloadAPK(Context context) {
        //已存在 -- 删除
        File apkFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "MyApp.apk");
        if (apkFile != null && apkFile.exists()) {
            apkFile.delete();
        }
        DownloadManager downloadManager = (DownloadManager)context.getSystemService(DOWNLOAD_SERVICE);
        //下载 （AppCont.Update_URL 是你的app下载地址）
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(MyApp.Update_URL));
        //设置title
        request.setTitle(context.getResources().getString(R.string.app_name));
        // 完成后显示通知栏
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        //设置存储路径 --这个是应用专用的,软件卸载后，下载的文件将随着卸载全部被删除
        request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, "MyApp.apk");
        //设置 文件类型
        request.setMimeType("application/vnd.android.package-archive");
        assert downloadManager != null;
        downloadManager.enqueue(request);
    }


}
