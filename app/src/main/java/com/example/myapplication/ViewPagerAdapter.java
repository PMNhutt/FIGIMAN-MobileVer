package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.CartFragment;
import com.example.myapplication.fragments.HomeFragment;
import com.example.myapplication.fragments.UserFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new CartFragment();
            case 2:
                return new UserFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
