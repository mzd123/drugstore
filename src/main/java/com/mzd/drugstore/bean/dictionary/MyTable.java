package com.mzd.drugstore.bean.dictionary;

import java.util.List;

public class MyTable {
    private String tablename;
    private List<MyColumn> list;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public List<MyColumn> getList() {
        return list;
    }

    public void setList(List<MyColumn> list) {
        this.list = list;
    }
}
