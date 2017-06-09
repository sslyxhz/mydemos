package com.xhz.mydemos.zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xhz.mydemos.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

/**
 * Created by xh.zeng on 2017/6/9.
 */

public class ZxingActivity extends AppCompatActivity {

    private Button mBtnScanner;
    private Button mBtnGenerate;
    private TextView mTvResult;
    private ImageView mIvQrCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        initview();
    }

    private void initview() {
        mBtnScanner = (Button) findViewById(R.id.btn_scan);
        mBtnGenerate = (Button) findViewById(R.id.btn_generate);
        mTvResult = (TextView) findViewById(R.id.tv_result);
        mIvQrCode = (ImageView) findViewById(R.id.iv_qrcode);

        mBtnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(ZxingActivity.this , CaptureActivity.class) , 0);
            }
        });
        mBtnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap qrCode = EncodingUtils.createQRCode("视讯，生成二维码",900,900,null);
                mIvQrCode.setImageBitmap(qrCode);
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
