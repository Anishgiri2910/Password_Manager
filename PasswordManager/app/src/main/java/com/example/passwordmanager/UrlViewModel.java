package com.example.passwordmanager;

import android.app.Application;


import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class UrlViewModel extends AndroidViewModel {
    private UrlRepository mRepository;

    private LiveData<List<URLs>> mAllUrls;

    public UrlViewModel (Application application) {
        super(application);
        mRepository = new UrlRepository(application);
        mAllUrls = mRepository.getAllUrl();
    }

    LiveData<List<URLs>> getAllUrl() { return mAllUrls; }

    public void insert(URLs url) { mRepository.insert(url); }

    public void deleteAll() {mRepository.deleteAll();}

    public void deleteUrl(URLs url) {mRepository.deleteUrl(url);}

}
