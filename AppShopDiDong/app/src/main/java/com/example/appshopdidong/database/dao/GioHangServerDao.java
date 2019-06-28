package com.example.appshopdidong.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.appshopdidong.database.entity.GioHangServer;

@Dao
public interface GioHangServerDao {

    @Insert
    void inputGioHang(GioHangServer gioHangServer);

    @Query("SELECT * FROM giohang WHERE SoDienThoai like :sdt ")
    GioHangServer getOneDonHang(String sdt);

    @Update
    void updateGioHang(GioHangServer gioHangServer);

    @Query("SELECT COUNT(SoDienThoai) FROM giohang")
    long getDHCount();

}
