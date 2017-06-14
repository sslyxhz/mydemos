package com.xhz.mydemos.zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xhz.mydemos.R;
import com.xhz.mydemos.test.ChatServer;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

import org.java_websocket.WebSocketImpl;

import java.net.UnknownHostException;

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
                Bitmap qrCode = EncodingUtils.createQRCode("ws://172.25.102.172:8887",900,900,null);
                mIvQrCode.setImageBitmap(qrCode);
            }
        });

        test();
    }

    private void test() {
        WebSocketImpl.DEBUG = false;
        int port = 8887; // 843 flash policy port
        ChatServer s = null;
        try {
            s = new ChatServer( port );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        s.start();
        Log.d("ZxingActivity","ChatServer started on address: " +s.getAddress());
        Log.d("ZxingActivity","ChatServer started on port: " + s.getPort());
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
