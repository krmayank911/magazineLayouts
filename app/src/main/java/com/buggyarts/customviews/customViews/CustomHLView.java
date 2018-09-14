package com.buggyarts.customviews.customViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.antonyt.infiniteviewpager.InfinitePagerAdapter;
import com.antonyt.infiniteviewpager.InfiniteViewPager;
import com.buggyarts.customviews.R;
import com.buggyarts.customviews.adapters.pagerAdapters.CardPagerAdapter;
import com.buggyarts.customviews.adapters.pagerAdapters.InfinitePager;
import com.buggyarts.customviews.customClasses.ShadowTransformer;
import com.buggyarts.customviews.model.CardItem;

import java.util.ArrayList;

public class CustomHLView extends FrameLayout implements ViewPager.OnPageChangeListener{

    private InfiniteViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private TextView itemCount;

    private Context mContext;

    public ArrayList<CardItem> cards = new ArrayList<>();


    public CustomHLView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.custom_hl_view,this,true);

        mViewPager = findViewById(R.id.viewPager);
        itemCount = findViewById(R.id.itemCount);
        mContext = context;

    }

    public void setupData(ArrayList<CardItem> itemList){

        cards = itemList;

        mCardAdapter = new CardPagerAdapter(mContext);
//        InfinitePager infinitePager = new InfinitePager(mContext,mCardAdapter);

        for(CardItem item : cards){
            mCardAdapter.addCardItem(item);
        }

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setCurrentItem(200);

        mViewPager.addOnPageChangeListener(this);

        mCardShadowTransformer.enableScaling(true);

        String textCount = 1 + "/" + cards.size();
        itemCount.setText(textCount);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        String textCount = position + 1 + "/" + cards.size();
        itemCount.setText(textCount);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
