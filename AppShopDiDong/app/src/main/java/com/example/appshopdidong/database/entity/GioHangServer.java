package com.example.appshopdidong.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "giohang")
public class GioHangServer {
    public GioHangServer() {
    }

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "SoDienThoai")
    private String sdt;

    @ColumnInfo(name = "DonHang")
    private String donHang;

    @ColumnInfo(name = "TongTien")
    private int tongTien;

    @ColumnInfo(name = "XacNhanDonHang")
    private String xacNhanDonHang;

    @ColumnInfo(name = "GhiChu")
    private String ghiChu = null;

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDonHang() {
        return donHang;
    }

    public void setDonHang(String donHang) {
        this.donHang = donHang;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getXacNhanDonHang() {
        return xacNhanDonHang;
    }

    public void setXacNhanDonHang(String xacNhanDonHang) {
        this.xacNhanDonHang = xacNhanDonHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
