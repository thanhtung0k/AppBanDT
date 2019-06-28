package com.example.appshopdidong.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.example.appshopdidong.App;
import com.example.appshopdidong.database.dao.GioHangServerDao;
import com.example.appshopdidong.database.dao.PhoneDao;
import com.example.appshopdidong.database.entity.GioHangServer;
import com.example.appshopdidong.database.entity.Phone;

public class AppDatabaseGioHang {
    private static AppDatabaseGioHang instance;

    public static AppDatabaseGioHang getInstance() {
        if (instance == null) {
            instance = new AppDatabaseGioHang();
        }
        return instance;
    }

    private DHDatabase dhDatabase;

    private AppDatabaseGioHang() {
        dhDatabase = Room.databaseBuilder(App.getInstance(), DHDatabase.class, "bang_don_hang_database")
                .allowMainThreadQueries()
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .build();
    }


    public DHDatabase getDHDatabase() {
        return dhDatabase;
    }


    @Database(
            entities = {GioHangServer.class},
            version = 1
    )


    public static abstract class DHDatabase extends RoomDatabase {
        public abstract GioHangServerDao getGioHangServerDao();
    }
}
