package com.xhz.mydemos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by xh.zeng on 2017/6/2.
 */

public class TextFragment extends Fragment {

    private String mTitle;
    private TextView mTitleTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TextFragment.class.getSimpleName(), "onCreate");
        mTitle = "Test Title";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_text,container,false);
        mTitleTextView = (TextView) v.findViewById(R.id.fragment_text_title);
        mTitleTextView.setText(mTitle);
        return v;
    }
}
