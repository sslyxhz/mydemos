package com.xhz.mydemos.draggablepanel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xhz.mydemos.R;

/**
 * Created by xh.zeng on 2017/6/9.
 */

public class DraggableViewActivity extends AppCompatActivity{
    private ListView mMainListView;
    private ListView mSecondListView;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_draggableview);

        String[] data1 = new String[50];
        for (int i = 0; i < data1.length; i++){
            data1[i] = "item:" + i;
        }
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, data1);
        mMainListView = (ListView) findViewById(R.id.mainListView);
        mMainListView.setAdapter(adapter1);

        String[] data2 = { "Z", "H", "A", "N", "G", "P", "H", "I", "L" };
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, data2);
        mSecondListView = (ListView) findViewById(R.id.secondListView);
        mSecondListView.setAdapter(adapter2);
    }

}
