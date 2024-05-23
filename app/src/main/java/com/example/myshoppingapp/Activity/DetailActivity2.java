package com.example.myshoppingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myshoppingapp.Helper.MangmentCart2;
import com.example.myshoppingapp.Model.Product;
import com.example.myshoppingapp.R;

public class DetailActivity2 extends AppCompatActivity {

    TextView tenspTxt, giaTxt, nuocsxTxt, maloaiTxt, dvtTxt;

    Button addToCart;

    private ImageView  backBtn;

    private Product object;

    private int numberOrder = 1;
    private MangmentCart2 managmentCart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail2);
        initView();
        getBundle();
    }

    private void getBundle() {
        object = (Product) getIntent().getSerializableExtra("object");
        tenspTxt.setText(object.getTenSP());
        giaTxt.setText( object.getGiaBan()+" VND");
        nuocsxTxt.setText(object.getSoLuongTonKho()+"");
        maloaiTxt.setText(object.getMaDM()+"");
        dvtTxt.setText("Mô tả: " +object.getTenSP());

        addToCart.setOnClickListener(v -> {
            if (managmentCart2 != null) {
                object.setNumberInCart(numberOrder);
                managmentCart2.insertFood(object);
            } else {
//                Toast.makeText(this, "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailActivity2.this,CartActivity.class));
            }

        });

        backBtn.setOnClickListener(v -> finish());
    }
    private void initView() {
        addToCart = findViewById(R.id.addToCart_btn2);
        backBtn = findViewById(R.id.backBtn);
        tenspTxt = findViewById(R.id.tenspTxt);
        giaTxt = findViewById(R.id.giaTxt);
        nuocsxTxt = findViewById(R.id.nuocsxTxt);
        maloaiTxt = findViewById(R.id.maloaiTxt);
        dvtTxt = findViewById(R.id.dvtTxt);
    }
}