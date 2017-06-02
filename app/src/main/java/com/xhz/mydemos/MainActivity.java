package com.xhz.mydemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BookInfo> mBookInfoList;
    private RecyclerView mRecyclerView;
    private BooksAdapter mBooksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView)this.findViewById(R.id.books_recycler_view);
        mBooksAdapter = new BooksAdapter(mBookInfoList);
        mRecyclerView.setAdapter(mBooksAdapter);
    }

    private void initData(){
        mBookInfoList = new ArrayList<>();
        for(int i=0;i<100;++i){
            BookInfo info = new BookInfo(i,"book"+i);
            mBookInfoList.add(info);
        }
    }

    private class BooksHolder extends RecyclerView.ViewHolder{
        public TextView mNameTextView;

        public BooksHolder(View itemView){
            super(itemView);
            mNameTextView = (TextView) itemView;
        }
    }

    private class BooksAdapter extends RecyclerView.Adapter<BooksHolder>{

        private List<BookInfo> mBooks;

        public BooksAdapter(List<BookInfo> list){
            mBooks = list;
        }

        @Override
        public BooksHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1,parent,false);
            return new BooksHolder(view);
        }

        @Override
        public void onBindViewHolder(BooksHolder holder, int position) {
            BookInfo bookInfo = mBooks.get(position);
            holder.mNameTextView.setText(bookInfo.getName());
        }

        @Override
        public int getItemCount() {
            return mBooks==null?0:mBooks.size();
        }
    }

}
