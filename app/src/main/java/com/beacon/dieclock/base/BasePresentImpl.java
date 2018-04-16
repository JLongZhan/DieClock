package com.beacon.dieclock.base;

/**
 * Created by Administrator on 2018/4/16.
 */

public class BasePresentImpl<T extends BaseView> implements BasePresent<T> {
    protected  T mView;
    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
