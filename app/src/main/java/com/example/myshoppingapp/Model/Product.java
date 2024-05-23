package com.example.myshoppingapp.Model;

import java.io.Serializable;

public class Product implements Serializable {
    private int MaSP;
    private String TenSP;
    private int GiaBan;

    private int SoLuongTonKho;

    private int MaDM;

    private String picUrl;


    private int numberInCart;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public Product(int maSP, String tenSP, int giaBan, int soLuongTonKho, int maDM, String picUrl) {
        MaSP = maSP;
        TenSP = tenSP;
        GiaBan = giaBan;
        SoLuongTonKho = soLuongTonKho;
        MaDM = maDM;
        this.picUrl = picUrl;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int giaBan) {
        GiaBan = giaBan;
    }

    public int getSoLuongTonKho() {
        return SoLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        SoLuongTonKho = soLuongTonKho;
    }

    public int getMaDM() {
        return MaDM;
    }

    public void setMaDM(int maDM) {
        MaDM = maDM;
    }
}

