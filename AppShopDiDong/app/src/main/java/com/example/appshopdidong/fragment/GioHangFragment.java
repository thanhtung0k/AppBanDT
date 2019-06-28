package com.example.appshopdidong.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appshopdidong.R;
import com.example.appshopdidong.adapter.GioHangAdapter;
import com.example.appshopdidong.database.AppDatabaseGioHang;
import com.example.appshopdidong.database.entity.GioHangServer;
import com.example.appshopdidong.view.MainActivity;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class GioHangFragment extends Fragment {
    public static final String TAG = "GioHangFragment";
    public static ListView lvGioHang;
    public static TextView txtThongBaoGioHang;
    static TextView txtTongTien;
    private Button btnDatHang;
    static GioHangAdapter gioHangAdapter;
    private TextView txtSdtDatHang;
    private EditText edtSdtDatHang;

    public GioHangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gio_hang, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        lvGioHang = view.findViewById(R.id.lvGioHang);
        txtThongBaoGioHang = view.findViewById(R.id.txtThongBaoGioHang);
        txtTongTien = view.findViewById(R.id.txtTongTien);
        btnDatHang = view.findViewById(R.id.btnDatHang);
        txtSdtDatHang = view.findViewById(R.id.txtSdtDatHang);
        edtSdtDatHang = view.findViewById(R.id.edtSdtDatHang);


        gioHangAdapter = new GioHangAdapter(this.getContext(), MainActivity.mangGioHang);
        lvGioHang.setAdapter(gioHangAdapter);
        checkDataGioHang();
        EvenUntil();

        if (MainActivity.sdtKhachHang != null) {
            txtSdtDatHang.setText("Số điện thoại đặt hàng: " + MainActivity.sdtKhachHang);
        }

        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String noiDungDonHangMoi = "";

                for (int i = 0; i < MainActivity.mangGioHang.size(); i++) {
                    if (!noiDungDonHangMoi.equals("")) {
                        noiDungDonHangMoi = noiDungDonHangMoi + ", ";
                    }
                    noiDungDonHangMoi = noiDungDonHangMoi + MainActivity.mangGioHang.get(i).tenSp + " - Số lượng: " + MainActivity.mangGioHang.get(i).soLuong + "c";
                }

                if (txtSdtDatHang.getText().equals("") && edtSdtDatHang.getText().toString().equals("")) {
                    //khi chưa có sđt và mà có edt
                    Toast.makeText(getContext(), "Vui lòng nhập sđt trước khi đặt hàng", Toast.LENGTH_SHORT).show();
                } else if (txtSdtDatHang.getText().equals("") && !edtSdtDatHang.getText().toString().equals("")) {
                    //khi chưa có sđt và có edt
                    MainActivity.sdtKhachHang = edtSdtDatHang.getText().toString();
                    MainActivity.noiDungDonHang = noiDungDonHangMoi;

                    GioHangServer donHangMoi = new GioHangServer();
                    donHangMoi.setSdt(edtSdtDatHang.getText().toString());
                    donHangMoi.setDonHang(noiDungDonHangMoi);
                    donHangMoi.setTongTien(EvenUntil());
                    donHangMoi.setXacNhanDonHang("Chưa xác nhận");

                    AppDatabaseGioHang.getInstance().getDHDatabase().getGioHangServerDao().inputGioHang(donHangMoi);

                    Toast.makeText(getContext(), "Đặt hàng thành công! Shop sẽ liên hệ lại để xác nhận đơn hàng.", Toast.LENGTH_SHORT).show();

                    txtSdtDatHang.setText("Số điện thoại đặt hàng: " + edtSdtDatHang.getText().toString());
                    edtSdtDatHang.setText(null);

                } else if (!txtSdtDatHang.getText().equals("") && edtSdtDatHang.getText().toString().equals("")) {
                    //Khi có sđt và không có edt
                    if (MainActivity.noiDungDonHang.equals(noiDungDonHangMoi)) {
                        Toast.makeText(getContext(), "Đơn hàng không thay đổi!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        MainActivity.noiDungDonHang = noiDungDonHangMoi;

                        GioHangServer donHangUpDate = AppDatabaseGioHang.getInstance().getDHDatabase().getGioHangServerDao().getOneDonHang(MainActivity.sdtKhachHang);
                        donHangUpDate.setDonHang(noiDungDonHangMoi);
                        donHangUpDate.setTongTien(EvenUntil());
                        AppDatabaseGioHang.getInstance().getDHDatabase().getGioHangServerDao().updateGioHang(donHangUpDate);
                        Toast.makeText(getContext(), "Update Đơn hàng thành công!!!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    String sdtMoi = edtSdtDatHang.getText().toString();
                    if (MainActivity.sdtKhachHang.equals(sdtMoi)) {
                        Toast.makeText(getContext(), "Số điện thoại trùng khớp!!!", Toast.LENGTH_SHORT).show();
                        edtSdtDatHang.setText(null);
                    } else {
                        GioHangServer donHangUpDate = new GioHangServer();
                        donHangUpDate.setSdt(edtSdtDatHang.getText().toString());
                        donHangUpDate.setDonHang(noiDungDonHangMoi);
                        donHangUpDate.setTongTien(EvenUntil());
                        donHangUpDate.setXacNhanDonHang("Chưa xác nhận");
                        donHangUpDate.setGhiChu("Được thay đổi từ đơn hàng: " + MainActivity.sdtKhachHang);
                        AppDatabaseGioHang.getInstance().getDHDatabase().getGioHangServerDao().inputGioHang(donHangUpDate);

                        if (MainActivity.noiDungDonHang.equals(noiDungDonHangMoi)) {
                            Toast.makeText(getContext(), "Đã thay đổi số điện thoại!!! Shop sẽ liên hệ lại để xác nhận đơn hàng!", Toast.LENGTH_LONG).show();
                        } else {
                            MainActivity.noiDungDonHang = noiDungDonHangMoi;
                            Toast.makeText(getContext(), "Đã thay đổi số điện thoại và đơn hàng!!! Shop sẽ liên hệ lại để xác nhận!", Toast.LENGTH_LONG).show();
                        }

                        txtSdtDatHang.setText("Số điện thoại đặt hàng: " + edtSdtDatHang.getText().toString());
                        edtSdtDatHang.setText(null);
                    }
                }
            }

        });
    }

    @SuppressLint("SetTextI18n")
    public static int EvenUntil() {
        int tongTien = 0;

        for (int i = 0; i < MainActivity.mangGioHang.size(); i++) {
            int soLuong = MainActivity.mangGioHang.get(i).getSoLuong();
            if (soLuong > 20) {
                soLuong = 20;
                MainActivity.mangGioHang.get(i).setSoLuong(20);
            }
            int giaSp = MainActivity.mangGioHang.get(i).getGiaSp();
            int thanhTien = soLuong * giaSp;
            tongTien += thanhTien;
            checkDataGioHang();

        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTongTien.setText(decimalFormat.format(tongTien) + " Đ");
        return tongTien;
    }

    private static void checkDataGioHang() {
        if (MainActivity.mangGioHang.size() <= 0) {
            gioHangAdapter.notifyDataSetChanged();
            txtThongBaoGioHang.setVisibility(View.VISIBLE);
            lvGioHang.setVisibility(View.INVISIBLE);
        } else {
            gioHangAdapter.notifyDataSetChanged();
            txtThongBaoGioHang.setVisibility(View.INVISIBLE);
            lvGioHang.setVisibility(View.VISIBLE);
        }
    }
}
