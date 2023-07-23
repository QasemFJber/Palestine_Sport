package com.example.palestinesport.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.palestinesport.databinding.ItemMatchBinding;
import com.example.palestinesport.interfaces.ItemOnClick;
import com.example.palestinesport.models.Matchas;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchViewHolder> {

    List<Matchas> matchas;
    ItemOnClick itemOnClick;

    public MatchAdapter(List<Matchas> matchas) {
        this.matchas = matchas;
    }

    public void setItemOnClick(ItemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMatchBinding binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MatchViewHolder(binding,itemOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        holder.savaData(matchas.get(position));

    }

    @Override
    public int getItemCount() {
        return matchas.size();
    }
}
