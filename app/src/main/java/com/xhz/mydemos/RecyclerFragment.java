package com.xhz.mydemos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xh.zeng on 2017/6/2.
 */

public class RecyclerFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private BooksAdapter mBooksAdapter;
    private List<BookInfo> mBookInfoList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBookInfoList = new ArrayList<>();
        for(int i=0;i<100;++i){
            BookInfo info = new BookInfo(i,"book"+i);
            mBookInfoList.add(info);
        }
        mBooksAdapter = new BooksAdapter(mBookInfoList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        mRecyclerView = (RecyclerView)v.findViewById(R.id.books_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mBooksAdapter);
        mBooksAdapter.notifyDataSetChanged();
        return v;
    }

    private class BooksHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private BookInfo mBookInfo;
        public TextView mIdTextView;
        public TextView mNameTextView;

        public BooksHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mIdTextView = (TextView) itemView.findViewById(R.id.list_item_bookinfo_id_text_view);
            mNameTextView = (TextView) itemView.findViewById(R.id.list_item_bookinfo_name_text_view);
        }
        public void bindBook(BookInfo bookInfo){
            mBookInfo = bookInfo;
            mIdTextView.setText(""+mBookInfo.getId());
            mNameTextView.setText(mBookInfo.getName());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), mBookInfo.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    private class BooksAdapter extends RecyclerView.Adapter<BooksHolder>{

        private List<BookInfo> mBooks;

        public BooksAdapter(List<BookInfo> list){
            mBooks = list;
        }

        @Override
        public BooksHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_book,parent,false);
            return new BooksHolder(view);
        }

        @Override
        public void onBindViewHolder(BooksHolder holder, int position) {
            BookInfo bookInfo = mBooks.get(position);
            holder.bindBook(bookInfo);
        }

        @Override
        public int getItemCount() {
            return mBooks==null?0:mBooks.size();
        }
    }
}
