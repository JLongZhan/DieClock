package com.beacon.dieclock.activity;

import android.animation.ObjectAnimator;
import android.os.SystemClock;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.beacon.dieclock.R;
import com.beacon.dieclock.base.BaseActivity;
import com.beacon.dieclock.base.BasePresent;
import com.beacon.dieclock.mvp.present.SplashPresent;
import com.beacon.dieclock.mvp.view.SplashView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/16.
 */

public class SplashActivity extends BaseActivity implements SplashView {
    @BindView(R.id.tv_start)
    TextView mTvStart;
    @BindView(R.id.tv_center)
    TextView mTvCenter;
    @BindView(R.id.tv_end)
    TextView mTvEnd;
    private static final String TAG = "SplashActivity";

    @Override
    protected int getResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        final AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setFillAfter(true);
        aa.setDuration(1000);
        Observable.create(new ObservableOnSubscribe<TextView>() {
            @Override
            public void subscribe(ObservableEmitter<TextView> emitter) throws Exception {
                emitter.onNext(mTvStart);
                SystemClock.sleep(2000);
                emitter.onNext(mTvCenter);
                SystemClock.sleep(2000);
                emitter.onNext(mTvEnd);
                SystemClock.sleep(2000);
                emitter.onComplete();
            }
        }).delay(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextView>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextView textView) {
                        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha",  0f, 1f);
                        animator.setDuration(2000);
                        animator.start();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {

                        startActivity(MainActivity.class);
                    }
                });
    }

    @Override
    protected BasePresent injectPresent() {
        return new SplashPresent();
    }

    @Override
    public void startAnim() {

    }
}
