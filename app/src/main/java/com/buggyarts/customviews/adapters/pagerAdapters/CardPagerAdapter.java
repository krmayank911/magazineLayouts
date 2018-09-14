package com.buggyarts.customviews.adapters.pagerAdapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.buggyarts.customviews.R;
import com.buggyarts.customviews.customClasses.CardAdapter;
import com.buggyarts.customviews.customClasses.GlideApp;
import com.buggyarts.customviews.customViews.SkewedLayout;
import com.buggyarts.customviews.model.CardItem;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter{

    private List<RelativeLayout> mViews = new ArrayList<>();
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
    public int getCardCount() {
        return mData.size();
    }

    @Override
    public RelativeLayout getCardViewAt(int position) {
        if(mViews.size() != 0) {

            int virtualPosition = position % this.getRealCount();
            return mViews.get(virtualPosition);

        }else return null;
    }

//    @Override
//    public int getCount() {
//        return mData.size();
//    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position ) {

        int virtualPosition = position % this.getRealCount();

        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.custom_hl_cell, container, false);
        container.addView(view);
//        bind(mData.get(position), view);
        setViews(mData.get(virtualPosition), view);
        RelativeLayout cardView = (RelativeLayout) view.findViewById(R.id.cardView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            if (mBaseElevation == 0) {
                mBaseElevation = cardView.getElevation();
            }

            cardView.setElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
            mViews.set(virtualPosition, cardView);
        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        int virtualPosition = position % this.getRealCount();
        mViews.set(virtualPosition, null);
    }

    private void bind(CardItem item, View view) {
//        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
//        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
//        titleTextView.setText(item.getTitle());
//        contentTextView.setText(item.getText());
    }

    private void setViews(CardItem item, View view){

        SkewedLayout skewedLayout = view.findViewById(R.id.skewLayout);
        skewedLayout.labelTextView.setText(item.getLableText());

//        ImageView imageView = view.findViewById(R.id.cell_iv);
//        TextView labelTextView = view.findViewById(R.id.labelText);

//        labelTextView.setText(item.getLableText());
//        Glide.with(mContext).load(item.getImageLink()).into(imageView);
        GlideApp.with(mContext).load(item.getImageLink()).into(skewedLayout.imageView);
    }

    @Override
    public int getCount() {
        return getRealCount() == 0 ? 0 :  4000;
    }

    public int getRealCount() {
        return getCardCount();
    }


}
