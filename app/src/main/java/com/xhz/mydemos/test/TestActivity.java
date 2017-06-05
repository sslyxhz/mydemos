package com.xhz.mydemos.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xhz.mydemos.R;

/**
 * Created by xh.zeng on 2017/6/2.
 */

public class TestActivity extends AppCompatActivity {

    private TextView mTvTestTitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mTvTestTitle = (TextView) this.findViewById(R.id.tvTestTitle);
        mTvTestTitle.setText("This is the test title.");
        mTvTestTitle.setText(stringFromJNI());
    }

    public native String stringFromJNI();

    static{
        System.loadLibrary("native-lib");
    }

}
