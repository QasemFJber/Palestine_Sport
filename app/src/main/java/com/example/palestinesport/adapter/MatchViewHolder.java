package com.example.palestinesport.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.palestinesport.databinding.ItemMatchBinding;
import com.example.palestinesport.interfaces.ItemOnClick;
import com.example.palestinesport.models.Matchas;

public class MatchViewHolder extends RecyclerView.ViewHolder {
    ItemMatchBinding binding;
    ItemOnClick itemOnClick;
    public MatchViewHolder(ItemMatchBinding binding,ItemOnClick itemOnClick) {
        super(binding.getRoot());
        this.binding=binding;
        this.itemOnClick =itemOnClick;
    }

    public void savaData(Matchas matchas){
        binding.textTeam1.setText(String.valueOf(matchas.team1));
        binding.textTeam2.setText(String.valueOf(matchas.team2));
        binding.textMatchTime.setText(String.valueOf(matchas.matchTime));

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClick.onItemClick(matchas.id);
            }
        });

    }
}
