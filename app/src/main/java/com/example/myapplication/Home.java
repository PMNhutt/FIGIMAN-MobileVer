package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    // LAB4

//    TextView loginName;
//    Button closeBtn;

    //============== lab 4 code ==================================================

//    @Override
//    public void finish() {
//        Intent intent = new Intent(Home.this, Login.class);
//        intent.putExtra("Logout", "bạn đã đăng xuất thành công");
//        setResult(1, intent);
//        super.finish();
//
//    }

    // ====== LAB 5
//    private RecyclerView recyProduct;
//    private ProductAdapter productAdapter;

    // viewPager + bottom navigation
    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // LAB4
        //============== lab 4 code ==================================================

//        loginName = findViewById(R.id.loginName);
//
//        loginName.setText(getIntent().getStringExtra("LoginName"));
//
//        closeBtn = findViewById(R.id.closeBtn);
//        closeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

        //LAB 5
//        recyProduct = findViewById(R.id.recvProduct);
//        productAdapter = new ProductAdapter(this);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyProduct.setLayoutManager(gridLayoutManager);
//
//
//        productAdapter.setData(getListProduct());
//        recyProduct.setAdapter(productAdapter);

        mViewPager2 = findViewById(R.id.viewPager2);
        mBottomNavigation = findViewById(R.id.bottomNavigation);

        //add 3 fragments to view pager
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        mViewPager2.setAdapter(viewPagerAdapter);

        //handle click to change fragment
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.bottomHome) {
                    mViewPager2.setCurrentItem(0);
                } else if (id == R.id.bottomCart) {
                    mViewPager2.setCurrentItem(1);
                } else if (id == R.id.bottomUser) {
                    mViewPager2.setCurrentItem(2);
                }
                return true;
            }
        });

        //handle swipe to change fragment
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mBottomNavigation.getMenu().findItem(R.id.bottomHome).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigation.getMenu().findItem(R.id.bottomCart).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigation.getMenu().findItem(R.id.bottomUser).setChecked(true);
                        break;
                }
            }
        });

    }


}