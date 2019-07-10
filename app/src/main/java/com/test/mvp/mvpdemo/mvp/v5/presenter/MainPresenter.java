package com.test.mvp.mvpdemo.mvp.v5.presenter;

import android.util.Log;

import com.test.mvp.mvpdemo.mvp.v5.MainContract;
import com.test.mvp.mvpdemo.mvp.v5.basemvp.BasePresenter;
import com.test.mvp.mvpdemo.mvp.v5.model.DataModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * presenter 层，承担业务逻辑处理，数据源处理等
 */
public class MainPresenter extends BasePresenter<MainContract.IMainView, DataModel> implements MainContract.IMainPresenter {

    @Override
    public void handlerData() {
        getView().showDialog();

        getModel().requestBaidu(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String content = response.body().string();
                getView().succes(content);
            }
        });
    }

    @Override
    public void detach() {
        super.detach();
        /**
         * 释放内存、关闭网络请求、关闭线程等操作
         */
        Log.d("==========", "detech: 解除绑定，释放内存");
    }
}
