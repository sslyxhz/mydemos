package com.xhz.mydemos.draggablepanel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by xh.zeng on 2017/6/9.
 */

public class TestFragment extends Fragment{

    public static final TestFragment newInstance(int color, String content){
        TestFragment fragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);
        bundle.putString("content",content);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int color = getArguments().getInt("color");
        String content = getArguments().getString("content");

        View v = inflater.inflate(android.R.layout.simple_list_item_1, null);
        v.setBackgroundColor(color);
        TextView text = (TextView) v.findViewById(android.R.id.text1);
        text.setText(content);
        return v;
    }
}
