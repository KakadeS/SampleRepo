package com.phunware.example.mvvmrecyclerviewblog;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.phunware.example.mvvmrecyclerviewblog.databinding.AppDataBindingComponent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
