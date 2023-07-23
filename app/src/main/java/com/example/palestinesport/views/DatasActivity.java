package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.palestinesport.R;
import com.example.palestinesport.adapter.MyFragmentAdapter;
import com.example.palestinesport.api.controller.PlaygoundController;
import com.example.palestinesport.databinding.ActivityDatasBinding;
import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.Playgound;

import java.util.List;

public class DatasActivity extends AppCompatActivity {

    ActivityDatasBinding binding;
    MyFragmentAdapter adapter;
    PlaygoundController controller = new PlaygoundController();
    Intent intent;
    String playgroundName ,coordinatorName,coordinatorPhone,playgroundType,workHours,playgroundAddress;
    int hourPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new MyFragmentAdapter(this);

        binding.pager.setAdapter(adapter);

        intent = new Intent();
        int id = intent.getIntExtra("id", 00);
        if (intent.hasExtra("id")) {

            Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        }

        controller.getPlaygroundDetail(String.valueOf(id), new ListCallback<Playgound>() {
            @Override
            public void onSuccess(List<Playgound> list) {
                for (int i = 0; i < list.size(); i++) {
                    playgroundName = list.get(i).playgoundName;
                    playgroundType = list.get(i).playgoundType;
                    playgroundAddress = list.get(i).playgoundAddress;
                    hourPrice = list.get(i).hourePrice;

                    intent.putExtra("playgroundName",playgroundName);
                    intent.putExtra("playgroundType",playgroundType);
                    intent.putExtra("playgroundAddress",playgroundAddress);
                    intent.putExtra("hourPrice",hourPrice);
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });

        // binding.pager.addItemDecoration(R.layout.fragment_stadium_data1,1);
    }
}