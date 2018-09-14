package com.buggyarts.customviews.customClasses;


import android.support.v7.widget.CardView;
import android.widget.RelativeLayout;

public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    RelativeLayout getCardViewAt(int position);

    int getCardCount();
}
