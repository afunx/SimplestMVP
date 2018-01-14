package com.afunx.mvp.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afunx.mvp.R;

import com.afunx.mvp.main.MainContract;
import com.afunx.mvp.main.bean.TemperatureBean;
import com.afunx.mvp.main.presenter.MainPresenter;

/**
 * UI for ({@link MainPresenter})
 * MainPresenter对应的UI
 */
public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener {

    private Button mBtnShowTemperature;
    private MainContract.Presenter mMainPresenter;

    @Override
    public void setPresenter(MainContract.Presenter presetner) {
        mMainPresenter = presetner;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MainPresenter(this);

        mBtnShowTemperature = (Button) findViewById(R.id.btn_show_temperature);
        mBtnShowTemperature.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnShowTemperature) {
            mMainPresenter.showPresentTemperature();
        }
    }

    @Override
    public void showTemperature(TemperatureBean temperatureBean) {
        int celsius = temperatureBean.getDegree();
        String format = getString(R.string.present_temperature_text);
        String text = String.format(format, celsius);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
