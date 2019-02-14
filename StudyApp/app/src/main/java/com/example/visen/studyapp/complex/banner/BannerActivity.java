package com.example.visen.studyapp.complex.banner;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * 采用第三方框架实现 banner
 * implementation 'com.youth.banner:banner:1.4.10'
 * */
public class BannerActivity extends BaseActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        setActionBarTitle("Banner视图");


        //图片资源
        ArrayList<String> imageUrls = new ArrayList<>();
        imageUrls.add("http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg");
        imageUrls.add("http://f.hiphotos.baidu.com/image/pic/item/4034970a304e251f503521f5a586c9177e3e53f9.jpg");
        imageUrls.add("http://c.hiphotos.baidu.com/image/pic/item/9c16fdfaaf51f3de1e296fa390eef01f3b29795a.jpg");


        //获取ListView
        listView = findViewById(R.id.banner_list);

        //获取headerView
        View headerView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.header_banner,null);
        //获取Banner
        Banner banner = headerView.findViewById(R.id.banner);
        //设置样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置轮播的动画效果
        banner.setBannerAnimation(Transformer.ZoomOutSlide);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，居中显示
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        banner.setImageLoader(new MyImageLoader());
        //设置图片加载地址
        banner.setImages(imageUrls);
        //启动轮播
        banner.start();
        listView.addHeaderView(headerView);


        //创建数组
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<50; i++) {
            list.add("第 "+i+" 行");
        }

        //创建适配器
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.item_main, list);
        //设置适配器
        listView.setAdapter(adapter);
    }
}
