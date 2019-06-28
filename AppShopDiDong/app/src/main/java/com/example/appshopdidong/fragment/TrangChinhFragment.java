package com.example.appshopdidong.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.example.appshopdidong.R;
import com.example.appshopdidong.adapter.HangdtAdapter;
import com.example.appshopdidong.adapter.PhoneAdaper;
import com.example.appshopdidong.database.AppDatabasePhone;
import com.example.appshopdidong.database.entity.Phone;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChinhFragment extends Fragment {

    private final String TAG = "TrangChinhFragment";

    private List<Phone> listphones;
    private List<String> listHangdts;

    private RecyclerView rcvPhone;
    private RecyclerView rcvHangdt;
    private HangdtAdapter hangdtAdapter;
    private PhoneAdaper phoneAdaper;

    private EditText edtTimKiem;
    private ImageView imgTimKiem;
    private TextView txtThongBaoTimKiem;
    private TextView txtTieuDe;
    private TextView txtTraVeTimKiem;

    public TrangChinhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trang_chinh, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtTimKiem = view.findViewById(R.id.edtTimKiem);
        imgTimKiem = view.findViewById(R.id.imgTimKiem);
        txtThongBaoTimKiem = view.findViewById(R.id.txtThongBaoTimKiem);
        txtTieuDe = view.findViewById(R.id.txtTieuDe);
        rcvPhone = view.findViewById(R.id.rcvPhone);
        rcvHangdt = view.findViewById(R.id.rcvHangdt);
        txtTraVeTimKiem = view.findViewById(R.id.txtTraVeTimKiem);

        txtTieuDe.setText("Điện Thoại Hot");

        txtTieuDe.setVisibility(View.VISIBLE);
        txtTraVeTimKiem.setVisibility(View.INVISIBLE);

        List<String> dsHangdts = new ArrayList<>();
        dsHangdts.add("Hot");
        dsHangdts.addAll(AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().getListTenHang());
        listHangdts = dsHangdts;
        loadHangDt(view);

        listphones = AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().getListHotPhone("Hot");
        checkDataListPhone(listphones.size());
        loadDataTrangChinh(view);

        imgTimKiem.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String srearch = String.valueOf(edtTimKiem.getText()).trim().replaceAll("\\s+", " ");
                String timKiem = "%" + srearch + "%";
                listphones = AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().getListTimKiem(timKiem);
                phoneAdaper.notifyDataSetChanged();

                checkDataListPhone(listphones.size());
                loadDataTrangChinh(view);

                txtTraVeTimKiem.setVisibility(View.VISIBLE);
                txtTieuDe.setVisibility(View.INVISIBLE);

                txtTraVeTimKiem.setText("Kết quả tìm kiếm cho: ' " + edtTimKiem.getText() + " '");
            }
        });
    }


    private void loadHangDt(final View view) {

        hangdtAdapter = new HangdtAdapter(getContext(), listHangdts);
        rcvHangdt.setAdapter(hangdtAdapter);
        rcvHangdt.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));

        hangdtAdapter.setOnItemClickListener(new HangdtAdapter.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void OnItemClicked(int position) {
                txtTieuDe.setVisibility(View.VISIBLE);
                txtTraVeTimKiem.setVisibility(View.INVISIBLE);

                if (listHangdts.get(position).equals("Hot")) {
                    listphones = AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().getListHotPhone("Hot");
                    txtTieuDe.setText("Điện Thoại Hot");
                    checkDataListPhone(listphones.size());
                } else {
                    listphones = AppDatabasePhone.getInstance().getIDatabase().getPhoneDao().getListDienThoaiTheoHangSx(listHangdts.get(position));
                    txtTieuDe.setText("Điện Thoại "+ listHangdts.get(position));
                    phoneAdaper.notifyDataSetChanged();
                    checkDataListPhone(listphones.size());
                }
                loadDataTrangChinh(view);
            }
        });

    }

    private void checkDataListPhone(int countSize) {
        if (countSize <= 0) {
            txtThongBaoTimKiem.setVisibility(View.VISIBLE);
            rcvPhone.setVisibility(View.INVISIBLE);
        } else {
            rcvPhone.setVisibility(View.VISIBLE);
            txtThongBaoTimKiem.setVisibility(View.INVISIBLE);
        }
    }

    private void loadDataTrangChinh(final View view) {
        rcvPhone = view.findViewById(R.id.rcvPhone);
        phoneAdaper = new PhoneAdaper(getContext(), listphones);
        rcvPhone.setHasFixedSize(true);
        rcvPhone.setAdapter(phoneAdaper);
        rcvPhone.setLayoutManager(new GridLayoutManager(getContext(), 2));

        phoneAdaper.setOnItemClickListener(new PhoneAdaper.OnItemClickListener() {
            @Override
            public void OnItemClicked(int position) {
                Bundle bundle = new Bundle();
                bundle.putString("idPhone", listphones.get(position).getId());
                Navigation.findNavController(view).navigate(R.id.action_trangChinh_to_thongTinChiTiet, bundle);
            }
        });
    }
}
