package com.example.nlonr.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveInfo {
    private static final String FILE_NAME = "user_info";

    //保存用户信息
    public static void saveUserInfo(Context context, String key, Object object) {
        String type = object.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        switch (type) {
            case "String":
                editor.putString(key, (String) object);
                break;
            case "Boolean":
                editor.putBoolean(key, (Boolean) object);
                break;
            case "Integer":
                editor.putInt(key, (Integer) object);
                break;
        }

        //必须提交，否则保存不成功
        editor.commit();

    }

    //读取用户信息
    public static Object readUserInfo(Context context, String key, Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        switch (type) {
            case "String":
                return sp.getString(key, (String) defaultObject);
            case "Boolean":
                return sp.getBoolean(key, (Boolean) defaultObject);
            case "Integer":
                return sp.getInt(key, (Integer) defaultObject);
        }

        return "";

    }

    //删除用户信息
    public static boolean deleteUserInfo(Context context,String fileName) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.edit().clear().commit();
    }

}
