package com.example.appshopdidong.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appshopdidong.R;
import com.example.appshopdidong.database.AppDatabasePhone;
import com.example.appshopdidong.database.entity.Phone;
import com.example.appshopdidong.model.GioHang;
import com.example.appshopdidong.view.MainActivity;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThongTinChiTietFragment extends Fragment {

    public final String TAG = "ThongTinChiTietFragment";

    private ImageView imgAnhCT;
    private TextView txtTendtCT;
    private TextView txtGiadtCT;
    /*private TextView txtThongTindtCT;
    private Button btnGioHang;*/

    private TextView txtCamtruoc;
    private TextView txtCamsau;
    private TextView txtScreen;
    private TextView txtHeDieuHanh;
    private TextView txtCpu;
    private TextView txtInternalMemory;
    private TextView txtRAM;
    private TextView txtCauHinhPhanCung;
    private TextView txtSim;
    private TextView txtDungLuongPin;
    private TextView txtBaoHanh;
    private Spinner spinnerSoLuong;

    private Button btnGioHang;

    private int imageId;
    private String id;
    private String tendt;
    private int price;
    int soLuong;
    private Phone phone;

    public ThongTinChiTietFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thong_tin_chi_tiet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgAnhCT = view.findViewById(R.id.imgAnhCT);
        txtTendtCT = view.findViewById(R.id.txtTendtCT);
        txtGiadtCT = view.findViewById(R.id.txtGiadtCT);
        txtCamtruoc = view.findViewById(R.id.txtCameraTruocInformation);
        txtCamsau = view.findViewById(R.id.txtCameraSauInformation);
        txtScreen = view.findViewById(R.id.txtScreenInformation);
        txtHeDieuHanh = view.findViewById(R.id.txtHeDieuHanhInformation);
        txtCpu = view.findViewById(R.id.txtcpuInformation);
        txtInternalMemory = view.findViewById(R.id.txtInternalMemoryInformation);
        txtRAM = view.findViewById(R.id.txtRamInformation);
        txtCauHinhPhanCung = view.findViewById(R.id.txtCauHinhPhanCungInformation);
        txtSim = view.findViewById(R.id.txttheSimInformation);
        txtDungLuongPin = view.findViewById(R.id.txtDungLuongPinInformation);
        txtBaoHanh = view.findViewById(R.id.txtBaoHanhInformation);
        btnGioHang = view.findViewById(R.id.btnThemGioHang);

        spinnerSoLuong = view.findViewById(R.id.spinnerSoLuong);

        spinnerSoLuong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                soLuong = Integer.parseInt(spinnerSoLuong.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:... " + tendt + "..." + soLuong + "..." + price);
                Boolean themMoi = false;
                if (MainActivity.mangGioHang.size() > 0) {
                    for (int i = 0; i < MainActivity.mangGioHang.size(); i++) {
                        if (MainActivity.mangGioHang.get(i).getHinhSP() == imageId) {
                            themMoi = true;
                            MainActivity.mangGioHang.get(i).setSoLuong(MainActivity.mangGioHang.get(i).getSoLuong() + soLuong);
                        }
                    }
                    if (!themMoi) {
                        MainActivity.mangGioHang.add(new GioHang(id, tendt, price, imageId, soLuong));
                    }
                } else {
                    MainActivity.mangGioHang.add(new GioHang(id, tendt, price, imageId, soLuong));
                }
            }
        });

        loadDataThongTinChiTiet();
        evenSpinner();
    }

    private void evenSpinner() {
        Integer[] soLuongs = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, soLuongs);
        spinnerSoLuong.setAdapter(arrayAdapter);
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    private void loadDataThongTinChiTiet() {
        Bundle bundle = getArguments();
        if(bundle != null){
            String getIdDt =bundle.getString("idPhone"," ");
            phone = AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().getOnePhone(getIdDt);
        }
        id = phone.getId();
        tendt = phone.getTen();
        price = phone.getGia();
        imageId = phone.getAnhId();
        imgAnhCT.setImageResource(imageId);
        txtTendtCT.setText(phone.getTen());
        int gia = phone.getGia();
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGiadtCT.setText(decimalFormat.format(gia)+" đ");

        txtCamtruoc.setText("Camera trước: " + phone.getCameraTruoc());
        txtCamsau.setText("Camera sau: " + phone.getCameraSau());
        txtScreen.setText("Màn hình: " + phone.getManHinh());
        txtHeDieuHanh.setText("Hệ điều hành: " + phone.getHeDieuHanh());
        txtCpu.setText("CPU: " + phone.getCpu());
        txtInternalMemory.setText("Bộ nhớ trong: " + phone.getBoNhoTrong());
        txtRAM.setText("RAM: " + phone.getRam());
        txtCauHinhPhanCung.setText("Cấu hình phần cứng: " + phone.getCauHinhPhanCung());
        txtSim.setText("Thẻ sim: " + phone.getTheSim());
        txtDungLuongPin.setText("Dung lượng pin: " + phone.getDungLuongPin());
        txtBaoHanh.setText("Bảo hành: " + phone.getBaoHanh());
    }
}
