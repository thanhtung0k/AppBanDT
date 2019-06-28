package com.example.appshopdidong.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.appshopdidong.R;
import com.example.appshopdidong.database.AppDatabaseGioHang;
import com.example.appshopdidong.database.AppDatabasePhone;
import com.example.appshopdidong.database.entity.GioHangServer;
import com.example.appshopdidong.database.entity.Phone;
import com.example.appshopdidong.model.GioHang;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public static ArrayList<GioHang> mangGioHang;
    public static String sdtKhachHang;
    public static String noiDungDonHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        putDataPhone();
        creatMangGH();
        putDataGioHang();
    }


    private void creatMangGH() {
        if (mangGioHang != null) {
        } else {
            mangGioHang = new ArrayList<>();
        }
    }


    private void putDataGioHang() {
        GioHangServer g1 = new GioHangServer();
        g1.setSdt("0357656668");
        g1.setDonHang("Iphone XS Max - Số lượng: 1c");
        g1.setTongTien(39999000);
        g1.setXacNhanDonHang("Đã xác nhận");

        //---------------------------------//

        GioHangServer g2 = new GioHangServer();
        g2.setSdt("0338622820");
        g2.setDonHang("Huawei P30 Pro - Số lượng: 1c");
        g2.setTongTien(22990000);
        g2.setXacNhanDonHang("Đã xác nhận");

        //---------------------------------//
        long checkDl = AppDatabaseGioHang.getInstance().getDHDatabase().getGioHangServerDao().getDHCount();
        if (checkDl == 0) {
            AppDatabaseGioHang.getInstance().getDHDatabase().getGioHangServerDao().inputGioHang(g1);
            AppDatabaseGioHang.getInstance().getDHDatabase().getGioHangServerDao().inputGioHang(g2);

        }
    }

    private void putDataPhone() {
        Phone p1 = new Phone();
        p1.setAnhId(R.drawable.iphonexsmax);
        p1.setTen("Iphone XS Max");
        p1.setGia(39999000);
        p1.setCameraTruoc("7MP");
        p1.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p1.setManHinh("OLED, 6.5");
        p1.setHeDieuHanh("iOS 12");
        p1.setCpu("Hisilicon Kirin 980 8 nhân 64-bit");
        p1.setBoNhoTrong("512 GB");
        p1.setRam("4 GB");
        p1.setCauHinhPhanCung("Apple Pay +Chuẩn Kháng nước, Chuẩn kháng bụi + 3D Touch + Sạc pin nhanh");
        p1.setTheSim("Nano SIM & eSIM");
        p1.setDungLuongPin("3174 mAh, có sạc nhanh");
        p1.setBaoHanh("12 Tháng");
        p1.setHangSx("Iphone");
        p1.setSoLuong(20);
        p1.setTrangThai("Hot");

        //----------------------//
        Phone p2 = new Phone();
        p2.setAnhId(R.drawable.iphonexs);
        p2.setTen("Iphone X Max");
        p2.setGia(32990000);
        p2.setCameraTruoc("7MP");
        p2.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p2.setManHinh("OLED 1125 x 2436 Pixels");
        p2.setHeDieuHanh("iOS 12");
        p2.setCpu("Apple A12 Bionic 6 nhân");
        p2.setBoNhoTrong("256 GB");
        p2.setRam("4 GB");
        p2.setCauHinhPhanCung("Tính năng đặc biệt: Apple Pay + Chuẩn Kháng nước, Chuẩn kháng bụi + 3D Touch + Sạc pin nhanh");
        p2.setTheSim("Nano SIM & eSIM");
        p2.setDungLuongPin("2658 mAh, có sạc nhanh");
        p2.setBaoHanh("12 Tháng");
        p2.setHangSx("Iphone");
        p2.setSoLuong(50);
        p2.setTrangThai("Hot");

        //----------------------//
        Phone p3 = new Phone();
        p3.setAnhId(R.drawable.iphonex);
        p3.setTen("Iphone X");
        p3.setGia(27990000);
        p3.setCameraTruoc("7MP");
        p3.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p3.setManHinh("OLED 1125 x 2436 Pixels");
        p3.setHeDieuHanh("iOS 12");
        p3.setCpu("Apple A11 Bionic 6 nhân");
        p3.setBoNhoTrong("256 GB");
        p3.setRam("3 GB");
        p3.setCauHinhPhanCung("Apple Pay + Chuẩn Kháng nước, Chuẩn kháng bụi + 3D Touch + Sạc pin nhanh");
        p3.setTheSim("1 Nano SIM");
        p3.setDungLuongPin("2716 mAh, có sạc nhanh");
        p3.setBaoHanh("12 Tháng");
        p3.setHangSx("Iphone");
        p3.setSoLuong(50);
        p3.setTrangThai("Hot");

        //----------------------//
        Phone p4 = new Phone();
        p4.setAnhId(R.drawable.iphone8plus);
        p4.setTen("Iphone 8 plus");
        p4.setGia(20990000);
        p4.setCameraTruoc("7MP");
        p4.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p4.setManHinh("LED-backlit IPS LCD, 5.5, Retina HD");
        p4.setHeDieuHanh("iOS 12");
        p4.setCpu("Apple A11 Bionic 6 nhân");
        p4.setBoNhoTrong("64 GB");
        p4.setRam("3 GB");
        p4.setCauHinhPhanCung("Apple Pay + Chuẩn Kháng nước, Chuẩn kháng bụi + 3D Touch + Sạc pin nhanh");
        p4.setTheSim("1 Nano SIM, Hỗ trợ 4G");
        p4.setDungLuongPin("2691 mAh, có sạc nhanh");
        p4.setBaoHanh("12 Tháng");
        p4.setHangSx("Iphone");
        p4.setSoLuong(100);
        p4.setTrangThai("New");

        //----------------------//
        Phone p5 = new Phone();
        p5.setAnhId(R.drawable.iphone8);
        p5.setTen("Iphone 8");
        p5.setGia(16990000);
        p5.setCameraTruoc("7MP");
        p5.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p5.setManHinh("LED-backlit IPS LCD, 5.5\", Retina HD");
        p5.setHeDieuHanh("iOS 12");
        p5.setCpu("Apple A11 Bionic 6 nhân");
        p5.setBoNhoTrong("64 GB");
        p5.setRam("3 GB");
        p5.setCauHinhPhanCung("Apple Pay + Chuẩn Kháng nước, Chuẩn kháng bụi + 3D Touch + Sạc pin nhanh");
        p5.setTheSim("1 Nano SIM, Hỗ trợ 4G");
        p5.setDungLuongPin("2691 mAh, có sạc nhanh");
        p5.setBaoHanh("12 Tháng");
        p5.setHangSx("Iphone");
        p5.setSoLuong(100);
        p5.setTrangThai("New");

        //----------------------//
        Phone p6 = new Phone();
        p6.setAnhId(R.drawable.iphone7plus);
        p6.setTen("Iphone 7 Plus");
        p6.setGia(12990000);
        p6.setCameraTruoc("7MP");
        p6.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p6.setManHinh("LED-backlit IPS LCD, 5.5, Retina HD");
        p6.setHeDieuHanh("iOS 12");
        p6.setCpu("Apple A11 Bionic 6 nhân");
        p6.setBoNhoTrong("64 GB");
        p6.setRam("3 GB");
        p6.setCauHinhPhanCung("Apple Pay + Chuẩn Kháng nước, Chuẩn kháng bụi + 3D Touch + Sạc pin nhanh");
        p6.setTheSim("1 Nano SIM, Hỗ trợ 4G");
        p6.setDungLuongPin("2691 mAh, có sạc nhanh");
        p6.setBaoHanh("12 Tháng");
        p6.setHangSx("Iphone");
        p6.setSoLuong(100);
        p6.setTrangThai("Bt");

        //----------------------//
        Phone p7 = new Phone();
        p7.setAnhId(R.drawable.iphone7);
        p7.setTen("Iphone 7");
        p7.setGia(11990000);
        p7.setCameraTruoc("7MP");
        p7.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p7.setManHinh("LED-backlit IPS LCD, 5.5, Retina HD");
        p7.setHeDieuHanh("iOS 12");
        p7.setCpu("Apple A11 Bionic 6 nhân");
        p7.setBoNhoTrong("64 GB");
        p7.setRam("3 GB");
        p7.setCauHinhPhanCung("Apple Pay + Chuẩn Kháng nước, Chuẩn kháng bụi + 3D Touch + Sạc pin nhanh");
        p7.setTheSim("1 Nano SIM, Hỗ trợ 4G");
        p7.setDungLuongPin("2691 mAh, có sạc nhanh");
        p7.setBaoHanh("12 Tháng");
        p7.setHangSx("Iphone");
        p7.setSoLuong(100);
        p7.setTrangThai("Bt");

        //----------------------//
        Phone p8 = new Phone();
        p8.setAnhId(R.drawable.iphone6s);
        p8.setTen("Iphone 6s");
        p8.setGia(7990000);
        p8.setCameraTruoc("7MP");
        p8.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p8.setManHinh("LED-backlit IPS LCD, 5.5, Retina HD");
        p8.setHeDieuHanh("iOS 12");
        p8.setCpu("Apple A11 Bionic 6 nhân");
        p8.setBoNhoTrong("64 GB");
        p8.setRam("3 GB");
        p8.setCauHinhPhanCung("Apple Pay + Chuẩn Kháng nước, Chuẩn kháng bụi + 3D Touch + Sạc pin nhanh");
        p8.setTheSim("1 Nano SIM, Hỗ trợ 4G");
        p8.setDungLuongPin("2691 mAh, có sạc nhanh");
        p8.setBaoHanh("12 Tháng");
        p8.setHangSx("Iphone");
        p8.setSoLuong(100);
        p8.setTrangThai("Bt");

        //----------------------//
        Phone p9 = new Phone();
        p9.setAnhId(R.drawable.huaweip30pro);
        p9.setTen("Huawei P30 Pro");
        p9.setGia(22990000);
        p9.setCameraTruoc("32 MP");
        p9.setCameraSau("Chính 40 MP & Phụ 20 MP, 8 MP, TOF 3D");
        p9.setManHinh("OLED, 6.47, Full HD+");
        p9.setHeDieuHanh("Android 9.0 (Pie)");
        p9.setCpu("Hisilicon Kirin 980 8 nhân 64-bit");
        p9.setBoNhoTrong("256 GB");
        p9.setRam("8 GB");
        p9.setCauHinhPhanCung("Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Sạc pin nhanh + Cổng hồng ngoại + Máy ảnh kép, ống kính Leica + Mặt kính 2.5D");
        p9.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p9.setDungLuongPin("4200 mAh,, có sạc nhanh");
        p9.setBaoHanh("12 Tháng");
        p9.setHangSx("Huawei");
        p9.setSoLuong(50);
        p9.setTrangThai("Hot");

        //----------------------//
        Phone p10 = new Phone();
        p10.setAnhId(R.drawable.huaweimate20pro);
        p10.setTen("Huawei Mate 20 Pro");
        p10.setGia(21990000);
        p10.setCameraTruoc("24 MP");
        p10.setCameraSau("Chính 40 MP & Phụ 20 MP, 8 MP");
        p10.setManHinh("OLED, 6.39, Quad HD+ (2K+)");
        p10.setHeDieuHanh("Android 9.0 (Pie)");
        p10.setCpu("Hisilicon Kirin 980 8 nhân 64-bit");
        p10.setBoNhoTrong("128 GB");
        p10.setRam("6 GB");
        p10.setCauHinhPhanCung("Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Sạc pin nhanh + Cổng hồng ngoại + Máy ảnh kép, ống kính Leica + Mặt kính 2.5D");
        p10.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p10.setDungLuongPin("4200 mAh,, có sạc nhanh");
        p10.setBaoHanh("12 Tháng");
        p10.setHangSx("Huawei");
        p10.setSoLuong(50);
        p10.setTrangThai("Hot");

        //----------------------//
        Phone p11 = new Phone();
        p11.setAnhId(R.drawable.huaweip30blue);
        p11.setTen("Huawei P30");
        p11.setGia(16990000);
        p11.setCameraTruoc("32 MP");
        p11.setCameraSau("Chính 40 MP & Phụ 16 MP, 8 MP");
        p11.setManHinh("OLED, 6.39, Quad HD+ (2K+)");
        p11.setHeDieuHanh("Android 9.0 (Pie)");
        p11.setCpu("Hisilicon Kirin 980 8 nhân 64-bit");
        p11.setBoNhoTrong("128 GB");
        p11.setRam("8 GB");
        p11.setCauHinhPhanCung("Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Sạc pin nhanh + Cổng hồng ngoại + Máy ảnh kép, ống kính Leica + Mặt kính 2.5D");
        p11.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p11.setDungLuongPin("3650 mAh,, có sạc nhanh");
        p11.setBaoHanh("12 Tháng");
        p11.setHangSx("Huawei");
        p11.setSoLuong(50);
        p11.setTrangThai("Hot");

        //----------------------//
        Phone p12 = new Phone();
        p12.setAnhId(R.drawable.huaweimate20);
        p12.setTen("Huawei Mate 20");
        p12.setGia(13990000);
        p12.setCameraTruoc("24 MP");
        p12.setCameraSau("Chính 12 MP & Phụ 16 MP, 8 MP");
        p12.setManHinh("IPS LCD, 6.5, Full HD+");
        p12.setHeDieuHanh("Android 9.0 (Pie)");
        p12.setCpu("Hisilicon Kirin 980 8 nhân 64-bit");
        p12.setBoNhoTrong("128 GB");
        p12.setRam("6 GB");
        p12.setCauHinhPhanCung("Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Sạc pin nhanh + Cổng hồng ngoại + Máy ảnh kép, ống kính Leica + Mặt kính 2.5D");
        p12.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p12.setDungLuongPin("4000 mAh,, có sạc nhanh");
        p12.setBaoHanh("12 Tháng");
        p12.setHangSx("Huawei");
        p12.setSoLuong(100);
        p12.setTrangThai("New");

        //----------------------//
        Phone p13 = new Phone();
        p13.setAnhId(R.drawable.huaweip30lite);
        p13.setTen("Huawei P30 Lite");
        p13.setGia(7490000);
        p13.setCameraTruoc("32 MP");
        p13.setCameraSau("Chính 24 MP & Phụ 8 MP, 2 MP");
        p13.setManHinh("IPS LCD, 6.15, Full HD+");
        p13.setHeDieuHanh("Android 9.0 (Pie)");
        p13.setCpu("Hisilicon Kirin 980 8 nhân 64-bit");
        p13.setBoNhoTrong("128 GB");
        p13.setRam("6 GB");
        p13.setCauHinhPhanCung("Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Sạc pin nhanh + Cổng hồng ngoại + Máy ảnh kép, ống kính Leica + Mặt kính 2.5D");
        p13.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p13.setDungLuongPin("3340 mAh, có sạc nhanh");
        p13.setBaoHanh("12 Tháng");
        p13.setHangSx("Huawei");
        p13.setSoLuong(100);
        p13.setTrangThai("New");

        //----------------------//
        Phone p14 = new Phone();
        p14.setAnhId(R.drawable.huaweinova3i);
        p14.setTen("Huawei Nova 3i");
        p14.setGia(5990000);
        p14.setCameraTruoc("Chính 24 MP & Phụ 2 MP");
        p14.setCameraSau("Chính 16 MP & Phụ 2 MP");
        p14.setManHinh("IPS LCD, 6.3, Full HD+");
        p14.setHeDieuHanh("Android 8.1 (Oreo)");
        p14.setCpu("HiSilicon Kirin 710");
        p14.setBoNhoTrong("64 GB");
        p14.setRam("4 GB");
        p14.setCauHinhPhanCung("Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Sạc pin nhanh + Cổng hồng ngoại + Máy ảnh kép, ống kính Leica + Mặt kính 2.5D");
        p14.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p14.setDungLuongPin("3340 mAh,, có sạc nhanh");
        p14.setBaoHanh("12 Tháng");
        p14.setHangSx("Huawei");
        p14.setSoLuong(100);
        p14.setTrangThai("Bt");

        //----------------------//
        Phone p15 = new Phone();
        p15.setAnhId(R.drawable.huaweiy9);
        p15.setTen("Huawei Y9");
        p15.setGia(5490000);
        p15.setCameraTruoc("Chính 16 MP & Phụ 2 MP");
        p15.setCameraSau("Chính 13 MP & Phụ 2 MP");
        p15.setManHinh("IPS LCD, 6.5, Full HD+");
        p15.setHeDieuHanh("Android 8.1 (Oreo)");
        p15.setCpu("HiSilicon Kirin 710");
        p15.setBoNhoTrong("64 GB");
        p15.setRam("4 GB");
        p15.setCauHinhPhanCung("Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Sạc pin nhanh + Cổng hồng ngoại + Máy ảnh kép, ống kính Leica + Mặt kính 2.5D");
        p15.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p15.setDungLuongPin("4000 mAh, có sạc nhanh");
        p15.setBaoHanh("12 Tháng");
        p15.setHangSx("Huawei");
        p15.setSoLuong(100);
        p15.setTrangThai("Bt");

        //----------------------//
        Phone p16 = new Phone();
        p16.setAnhId(R.drawable.huaweiy7pro);
        p16.setTen("Huawei Y7 Pro");
        p16.setGia(3990000);
        p16.setCameraTruoc("Chính 16 MP ");
        p16.setCameraSau("Chính 13 MP & Phụ 2 MP");
        p16.setManHinh("IPS LCD, 6.26, Full HD+");
        p16.setHeDieuHanh("Android 8.1 (Oreo)");
        p16.setCpu("Qualcomm Snapdragon 450 8 nhân 64-bit");
        p16.setBoNhoTrong("32 GB");
        p16.setRam("3 GB");
        p16.setCauHinhPhanCung("Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Sạc pin nhanh + Cổng hồng ngoại + Máy ảnh kép, ống kính Leica + Mặt kính 2.5D");
        p16.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p16.setDungLuongPin("4000 mAh, có sạc nhanh");
        p16.setBaoHanh("12 Tháng");
        p16.setHangSx("Huawei");
        p16.setSoLuong(100);
        p16.setTrangThai("Bt");

        //----------------------//
        Phone p17 = new Phone();
        p17.setAnhId(R.drawable.oppofindx);
        p17.setTen("OPPO Find X");
        p17.setGia(19990000);
        p17.setCameraTruoc("25 MP");
        p17.setCameraSau("Chính 16 MP & Phụ 20 MP");
        p17.setManHinh("AMOLED, 6.42, Full HD+");
        p17.setHeDieuHanh("Android 8.1 (Oreo)");
        p17.setCpu("Snapdragon 845 8 nhân");
        p17.setBoNhoTrong("256 GB");
        p17.setRam("8 GB");
        p17.setCauHinhPhanCung("Mặt kính 2.5D + Chặn tin nhắn + Chặn cuộc gọi + Sạc pin nhanh + Đèn pin");
        p17.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p17.setDungLuongPin("3730 mAh, có sạc nhanh");
        p17.setBaoHanh("12 Tháng");
        p17.setHangSx("Oppo");
        p17.setSoLuong(50);
        p17.setTrangThai("Hot");

        //----------------------//
        Phone p18 = new Phone();
        p18.setAnhId(R.drawable.oppor17pro);
        p18.setTen("OPPO R17 Pro");
        p18.setGia(15990000);
        p18.setCameraTruoc("25 MP");
        p18.setCameraSau("Chính 12 MP & Phụ 20 MP, TOF 3D");
        p18.setManHinh("AMOLED, 6.4, Full HD+");
        p18.setHeDieuHanh("Android 8.1 (Oreo)");
        p18.setCpu("Snapdragon 710 8 nhân 64-bit");
        p18.setBoNhoTrong("128 GB");
        p18.setRam("8 GB");
        p18.setCauHinhPhanCung("Mặt kính 2.5D + Chặn tin nhắn + Chặn cuộc gọi + Sạc pin nhanh + Đèn pin");
        p18.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p18.setDungLuongPin("3700 mAh, có sạc nhanh");
        p18.setBaoHanh("12 Tháng");
        p18.setHangSx("Oppo");
        p18.setSoLuong(50);
        p18.setTrangThai("Hot");

        //----------------------//
        Phone p19 = new Phone();
        p19.setAnhId(R.drawable.oppof11pro);
        p19.setTen("OPPO F11 Pro");
        p19.setGia(8490000);
        p19.setCameraTruoc("16 MP");
        p19.setCameraSau("Chính 48 MP & Phụ 5 MP");
        p19.setManHinh("LTPS LCD, 6.5, Full HD+");
        p19.setHeDieuHanh("Android 9.0 (Pie)");
        p19.setCpu("MediaTek Helio P70 8 nhân");
        p19.setBoNhoTrong("64 GB");
        p19.setRam("6 GB");
        p19.setCauHinhPhanCung("Mặt kính 2.5D + Chặn tin nhắn + Chặn cuộc gọi + Sạc pin nhanh + Đèn pin");
        p19.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p19.setDungLuongPin("4000 mAh, có sạc nhanh");
        p19.setBaoHanh("12 Tháng");
        p19.setHangSx("Oppo");
        p19.setSoLuong(50);
        p19.setTrangThai("Hot");

        //----------------------//
        Phone p20 = new Phone();
        p20.setAnhId(R.drawable.oppof9);
        p20.setTen("OPPO F9");
        p20.setGia(8490000);
        p20.setCameraTruoc("25 MP");
        p20.setCameraSau("16 MP");
        p20.setManHinh("LTPS LCD, 6.3, Full HD+");
        p20.setHeDieuHanh("Android 8.1 (Oreo)");
        p20.setCpu("MediaTek Helio P60 8 nhân 64-bit");
        p20.setBoNhoTrong("64 GB");
        p20.setRam("6 GB");
        p20.setCauHinhPhanCung("Mặt kính 2.5D + Chặn tin nhắn + Chặn cuộc gọi + Sạc pin nhanh + Đèn pin");
        p20.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p20.setDungLuongPin("3500 mAh,, có sạc nhanh");
        p20.setBaoHanh("12 Tháng");
        p20.setHangSx("Oppo");
        p20.setSoLuong(100);
        p20.setTrangThai("New");

        //----------------------//
        Phone p21 = new Phone();
        p21.setAnhId(R.drawable.oppof7);
        p21.setTen("OPPO F7");
        p21.setGia(5490000);
        p21.setCameraTruoc("25 MP");
        p21.setCameraSau("16 MP");
        p21.setManHinh("LTPS LCD, 6.23, Full HD+");
        p21.setHeDieuHanh("Android 8.1 (Oreo)");
        p21.setCpu("MediaTek Helio P60 8 nhân 64-bit");
        p21.setBoNhoTrong("64 GB");
        p21.setRam("4 GB");
        p21.setCauHinhPhanCung("Mặt kính 2.5D + Chặn tin nhắn + Chặn cuộc gọi + Sạc pin nhanh + Đèn pin");
        p21.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p21.setDungLuongPin("3400 mAh,, có sạc nhanh");
        p21.setBaoHanh("12 Tháng");
        p21.setHangSx("Oppo");
        p21.setSoLuong(100);
        p21.setTrangThai("New");

        //----------------------//
        Phone p22 = new Phone();
        p22.setAnhId(R.drawable.oppoa7);
        p22.setTen("OPPO A7");
        p22.setGia(5490000);
        p22.setCameraTruoc("16 MP");
        p22.setCameraSau("Chính 13 MP & Phụ 2 MP");
        p22.setManHinh("LTPS LCD, 6.2, Full HD+");
        p22.setHeDieuHanh("Android 8.1 (Oreo)");
        p22.setCpu("MediaTek Helio P60 8 nhân 64-bit");
        p22.setBoNhoTrong("64 GB");
        p22.setRam("4 GB");
        p22.setCauHinhPhanCung("Mặt kính 2.5D + Chặn tin nhắn + Chặn cuộc gọi + Sạc pin nhanh + Đèn pin");
        p22.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p22.setDungLuongPin("4230 mAh, có sạc nhanh");
        p22.setBaoHanh("12 Tháng");
        p22.setHangSx("Oppo");
        p22.setSoLuong(100);
        p22.setTrangThai("Bt");

        //----------------------//
        Phone p23 = new Phone();
        p23.setAnhId(R.drawable.oppoa3s);
        p23.setTen("OPPO A3S");
        p23.setGia(4090000);
        p23.setCameraTruoc("8 MP");
        p23.setCameraSau("Chính 13 MP & Phụ 2 MP");
        p23.setManHinh("LTPS LCD, 6.2, Full HD+");
        p23.setHeDieuHanh("Android 8.1 (Oreo)");
        p23.setCpu("Qualcomm Snapdragon 450 8 nhân 64-bit");
        p23.setBoNhoTrong("32 GB");
        p23.setRam("3 GB");
        p23.setCauHinhPhanCung("Mặt kính 2.5D + Chặn tin nhắn + Chặn cuộc gọi + Sạc pin nhanh + Đèn pin");
        p23.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p23.setDungLuongPin("4230 mAh, có sạc nhanh");
        p23.setBaoHanh("12 Tháng");
        p23.setHangSx("Oppo");
        p23.setSoLuong(100);
        p23.setTrangThai("Bt");

        //----------------------//
        Phone p24 = new Phone();
        p24.setAnhId(R.drawable.galaxys10plus);
        p24.setTen("Galaxy S10 Plus");
        p24.setGia(28990000);
        p24.setCameraTruoc("Chính 10 MP & Phụ 8 MP");
        p24.setCameraSau("Chính 12 MP & Phụ 12 MP, 16 MP");
        p24.setManHinh("Dynamic AMOLED, 6.4, Quad HD+ (2K+)");
        p24.setHeDieuHanh("Android 9.0 (Pie)");
        p24.setCpu("Exynos 9820 8 nhân 64-bit");
        p24.setBoNhoTrong("512 GB");
        p24.setRam("8 GB");
        p24.setCauHinhPhanCung("Dolby Audio™ + Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Chạm 2 lần sáng màn hình + Sạc pin nhanh + Chặn cuộc gọi + Ghi âm cuộc gọi + Chặn tin nhắn + Màn hình luôn hiển thị AOD + Samsung DeX + Nhân bản ứng dụng + Samsung Pay + Thu nhỏ màn hình sử dụng một tay + Trợ lý ảo Samsung Bixby");
        p24.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p24.setDungLuongPin("4100 mAh, có sạc nhanh");
        p24.setBaoHanh("12 Tháng");
        p24.setHangSx("SamSung");
        p24.setSoLuong(50);
        p24.setTrangThai("Hot");

        //----------------------//
        Phone p25 = new Phone();
        p25.setAnhId(R.drawable.galaxys10);
        p25.setTen("Galaxy S10");
        p25.setGia(20990000);
        p25.setCameraTruoc("10 MP");
        p25.setCameraSau("Chính 12 MP & Phụ 12 MP, 16 MP");
        p25.setManHinh("Dynamic AMOLED, 6.1, Quad HD+ (2K+)");
        p25.setHeDieuHanh("Android 9.0 (Pie)");
        p25.setCpu("Exynos 9820 8 nhân 64-bit");
        p25.setBoNhoTrong("128 GB");
        p25.setRam("8 GB");
        p25.setCauHinhPhanCung("Dolby Audio™ + Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Chạm 2 lần sáng màn hình + Sạc pin nhanh + Chặn cuộc gọi + Ghi âm cuộc gọi + Chặn tin nhắn + Màn hình luôn hiển thị AOD + Samsung DeX + Nhân bản ứng dụng + Samsung Pay + Thu nhỏ màn hình sử dụng một tay + Trợ lý ảo Samsung Bixby");
        p25.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p25.setDungLuongPin("3400 mAh,, có sạc nhanh");
        p25.setBaoHanh("12 Tháng");
        p25.setHangSx("SamSung");
        p25.setSoLuong(50);
        p25.setTrangThai("Hot");

        //----------------------//
        Phone p26 = new Phone();
        p26.setAnhId(R.drawable.galaxynote9);
        p26.setTen("Galaxy Note 9");
        p26.setGia(18990000);
        p26.setCameraTruoc("8 MP");
        p26.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p26.setManHinh("Super AMOLED, 6.4, Quad HD+ (2K+)");
        p26.setHeDieuHanh("Android 9.0 (Pie)");
        p26.setCpu("Exynos 9820 8 nhân 64-bit");
        p26.setBoNhoTrong("128 GB");
        p26.setRam("6 GB");
        p26.setCauHinhPhanCung("Tính năng đặc biệt: Dolby Audio™ + Chuẩn Kháng nước, Chuẩn kháng bụi + Đèn pin + Chạm 2 lần sáng màn hình + Sạc pin nhanh + Chặn cuộc gọi + Ghi âm cuộc gọi + Chặn tin nhắn + Màn hình luôn hiển thị AOD + Samsung DeX + Nhân bản ứng dụng + Samsung Pay + Thu nhỏ màn hình sử dụng một tay + Trợ lý ảo Samsung Bixby");
        p26.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p26.setDungLuongPin("4000 mAh,, có sạc nhanh");
        p26.setBaoHanh("12 Tháng");
        p26.setHangSx("SamSung");
        p26.setSoLuong(50);
        p26.setTrangThai("New");

        //----------------------//
        Phone p27 = new Phone();
        p27.setAnhId(R.drawable.galaxys9);
        p27.setTen("Galaxy S9");
        p27.setGia(17990000);
        p27.setCameraTruoc("8 MP");
        p27.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p27.setManHinh("Super AMOLED, 6.4, Quad HD+ (2K+)");
        p27.setHeDieuHanh("Android 9.0 (Pie)");
        p27.setCpu("Exynos 9820 8 nhân 64-bit");
        p27.setBoNhoTrong("64 GB");
        p27.setRam("6 GB");
        p27.setCauHinhPhanCung("Tính năng đặc biệt: Chuẩn Kháng nước, Chuẩn kháng bụi +  Sạc pin nhanh + Chặn cuộc gọi + Ghi âm cuộc gọi + Chặn tin nhắn + Màn hình luôn hiển thị AOD + Samsung Pay");
        p27.setTheSim("2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p27.setDungLuongPin("3500 mAh, có sạc nhanh");
        p27.setBaoHanh("12 Tháng");
        p27.setHangSx("SamSung");
        p27.setSoLuong(50);
        p27.setTrangThai("New");

        //----------------------//
        Phone p28 = new Phone();
        p28.setAnhId(R.drawable.galaxya8);
        p28.setTen("Galaxy A8");
        p28.setGia(8990000);
        p28.setCameraTruoc("24 MP");
        p28.setCameraSau("Chính 16 MP & Phụ 12 MP");
        p28.setManHinh("Super AMOLED, 6.3, Full HD+");
        p28.setHeDieuHanh("Android 8.0 (Pie)");
        p28.setCpu("Qualcomm Snapdragon 660 8 nhân");
        p28.setBoNhoTrong("64 GB");
        p28.setRam("6 GB");
        p28.setCauHinhPhanCung("Tính năng đặc biệt: Chuẩn Kháng nước, Chuẩn kháng bụi + Sạc pin nhanh + Chặn cuộc gọi + Ghi âm cuộc gọi + Chặn tin nhắn + Màn hình luôn hiển thị AOD + Samsung Pay");
        p28.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p28.setDungLuongPin("3700 mAh, có sạc nhanh");
        p28.setBaoHanh("12 Tháng");
        p28.setHangSx("SamSung");
        p28.setSoLuong(50);
        p28.setTrangThai("New");

        //----------------------//
        Phone p29 = new Phone();
        p29.setAnhId(R.drawable.galaxya70);
        p29.setTen("Galaxy A70");
        p29.setGia(9290000);
        p29.setCameraTruoc("32 MP");
        p29.setCameraSau("Chính 32 MP & Phụ 8 MP, 5 MP");
        p29.setManHinh("Super AMOLED, 6.7, Full HD+");
        p29.setHeDieuHanh("Android 9.0 (Pie)");
        p29.setCpu("Snapdragon 675 8 nhân 64-bit");
        p29.setBoNhoTrong("128 GB");
        p29.setRam("6 GB");
        p29.setCauHinhPhanCung("Tính năng đặc biệt: Chuẩn Kháng nước, Chuẩn kháng bụi + Sạc pin nhanh + Chặn cuộc gọi + Ghi âm cuộc gọi + Chặn tin nhắn + Màn hình luôn hiển thị AOD + Samsung Pay");
        p29.setTheSim("2 Nano SIM, Hỗ trợ 4G");
        p29.setDungLuongPin("4500 mAh, có sạc nhanh");
        p29.setBaoHanh("12 Tháng");
        p29.setHangSx("SamSung");
        p29.setSoLuong(100);
        p29.setTrangThai("Bt");

        //----------------------//
        Phone p30 = new Phone();
        p30.setAnhId(R.drawable.galaxya7);
        p30.setTen("Galaxy A7");
        p30.setGia(6490000);
        p30.setCameraTruoc("24 MP");
        p30.setCameraSau("Chính 24 MP & Phụ 8 MP, 5 MP");
        p30.setManHinh("Màn hình: Super AMOLED, 6.7, Full HD+");
        p30.setHeDieuHanh("Hệ điều hành: Android 9.0 (Pie)");
        p30.setCpu("CPU: Exynos 7885 8 nhân 64-bit");
        p30.setBoNhoTrong("Bộ nhớ trong: 128 GB");
        p30.setRam("RAM: 6 GB");
        p30.setCauHinhPhanCung("Tính năng đặc biệt: Chuẩn Kháng nước, Chuẩn kháng bụi + Sạc pin nhanh + Chặn cuộc gọi + Ghi âm cuộc gọi + Chặn tin nhắn + Màn hình luôn hiển thị AOD + Samsung Pay");
        p30.setTheSim("SIM: 2 Nano SIM, Hỗ trợ 4G");
        p30.setDungLuongPin("Dung lượng pin: 3300 mAh, có sạc nhanh");
        p30.setBaoHanh("Bảo hành: 12 Tháng");
        p30.setHangSx("SamSung");
        p30.setSoLuong(100);
        p30.setTrangThai("Bt");

        //----------------------//
        Phone p31 = new Phone();
        p31.setAnhId(R.drawable.galaxya50);
        p31.setTen("Galaxy A50");
        p31.setGia(7990000);
        p31.setCameraTruoc("25 MP");
        p31.setCameraSau("Chính 25 MP & Phụ 8 MP, 5 MP");
        p31.setManHinh("Màn hình: Super AMOLED, 6.4, Full HD+");
        p31.setHeDieuHanh("Hệ điều hành: Android 9.0 (Pie)");
        p31.setCpu("CPU: Exynos 9610 8 nhân 64-bit");
        p31.setBoNhoTrong("Bộ nhớ trong: 128 GB");
        p31.setRam("RAM: 6 GB");
        p31.setCauHinhPhanCung("Tính năng đặc biệt: Chuẩn Kháng nước, Chuẩn kháng bụi + Sạc pin nhanh + Chặn cuộc gọi + Ghi âm cuộc gọi + Chặn tin nhắn + Màn hình luôn hiển thị AOD + Samsung Pay");
        p31.setTheSim("SIM: 2 Nano SIM, Hỗ trợ 4G");
        p31.setDungLuongPin("Dung lượng pin: 3300 mAh,, có sạc nhanh");
        p31.setBaoHanh("Bảo hành: 12 Tháng");
        p31.setHangSx("SamSung");
        p31.setSoLuong(100);
        p31.setTrangThai("Bt");

        //----------------------//
        Phone p32 = new Phone();
        p32.setAnhId(R.drawable.xiaomimi8);
        p32.setTen("Xiaomi Mi 8");
        p32.setGia(11990000);
        p32.setCameraTruoc("20 MP");
        p32.setCameraSau("Chính 12 MP & Phụ 12 MP");
        p32.setManHinh("Màn hình: Super AMOLED, 6.21, Full HD+");
        p32.setHeDieuHanh("Hệ điều hành: Android 8.1 (Oreo)");
        p32.setCpu("CPU:Snapdragon 845 8 nhân");
        p32.setBoNhoTrong("Bộ nhớ trong: 64 GB");
        p32.setRam("RAM: 6 GB");
        p32.setCauHinhPhanCung("Tính năng đặc biệt: Mặt kính 2.5D + Đèn pin");
        p32.setTheSim("SIM: 2 Nano SIM, Hỗ trợ 4G");
        p32.setDungLuongPin("Dung lượng pin: 3400 mAh, có sạc nhanh");
        p32.setBaoHanh("Bảo hành: 12 Tháng");
        p32.setHangSx("Xiaomi");
        p32.setSoLuong(50);
        p32.setTrangThai("Hot");

        //----------------------//
        Phone p33 = new Phone();
        p33.setAnhId(R.drawable.xiaomimi8lite);
        p33.setTen("Xiaomi Mi 8 Lite");
        p33.setGia(6690000);
        p33.setCameraTruoc("24 MP");
        p33.setCameraSau("Chính 12 MP & Phụ 5 MP");
        p33.setManHinh("Màn hình: Super AMOLED, 6.26, Full HD+");
        p33.setHeDieuHanh("Hệ điều hành: Android 8.1 (Oreo)");
        p33.setCpu("CPU:Qualcomm Snapdragon 660 8 nhân");
        p33.setBoNhoTrong("Bộ nhớ trong: 64 GB");
        p33.setRam("RAM: 6 GB");
        p33.setCauHinhPhanCung("Tính năng đặc biệt: Mặt kính 2.5D + Đèn pin");
        p33.setTheSim("SIM: 2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G");
        p33.setDungLuongPin("Dung lượng pin: 3350 mAh, có sạc nhanh");
        p33.setBaoHanh("Bảo hành: 12 Tháng");
        p33.setHangSx("Xiaomi");
        p33.setSoLuong(50);
        p33.setTrangThai("Hot");

        //----------------------//
        Phone p34 = new Phone();
        p34.setAnhId(R.drawable.xiaomia2);
        p34.setTen("Xiaomi Mi A2");
        p34.setGia(5690000);
        p34.setCameraTruoc("20 MP");
        p34.setCameraSau("Chính 12 MP & Phụ 20 MP");
        p34.setManHinh("Màn hình: IPS LCD, 5.99, Full HD+");
        p34.setHeDieuHanh("Hệ điều hành: Android 8.1 (Oreo)");
        p34.setCpu("CPU:Qualcomm Snapdragon 660 8 nhân");
        p34.setBoNhoTrong("Bộ nhớ trong: 64 GB");
        p34.setRam("RAM: 6 GB");
        p34.setCauHinhPhanCung("Tính năng đặc biệt: Mặt kính 2.5D + Đèn pin");
        p34.setTheSim("SIM: 2 Nano SIM, Hỗ trợ 4G");
        p34.setDungLuongPin("Dung lượng pin: 3010 mAh, có sạc nhanh");
        p34.setBaoHanh("Bảo hành: 12 Tháng");
        p34.setHangSx("Xiaomi");
        p34.setSoLuong(100);
        p34.setTrangThai("New");

        //----------------------//
        Phone p35 = new Phone();
        p35.setAnhId(R.drawable.xiaomia2lite);
        p35.setTen("Xiaomi A2Lite");
        p35.setGia(3990000);
        p35.setCameraTruoc("5 MP");
        p35.setCameraSau("Chính 12 MP & Phụ 5 MP");
        p35.setManHinh("Màn hình: IPS LCD, 5.84, Full HD+");
        p35.setHeDieuHanh("Hệ điều hành: Android 8.1 (Oreo)");
        p35.setCpu("CPU:Snapdragon 625 8 nhân 64-bit");
        p35.setBoNhoTrong("Bộ nhớ trong: 32 GB");
        p35.setRam("RAM: 3 GB");
        p35.setCauHinhPhanCung("Tính năng đặc biệt: Mặt kính 2.5D + Đèn pin");
        p35.setTheSim("SIM: 2 Nano SIM, Hỗ trợ 4G");
        p35.setDungLuongPin("Dung lượng pin: 4000 mAh,, có sạc nhanh");
        p35.setBaoHanh("Bảo hành: 12 Tháng");
        p35.setHangSx("Xiaomi");
        p35.setSoLuong(100);
        p35.setTrangThai("New");

        //----------------------//
        Phone p36 = new Phone();
        p36.setAnhId(R.drawable.xiaominot7pro);
        p36.setTen("Redmi Note 7Pro");
        p36.setGia(5790000);
        p36.setCameraTruoc("13 MP");
        p36.setCameraSau("Chính 48 MP & Phụ 5 MP");
        p36.setManHinh("Màn hình: IPS LCD, 6.3, Full HD+");
        p36.setHeDieuHanh("Hệ điều hành: Android 9.0 (Pie)");
        p36.setCpu("CPU:Qualcomm Snapdragon 660 8 nhân");
        p36.setBoNhoTrong("Bộ nhớ trong: 64 GB");
        p36.setRam("RAM: 4 GB");
        p36.setCauHinhPhanCung("Tính năng đặc biệt: Mặt kính 2.5D + Đèn pin");
        p36.setTheSim("SIM: 2 Nano SIM, Hỗ trợ 4G");
        p36.setDungLuongPin("Dung lượng pin: 4000 mAh, có sạc nhanh");
        p36.setBaoHanh("Bảo hành: 12 Tháng");
        p36.setHangSx("Xiaomi");
        p36.setSoLuong(100);
        p36.setTrangThai("Bt");

        //----------------------//
        Phone p37 = new Phone();
        p37.setAnhId(R.drawable.xiaominot7);
        p37.setTen("Redmi Note 7");
        p37.setGia(4990000);
        p37.setCameraTruoc("13 MP");
        p37.setCameraSau("Chính 48 MP & Phụ 5 MP");
        p37.setManHinh("Màn hình: Super AMOLED, 6.21, Full HD+");
        p37.setHeDieuHanh("Hệ điều hành: Android 8.1 (Oreo)");
        p37.setCpu("CPU:Qualcomm Snapdragon 660 8 nhân");
        p37.setBoNhoTrong("Bộ nhớ trong: 64 GB");
        p37.setRam("RAM: 4 GB");
        p37.setCauHinhPhanCung("Tính năng đặc biệt: Mặt kính 2.5D + Đèn pin");
        p37.setTheSim("SIM: 2 Nano SIM, Hỗ trợ 4G");
        p37.setDungLuongPin("Dung lượng pin: 3400 mAh, có sạc nhanh");
        p37.setBaoHanh("Bảo hành: 12 Tháng");
        p37.setHangSx("Xiaomi");
        p37.setSoLuong(100);
        p37.setTrangThai("Bt");

        //----------------------//
        Phone p38 = new Phone();
        p38.setAnhId(R.drawable.xiaominot6pro);
        p38.setTen("Redmi Note 6Pro");
        p38.setGia(5690000);
        p38.setCameraTruoc("Chính 20 MP & Phụ 2 MP");
        p38.setCameraSau("Chính 12 MP & Phụ 5 MP");
        p38.setManHinh("Màn hình: Super AMOLED, 6.26, Full HD+");
        p38.setHeDieuHanh("Hệ điều hành: Android 8.1 (Oreo)");
        p38.setCpu("CPU:Qualcomm Snapdragon 636 8 nhân 64-bit");
        p38.setBoNhoTrong("Bộ nhớ trong: 64 GB");
        p38.setRam("RAM: 4 GB");
        p38.setCauHinhPhanCung("Tính năng đặc biệt: Mặt kính 2.5D + Đèn pin");
        p38.setTheSim("SIM: 2 Nano SIM, Hỗ trợ 4G");
        p38.setDungLuongPin("Dung lượng pin: 4000 mAh, có sạc nhanh");
        p38.setBaoHanh("Bảo hành: 12 Tháng");
        p38.setHangSx("Xiaomi");
        p38.setSoLuong(100);
        p38.setTrangThai("Bt");


        long check = AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().getCount();
        if (check == 0) {
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p1);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p2);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p3);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p4);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p5);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p6);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p7);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p8);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p9);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p10);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p11);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p12);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p13);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p14);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p15);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p16);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p17);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p18);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p19);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p20);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p21);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p22);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p23);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p24);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p25);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p26);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p27);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p28);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p29);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p30);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p31);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p32);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p33);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p34);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p35);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p36);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p37);
            AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().putDataIn(p38);

            Log.d(TAG, "Save success.");
        }

    }
}
