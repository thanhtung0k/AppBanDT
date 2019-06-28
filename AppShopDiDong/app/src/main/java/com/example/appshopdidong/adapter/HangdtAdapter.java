package com.example.appshopdidong.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appshopdidong.Key;
import com.example.appshopdidong.R;

import java.util.List;

public class HangdtAdapter extends RecyclerView.Adapter<HangdtAdapter.ViewHolder> {

    private static final String TAG = "HangdtAdapter";

    private List<String> hangDts;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public HangdtAdapter(Context context, List<String> hangDts){
        inflater = LayoutInflater.from(context);
        this.hangDts = hangDts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_hangdt_rcv,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        final String hangdt = hangDts.get(position);
        Log.d(TAG, hangDts.toString());
        viewHolder.txtHangDtRcv.setText(hangdt);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClicked(viewHolder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return hangDts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtHangDtRcv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHangDtRcv = itemView.findViewById(R.id.txtHangDtRcv);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClicked(int position);
    }
}
