package com.test.mvp.mvpdemo.mvp.v5.basemvp;

public interface IBasePresenter {

    void attach(IBaseView view);

    void detach();
}
