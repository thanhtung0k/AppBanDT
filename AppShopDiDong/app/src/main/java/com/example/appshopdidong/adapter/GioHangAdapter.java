package com.example.appshopdidong.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appshopdidong.R;
import com.example.appshopdidong.model.GioHang;
import com.example.appshopdidong.view.MainActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.appshopdidong.fragment.GioHangFragment.EvenUntil;
import static com.example.appshopdidong.fragment.GioHangFragment.lvGioHang;
import static com.example.appshopdidong.fragment.GioHangFragment.txtThongBaoGioHang;

public class GioHangAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<GioHang> arrayGioHang;

    public GioHangAdapter(Context context, ArrayList<GioHang> arrayGioHang) {
        this.context = context;
        this.arrayGioHang = arrayGioHang;
    }

    @Override
    public int getCount() {
        return MainActivity.mangGioHang.size();
    }

    @Override
    public Object getItem(int position) {
        return MainActivity.mangGioHang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        private TextView txtPhoneItemGH;
        private TextView txtGiaPhoneItemGH;
        private ImageView imgPhoneItemGH;
        private Button btnPlus;
        private Button btnMinus;
        private TextView txtSoLuongItemGH;
        private TextView txtThanhTienItemGH;
        private TextView txtTongTien;
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_gio_hang, null);
            viewHolder.txtPhoneItemGH = view.findViewById(R.id.txtPhoneItemGH);
            viewHolder.txtGiaPhoneItemGH = view.findViewById(R.id.txtGiaPhoneItemGH);
            viewHolder.imgPhoneItemGH = view.findViewById(R.id.imgPhoneItemGH);
            viewHolder.btnPlus = view.findViewById(R.id.btnPlusItemGH);
            viewHolder.btnMinus = view.findViewById(R.id.btnMinusItemGH);
            viewHolder.txtSoLuongItemGH = view.findViewById(R.id.txtSoLuongItemGH);
            viewHolder.txtThanhTienItemGH = view.findViewById(R.id.txtThanhTienItemGH);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final GioHang gioHang = (GioHang) getItem(position);
        viewHolder.txtPhoneItemGH.setText(gioHang.getTenSp());
        final DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        int soLuongData = gioHang.getSoLuong();
        if (soLuongData > 20) {
            soLuongData = 20;
            gioHang.setSoLuong(20);
        }
        final int soLuong = soLuongData;
        long giaSp = gioHang.getGiaSp();
        long thanhTien = soLuong * giaSp;
        viewHolder.imgPhoneItemGH.setImageResource(gioHang.hinhSP);
        viewHolder.txtSoLuongItemGH.setText(soLuong + "");
        viewHolder.txtGiaPhoneItemGH.setText("Giá: "+decimalFormat.format(giaSp)+" đ");
        viewHolder.txtThanhTienItemGH.setText("= "+decimalFormat.format(thanhTien)+" đ");
        final ViewHolder finalViewHolder = viewHolder;
        checkSoLuong(gioHang, viewHolder);

        viewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soLuongMoiNhat = Integer.parseInt(finalViewHolder.txtSoLuongItemGH.getText().toString()) + 1;
                gioHang.setSoLuong(soLuong);
                long giaHienTai = MainActivity.mangGioHang.get(position).getGiaSp();
                long thanhTien = soLuongMoiNhat * giaHienTai;
                finalViewHolder.txtThanhTienItemGH.setText("= "+ decimalFormat.format(thanhTien) + " đ");
                finalViewHolder.txtSoLuongItemGH.setText(soLuongMoiNhat + "");

                MainActivity.mangGioHang.get(position).setSoLuong(soLuongMoiNhat);
                EvenUntil();
                checkSoLuong(gioHang, finalViewHolder);

            }
        });

        viewHolder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soLuong > 1) {
                    int soLuongMoiNhat = Integer.parseInt(finalViewHolder.txtSoLuongItemGH.getText().toString()) - 1;
                    gioHang.setSoLuong(soLuong);
                    long giaHienTai = MainActivity.mangGioHang.get(position).getGiaSp();
                    long thanhTien = soLuongMoiNhat * giaHienTai;
                    finalViewHolder.txtThanhTienItemGH.setText("= "+decimalFormat.format(thanhTien) + " đ");
                    finalViewHolder.txtSoLuongItemGH.setText(soLuongMoiNhat + "");
                    MainActivity.mangGioHang.get(position).setSoLuong(soLuongMoiNhat);
                    EvenUntil();
                    checkSoLuong(gioHang, finalViewHolder);
                }
                if (soLuong == 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Xóa : " +  gioHang.getTenSp() + " khỏi giỏ hàng");
                    builder.setMessage("Bạn có thực sự muốn xóa sản phẩm không?");
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (MainActivity.mangGioHang.size() <= 0) {
                                txtThongBaoGioHang.setVisibility(View.VISIBLE);
                            } else {
                                Toast.makeText(context, "Xóa thành công : " + gioHang.getTenSp(), Toast.LENGTH_SHORT).show();
                                MainActivity.mangGioHang.remove(position);
                                EvenUntil();
                                if (MainActivity.mangGioHang.size() <= 0) {
                                    lvGioHang.setVisibility(View.INVISIBLE);
                                    txtThongBaoGioHang.setVisibility(View.VISIBLE);
                                } else {
                                    txtThongBaoGioHang.setVisibility(View.INVISIBLE);
                                }
                            }
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            EvenUntil();
                        }
                    });
                    builder.show();
                }
            }
        });


        return view;
    }

    private void checkSoLuong(GioHang gioHang, ViewHolder viewHolder) {
        if (gioHang.getSoLuong() >= 20) {
            viewHolder.btnPlus.setVisibility(View.INVISIBLE);
            viewHolder.btnMinus.setVisibility(View.VISIBLE);
        }
        else {
            viewHolder.btnPlus.setVisibility(View.VISIBLE);
            viewHolder.btnMinus.setVisibility(View.VISIBLE);
        }
    }

}