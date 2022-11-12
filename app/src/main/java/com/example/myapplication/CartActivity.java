package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CartActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mViewPager2 = findViewById(R.id.viewPager2cart);
        mBottomNavigation = findViewById(R.id.bottomNavigationcart);

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