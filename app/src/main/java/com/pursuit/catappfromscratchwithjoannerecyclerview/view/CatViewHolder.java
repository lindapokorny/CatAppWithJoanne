package com.pursuit.catappfromscratchwithjoannerecyclerview.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.catappfromscratchwithjoannerecyclerview.CatPojo;
import com.pursuit.catappfromscratchwithjoannerecyclerview.R;
import com.squareup.picasso.Picasso;

public class CatViewHolder extends RecyclerView.ViewHolder {

    private TextView catNameTextview;
    private ImageView catImageView;

    public CatViewHolder(@NonNull View itemView) {
        super(itemView);

        catNameTextview = itemView.findViewById(R.id.name_text_view);
        catImageView = itemView.findViewById(R.id.image_imageview);

    }

    public void onBind(CatPojo breed){
        catNameTextview.setText(breed.getId());
    }
}
