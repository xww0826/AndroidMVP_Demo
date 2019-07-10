package com.test.mvp.mvpdemo.mvp.v3.basemvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    private P mPresenter;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    protected abstract P setPresenter();

    protected abstract void initViews();

    protected abstract void initData();


    @SuppressWarnings("SameParameterValue")
    protected <T extends View> T $(@IdRes int viewId) {
        return findViewById(viewId);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout(savedInstanceState);

        /**
         * 实例化和绑定 P 层
         */
        this.mPresenter = setPresenter();
        this.mPresenter.attech(this);

        initViews();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 解绑，避免内存泄漏
         */
        this.mPresenter.detech();
        this.mPresenter = null;
    }

    @Override
    public Context getContext() {
        return this;
    }

    public P getPresenter() {
        return mPresenter;
    }
}
