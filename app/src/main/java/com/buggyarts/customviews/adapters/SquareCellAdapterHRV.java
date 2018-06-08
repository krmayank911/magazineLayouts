package com.buggyarts.customviews.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buggyarts.customviews.R;
import com.buggyarts.customviews.viewHolders.VHSquareCell;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SquareCellAdapterHRV extends RecyclerView.Adapter<VHSquareCell> implements View.OnClickListener{

    public interface SquareCellCallbacks{
        void onCellClick();
    }

    private Context context;
    private ArrayList<String> imageList;
    private SquareCellCallbacks cellCallbacks;

    public int CELL_CONTAINER = 10;

    public SquareCellAdapterHRV(Context context, ArrayList<String> list){
        this.imageList = list;
        this.context = context;
    }

    public void setUpCellCallbacks(SquareCellCallbacks cellCallbacks){
        this.cellCallbacks = cellCallbacks;
    }

    @NonNull
    @Override
    public VHSquareCell onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_hrv_square_no_text,parent,false);
        return new VHSquareCell(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHSquareCell holder, int position) {

//        holder.container.setTag(CELL_CONTAINER,holder);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cellCallbacks.onCellClick();
            }
        });

        //user Glide to set images
        Glide.with(context).load(imageList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(imageList.size() > 0){
            return imageList.size();
        }
        return 0;
    }

    @Override
    public void onClick(View view) {

    }
}
