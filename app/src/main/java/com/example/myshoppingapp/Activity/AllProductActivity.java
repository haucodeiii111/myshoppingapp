package com.example.myshoppingapp.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshoppingapp.Adapter.ProductAdapter;
import com.example.myshoppingapp.Api.ApiClient;
import com.example.myshoppingapp.Api.ApiService;
import com.example.myshoppingapp.Model.Product;
import com.example.myshoppingapp.R;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllProductActivity extends AppCompatActivity {
    RecyclerView rcvUser;
    private List<Product> products;



    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_all_product_main);
        rcvUser = findViewById(R.id.rcv_product);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(dividerItemDecoration);

        loadData();

    }

    public void loadData() {

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Product>> call = apiService.getUsers();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> productList = response.body();
                    products = productList;
                    productAdapter = new ProductAdapter(productList, AllProductActivity.this);
                    rcvUser.setAdapter(productAdapter);
                    Toast.makeText(AllProductActivity.this, "onResponse", Toast.LENGTH_SHORT).show();
                } else {
                    // Xử lý khi gọi API thất bại
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Xử lý khi gọi API thất bại
                Toast.makeText(AllProductActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}