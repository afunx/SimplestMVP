package com.afunx.mvp.main;

import com.afunx.mvp.BasePresenter;
import com.afunx.mvp.BaseView;

import com.afunx.mvp.main.bean.TemperatureBean;

/**
 * This specifies the contract between the view and the presenter(View和Presenter的协议)
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        /**
         * show present temperature(显示当前温度)
         *
         * @param temperatureBean temperature bean(temperature bean对象)
         */
        void showTemperature(TemperatureBean temperatureBean);
    }

    interface Presenter extends BasePresenter {
        /**
         * query present temperature from Internet and show it(从网络上查询当前温度，并显示它)
         */
        void showPresentTemperature();
    }
}
