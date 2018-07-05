package com.buggyarts.customviews.adapters.recyclerViewAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerSuperAdapter extends RecyclerView.Adapter<RecyclerSuperAdapter.SuperAdapterViewHolder>{

    @NonNull
    @Override
    public SuperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SuperAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SuperAdapterViewHolder extends RecyclerView.ViewHolder{

        public SuperAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
