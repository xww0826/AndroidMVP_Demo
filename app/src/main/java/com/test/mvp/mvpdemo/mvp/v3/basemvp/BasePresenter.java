package com.test.mvp.mvpdemo.mvp.v3.basemvp;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {
    private SoftReference<IBaseView> mReferenceView;
    private V mProxyView;

    @SuppressWarnings("unchecked")
    @Override
    public void attech(IBaseView view) {
        mReferenceView = new SoftReference<>(view);
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (mReferenceView == null || mReferenceView.get() == null) {
                    return null;
                }
                return method.invoke(mReferenceView.get(), objects);
            }
        });
    }

    @SuppressWarnings("unchecked")
    public V getView() {
        return mProxyView;
    }

    @Override
    public void detech() {
        mReferenceView.clear();
        mReferenceView = null;
    }
}
