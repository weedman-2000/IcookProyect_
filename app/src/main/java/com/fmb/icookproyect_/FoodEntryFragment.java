package com.fmb.icookproyect_;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fmb.icookproyect_.network.FoodEntry;

public class FoodEntryFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView
            (
                @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
            )
    {
        //return inflater.inflate(R.layout.food_entry_fragment, container, false);
        View view = inflater.inflate(R.layout.food_entry_fragment, container, false);

        setUpToolBar(view);

        RecyclerView recyclerView    = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
        FoodCardRecyclerViewAdapter adapter = new FoodCardRecyclerViewAdapter
                (
                        FoodEntry.initFoodEntryList(getResources())
                );
        recyclerView.setAdapter(adapter);

        //recyclerView.addItemDecoration(new FoodGridItemDecoration());


        return view;
    }

    private void setUpToolBar(View view)
    {
        Toolbar toolbar = view  .findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        if(activity != null)
        {
            activity.setSupportActionBar(toolbar);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater)
    {
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
