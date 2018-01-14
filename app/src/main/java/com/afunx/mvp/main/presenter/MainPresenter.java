package com.afunx.mvp.main.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.afunx.mvp.main.MainContract;
import com.afunx.mvp.main.bean.TemperatureBean;
import com.afunx.mvp.main.model.MainModel;
import com.afunx.mvp.main.view.MainActivity;

/**
 * Listens to user actions from the UI ({@link MainActivity}), receives the data and updates the UI
 * (监听用户在UI上的动作，接收温度变化，并更新UI)
 */

public class MainPresenter implements MainContract.Presenter {

    @NonNull
    private final MainContract.View mMainView;

    private final MainModel mMainModel;

    public MainPresenter(@NonNull MainContract.View mainView) {
        mMainView = mainView;
        mMainModel = new MainModel();

        mainView.setPresenter(this);
    }

    @Override
    public void showPresentTemperature() {

        // mainHandler is created in UI thread(mainHandler在UI线程中创建)
        final Handler mainHandler = new Handler();

        new Thread(){
            @Override
            public void run() {
                // query temperature in non-UI thread(在非UI线程中，查询温度)
                final TemperatureBean temperatureBean = mMainModel.queryTemperature();
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // update View in UI thread(在UI线程中更新View)
                        mMainView.showTemperature(temperatureBean);
                    }
                });
            }
        }.start();
    }
}
