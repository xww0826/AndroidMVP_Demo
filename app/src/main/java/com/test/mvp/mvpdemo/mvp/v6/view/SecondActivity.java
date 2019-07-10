package com.test.mvp.mvpdemo.mvp.v6.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.mvp.mvpdemo.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /**
         * 开启一个 fragment
         */
        getSupportFragmentManager().beginTransaction().replace(R.id.second_container, new SecondFragment()).commit();
    }
}
