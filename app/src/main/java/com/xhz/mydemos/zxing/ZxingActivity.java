package com.xhz.mydemos.zxing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xhz.mydemos.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by xh.zeng on 2017/6/9.
 */

public class ZxingActivity extends AppCompatActivity {

    private Button mBtnScanner;
    private TextView mTvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        initview();

    }

    private void initview() {
        mBtnScanner = (Button) findViewById(R.id.btn_scan);
        mTvResult = (TextView) findViewById(R.id.tv_result);

        mBtnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(ZxingActivity.this , CaptureActivity.class) , 0);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            mTvResult.setText(result);
        }

    }
}
