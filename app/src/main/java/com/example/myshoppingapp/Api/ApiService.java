package com.example.myshoppingapp.Api;

import com.example.myshoppingapp.Model.Product;
import com.example.myshoppingapp.Model.Product;
import com.example.myshoppingapp.Model.khachhang;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {
    @GET("api_get.php")
    Call<List<Product>> getUsers();

    @GET("api_get.php")
    Call<ArrayList<Product>> getProduct();

    @GET("api_get_maloai_BB.php")
    Call<List<Product>> getMaLoaiBB();

    @GET("api_get_maloai_BC.php")
    Call<List<Product>> getMaLoaiBC();

    @GET("api_get_maloai_ST.php")
    Call<List<Product>> getMaLoaiST();

    @GET("api_get_maloai_TV.php")
    Call<List<Product>> getMaLoaiTV();

    @GET("api_get_kh.php")
    Call<List<khachhang>> getkh();


    @FormUrlEncoded
    @POST("api_add_kh.php")
    Call<ResponseBody> addCustomer(
            @Field("makh") String makh,
            @Field("hoten") String hoten,
            @Field("dchi") String dchi,
            @Field("ngsinh") String ngsinh,
            @Field("sdt") int sdt,
            @Field("ngdk") String ngdk,
            @Field("email") String email,
            @Field("password") String password
    );

    @POST("api_edit.php")
    @FormUrlEncoded
    Call<ResponseBody> updateProduct(@Field("MaSP") int MaSP,
                                     @Field("TenSP") String TenSP,
                                     @Field("DonGia") int DonGia,
                                     @Field("SoLuong") int SoLuong,
                                     @Field("MoTa") String MoTa,
                                     @Field("MaLoai") int MaLoai);

    @DELETE("api_delete.php")
    Call<ResponseBody> deleteProduct(@Query("MaSP") int MaSP);

//    Call<> userLogin(@Body LoginRequest loginRequest);
}
