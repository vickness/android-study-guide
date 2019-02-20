package com.example.visen.studyapp.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

import java.util.Map;

/**
 * Android的四大数据存储方式 SharedPreference，SQLite，Content Provider，File
 * */
public class StorageActivity extends BaseActivity implements View.OnClickListener {

    /*

    sp是一种轻量级的存储方式，使用方便，但是也有它适用的场景。要优雅滴使用sp，要注意以下几点：

    不要存放大的key和value！我就不重复三遍了，会引起界面卡、频繁GC、占用内存等等，好自为之！
    毫不相关的配置项就不要丢在一起了！文件越大读取越慢，不知不觉就被猪队友给坑了；蓝后，放进defalut的那个简直就是愚蠢行为！
    读取频繁的key和不易变动的key尽量不要放在一起，影响速度。（如果整个文件很小，那么忽略吧，为了这点性能添加维护成本得不偿失）
    不要乱edit和apply，尽量批量修改一次提交！
    尽量不要存放JSON和HTML，这种场景请直接使用json！
    不要指望用这货进行跨进程通信！！！

    * */

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        //设置标题
        setActionBarTitle("数据存储");

        //操作结果
        resultText = findViewById(R.id.result_text);

        /*
            mode指定为MODE_PRIVATE，则该配置文件只能被自己的应用程序访问。
            mode指定为MODE_WORLD_READABLE，则该配置文件除了自己访问外还可以被其它应该程序读取。
            mode指定为MODE_WORLD_WRITEABLE，则该配置文件除了自己访问外还可以被其它应该程序读取和写入
        */

        //获取SharedPreferences对象，默认使用当前类不带包名的类名作为文件的名称
        SharedPreferences myPreference = getPreferences(Context.MODE_PRIVATE);
        //获取SharedPreferences对象，使用自定义名称
        //SharedPreferences myPreference = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        //像SharedPreference中写入数据需要使用Editor
        SharedPreferences.Editor editor = myPreference.edit();

        //存入键值对数据，注意此处的put[type]("key",value);
        editor.putString("STRING_KEY", "string");
        editor.putInt("INT_KEY", 0);
        editor.putBoolean("BOOLEAN_KEY", true);

        /*  提交保存, apply和commit都是提交保存，区别在于apply是异步执行的，不需要等待。不论删除，修改，增加都必须调用apply或者commit提交保存。
            关于更新：如果已经插入的key已经存在。那么将更新原来的key。
            应用程序一旦卸载，SharedPreference也会被删除。
         */
        editor.apply();
        //editor.commit();


        //读取这里主要用到了get[type]("key",defaultvalue),第一个参数是要获取的key，第二个参数是默认值，是当没有为这个key保存值的时候使用。
        String name1 = myPreference.getString("name", "defaultname");
        String name2 = myPreference.getString("name", "暂无");
        int age = myPreference.getInt("age", 0);
        boolean isRead = myPreference.getBoolean("isRead", false);


        //检查当前键是否存在
        boolean isContains = myPreference.contains("key");

        //使用getAll可以返回所有可用的键值
        Map<String,?> allMaps = myPreference.getAll();


        //删除指定数据
        editor.remove("key");

        //清空所有数据
        editor.clear();

        //初始化PreferenceUtils
        PreferenceUtils.getInstance(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loc_add:
                PreferenceUtils.put("UserName", "abc");
                PreferenceUtils.put("PassWord", "111");
                PreferenceUtils.put("isLogin", true);
                PreferenceUtils.put("price", 10.55f);
                PreferenceUtils.put("number", 111);
                break;
            case R.id.loc_delete:
                PreferenceUtils.remove("UserName");
                PreferenceUtils.remove("PassWord");
                PreferenceUtils.remove("isLogin");
                PreferenceUtils.remove("price");
                PreferenceUtils.remove("number");
                break;
            case R.id.loc_check:
                String userName = PreferenceUtils.get("UserName", "");
                String passWord = PreferenceUtils.get("PassWord", "");
                Boolean isLogin = PreferenceUtils.get("isLogin", false);
                Float price = PreferenceUtils.get("price", 0.01f);
                Integer number = PreferenceUtils.get("number", 0);
                Log.d("aa", userName);
                Log.d("aa", passWord);
                Log.d("aa", ""+isLogin);
                Log.d("aa", ""+price);
                Log.d("aa", ""+number);
                break;
            case R.id.sql_add:

                break;
            case R.id.sql_delete:

                break;
            case R.id.sql_check:

                break;
        }

    }
}
