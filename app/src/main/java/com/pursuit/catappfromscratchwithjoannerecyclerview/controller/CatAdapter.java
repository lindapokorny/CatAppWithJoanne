package com.pursuit.catappfromscratchwithjoannerecyclerview.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.catappfromscratchwithjoannerecyclerview.CatPojo;
import com.pursuit.catappfromscratchwithjoannerecyclerview.R;
import com.pursuit.catappfromscratchwithjoannerecyclerview.view.CatViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder> {
    private List<CatPojo> breedsList = new ArrayList<>();
    public CatAdapter(List<CatPojo> breedsList) {
        this.breedsList.addAll(breedsList);
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cat_itemview, viewGroup, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder catViewHolder, int i) {
    catViewHolder.onBind(breedsList.get(i));
    }

    @Override
    public int getItemCount() {
        return breedsList.size();
    }
}
