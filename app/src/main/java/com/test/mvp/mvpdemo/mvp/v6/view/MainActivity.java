package com.test.mvp.mvpdemo.mvp.v6.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.test.mvp.mvpdemo.R;
import com.test.mvp.mvpdemo.mvp.v6.MainContract;
import com.test.mvp.mvpdemo.mvp.v6.basemvp.BaseActivity;
import com.test.mvp.mvpdemo.mvp.v6.inject.InjectPresenter;
import com.test.mvp.mvpdemo.mvp.v6.presenter.MainPresenter;

/**
 * MVP 的写法，Version 6: 封装 BaseFragment
 *
 * @author 神探丶威威猫
 * @blog https://blog.csdn.net/smile_running
 * @warning 点个赞哦，评个论哦
 */
public class MainActivity extends BaseActivity implements MainContract.IMainView {

    private TextView tv;

    @InjectPresenter
    private MainPresenter mPresenter;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        tv = $(R.id.tv);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SecondActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.handlerData();
    }

    @Override
    public void showDialog() {
        ProgressDialog dialog = new ProgressDialog(getContext());
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
                Toast.makeText(getContext(), "" + content, Toast.LENGTH_SHORT).show();
                tv.setText(content);
            }
        });
    }
}
