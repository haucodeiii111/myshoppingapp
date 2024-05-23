package com.example.myshoppingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshoppingapp.Adapter.PopularListAdapter;
import com.example.myshoppingapp.Domain.PopularDomain;
import com.example.myshoppingapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPupolar;

    private RecyclerView recyclerViewPupolar;

//    private List<Product> products;

    private ConstraintLayout iv_allProduct, iv_Bb, iv_Bc, iv_Tv, iv_St;

    private TextView inten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerViewPupolar = findViewById(R.id.view1);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPupolar.setLayoutManager(linearLayoutManager);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewPupolar.addItemDecoration(dividerItemDecoration);
        inten = findViewById(R.id.tv_inten);
        Bundle bundleRecive = getIntent().getExtras();



//        if (bundleRecive != null) {
//            khachhang khachhang = (khachhang) bundleRecive.get("object_khachhang");
//            if (khachhang != null) {
//                inten.setText(khachhang.toString());
//            }
//        }
        initRecyclerview();
//        initRcvProduct();
        list_navigation();
        bottom_navigation();
    }

    private void list_navigation() {
        iv_allProduct = findViewById(R.id.iv_allProduct);
        iv_Bb = findViewById(R.id.iv_Bb);
        iv_Bc = findViewById(R.id.iv_Bc);
        iv_St = findViewById(R.id.iv_St);
        iv_Tv = findViewById(R.id.iv_Tv);


        iv_Bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BbProductActivity.class));
            }
        });

        iv_Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TVProductActivity.class));
            }
        });

        iv_Bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BcProductActivity.class));
            }
        });

        iv_allProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AllProductActivity.class));
            }
        });

        iv_St.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NoteBookActivity.class));
            }
        });
    }


    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout profile = findViewById(R.id.profile);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Áo thun", "Mô tả sản phẩm\n" +
                "Chất liệu: Thun Poly Mè 4C\n" +
                "Thành phần: 93% Polyester 7% Spandex\n" +
                "- Co giãn 4 chiều\n" +
                "- Kỹ thuật: In nhũ bạc",
                "item_1",
                15, 4, 100000));

        items.add(new PopularDomain("Đồng hồ Apple Watch", "Màn Hình\n" +
                "\n" +
                "Công nghệ màn hình\n" +
                "\n" +
                "Retina LTPO OLED\n" +
                "\n" +
                "Tích hợp nhiều ứng dụng theo dõi sức khỏeNghe gọi trên đồng hồChống nướcĐo nhịp timNghe nhạc với tai nghe BluetoothTính lượng calories tiêu thụTheo dõi giấc ngủĐếm số bước chânPhát hiện té ngãTheo dõi chu kì kinh nguyệt\n" +
                "\n" +
                "Dung lượng pin (mAh)\n" +
                "\n" +
                "296mAh\n" +
                "\n" +
                "36.4g",
                "item_2",
                12, 5, 200000));
        items.add(new PopularDomain("Áo thun Man", "Mô tả sản phẩm\n" +
                "Chất liệu: Thun Poly Mè 4C\n" +
                "Thành phần: 93% Polyester 7% Spandex\n" +
                "- Co giãn 4 chiều\n" +
                "- Kỹ thuật: In nhũ bạc",
                "item_1",
                15, 4, 100000));

        items.add(new PopularDomain("Đồng hồ cơ Rolex", "Màn Hình\n" +
                "\n" +
                "Công nghệ màn hình\n" +
                "\n" +
                "Retina LTPO OLED\n" +
                "\n" +
                "Tích hợp nhiều ứng dụng theo dõi sức khỏeNghe gọi trên đồng hồChống nướcĐo nhịp timNghe nhạc với tai nghe BluetoothTính lượng calories tiêu thụTheo dõi giấc ngủĐếm số bước chânPhát hiện té ngãTheo dõi chu kì kinh nguyệt\n" +
                "\n" +
                "Dung lượng pin (mAh)\n" +
                "\n" +
                "296mAh\n" +
                "\n" +
                "36.4g",
                "item_2",
                12, 50, 200000));
        recyclerViewPupolar = findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterPupolar = new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
//    private void initRcvProduct(){
//
//        ApiService apiService = ApiClient.getClient().create(ApiService.class);
//        Call<List<Product>> call = apiService.getUsers();
//        call.enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//                if (response.isSuccessful()) {
//                    List<Product> productList = response.body();
//                    Collections.reverse(productList);
//                    products =  productList;
//                    adapterPupolar = new ProductAdapter(productList, MainActivity.this);
//                    recyclerViewPupolar.setAdapter(adapterPupolar);
//                    Toast.makeText(MainActivity.this, "onResponse", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Xử lý khi gọi API thất bại
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//                // Xử lý khi gọi API thất bại
//                Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
//            }
//        });
////        recyclerViewPupolar = findViewById(R.id.view1);
////        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
////        adapterPupolar = new ProductAdapter(items,this);
////        recyclerViewPupolar.setAdapter(adapterPupolar);
//    }
}