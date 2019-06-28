package com.example.appshopdidong.model;

public class GioHang {
    public String idSanPham;
    public String tenSp;
    public int giaSp;
    public int hinhSP;
    public int soLuong;


    public GioHang(String idSanPham, String tenSp, int giaSp, int hinhSP, int soLuong) {
        this.idSanPham = idSanPham;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.hinhSP = hinhSP;
        this.soLuong = soLuong;

    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public GioHang setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
        return this;
    }

    public String getTenSp() {
        return tenSp;
    }

    public GioHang setTenSp(String tenSp) {
        this.tenSp = tenSp;
        return this;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public GioHang setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        return this;
    }

    public int getGiaSp() {
        return giaSp;
    }

    public GioHang setGiaSp(int giaSp) {
        giaSp = giaSp;
        return this;
    }

    public int getHinhSP() {
        return hinhSP;
    }

    public GioHang setHinhSP(int hinhSP) {
        this.hinhSP = hinhSP;
        return this;
    }

}
