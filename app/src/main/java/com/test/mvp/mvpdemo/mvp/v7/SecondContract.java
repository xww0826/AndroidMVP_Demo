package com.test.mvp.mvpdemo.mvp.v7;

import com.test.mvp.mvpdemo.mvp.v7.basemvp.IBasePresenter;
import com.test.mvp.mvpdemo.mvp.v7.basemvp.IBaseView;

import okhttp3.Callback;

public interface SecondContract {
    interface ISecondModel {
        void requestBaidu(Callback callback);
    }

    interface ISecondView extends IBaseView {
        void showDialog();

        void succes(String content);
    }

    interface ISecondPresenter extends IBasePresenter {
        void handlerData();
    }
}
