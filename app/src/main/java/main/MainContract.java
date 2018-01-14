package main;

import com.afunx.mvp.BasePresenter;
import com.afunx.mvp.BaseView;

import main.bean.TemperatureBean;

/**
 * This specifies the contract between the view and the presenter
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        /**
         * show present temperature
         *
         * @param temperatureBean temperature bean
         */
        void showTemperature(TemperatureBean temperatureBean);
    }

    interface Presenter extends BasePresenter {
        /**
         * query present temperature from Internet and show it
         */
        void showPresentTemperature();
    }
}
