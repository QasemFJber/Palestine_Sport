package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.palestinesport.R;
import com.example.palestinesport.adapter.MatchAdapter;
import com.example.palestinesport.api.controller.MatchesController;
import com.example.palestinesport.api.controller.PlaygoundController;
import com.example.palestinesport.databinding.ActivityMatchScheduleBinding;
import com.example.palestinesport.interfaces.ItemOnClick;
import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.Matchas;
import com.example.palestinesport.models.Playgound;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchScheduleActivity extends AppCompatActivity implements ItemOnClick {
    ActivityMatchScheduleBinding binding;

    List<Matchas> matchas = new ArrayList<>();
    MatchAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMatchScheduleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());







        binding.tabDay.addTab(binding.tabDay.newTab().setText("الخميس"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("الاربعاء"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("الثلاثاء"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("الاثنين"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("الاحد"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("السبت"),true);


        adapter = new MatchAdapter(matchas);
        adapter.setItemOnClick(this::onItemClick);
        binding.recMatch.setAdapter(adapter);
        binding.recMatch.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MatchesController controller = new MatchesController();
        controller.getAllMatches(new ListCallback<Matchas>() {
            @Override
            public void onSuccess(List<Matchas> list) {
                //Toast.makeText(MatchScheduleActivity.this, ""+binding.tabDay.getTabMode(), Toast.LENGTH_SHORT).show();
                //if ()

                String selectedDay = "السبت";
                for (Matchas matchas1 : list) {
                    if (matchas1.matchDay.equals(selectedDay)) {
                        // تحقق من أن اليوم يتطابق مع اليوم المحدد
                        // يمكنك استخدام الفرق المتعلقة باليوم المحدد كما تريد
                        matchas.clear();
                        //Toast.makeText(MatchScheduleActivity.this, ""+Collections.singleton(matchas1).size(), Toast.LENGTH_SHORT).show();
                        matchas.addAll(Collections.singleton(matchas1));
                        adapter.notifyDataSetChanged();
                    }else {
                        matchas.clear();
                    }

                }

                //matchas.addAll(list);
                //adapter.notifyDataSetChanged();
                //Toast.makeText(MatchScheduleActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(MatchScheduleActivity.this, ""+message, Toast.LENGTH_SHORT).show();

            }
        });

        binding.tabDay.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Toast.makeText(MatchScheduleActivity.this, ""+ tab.getText().toString(), Toast.LENGTH_SHORT).show();
                //tab.getText().toString();
                matchas.clear();

                controller.getAllMatches(new ListCallback<Matchas>() {
                    @Override
                    public void onSuccess(List<Matchas> list) {
                        //Toast.makeText(MatchScheduleActivity.this, ""+binding.tabDay.getTabMode(), Toast.LENGTH_SHORT).show();


                        String selectedDay = tab.getText().toString();
                        for (Matchas matchas1 : list) {
                                if (matchas1.matchDay.equals(selectedDay)) {
                                    // تحقق من أن اليوم يتطابق مع اليوم المحدد
                                    // يمكنك استخدام الفرق المتعلقة باليوم المحدد كما تريد
                                    binding.recMatch.setVisibility(View.VISIBLE);
                                    matchas.clear();
                                   // Toast.makeText(MatchScheduleActivity.this, ""+Collections.singleton(matchas1).size(), Toast.LENGTH_SHORT).show();
                                    matchas.addAll(Collections.singleton(matchas1));
                                    adapter.notifyDataSetChanged();
                                }else {
                                    matchas.clear();
                                    binding.recMatch.setVisibility(View.GONE);
                                }

                        }

                        //matchas.addAll(list);
                        //adapter.notifyDataSetChanged();

                        //Toast.makeText(MatchScheduleActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        Toast.makeText(MatchScheduleActivity.this, ""+message, Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    @Override
    public void onItemClick(int id) {
        Intent intent =new Intent(getApplicationContext(), MatchDataActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);

    }
}