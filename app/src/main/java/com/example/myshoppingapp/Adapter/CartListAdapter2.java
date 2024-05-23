package com.example.myshoppingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshoppingapp.Helper.ChangeNumberItemsListener;
import com.example.myshoppingapp.Helper.ChangeNumberItemsListener2;
import com.example.myshoppingapp.Helper.MangmentCart2;
import com.example.myshoppingapp.Model.Product;
import com.example.myshoppingapp.R;

import java.util.ArrayList;

public class CartListAdapter2 extends RecyclerView.Adapter<CartListAdapter2.ViewHoder> {

    ArrayList<Product> listItemSelected;
    private MangmentCart2 managmentCart;
    ChangeNumberItemsListener2 changeNumberItemsListener2;

    public CartListAdapter2(ArrayList<Product> listItemSelected, Context context, ChangeNumberItemsListener2 changeNumberItemsListener) {
        this.listItemSelected = listItemSelected;
        managmentCart = new MangmentCart2(context);
        this.changeNumberItemsListener2 = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhoder_cart2, parent, false);
        return new ViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

        holder.tenspTxt.setText(listItemSelected.get(position).getTenSP());
        holder.freeEachItem.setText("$" + listItemSelected.get(position).getGiaBan());
        holder.totalEachItem.setText("$" + Math.round(listItemSelected.get(position).
                getNumberInCart() * listItemSelected.get(position).getGiaBan()));
        holder.numberItemTxt.setText(String.valueOf(listItemSelected.get(position).getNumberInCart()));


        holder.plusCartBtn.setOnClickListener(v -> {
            managmentCart.plusNumberItem(listItemSelected, position, new ChangeNumberItemsListener2() {
                @Override
                public void change() {
                    notifyDataSetChanged();
                    changeNumberItemsListener2.change();
                }
            });

        });

        holder.minusCartBtn.setOnClickListener(v -> {
            managmentCart.minusNumberItem(listItemSelected, position, new ChangeNumberItemsListener2() {
                @Override
                public void change() {
                    notifyDataSetChanged();
                    changeNumberItemsListener2.change();
                }
            });

        });


    }

    @Override
    public int getItemCount() {
        return listItemSelected.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView tenspTxt, freeEachItem, plusCartBtn, minusCartBtn;

        TextView numberItemTxt, totalEachItem;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            tenspTxt = itemView.findViewById(R.id.tenspTxt);
            freeEachItem = itemView.findViewById(R.id.freeEachItem);
            plusCartBtn = itemView.findViewById(R.id.plusCartBtn);
            minusCartBtn = itemView.findViewById(R.id.minusCartBtn);

            numberItemTxt = itemView.findViewById(R.id.numberItemTxt);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
        }
    }
}
