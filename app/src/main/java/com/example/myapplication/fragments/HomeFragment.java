package com.example.myapplication.fragments;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import Model.Cart;
import Model.Product;

public class HomeFragment extends Fragment {

    private View mView;
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

//    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == Activity.RESULT_OK){
//                        Intent intent = result.getData();
//                        Bundle bundle = getActivity().getIntent().getExtras();
//                        if (bundle == null) {
//                            return;
//                        }
////                        Product pro = (Product) bundle.get("product_cart_data");
////                        Product pro = (Product) intent.getBundleExtra("product_cart_data");
//                    }
//                }
//            });


    private void onClickShowDetail (Product product) {
        Intent intent = new Intent(getActivity(), ProductDetail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("product_data", product);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
