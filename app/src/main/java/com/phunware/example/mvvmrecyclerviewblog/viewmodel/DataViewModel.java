package com.phunware.example.mvvmrecyclerviewblog.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.phunware.example.mvvmrecyclerviewblog.BR;
import com.phunware.example.mvvmrecyclerviewblog.adapter.DataAdapter;
import com.phunware.example.mvvmrecyclerviewblog.helper.ApiInterface;
import com.phunware.example.mvvmrecyclerviewblog.helper.RetrofitClass;
import com.phunware.example.mvvmrecyclerviewblog.model.CountryListModel;
import com.phunware.example.mvvmrecyclerviewblog.model.DataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends BaseObservable {
    private static final String TAG = "DataViewModel";
    private DataAdapter adapter;
    private List<DataModel> data;

    public DataViewModel() {
        data = new ArrayList<DataModel>();
        adapter = new DataAdapter();
    }

    public void setUp() {
        // perform set up tasks, such as adding listeners, data population, etc.
        populateData();
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public List<DataModel> getData() {
        return this.data;
    }

    @Bindable
    public DataAdapter getAdapter() {
        return this.adapter;
    }

    private void populateData() {
        // populate the data from the source, such as the database.

        ApiInterface api = RetrofitClass.getRetrofitObject().create(ApiInterface.class);
        Call<CountryListModel> call = api.getCountryDetails();
        call.enqueue(new Callback<CountryListModel>() {
            @Override
            public void onResponse(Call<CountryListModel> call, Response<CountryListModel> response) {
                Log.e("response=", String.valueOf(response.body()));
                data = response.body().getRows();
            }

            @Override
            public void onFailure(Call<CountryListModel> call, Throwable t) {
            }
        });
        notifyPropertyChanged(BR.data);
    }
}
