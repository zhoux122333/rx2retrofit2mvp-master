package com.aragoto.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.aragoto.R;
import com.aragoto.data.entity.Gank1;
import com.aragoto.mvp.presenter.GankPresenter;
import com.aragoto.mvp.view.GankView;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity implements GankView {
    private GankPresenter gankPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidNetworking.initialize(getApplicationContext());
        Logger.addLogAdapter(new AndroidLogAdapter());
        setContentView(R.layout.activity_main);
        gankPresenter = new GankPresenter(this);
        gankPresenter.loadInfo();
    }

    @Override
    public void showInfoSuccess(Gank1 gank1) {
        Toast.makeText(this, "数据展示成功", Toast.LENGTH_LONG).show();
//        Logger.json(String.valueOf(gank1));
    }

    @Override
    public void showInfoFail() {
        Toast.makeText(this, "数据展示失败", Toast.LENGTH_LONG).show();

    }
}
