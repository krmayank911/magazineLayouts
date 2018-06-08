package com.buggyarts.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.buggyarts.customviews.customViews.HRVOne;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    HRVOne hrvOne;
    ArrayList<String> imageList;
    String[] list = {"https://e-mozg.com/wp-content/uploads/2017/11/Preview_lovepam-1-500x500.png",
    "http://hopojo.com/wp-content/uploads/2017/11/catalogmodel-11.jpg",
    "http://invenda.co.uk/wp-content/uploads/2013/10/INVENDA-1.jpg",
    "http://www.fei-xu.com/wp-content/uploads/2015/03/ss-500x500.jpg",
    "https://static1.squarespace.com/static/599d1aaf6b8f5b243b14699c/5a5502bb419202e14cbbc8ce/5a567db79140b755af37eba2/1515617761737/model-portfolio-portraits-denver-colorado-las-vegas-rebel-imagery-3.jpg?format=500w",
    "https://static1.squarespace.com/static/5a7b6a5080bd5e9ec7cf2205/t/5a7c2b71e2c483d427b4e3b0/1519231978084/12.jpg?format=500w"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hrvOne = findViewById(R.id.hrvOne);
        hrvOne.setHrvTitle("This Week");
        hrvOne.getHrvContainer().setBackgroundColor(getResources().getColor(R.color.v1_background));
//        imageList = new ArrayList<>();
//        imageList = (ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.squareImages));
//        for(String item: list){
//            imageList.add(item);
//        }
//        hrvOne.setImageList(imageList);
//        hrvOne.updateView();
    }
}
