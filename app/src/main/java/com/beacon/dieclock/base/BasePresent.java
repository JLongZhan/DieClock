package com.beacon.dieclock.base;

import android.view.View;

/**
 * Created by Administrator on 2018/4/16.
 */

public interface BasePresent<T> {
    void attachView(T view);

    void detachView();

}
