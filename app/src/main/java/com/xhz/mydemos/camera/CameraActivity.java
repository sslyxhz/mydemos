package com.xhz.mydemos.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xhz.mydemos.R;


/**
 * Created by xh.zeng on 2017/6/6.
 */

public class CameraActivity extends AppCompatActivity {
    private ImageView mIvCapturePicture;
    private TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mIvCapturePicture = (ImageView) this.findViewById(R.id.iv_camera_picture);
        mTvTitle = (TextView) this.findViewById(R.id.tv_camera_title);
        mIvCapturePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCapture();
            }
        });
    }

    private void startCapture() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bp = (Bitmap) data.getExtras().get("data");
        mIvCapturePicture.setImageBitmap(bp);
    }
}
