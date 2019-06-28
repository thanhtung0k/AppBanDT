package com.example.appshopdidong.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity(tableName = "phone")
public class Phone {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "Id")
    private String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "AnhId")
    private int anhId;

    @ColumnInfo(name = "Ten")
    private String ten;

    @ColumnInfo(name = "Gia")
    private int gia;

    @ColumnInfo(name = "CameraTruoc")
    private String cameraTruoc;

    @ColumnInfo(name = "CameraSau")
    private String cameraSau;

    @ColumnInfo(name = "ManHinh")
    private String manHinh;

    @ColumnInfo(name = "HeDieuHanh")
    private String heDieuHanh;

    @ColumnInfo(name = "Cpu")
    private String cpu;

    @ColumnInfo(name = "BoNhoTrong")
    private String boNhoTrong;

    @ColumnInfo(name = "Ram")
    private String ram;

    @ColumnInfo(name = "CauHinhPhanCung")
    private String cauHinhPhanCung;

    @ColumnInfo(name = "TheSim")
    private String theSim;

    @ColumnInfo(name = "DungLuongPin")
    private String dungLuongPin;

    @ColumnInfo(name = "BaoHanh")
    private String baoHanh;

    @ColumnInfo(name = "HangSx")
    private String hangSx;

    @ColumnInfo(name = "SoLuong")
    private int soLuong;

    @ColumnInfo(name = "TrangThai")
    private String trangThai;

    public Phone(){
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public int getAnhId() {
        return anhId;
    }

    public void setAnhId(int anhId) {
        this.anhId = anhId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(String cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    public String getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(String cameraSau) {
        this.cameraSau = cameraSau;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getBoNhoTrong() {
        return boNhoTrong;
    }

    public void setBoNhoTrong(String boNhoTrong) {
        this.boNhoTrong = boNhoTrong;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCauHinhPhanCung() {
        return cauHinhPhanCung;
    }

    public void setCauHinhPhanCung(String cauHinhPhanCung) {
        this.cauHinhPhanCung = cauHinhPhanCung;
    }

    public String getTheSim() {
        return theSim;
    }

    public void setTheSim(String theSim) {
        this.theSim = theSim;
    }

    public String getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(String dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    public String getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(String baoHanh) {
        this.baoHanh = baoHanh;
    }

    public String getHangSx() {
        return hangSx;
    }

    public void setHangSx(String hangSx) {
        this.hangSx = hangSx;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
