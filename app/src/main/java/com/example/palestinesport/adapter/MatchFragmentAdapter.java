package com.example.palestinesport.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.palestinesport.fragment.MatchScheduleFragment;
import com.example.palestinesport.fragment.StadiumDataFragment1;
import com.example.palestinesport.fragment.StadiumDataFragment2;


public class MatchFragmentAdapter extends FragmentStateAdapter {


    public MatchFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
            return new MatchScheduleFragment();
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
