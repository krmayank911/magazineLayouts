package com.buggyarts.customviews.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.buggyarts.customviews.R;
import com.buggyarts.customviews.model.CardItem;
import com.buggyarts.customviews.model.MDImage;
import com.buggyarts.customviews.model.StoryData;

import java.util.ArrayList;

public class StoryMIView extends FrameLayout{

    StoryData data;

    ArrayList<CardItem> cardItems = new ArrayList<>();
    CustomHLView customHLView;

    public StoryMIView(Context context, AttributeSet attrs) {
        super(context, attrs);

        customHLView = findViewById(R.id.custom_hl_view);

        for(MDImage mdImage: data.getImages()){
            cardItems.add(new CardItem(mdImage.getImageUrl(),mdImage.getImageLabel()));
        }

        customHLView.setupData(cardItems);
    }
}
