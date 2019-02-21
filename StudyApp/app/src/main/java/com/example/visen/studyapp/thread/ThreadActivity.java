package com.example.visen.studyapp.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

import java.lang.ref.WeakReference;

/** 多线程实现方式
 *
 * 继承Thread类
 * 实现Runnable接口
 * Handler
 * AsyncTask
 * HandlerThread
 *
 * */
public class ThreadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        //设置标题
        setActionBarTitle("多线程操作");


        /** 1.继承Thread类，重写run方法，start启动线程
         *
         * public class CustomThread extends Thread{
         *     @Override
         *     public void run() {
         *         // 处理耗时逻辑
         *     }
         * }
         *
         * new CustomThread().start();
         *
         * */


        /** 2.实现 Runnable 接口，重写run方法 start启动线程
         *
         * public class CustomThread implements Runnable{
         *     @Override
         *     public void run() {
         *         // 处理耗时逻辑
         *     }
         * }
         *
         * new Thread(new CustomThread()).start();
         *
         * */


        /** 3.使用匿名类，实现 Runnable 接口
         *
         * new Thread(new Runnable() {
         *     @Override
         *     public void run() {
         *         //处理耗时逻辑
         *     }
         * });
         *
         * */



        /** 在子线程中更新UI*/

        /** 1.如果你的子线程里可以得到要更新的view的话， view.post(Runnable action)
         *
         * textView.post(new Runnable() {
         *         @Override
         *         public void run() {
         *             textView.setText("更新textView");
         *         }
         *     });
         *
         * */

        /** 2.runOnUiThread(Runnable action) 该方法是在子线程中, context 对象要是 主线程中的MainActivity
         *
         * runOnUiThread(new Runnable() {
         *             @Override
         *             public void run() {
         *                 //此时已在主线程中，更新UI
         *             }
         *         });
         *
         * */


        /** 3.Handler机制，首先在主线程中定义Handler，Handler mainHandler = new Handler();
         * （必须要在主线程中定义才能操作主线程，如果想在其他地方定义声明时要这样写Handler mainHandler = new Handler(Looper.getMainLooper())，来获取主线程的 Looper 和 Queue ）
         *
         * 获取到 Handler 后就很简单了，用handler.post(Runnable r)方法把消息处理放在该 handler 依附的消息队列中（也就是主线程消息队列）
         *
         * 假如该方法是在子线程中
         * Handler mainHandler = new Handler(Looper.getMainLooper());
         *     mainHandler.post(new Runnable() {
         *         @Override
         *         public void run() {
         *             //已在主线程中，更新UI
         *         }
         *     });
         *
         * */

    }



    private static class MyTask extends AsyncTask<Void, Void, String> {

        private WeakReference<ThreadActivity> activityReference;

        // only retain a weak reference to the activity
        MyTask(ThreadActivity context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected String doInBackground(Void... params) {

            // do some long running task...

            return "task finished";
        }

        @Override
        protected void onPostExecute(String result) {

            // get a reference to the activity if it is still there
            ThreadActivity activity = activityReference.get();
            if (activity == null || activity.isFinishing()) return;

            // modify the activity's UI
            //TextView textView = activity.findViewById(R.id.textview);
            //textView.setText(result);

            // access Activity member variables
            //activity.mSomeMemberVariable = 321;
        }
    }

}
