package com.example.appshopdidong.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appshopdidong.Key;
import com.example.appshopdidong.R;
import com.example.appshopdidong.database.entity.Phone;

import java.text.DecimalFormat;
import java.util.List;

public class PhoneAdaper extends RecyclerView.Adapter<PhoneAdaper.ViewHolder>{


    private List<Phone> phones;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public PhoneAdaper(Context context,List<Phone> phones){
        inflater = LayoutInflater.from(context);
        this.phones = phones;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_dienthoai,viewGroup,false);
        return new ViewHolder(view);
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        final Phone phone = phones.get(position);
        viewHolder.imgAnhItemDT.setImageResource(phone.getAnhId());
        viewHolder.txtTenItemDT.setText(phone.getTen());
        if(phone.getTrangThai().equals("Hot")){
            viewHolder.txtTenItemDT.setTextColor(R.color.colorDienThoaiHot);
        }
        int gia = phone.getGia();
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaItemDT.setText(decimalFormat.format(gia) +" đ");

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClicked(viewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return phones.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAnhItemDT;
        private TextView txtTenItemDT;
        private TextView txtGiaItemDT;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnhItemDT = itemView.findViewById(R.id.imgAnhItemDT);
            txtTenItemDT = itemView.findViewById(R.id.txtTenItemDT);
            txtGiaItemDT = itemView.findViewById(R.id.txtGiaItemDT);
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClicked(int position);
    }
}
