package com.test.mvp.mvpdemo.mvp.v1.presenter;

import com.test.mvp.mvpdemo.mvp.v1.MainContract;
import com.test.mvp.mvpdemo.mvp.v1.model.DataModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * presenter 层，承担业务逻辑处理，数据源处理等
 */
public class MainPresenter implements MainContract.IMainPresenter {

    private MainContract.IMainModel mModel;
    private MainContract.IMainView mView;

    public MainPresenter(MainContract.IMainView view) {
        this.mView = view;
        mModel = new DataModel();
    }

    @Override
    public void handlerData() {
        if (mView != null) {
            mView.showDialog();
        }
        /**
         * 发起请求，获得回调数据
         */
        mModel.requestBaidu(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String content = response.body().string();
                if (mView != null) {
                    mView.succes(content);
                }
            }
        });
    }
}
