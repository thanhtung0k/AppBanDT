package com.example.appshopdidong.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.example.appshopdidong.App;
import com.example.appshopdidong.database.dao.PhoneDao;
import com.example.appshopdidong.database.entity.Phone;


public class AppDatabasePhone {
    private static AppDatabasePhone instance;

    public static AppDatabasePhone getInstance() {
        if (instance == null) {
            instance = new AppDatabasePhone();
        }
        return instance;
    }

    private IDatabase database;

    private AppDatabasePhone() {
        database = Room.databaseBuilder(App.getInstance(), IDatabase.class, "bang_phone_database")
                .allowMainThreadQueries()
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .build();
    }

    public IDatabase getIDatabase() {
        return database;
    }

    @Database(
            entities = {Phone.class},
            version = 1
    )


    public static abstract class IDatabase extends RoomDatabase {
        public abstract PhoneDao getPhoneDao();
    }
}
