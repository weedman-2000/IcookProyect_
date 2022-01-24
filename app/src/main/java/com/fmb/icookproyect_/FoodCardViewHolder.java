package com.fmb.icookproyect_;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class FoodCardViewHolder extends RecyclerView.ViewHolder
{
    public NetworkImageView foodImage;
    public TextView foodName;
    public TextView foodDescription;

    public FoodCardViewHolder(@NonNull View itemView)
    {
        super(itemView);
        foodImage = itemView.findViewById(R.id.food_image);
        foodName = itemView.findViewById(R.id.food_name);
        foodDescription = itemView.findViewById(R.id.food_description);

    }
}
