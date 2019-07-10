package com.test.mvp.mvpdemo.mvc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.test.mvp.mvpdemo.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 一般 MVC 的写法
 *
 * @author 神探丶威威猫
 * @blog https://blog.csdn.net/smile_running
 * @warning 点个赞哦，评个论哦
 */
public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        request();
        showDialog();
    }

    private void initViews() {
        tv = findViewById(R.id.tv);
    }

    private void showDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }

    private void request() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resp = response.body().string();
                toast(resp);
            }
        });
    }

    private void toast(String resp) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "" + resp, Toast.LENGTH_SHORT).show();
                tv.setText(resp);
            }
        });
    }

}
