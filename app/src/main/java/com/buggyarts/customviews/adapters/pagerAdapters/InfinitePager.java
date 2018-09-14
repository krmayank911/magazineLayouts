package com.buggyarts.customviews.adapters.pagerAdapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.buggyarts.customviews.customClasses.CardAdapter;


public class InfinitePager extends CardPagerAdapter implements CardAdapter{
    private static final String TAG = "InfinitePagerAdapter";
    private static final boolean DEBUG = true;
    private PagerAdapter adapter;

    public InfinitePager(Context context ,PagerAdapter adapter) {
        super(context);
        this.adapter = adapter;
    }

    @Override
    public RelativeLayout getCardViewAt(int position) {
        return getCardViewAt(position);
    }

    @Override
    public int getCardCount() {
        return super.getCount();
    }

    public int getCount() {
        return this.getRealCount() == 0 ? 0 : 2147483647;
    }

    public int getRealCount() {
        return this.adapter.getCount();
    }

    public Object instantiateItem(ViewGroup container, int position) {
        int virtualPosition = position % this.getRealCount();
        this.debug("instantiateItem: real position: " + position);
        this.debug("instantiateItem: virtual position: " + virtualPosition);
        return this.adapter.instantiateItem(container, virtualPosition);
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        int virtualPosition = position % this.getRealCount();
        this.debug("destroyItem: real position: " + position);
        this.debug("destroyItem: virtual position: " + virtualPosition);
        this.adapter.destroyItem(container, virtualPosition, object);
    }

    public void finishUpdate(ViewGroup container) {
        this.adapter.finishUpdate(container);
    }

    public boolean isViewFromObject(View view, Object object) {
        return this.adapter.isViewFromObject(view, object);
    }

    public void restoreState(Parcelable bundle, ClassLoader classLoader) {
        this.adapter.restoreState(bundle, classLoader);
    }

    public Parcelable saveState() {
        return this.adapter.saveState();
    }

    public void startUpdate(ViewGroup container) {
        this.adapter.startUpdate(container);
    }

    public CharSequence getPageTitle(int position) {
        int virtualPosition = position % this.getRealCount();
        return this.adapter.getPageTitle(virtualPosition);
    }

    public float getPageWidth(int position) {
        return this.adapter.getPageWidth(position);
    }

    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        this.adapter.setPrimaryItem(container, position, object);
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        this.adapter.unregisterDataSetObserver(observer);
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        this.adapter.registerDataSetObserver(observer);
    }

    public void notifyDataSetChanged() {
        this.adapter.notifyDataSetChanged();
    }

    public int getItemPosition(Object object) {
        return this.adapter.getItemPosition(object);
    }

    private void debug(String message) {
        Log.d("InfinitePagerAdapter", message);
    }
}
