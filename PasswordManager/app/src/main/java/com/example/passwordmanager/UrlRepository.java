package com.example.passwordmanager;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UrlRepository {
    private UrlDao mWordDao;
    private LiveData<List<URLs>> mAllWords;

    UrlRepository(Application application) {
        UrlRoomDatabase db = UrlRoomDatabase.getDatabase(application);
        mWordDao = db.urlDao();
        mAllWords = mWordDao.getAllUrls();
    }

    private static class deleteAllUrlsAsyncTask extends AsyncTask<Void, Void, Void> {
        private UrlDao mAsyncTaskDao;

        deleteAllUrlsAsyncTask(UrlDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    public void deleteUrl(URLs url)  {
        new deleteUrlAsyncTask(mWordDao).execute(url);
    }

    LiveData<List<URLs>> getAllUrl() {
        return mAllWords;
    }

    public void insert (URLs url) {
        new insertAsyncTask(mWordDao).execute(url);
    }

    public void deleteAll()  {
        new deleteAllUrlsAsyncTask(mWordDao).execute();
    }

    private static class deleteUrlAsyncTask extends AsyncTask<URLs, Void, Void> {
        private UrlDao mAsyncTaskDao;

        deleteUrlAsyncTask(UrlDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final URLs... params) {
            mAsyncTaskDao.deleteUrl(params[0]);
            return null;
        }
    }

    private static class insertAsyncTask extends AsyncTask<URLs, Void, Void> {

        private UrlDao mAsyncTaskDao;

        insertAsyncTask(UrlDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final URLs... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
