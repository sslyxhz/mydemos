package com.xhz.mydemos.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.xhz.mydemos.R;

/**
 * Created by xh.zeng on 2017/6/2.
 */

public class TestActivity extends AppCompatActivity {

    public static final String TAG = TestActivity.class.getSimpleName();
    private TextView mTvTestTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mTvTestTitle = (TextView) this.findViewById(R.id.tvTestTitle);
        mTvTestTitle.setText("This is the test title.");

        Log.d(TAG, "stringFromJNI="+stringFromJNI());
        Log.d(TAG, "string2FromJNI="+string2FromJNI());

        Log.d(TAG, "stringHelloJni="+stringHelloJni());
    }

    public int add(int a, int b){
        return a+b;
    }

    public native String stringFromJNI();
    public native String string2FromJNI();

    public native int stringHelloJni();

    static{
        System.loadLibrary("native-lib");
        System.loadLibrary("hellojni");
    }

}
