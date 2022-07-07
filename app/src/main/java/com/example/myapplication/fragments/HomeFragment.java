package com.example.myapplication.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Home;
import com.example.myapplication.ProductAdapter;
import com.example.myapplication.ProductDetail;
import com.example.myapplication.R;
import com.example.myapplication.my_interfaces.IClickItemListener;

import java.util.ArrayList;
import java.util.List;

import DAO.ProductDAO;
import Model.Product;

public class HomeFragment extends Fragment {

    private  View mView;
    private RecyclerView recyProduct;
    private ProductAdapter productAdapter;
    private Home homeActivity;

    //Product DAO
    ProductDAO productDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        homeActivity = (Home) getActivity();
        productDAO = new ProductDAO(this.getContext());

        recyProduct = mView.findViewById(R.id.recvProduct);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(homeActivity, 2);
        recyProduct.setLayoutManager(gridLayoutManager);

        productAdapter = new ProductAdapter(homeActivity, new IClickItemListener() {
            @Override
            public void onClickProduct(Product product) {
                onClickShowDetail(product);
            }
        });
        productAdapter.setData(productDAO.getAllProducts());
        recyProduct.setAdapter(productAdapter);


        return  mView;
    }

    private List<Product> getListProduct() {
        List<Product> list = new ArrayList<>();
//        list.add(new Product(R.drawable.pro1, "Giyu Tomioka Nendoroid", "515,000"));
//        list.add(new Product(R.drawable.pro2, "Hatake Kakashi Nendoroid", "650,000"));
//        list.add(new Product(R.drawable.pro3, "Katsuki Bakugo Nendoroid", "515,000"));
//        list.add(new Product(R.drawable.pro4, "Kyojuro Rengoku Nendoroid", "515,000"));
//        list.add(new Product(R.drawable.pro5, "Nobara Kugisaki Nendoroid ", "350,000"));
//        list.add(new Product(R.drawable.pro6, "Megumi Fushiguro Nendoroid", "515,000"));
//        list.add(new Product(R.drawable.pro7, "Satoru Gojo Nendoroid", "515,000"));
//        list.add(new Product(R.drawable.pro8, "Shinobu Kocho Nendoroid", "515,000"));
//        list.add(new Product(R.drawable.pro9, "Sukuna Nendoroid", "515,000"));
//        list.add(new Product(R.drawable.pro10, "Yuji Itadori Nendoroid ", "515,000"));

        return list;
    }

    private void onClickShowDetail (Product product) {
        Intent intent = new Intent(getActivity(), ProductDetail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("product_data", product);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
