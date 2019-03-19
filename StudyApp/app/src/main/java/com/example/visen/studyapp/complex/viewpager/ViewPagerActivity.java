package com.example.visen.studyapp.complex.viewpager;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;
import com.example.visen.studyapp.complex.viewpager.adapter.FragmentAdapter;
import com.example.visen.studyapp.complex.viewpager.adapter.FragmentStateAdapter;
import com.example.visen.studyapp.complex.viewpager.adapter.SimpleAdapter;

import java.util.ArrayList;

public class ViewPagerActivity extends BaseActivity {

    /*
    *   1.setAdapter(PagerAdapter adapter)
        该方法为ViewPager设置适配器，ViewPager有三种适配器，它们分别有不同的特性，下面我会对这三种适配器进行讲解。

        2.setCurrentItem(int item)
        该方法设置显示item位置的界面。

        3.setOffscreenPageLimit(int limit)
        该方法用来设置当前显示页面左右两边各缓存的页面数。

        4.(OnPageChangeListener listener)
        该方法为ViewPager添加页面切换时的监听，关于界面监听的内容，接下来对OnPageChangeListener中的方法进行讲解时，再详细说明。

        5.setOnScrollChangeListener(OnScrollChangeListener l)
        该方法为ViewPager增加滚动状态监听，但该方法需要minSdkVersion为23
    *
    * */


    private ViewPager viewPager1;
    private ViewPager viewPager2;
    private ViewPager viewPager3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        setActionBarTitle("ViewPager 用法");

        this.initPager1();
        this.initPager2();
        this.initPager3();
        this.setOnPageChange();
    }

    /** 适合单纯的View切换*/
    private void initPager1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("page1");
        list.add("page2");
        list.add("page3");
        list.add("page4");
        list.add("page5");
        list.add("page6");
        viewPager1 = findViewById(R.id.viewPager1);
        SimpleAdapter adapter = new SimpleAdapter(this, list);
        viewPager1.setAdapter(adapter);
    }

    /** 适合有限个静态fragment页面的切换*/
    private void initPager2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Fragment page1");
        list.add("Fragment page2");
        list.add("Fragment page3");
        list.add("Fragment page4");
        list.add("Fragment page5");
        list.add("Fragment page6");
        viewPager2 = findViewById(R.id.viewPager2);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), list);
        viewPager2.setAdapter(adapter);
        viewPager2.setOffscreenPageLimit(list.size());
    }

    /** 适合处理大量的页面切换*/
    private void initPager3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("FragmentState page1");
        list.add("FragmentState page2");
        list.add("FragmentState page3");
        list.add("FragmentState page4");
        list.add("FragmentState page5");
        list.add("FragmentState page6");
        viewPager3 = findViewById(R.id.viewPager3);
        FragmentStateAdapter adapter = new FragmentStateAdapter(getSupportFragmentManager());
        viewPager3.setAdapter(adapter);
    }

    /** 滑动事件响应*/
    private void setOnPageChange() {

        /*
            三个方法的执行顺序：用手指拖动翻页时，最先执行一遍onPageScrollStateChanged(1)，
            然后不断执行onPageScrolled，放手指的时候，直接立即执行一次onPageScrollStateChanged(2)，
            然后立即执行一次onPageSelected，然后再不断执行onPageScrollStateChanged，
            最后执行一次onPageScrollStateChanged(0)。
        */
        //ViewPager回调方法
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /*
            该方法在滑动过程中将一直被调用，该方法的参数说明如下：

            position:当用手指滑动时，如果手指按在页面上不动，position和当前页面index是一致的；
            如果手指向左拖动（相应页面向右翻动），这时候position大部分时间和当前页面是一致的，
            只有翻页成功的情况下最后一次调用才会变为目标页面；如果手指向右拖动（相应页面向左翻动），
            这时候position大部分时间和目标页面是一致的，只有翻页不成功的情况下最后一次调用才会变为原页面。
            当直接设置setCurrentItem翻页时，如果是相邻的情况（比如现在是第二个页面，跳到第一或者第三个页面），
            如果页面向右翻动，大部分时间是和当前页面是一致的，只有最后才变成目标页面；如果向左翻动，position和目标页面是一致的。
            这和用手指拖动页面翻动是基本一致的。如果不是相邻的情况，
            比如我从第一个页面跳到第三个页面，position先是0，然后逐步变成1，然后逐步变成2；
            我从第三个页面跳到第一个页面，position先是1，然后逐步变成0，并没有出现为2的情况。

            positionOffset:当前页面滑动比例，如果页面向右翻动，这个值不断变大，最后在趋近1的情况后突变为0。如果页面向左翻动，这个值不断变小，最后变为0。

            positionOffsetPixels:当前页面滑动像素，变化情况和positionOffset一致
            */
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }


            /*
             position是被选中页面的索引，该方法在页面被选中或页面滑动足够距离切换到该页手指抬起时调用。
             */
            @Override
            public void onPageSelected(int i) {

            }


            /*
            该方法在手指操作屏幕的时候发生变化。
            有三个值：0(END)，1(PRESS) ，2(UP) 。
            当用手指滑动翻页时，手指按下去的时候会触发这个方法，state值为1，
            手指抬起时，如果发生了滑动（即使很小），这个值会变为2，然后最后变为0 。
            总共执行这个方法三次。一种特殊情况是手指按下去以后一点滑动也没有发生，
            这个时候只会调用这个方法两次，state值分别是1，0 。
            当setCurrentItem翻页时，会执行这个方法两次，state值分别为2 ，0 。
            */
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
