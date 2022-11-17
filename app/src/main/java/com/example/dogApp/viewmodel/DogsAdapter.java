package com.example.dogApp.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogApp.R;
import com.example.dogApp.model.DogBreed;
import com.example.dogApp.view.ListFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {

    private ArrayList<DogBreed> dogBreeds;
    private DogBreed dog;


    public DogsAdapter(ArrayList<DogBreed> dogBreeds) {
        this.dogBreeds = dogBreeds;
    }

    @NonNull
    @Override


    public DogsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dogs_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogsAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(dogBreeds.get(position).getName());
        holder.tvOrigin.setText(dogBreeds.get(position).getOrigin());
        Picasso.get().load(dogBreeds.get(position).getUrl()).into(holder.ivAvatar);

    }

    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView tvName;
        public TextView tvOrigin;
        public ImageView ivAvatar;

        public ViewHolder(View view){
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            tvOrigin = view.findViewById(R.id.tv_origin);
            ivAvatar = view.findViewById(R.id.iv_avatar);
        }
    }
}