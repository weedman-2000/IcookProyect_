package com.fmb.icookproyect_;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.display.DeviceProductInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.fmb.icookproyect_.network.FoodEntry;
import com.fmb.icookproyect_.network.ImageRequest;

import java.util.List;

public class FoodCardRecyclerViewAdapter extends RecyclerView.Adapter<FoodCardViewHolder>
{
    private List<FoodEntry> foodList;
    private ImageRequest imageRequest;

    FoodCardRecyclerViewAdapter(List<FoodEntry> foodList)
    {
        this.foodList = foodList;
        imageRequest = ImageRequest.getInstance();

    }

    @NonNull
    @Override
    public FoodCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType)
    {
        View layoutView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.food_card,parent,false);
        return new FoodCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodCardViewHolder holder, int position)
    {
        if(foodList != null && position < foodList.size())
        {
            FoodEntry food = foodList.get(position);
            holder.foodName.setText(food.title);
            holder.foodDescription.setText(food.type);
            imageRequest.setImageLoader(holder.foodImage, food.url);
        }
    }

    @Override
    public int getItemCount(){return foodList.size();}


}
