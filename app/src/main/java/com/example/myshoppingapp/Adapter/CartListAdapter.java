package com.example.myshoppingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.myshoppingapp.Domain.PopularDomain;
import com.example.myshoppingapp.Helper.ChangeNumberItemsListener;
import com.example.myshoppingapp.Helper.ManagmentCart;
import com.example.myshoppingapp.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHoder> {

    ArrayList<PopularDomain> listItemSelected;
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<PopularDomain> listItemSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listItemSelected = listItemSelected;
        managmentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhoder_cart, parent, false);
        return new ViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

        holder.titleTxt.setText(listItemSelected.get(position).getTitle());
        holder.freeEachItem.setText("$" + listItemSelected.get(position).getPrice());
        holder.totalEachItem.setText("$" + Math.round(listItemSelected.get(position).
                getNumberInCart() * listItemSelected.get(position).getPrice()));
        holder.numberItemTxt.setText(String.valueOf(listItemSelected.get(position).getNumberInCart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
                (listItemSelected.get(position).getPicUrl(),
                        "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30, 30, 30, 30))
                .into(holder.pic);

        holder.plusCartBtn.setOnClickListener(v -> {
            managmentCart.plusNumberItem(listItemSelected, position, new ChangeNumberItemsListener() {
                @Override
                public void change() {
                    notifyDataSetChanged();
                    changeNumberItemsListener.change();
                }
            });

        });

        holder.minusCartBtn.setOnClickListener(v -> {
            managmentCart.minusNumberItem(listItemSelected, position, new ChangeNumberItemsListener() {
                @Override
                public void change() {
                    notifyDataSetChanged();
                    changeNumberItemsListener.change();
                }
            });

        });


    }

    @Override
    public int getItemCount() {
        return listItemSelected.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView titleTxt, freeEachItem, plusCartBtn, minusCartBtn;

        ImageView pic;

        TextView numberItemTxt, totalEachItem;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            titleTxt = itemView.findViewById(R.id.titleTxt);
            freeEachItem = itemView.findViewById(R.id.freeEachItem);
            plusCartBtn = itemView.findViewById(R.id.plusCartBtn);
            minusCartBtn = itemView.findViewById(R.id.minusCartBtn);
            pic = itemView.findViewById(R.id.pic);
            numberItemTxt = itemView.findViewById(R.id.numberItemTxt);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
        }
    }
}
