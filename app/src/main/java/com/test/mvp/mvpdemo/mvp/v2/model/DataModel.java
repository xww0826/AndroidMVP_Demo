package com.test.mvp.mvpdemo.mvp.v2.model;

import com.test.mvp.mvpdemo.mvp.v2.MainContract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * model 层，请求网络或数据库，提供数据源（原始数据）
 */
public class DataModel implements MainContract.IMainModel {

    @Override
    public void requestBaidu(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
