package com.example.visen.studyapp.thread;

import android.os.AsyncTask;

/** 继承AsyncTask，创建一个异步任务*/

/**
 * 步骤1：创建AsyncTask子类
 * 注：
 *   a. 继承AsyncTask类
 *   b. 为3个泛型参数指定类型；若不使用，可用java.lang.Void类型代替
 *   c. 根据需求，在AsyncTask子类内实现核心方法
 */
public class MyTask extends AsyncTask<Void, Void, Void> {


    // 方法1：onPreExecute（）
    // 作用：执行 线程任务前的操作
    // 注：根据需求复写
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    // 方法2：doInBackground（）
    // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
    // 注：必须复写，从而自定义线程任务
    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }


    // 方法3：onProgressUpdate（）
    // 作用：在主线程 显示线程任务执行的进度
    // 注：根据需求复写
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    // 方法4：onPostExecute（）
    // 作用：接收线程任务执行结果、将执行结果显示到UI组件
    // 注：必须复写，从而自定义UI操作
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


    // 方法5：onCancelled()
    // 作用：将异步任务设置为：取消状态
    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}



/**
 * 步骤2：创建AsyncTask子类的实例对象（即 任务实例）
 * 注：AsyncTask子类的实例必须在UI线程中创建
 *
 * MyTask mTask = new MyTask();
 *
 */

/**
 * 步骤3：手动调用execute(Params... params) 从而执行异步线程任务
 * 注：
 *    a. 必须在UI线程中调用
 *    b. 同一个AsyncTask实例对象只能执行1次，若执行第2次将会抛出异常
 *    c. 执行任务中，系统会自动调用AsyncTask的一系列方法：onPreExecute() 、doInBackground()、onProgressUpdate() 、onPostExecute()
 *    d. 不能手动调用上述方法
 *
 *     mTask.execute()；
 */
