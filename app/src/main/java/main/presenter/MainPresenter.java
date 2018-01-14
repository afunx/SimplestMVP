package main.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;

import main.MainContract;
import main.bean.TemperatureBean;
import main.model.MainModel;
import main.view.MainActivity;

/**
 * Listens to user actions from the UI ({@link MainActivity}), receives the data and updates the UI
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

        // mainHandler is created in UI thread
        final Handler mainHandler = new Handler();

        new Thread(){
            @Override
            public void run() {
                // query temperature in non-UI thread
                final TemperatureBean temperatureBean = mMainModel.queryTemperature();
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // update View in UI thread
                        mMainView.showTemperature(temperatureBean);
                    }
                });
            }
        }.start();
    }
}
