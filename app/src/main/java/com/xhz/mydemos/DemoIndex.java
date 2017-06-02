package com.xhz.mydemos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.xhz.mydemos.test.TextFragment;

/**
 * Created by xh.zeng on 2017/6/2.
 */

public class DemoIndex extends FragmentActivity{

    private TextFragment mTextFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demoindex);

        mFragmentManager = getSupportFragmentManager();
        mTextFragment = new TextFragment();

    }


}
