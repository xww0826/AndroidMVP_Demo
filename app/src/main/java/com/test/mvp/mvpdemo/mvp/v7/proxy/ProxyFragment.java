package com.test.mvp.mvpdemo.mvp.v7.proxy;

import com.test.mvp.mvpdemo.mvp.v7.basemvp.IBaseView;

public class ProxyFragment<V extends IBaseView> extends ProxyImpl {
    public ProxyFragment(V view) {
        super(view);
    }
}
