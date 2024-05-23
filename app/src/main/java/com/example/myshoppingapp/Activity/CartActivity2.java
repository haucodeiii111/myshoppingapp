package com.example.myshoppingapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshoppingapp.Adapter.CartListAdapter2;

import com.example.myshoppingapp.Helper.ChangeNumberItemsListener2;
import com.example.myshoppingapp.Helper.MangmentCart2;
import com.example.myshoppingapp.R;

public class CartActivity2 extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private MangmentCart2 managmentCart;

    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt , emptyTxt;
    private ScrollView scrollView;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);
        managmentCart = new MangmentCart2(this);
        initView();
        setVariable();
        initList();
        calcualteCart();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter =new CartListAdapter2(managmentCart.getListCart(), this, new ChangeNumberItemsListener2() {
            @Override
            public void change() {
                calcualteCart();
            }
        });
        recyclerView.setAdapter(adapter);
        if (managmentCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }
    private void calcualteCart() {
        double percentTax = 0.02;
        double delivery = 10;

        double total = Math.round((managmentCart.getTotalFee() + delivery) * 100 )/100;
        double itemTotal = Math.round(managmentCart.getTotalFee() *100) /100;

        totalFeeTxt.setText("$"+itemTotal);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+total);

    }

    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFreeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        recyclerView = findViewById(R.id.view3);
        scrollView = findViewById(R.id.scrollView3);
        backBtn = findViewById(R.id.backBtn);
        emptyTxt = findViewById(R.id.emptyTxt);
    }
}