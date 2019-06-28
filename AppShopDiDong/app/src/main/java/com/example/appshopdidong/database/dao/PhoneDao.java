package com.example.appshopdidong.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.appshopdidong.database.entity.Phone;


import java.util.List;

@Dao
public interface PhoneDao {

    @Insert
    void putDataIn(Phone phone);

    // Câu lệnh tìm kiếm
    @Query("SELECT * FROM phone WHERE Ten like :timKiem")
    List<Phone> getListTimKiem(String timKiem);

    @Query("SELECT * FROM phone WHERE Id like :phoneID")
    Phone getOnePhone(String phoneID);


    @Query("SELECT * FROM phone WHERE TrangThai like :trangThaiHot " )
    List<Phone> getListHotPhone(String trangThaiHot);

    @Query("SELECT * FROM phone WHERE HangSx like :hangSxRcv")
    List<Phone> getListDienThoaiTheoHangSx(String hangSxRcv);

    @Query("Select distinct HangSx from phone")
    List<String> getListTenHang();

    @Query("SELECT COUNT(id) FROM phone")
    long getCount();

}
