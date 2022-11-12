package com.example.myapplication.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CartActivity;
import com.example.myapplication.CartAdapter;
import com.example.myapplication.R;
import com.example.myapplication.my_interfaces.ICartItemListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Model.Cart;


public class CartFragment extends Fragment implements ICartItemListener {

    private  View mView;
    private RecyclerView recyCart;
    private CartAdapter cartAdapter;
    private CartActivity cartActivity;
    boolean shouldRefresh = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_cart, container, false);
//        cartActivity = (CartActivity) getActivity();
//        cartDAO = new CartDAO(this.getContext());

        recyCart = mView.findViewById(R.id.recvCart);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyCart.setLayoutManager(linearLayoutManager);

        cartAdapter = new CartAdapter(getActivity(), this);

        // load tasks from preference

        cartAdapter.setData(loadData());
        recyCart.setAdapter(cartAdapter);

        SharedPreferences prefs = getActivity().getSharedPreferences("SHARED_PREFS_FILE", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("product_cart_data", "");
        Type type = new TypeToken<List<Cart>>() {}.getType();
        List<Cart> list = gson.fromJson(json, type);
        for (Cart item: list  ) {
            Log.d(String.valueOf(getActivity()), item.getProductName());
        }

        return  mView;
    }

    private List<Cart> loadData () {
        SharedPreferences prefs = getActivity().getSharedPreferences("SHARED_PREFS_FILE", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("product_cart_data", "");
        Type type = new TypeToken<List<Cart>>() {}.getType();
        List<Cart> list = gson.fromJson(json, type);
        cartAdapter.setData(list);
        for (Cart item: list  ) {
            Log.d(String.valueOf(getActivity()), item.getProductName());
        }

        return list;
    }

    private List<Model.Cart> getListCartItem( ) {
        List<Model.Cart> list = new ArrayList<>();
        list.add(new Model.Cart(1, "mo hinh", "pro1", 0));
        list.add(new Model.Cart(2, "mo hinh 2", "pro2", 0));

        SharedPreferences prefs = getActivity().getSharedPreferences("SHARED_PREFS_FILE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();

        String json = gson.toJson(list);

        editor.putString("product_cart_data", json);
        editor.commit();

        return list;
    }

    @Override
    public void onPause() {
        super.onPause();
        shouldRefresh = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (shouldRefresh) {
            loadData();
        }
    }

    @Override
    public void DeleteCart(int position) {
        SharedPreferences prefs = getActivity().getSharedPreferences("SHARED_PREFS_FILE", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("product_cart_data", "");
        Type type = new TypeToken<List<Cart>>() {}.getType();
        List<Cart> list = gson.fromJson(json, type);
        list.remove(position);
        cartAdapter.cartList.remove(position);
        cartAdapter.notifyItemRemoved(position);
        cartAdapter.notifyItemRangeChanged(position, list.size());
        json = gson.toJson(list);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("product_cart_data", json);
        editor.commit();

    }
}
