package com.test.mvp.mvpdemo.mvp.v7.proxy;

import com.test.mvp.mvpdemo.mvp.v7.basemvp.IBaseView;

public class ProxyActivity<V extends IBaseView> extends ProxyImpl {
    public ProxyActivity(V view) {
        super(view);
    }
}
