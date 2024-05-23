package com.example.myshoppingapp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.myshoppingapp.Model.Product;

import java.util.ArrayList;

public class MangmentCart2 {
    private Context context;
    private TinyDB2 tinyDB;

    public MangmentCart2(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB2(context);
    }

    public void insertFood(Product item) {
        ArrayList<Product> listPop = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listPop.size(); i++) {
            if (listPop.get(i).getTenSP().equals(item.getTenSP())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if (existAlready) {
            listPop.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listPop.add(item);
        }
        tinyDB.putListObject("CartList", listPop);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Product> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void minusNumberItem(ArrayList<Product> listItem, int position, ChangeNumberItemsListener2 changeNumberItemsListener2) {
        if (listItem.get(position).getNumberInCart() == 1) {
            listItem.remove(position);
        } else {
            listItem.get(position).setNumberInCart(listItem.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CartList", listItem);
        changeNumberItemsListener2.change();
    }

    public void plusNumberItem(ArrayList<Product> lisItem, int position, ChangeNumberItemsListener2 changeNumberItemsListener2) {
        lisItem.get(position).setNumberInCart(lisItem.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CartList", lisItem);
        changeNumberItemsListener2.change();
    }

    public Double getTotalFee() {
        ArrayList<Product> listItem = getListCart();
        double fee = 0;
        for (int i = 0; i < listItem.size(); i++) {
            fee = fee + (listItem.get(i).getGiaBan() * listItem.get(i).getNumberInCart());
        }
        return fee;
    }

}
