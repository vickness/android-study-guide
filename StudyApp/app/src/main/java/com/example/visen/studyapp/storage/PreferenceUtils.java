package com.example.visen.studyapp.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/** SharedPreferences单例工具类*/
public class PreferenceUtils {

    /** 全局对象*/
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    /** 缓存分组名称*/
    private static final String SHARED_NAME = "SHARED_NAME_KEY";


    /** 构造器*/
    private PreferenceUtils(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /** 单例模式*/
    private static PreferenceUtils preferenceUtils = null;
    public static PreferenceUtils getInstance(Context context){
        if (preferenceUtils == null) {
            synchronized (PreferenceUtils.class) {
                if (preferenceUtils == null) {
                    preferenceUtils = new PreferenceUtils(context.getApplicationContext());
                }
            }
        }
        return preferenceUtils;
    }


    /** 保存数据*/
    public static void put(String key, Object value) {
        if (preferenceUtils == null) {
            Log.e("PreferenceUtils", "PreferenceUtils is null");
            return;
        }
        if (value instanceof String) {
            preferenceUtils.editor.putString(key, (String) value).apply();
        } else if (value instanceof Integer) {
            preferenceUtils.editor.putInt(key, (Integer) value).apply();
        } else if (value instanceof Boolean) {
            preferenceUtils.editor.putBoolean(key, (Boolean) value).apply();
        } else if (value instanceof Long) {
            preferenceUtils.editor.putLong(key, (Long) value).apply();
        } else if (value instanceof Float) {
            preferenceUtils.editor.putFloat(key, (Float) value).apply();
        } else {
            Log.e("PreferenceUtils", "value is error");
        }
    }


    /** 查询数据*/
    public static <T> T get(String key, Object defaultValue) {
        if (preferenceUtils == null) {
            Log.e("PreferenceUtils", "PreferenceUtils is null");
            return null;
        }
        if (defaultValue instanceof String) {
            return (T) preferenceUtils.sharedPreferences.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(preferenceUtils.sharedPreferences.getInt(key, (Integer) defaultValue));
        } else if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(preferenceUtils.sharedPreferences.getBoolean(key, (Boolean) defaultValue));
        } else if (defaultValue instanceof Long) {
            return (T) Long.valueOf(preferenceUtils.sharedPreferences.getLong(key, (Long) defaultValue));
        } else if (defaultValue instanceof Float) {
            return (T) Float.valueOf(preferenceUtils.sharedPreferences.getFloat(key, (Float) defaultValue));
        } else {
            Log.e("PreferenceUtils", "defaultValue is error");
            return null;
        }
    }

    /** 删除数据*/
    public static void remove(String key) {
        if (preferenceUtils == null) {
            Log.e("PreferenceUtils", "PreferenceUtils is null");
            return ;
        }
        preferenceUtils.editor.remove(key).apply();
    }

    /** 清空数据*/
    public static void clear() {
        if (preferenceUtils == null) {
            Log.e("PreferenceUtils", "PreferenceUtils is null");
            return;
        }
        preferenceUtils.editor.clear().apply();
    }
}
