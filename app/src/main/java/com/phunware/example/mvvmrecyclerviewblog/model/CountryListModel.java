package com.phunware.example.mvvmrecyclerviewblog.model;

import java.util.ArrayList;

public class CountryListModel {
//    @SerializedName("rows")
    public String title;
    private ArrayList<DataModel> rows;

    public ArrayList<DataModel> getRows() {
        return rows;
    }

    public void setRows(ArrayList<DataModel> rows) {
        this.rows = rows;
    }
}
