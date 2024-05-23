package com.example.myshoppingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshoppingapp.Activity.DetailActivity2;
import com.example.myshoppingapp.Model.Product;
import com.example.myshoppingapp.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHoder> {

    private List<Product> productList;

    private Context context;

    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;

    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhoder_list_all_product,parent,false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Product product = productList.get(position);
        if (product == null) {
            return;
        }
        holder.tv_masp.setText(String.valueOf(product.getMaSP()));
        holder.tv_tensp.setText(String.valueOf(product.getTenSP()));
        holder.tv_gia.setText(String.valueOf(product.getGiaBan()+" VND"));
        holder.tv_sltk.setText(String.valueOf(product.getSoLuongTonKho()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity2.class);
                intent.putExtra("object", productList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        if (productList != null) {
            return productList.size();
        }
        return 0;
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private TextView tv_masp, tv_tensp, tv_gia, tv_sltk;


        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            tv_masp = itemView.findViewById(R.id.tv_masp);
            tv_tensp = itemView.findViewById(R.id.tv_tensp);
            tv_gia = itemView.findViewById(R.id.tv_gia);
            tv_sltk = itemView.findViewById(R.id.tv_sltk);
        }
    }
}

