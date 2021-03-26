package com.example.passwordmanager;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = URLs.class, version = 1, exportSchema = false)
public abstract class UrlRoomDatabase extends RoomDatabase {

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    public abstract UrlDao urlDao();
    private static UrlRoomDatabase INSTANCE;

    static UrlRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UrlRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UrlRoomDatabase.class, "url_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UrlDao mDao;
//        String[][] words = {{"1","Amazon","anish@outlook.com","shop","8943834360","null","null","null","null","null","null"}};

        PopulateDbAsync(UrlRoomDatabase db) {
            mDao = db.urlDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
//            mDao.deleteAll();
            if(mDao.getAnyUrl().length < 1){
            URLs url=new URLs("Amazon","anish@outlook.com","shop","8943834360","null","null","null","null","null","null");
            mDao.insert(url);
            URLs url1=new URLs("Netflix","anish@gmail.com","shop","8943834360","null","null","null","null","null","null");
            mDao.insert(url1);

            }
            return null;
        }
    }
}

