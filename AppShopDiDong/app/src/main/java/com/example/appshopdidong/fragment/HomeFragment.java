package com.example.appshopdidong.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;

import com.example.appshopdidong.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Button btnGotoTrangChinh;
    private Button btnGotoGioHang;
    private Button btnGotoThongTinShop;
    private Button btnThoat;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnGotoTrangChinh = view.findViewById(R.id.btnGotoTrangChinh);
        btnGotoGioHang = view.findViewById(R.id.btnGotoGioHang);
        btnGotoThongTinShop = view.findViewById(R.id.btnGotoThongTinShop);
        btnThoat = view.findViewById(R.id.btnThoat);

        view.findViewById(R.id.btnGotoTrangChinh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_home_to_trangChinh);
            }
        });
        view.findViewById(R.id.btnGotoGioHang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_home_to_gioHang);
            }
        });
        view.findViewById(R.id.btnGotoThongTinShop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_home_to_thongTinShop);
            }
        });
    }
}
