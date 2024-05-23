package com.example.myshoppingapp.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myshoppingapp.Model.khachhang;
import com.example.myshoppingapp.R;

public class ProfileActivity extends AppCompatActivity {

    TextView email, tenkh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_main);
        email = findViewById(R.id.email);
        tenkh = findViewById(R.id.tenkh);

        Bundle bundleRecive = getIntent().getExtras();
        if (bundleRecive != null){
            khachhang khachhang = (khachhang) bundleRecive.get("object_khachhang");
            if (khachhang != null){
                tenkh.setText(khachhang.toString());
                email.setText(khachhang.toString());
            }
        }
    }
}