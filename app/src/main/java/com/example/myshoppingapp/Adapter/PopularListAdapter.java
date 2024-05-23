package com.example.myshoppingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.myshoppingapp.Activity.DetailActivity;
import com.example.myshoppingapp.Domain.PopularDomain;
import com.example.myshoppingapp.R;

import java.util.ArrayList;
public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.Viewhoder> {

    ArrayList<PopularDomain> items;
    Context context;


    public PopularListAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhoder_pop_list, parent, false);
        context = parent.getContext();
        return new Viewhoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.feeTxt.setText("$" + items.get(position).getPrice());
        holder.scoreTxt.setText("" + items.get(position).getScore());


        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable", holder.itemView.getContext().getPackageName());

        // Tải hình ảnh
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.pic);

        // Xử lý sự kiện click
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView titleTxt, feeTxt, scoreTxt;
        ImageView pic;
        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            feeTxt = itemView.findViewById(R.id.freeTxt);
            scoreTxt = itemView.findViewById(R.id.srcoreTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
