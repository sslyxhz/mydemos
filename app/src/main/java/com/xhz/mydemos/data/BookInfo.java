package com.xhz.mydemos.data;

/**
 * Created by xh.zeng on 2017/6/2.
 */

public class BookInfo {
    private int id;
    private String name;

    public BookInfo(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
