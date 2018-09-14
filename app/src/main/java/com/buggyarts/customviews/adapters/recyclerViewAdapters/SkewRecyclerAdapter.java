package com.buggyarts.customviews.adapters.recyclerViewAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buggyarts.customviews.R;
import com.buggyarts.customviews.customViews.SkewedLayout;
import com.buggyarts.customviews.viewHolders.VHSquareCell;
import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.ShapeImageView;

import java.util.ArrayList;

public class SkewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    public interface SquareCellCallbacks{
        void onCellClick();
    }

    private Context context;
    private ArrayList<String> imageList;
    private SquareCellCallbacks cellCallbacks;

    public int CELL_CONTAINER = 10;

    public SkewRecyclerAdapter(Context context, ArrayList<String> list){
        this.imageList = list;
        this.context = context;
    }

    public void setUpCellCallbacks(SquareCellCallbacks cellCallbacks){
        this.cellCallbacks = cellCallbacks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.cell_hrv_square_no_text,parent,false);

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_hl_cell,parent,false);

        return new SkewCellHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SkewCellHolder skewCellHolder = (SkewCellHolder) holder;

        //user Glide to set images
        Glide.with(context).load(imageList.get(position)).into(skewCellHolder.layout.getImageView());
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


    public class SkewCellHolder extends RecyclerView.ViewHolder{

        public SkewedLayout layout;

        public SkewCellHolder(View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.skewLayout);
        }


    }
}
