package com.buggyarts.customviews.customViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.buggyarts.customviews.R;
import com.buggyarts.customviews.adapters.SquareCellAdapterHRV;

import java.util.ArrayList;

public class HRVOne extends FrameLayout implements SquareCellAdapterHRV.SquareCellCallbacks{

    private ArrayList<String> imageList = new ArrayList<>();

    private TextView hrvTitle;
    private RecyclerView hrv;

    private RelativeLayout hrvContainer;
    private RecyclerView.LayoutManager hrvLayoutManager;
    private SquareCellAdapterHRV hrvAdapter;

    private Context mContext;

    String[] list = {"https://e-mozg.com/wp-content/uploads/2017/11/Preview_lovepam-1-500x500.png",
            "http://hopojo.com/wp-content/uploads/2017/11/catalogmodel-11.jpg",
            "http://invenda.co.uk/wp-content/uploads/2013/10/INVENDA-1.jpg",
            "http://www.fei-xu.com/wp-content/uploads/2015/03/ss-500x500.jpg",
            "https://static1.squarespace.com/static/599d1aaf6b8f5b243b14699c/5a5502bb419202e14cbbc8ce/5a567db79140b755af37eba2/1515617761737/model-portfolio-portraits-denver-colorado-las-vegas-rebel-imagery-3.jpg?format=500w",
            "https://static1.squarespace.com/static/5a7b6a5080bd5e9ec7cf2205/t/5a7c2b71e2c483d427b4e3b0/1519231978084/12.jpg?format=500w"};


    public HRVOne(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.hrv_one,this,true);

        hrvTitle = findViewById(R.id.hrv_title);
        hrv = findViewById(R.id.hrv_recyclerView);
        hrvContainer = findViewById(R.id.hrv_container);

        this.mContext = context;
        // update data here
    }

    public void setupData(){
        for(String item: list){
            imageList.add(item);
        }

        hrvLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        hrv.setLayoutManager(hrvLayoutManager);

        hrvAdapter = new SquareCellAdapterHRV(mContext, imageList);
        hrvAdapter.setUpCellCallbacks(this);
        hrv.setAdapter(hrvAdapter);
    }

    public TextView getHrvTitle() {
        return hrvTitle;
    }

    public void setHrvTitle(String title){
        this.hrvTitle.setText(title);
    }

    public RecyclerView getHrv() {
        return hrv;
    }

    public RelativeLayout getHrvContainer() {
        return hrvContainer;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    public ArrayList<String> getImageList() {
        return imageList;
    }

    public void updateView(){
        hrvAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCellClick() {
        // show me its details
    }
}
