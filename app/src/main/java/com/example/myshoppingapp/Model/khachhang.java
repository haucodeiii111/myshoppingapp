package com.example.myshoppingapp.Model;

import java.io.Serializable;

public class khachhang implements Serializable {
    private String makh;
    private String hoten;
    private String dchi;
    private int sdt;
    private String  ngsinh;
    private String ngdk;
    private int doanhso;
    private String email;
    private String password;

    public khachhang(String makd, String hoten, String dchi, String ngsinh, int sdt, String ngdk, String email, String password) {
        this.makh = makd;
        this.hoten = hoten;
        this.dchi = dchi;
        this.ngsinh = ngsinh;
        this.sdt = sdt;
        this.ngdk = ngdk;
        this.email = email;

    }

    @Override
    public String toString() {
        return hoten;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getNgsinh() {
        return ngsinh;
    }

    public void setNgsinh(String ngsinh) {
        this.ngsinh = ngsinh;
    }

    public String getNgdk() {
        return ngdk;
    }

    public void setNgdk(String ngdk) {
        this.ngdk = ngdk;
    }

    public int getDoanhso() {
        return doanhso;
    }

    public void setDoanhso(int doanhso) {
        this.doanhso = doanhso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
