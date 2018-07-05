package com.buggyarts.customviews.adapters.pagerAdapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buggyarts.customviews.R;
import com.buggyarts.customviews.customClasses.CardAdapter;
import com.buggyarts.customviews.customClasses.GlideApp;
import com.buggyarts.customviews.customClasses.MyGlideModule;
import com.buggyarts.customviews.model.CardItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;
    private Context mContext;

    public CardPagerAdapter(Context context) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        this.mContext = context;
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.custom_hl_cell, container, false);
        container.addView(view);
//        bind(mData.get(position), view);
        setViews(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
//        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
//        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
//        titleTextView.setText(item.getTitle());
//        contentTextView.setText(item.getText());
    }

    private void setViews(CardItem item, View view){
        ImageView imageView = view.findViewById(R.id.cell_iv);
        TextView labelTextView = view.findViewById(R.id.labelText);

        labelTextView.setText(item.getLableText());
//        Glide.with(mContext).load(item.getImageLink()).into(imageView);
        GlideApp.with(mContext).load(item.getImageLink()).into(imageView);
    }

}
