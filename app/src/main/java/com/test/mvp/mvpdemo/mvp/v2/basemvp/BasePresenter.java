package com.test.mvp.mvpdemo.mvp.v2.basemvp;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {
    protected V mView;

    @SuppressWarnings("unchecked")
    @Override
    public void attech(IBaseView view) {
        mView = (V) view;
    }

    @Override
    public void detech() {
        mView = null;
    }
}
