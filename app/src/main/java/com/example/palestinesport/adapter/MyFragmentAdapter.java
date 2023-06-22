package com.example.palestinesport.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.palestinesport.fragment.StadiumDataFragment1;
import com.example.palestinesport.fragment.StadiumDataFragment2;


public class MyFragmentAdapter extends FragmentStateAdapter {


    public MyFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new StadiumDataFragment1();
        }
        return new StadiumDataFragment2();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
