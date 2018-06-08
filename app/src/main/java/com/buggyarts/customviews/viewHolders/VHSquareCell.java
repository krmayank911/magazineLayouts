package com.buggyarts.customviews.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.buggyarts.customviews.R;

public class VHSquareCell extends RecyclerView.ViewHolder {

    public RelativeLayout container;
    public ImageView imageView;

    public VHSquareCell(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.cell_image);
        container = itemView.findViewById(R.id.cell_container);
    }
}
