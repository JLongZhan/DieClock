package com.beacon.dieclock.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/16.
 */

public abstract class BaseActivity<T extends BasePresent> extends AppCompatActivity implements BaseView {
    protected T mPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(getResId());
        ButterKnife.bind(this);
        initView();
        mPresent = injectPresent();
//        mPresent.attachView(this);
    }

    protected abstract T injectPresent();


    protected abstract int getResId();


    protected abstract void initView();


    @Override
    public void showToast(String msg) {

    }

    protected void startActivity(Class<Activity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }
}
