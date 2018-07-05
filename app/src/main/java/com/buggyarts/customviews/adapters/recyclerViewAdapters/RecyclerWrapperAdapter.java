package com.buggyarts.customviews.adapters.recyclerViewAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buggyarts.customviews.R;
import com.buggyarts.customviews.model.StoryData;

import java.util.ArrayList;

public class RecyclerWrapperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    public ArrayList<Object> objectArrayList;

    /**
     * Data type constants
     */
    private static final int ITEM_TYPE_COLUMN = 11;
    private static final int ITEM_TYPE_EVENT = 22;
    private static final int ITEM_TYPE_FEATURED = 33;
    private static final int ITEM_TYPE_AD = 44;

    public RecyclerWrapperAdapter(Context context,ArrayList<Object> objects){
        this.mContext = context;
        this.objectArrayList = objects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;

        switch (viewType){
            case ITEM_TYPE_COLUMN:
//                itemView = LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.cell, parent, false);
//                return new ViewHolder(itemView);
                break;
            case ITEM_TYPE_EVENT: break;
            case ITEM_TYPE_FEATURED: break;
            case ITEM_TYPE_AD: break;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch(holder.getItemViewType()){
            case ITEM_TYPE_COLUMN:
//                StoryData data = (StoryData) objectArrayList.get(position);
//                setupStoryView(holder,position,data);
                break;
            case ITEM_TYPE_EVENT: break;
            case ITEM_TYPE_FEATURED: break;
            case ITEM_TYPE_AD: break;
        }
    }

    @Override
    public int getItemCount() {
        if(objectArrayList.size() > 0){
            return objectArrayList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {

        Object object = objectArrayList.get(position);

        if(object != null){
            if(object instanceof StoryData){
                return ITEM_TYPE_COLUMN;
            }
        }

        return super.getItemViewType(position);
    }

}
