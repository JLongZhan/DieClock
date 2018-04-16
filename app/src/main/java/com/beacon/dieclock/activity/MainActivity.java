package com.beacon.dieclock.activity;

import com.beacon.dieclock.R;
import com.beacon.dieclock.base.BaseActivity;
import com.beacon.dieclock.base.BasePresent;
import com.beacon.dieclock.mvp.present.SplashPresent;

public class MainActivity extends BaseActivity {


    @Override
    protected int getResId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresent injectPresent() {
        return new SplashPresent();
    }

    @Override
    protected void initView() {

    }
}
