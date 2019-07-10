package com.test.mvp.mvpdemo.mvp.v4.basemvp;

public interface IBasePresenter {

    void attach(IBaseView view);

    void detach();
}
