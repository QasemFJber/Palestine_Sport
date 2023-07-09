package com.example.palestinesport.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.palestinesport.models.Playgound;

import java.util.List;

public class PlaygoundAdapter extends RecyclerView.Adapter<PlaygoundViewHolder> {

    List<Playgound> playgoundList;

    @NonNull
    @Override
    public PlaygoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaygoundViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return playgoundList.size();
    }
}
