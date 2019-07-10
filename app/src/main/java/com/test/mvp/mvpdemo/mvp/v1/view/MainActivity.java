package com.test.mvp.mvpdemo.mvp.v1.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.test.mvp.mvpdemo.R;
import com.test.mvp.mvpdemo.mvp.v1.MainContract;
import com.test.mvp.mvpdemo.mvp.v1.presenter.MainPresenter;

/**
 * MVP 的写法，Version 1: 基础写法
 *
 * @author 神探丶威威猫
 * @blog https://blog.csdn.net/smile_running
 * @warning 点个赞哦，评个论哦
 */
public class MainActivity extends AppCompatActivity implements MainContract.IMainView {

    private TextView tv;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mPresenter = new MainPresenter(this);
        mPresenter.handlerData();
    }

    private void initViews() {
        tv = findViewById(R.id.tv);
    }

    @Override
    public void showDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }

    @Override
    public void succes(String content) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "" + content, Toast.LENGTH_SHORT).show();
                tv.setText(content);
            }
        });
    }
}
