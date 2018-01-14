package com.afunx.mvp.main.model;

import java.util.Random;

import com.afunx.mvp.main.bean.TemperatureBean;
import com.afunx.mvp.main.presenter.MainPresenter;

/**
 * Main Model represents model used by the Presenter （{@link MainPresenter})
 * ,simulate query present temperature from the Internet
 */

public class MainModel {
    /**
     * simulate query temperature from the Internet
     *
     * @return TemperatureBean
     */
    public TemperatureBean queryTemperature() {
        // simulate query from Server
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // degree is in random [20,30)
        int degree = 20 + new Random().nextInt(10);

        TemperatureBean temperatureBean = new TemperatureBean();
        temperatureBean.setDegree(degree);
        return temperatureBean;
    }
}
