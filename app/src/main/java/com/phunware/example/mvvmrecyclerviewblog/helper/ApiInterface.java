package com.phunware.example.mvvmrecyclerviewblog.helper;

import com.phunware.example.mvvmrecyclerviewblog.model.CountryListModel;

import retrofit2.Call;
import retrofit2.http.GET;

public abstract class ApiInterface {
    @GET("facts.json")
    public abstract Call<CountryListModel> getCountryDetails();
}
