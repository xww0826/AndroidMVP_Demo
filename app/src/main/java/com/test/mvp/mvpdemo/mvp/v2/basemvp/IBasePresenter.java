package com.test.mvp.mvpdemo.mvp.v2.basemvp;

public interface IBasePresenter<V extends IBaseView> {

    void attech(V view);

    void detech();
}
