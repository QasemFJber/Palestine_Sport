package com.example.palestinesport.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.palestinesport.R;
import com.example.palestinesport.models.Playgound;
import com.example.palestinesport.views.DatasActivity;

import java.util.List;

public class PlaygoundAdapter extends RecyclerView.Adapter<PlaygoundViewHolder> {

    List<Playgound> playgoundList;
    Context context;

    @NonNull
    @Override
    public PlaygoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaygoundViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DatasActivity.class);
                intent.putExtra("id",playgoundList.get(position).id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return playgoundList.size();
    }
}
