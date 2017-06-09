package com.xhz.mydemos.draggablepanel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.github.pedrovgs.DraggableListener;
import com.github.pedrovgs.DraggablePanel;
import com.xhz.mydemos.R;

/**
 * Created by xh.zeng on 2017/6/9.
 */

public class DraggablePanelActivity extends FragmentActivity {

    private DraggablePanel mDraggablePanel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draggablepanel);

        mDraggablePanel=(DraggablePanel)this.findViewById(R.id.draggable_panel);
        mDraggablePanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDraggablePanel.maximize();
            }
        });
        mDraggablePanel.setDraggableListener(new DraggableListener() {

            @Override
            public void onMaximized() {
                Toast.makeText(getApplication(), "onMaximized", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMinimized() {
                Toast.makeText(getApplication(), "onMinimized", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClosedToLeft() {
                Toast.makeText(getApplication(), "onClosedToLeft", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClosedToRight() {
                Toast.makeText(getApplication(), "onClosedToRight", Toast.LENGTH_SHORT).show();
            }
        });
        mDraggablePanel.setFragmentManager(getSupportFragmentManager());
        mDraggablePanel.setTopFragment(TestFragment.newInstance(0xFFEF5350, "TopFragment"));
        mDraggablePanel.setBottomFragment(TestFragment.newInstance(0xFF42A5F5, "BottomFragment"));
        mDraggablePanel.initializeView();
    }

}
