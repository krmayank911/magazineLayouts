package com.buggyarts.customviews;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.buggyarts.customviews.adapters.SquareCellAdapterHRV;
import com.buggyarts.customviews.adapters.pagerAdapters.CardPagerAdapter;
import com.buggyarts.customviews.adapters.recyclerViewAdapters.SkewRecyclerAdapter;
import com.buggyarts.customviews.customClasses.PageTransfromer;
import com.buggyarts.customviews.customClasses.ShadowTransformer;
import com.buggyarts.customviews.customViews.CustomHLView;
import com.buggyarts.customviews.customViews.HRVOne;
import com.buggyarts.customviews.model.CardItem;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

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

    String[] list2 = {"https://media.gettyimages.com/photos/singer-camila-cabello-is-photographed-for-billboard-magazine-on-20-picture-id877067284?k=6&m=877067284&s=612x612&w=0&h=SwpaWwtmYITcbu4WKO-nN4F6G7prI8vkADS2_xaeVd8=",
            "https://www.adorama.com/alc/wp-content/uploads/2014/07/shutterstock_598339082.jpg",
            "https://images.pexels.com/photos/794064/pexels-photo-794064.jpeg?auto=compress&cs=tinysrgb&h=350",
            "https://www.melyssagriffin.com/wp-content/uploads/2014/03/Fashion-1-2.jpg",
            "https://1.bp.blogspot.com/-dfW_j_Bzbts/Vm6VBku3QRI/AAAAAAAACOs/pdZ0uavxkeY/s1600/FC6A0451%2Bcopy.jpg"
    };

    ArrayList<CardItem> cardItems = new ArrayList<>();

    private DiscreteScrollView hrv;
    private RecyclerView.LayoutManager hrvLayoutManager;
    private SkewRecyclerAdapter hrvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hrvOne = findViewById(R.id.hrvOne);
        hrvOne.setHrvTitle("This Week");
        hrvOne.getHrvContainer().setBackgroundColor(getResources().getColor(R.color.v1_background));

        imageList = new ArrayList<>();
//        imageList = (ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.squareImages));
        for(String item: list){
//            imageList.add(item);
        }
        hrvOne.setImageList(imageList);
        hrvOne.setupData();
        hrvOne.updateView();

        CustomHLView customHLView = findViewById(R.id.custom_hl_view);

        for(String imageLink: list2){
            cardItems.add(new CardItem(imageLink,"label"));
        }

        customHLView.setupData(cardItems);

        setupData();

    }

    public void setupData(){
        for(String item: list2){
            imageList.add(item);
        }

        hrv = findViewById(R.id.skew_recycler);
        hrvLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        hrv.setLayoutManager(hrvLayoutManager);

        hrvAdapter = new SkewRecyclerAdapter(this, imageList);

        InfiniteScrollAdapter wrapper = InfiniteScrollAdapter.wrap(hrvAdapter);

        hrv.setAdapter(wrapper);

        hrv.setOffscreenItems(2); //Reserve extra space equal to (childSize * count) on each side of the view
        hrv.setOverScrollEnabled(false); //Can also be set using android:overScrollMode xml attribute
        hrv.setItemTransitionTimeMillis(300); //determines how much time it takes to change the item on fling, settle or smoothScroll

        hrv.setItemTransformer(new PageTransfromer.Builder()
                .setMaxScale(1.45f)
                .setMinScale(1.25f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.CENTER) // CENTER is a default one
                .build());

//        hrv.setSlideOnFling(true);

    }
}
