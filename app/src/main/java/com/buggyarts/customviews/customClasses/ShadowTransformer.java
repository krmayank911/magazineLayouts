package com.buggyarts.customviews.customClasses;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.buggyarts.customviews.R;


public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

    private ViewPager mViewPager;
    private CardAdapter mAdapter;
    private float mLastOffset = 0;
    private boolean mScalingEnabled;

    String TAG = ShadowTransformer.class.getSimpleName();
    private static final float MIN_SCALE = 1.52f;
    private static final float MAX_SCALE = MIN_SCALE + 0.2f;
    private static final float MIN_ALPHA = 0.5f;

    public ShadowTransformer(ViewPager viewPager, CardAdapter adapter) {
        mViewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        mAdapter = adapter;
    }

    public void enableScaling(boolean enable) {
//        if (mScalingEnabled && !enable) {
//            // shrink main card
//            RelativeLayout currentCard = mAdapter.getCardViewAt(mViewPager.getCurrentItem());
//            if (currentCard != null) {
//                currentCard.animate().scaleY(1.6f);
//                currentCard.animate().scaleX(1.6f);
//            }
//        }else if(!mScalingEnabled && enable){
//            // grow main card
//            RelativeLayout currentCard = mAdapter.getCardViewAt(mViewPager.getCurrentItem());
//            if (currentCard != null) {
//                currentCard.animate().scaleY(1.6f);
//                currentCard.animate().scaleX(1.6f);
//            }
//        }

        mScalingEnabled = enable;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            // view.setAlpha(0);

            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            view.setElevation(1);

        } else if (position <= 1) { // [-1,1]

            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

//            float horzMargin = (position % 3) * (pageWidth/3);
//
//            if (position < 0) {
//                view.findViewById(R.id.skewLayout).setTranslationX( - (position%3) * pageWidth );
//            }

            view.setElevation(2);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            // view.setAlpha(0);

            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            view.setElevation(1);

        }

    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        int realCurrentPosition;
//        int nextPosition;
//        float baseElevation = mAdapter.getBaseElevation();
//        float realOffset;
////        if(mLastOffset - positionOffset > 0.5 || positionOffset - mLastOffset > 0.5 || mLastOffset == 0) {
//            boolean goingLeft = mLastOffset > positionOffset;
//            // If we're going backwards, onPageScrolled receives the last position
//            // instead of the current one
//            if (goingLeft) {
//                realCurrentPosition = position + 1;
//                nextPosition = position;
//                realOffset = 1 - positionOffset;
//            } else {
//                nextPosition = position + 1;
//                realCurrentPosition = position;
//                realOffset = positionOffset;
//            }
//
//            // Avoid crash on overscroll
////            if (nextPosition > mAdapter.getCardCount() - 1
////                    || realCurrentPosition > mAdapter.getCardCount() - 1) {
////                return;
////
//            RelativeLayout currentCard = mAdapter.getCardViewAt(realCurrentPosition);
//
//            // This might be null if a fragment is being used
//            // and the views weren't created yet
//            if (currentCard != null) {
//                if (mScalingEnabled) {
////              }         currentCard.setScaleX((float) (1.5 + 0.1 * (1 - realOffset)));
////                    currentCard.setScaleY((float) (1.5 + 0.1 * (1 - realOffset)));
//
//                    currentCard.setScaleX((float) (1.6f));
//                    currentCard.setScaleY((float) (1.6f));
//                }
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    currentCard.setElevation((baseElevation + baseElevation
//                            * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (1 - realOffset)));
//                }
//            }
//
//            RelativeLayout nextCard = mAdapter.getCardViewAt(nextPosition);
//
//            // We might be scrolling fast enough so that the next (or previous) card
//            // was already destroyed or a fragment might not have been created yet
//            if (nextCard != null) {
//                if (mScalingEnabled) {
////                    nextCard.setScaleX((float) (1.5 + 0.1 * (realOffset)));
////                    nextCard.setScaleY((float) (1.5 + 0.1 * (realOffset)));
//
//                    nextCard.setScaleX((float) (1.6f));
//                    nextCard.setScaleY((float) (1.6f));
//                }
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    nextCard.setElevation((baseElevation + baseElevation
//                            * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (realOffset)));
//                }
//            }
//
//            mLastOffset = positionOffset;
////        }
//    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        int realCurrentPosition;
//        int nextPosition;
//        float baseElevation = mAdapter.getBaseElevation();
//        float realOffset;
////        if(mLastOffset - positionOffset > 0.5 || positionOffset - mLastOffset > 0.5 || mLastOffset == 0) {
//            boolean goingLeft = mLastOffset > positionOffset;
//            // If we're going backwards, onPageScrolled receives the last position
//            // instead of the current one
//            if (goingLeft) {
//                realCurrentPosition = position + 1;
//                nextPosition = position;
//                realOffset = 1 - positionOffset;
//            } else {
//                nextPosition = position + 1;
//                realCurrentPosition = position;
//                realOffset = positionOffset;
//            }
//
////             Avoid crash on overscroll
//            if (nextPosition > mAdapter.getCardCount() - 1
//                    || realCurrentPosition > mAdapter.getCardCount() - 1) {
//                return;
//            }
//
//            RelativeLayout currentCard = mAdapter.getCardViewAt(realCurrentPosition);
//
//            if (currentCard != null) {
//                if (mScalingEnabled) {
//                }
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    currentCard.setElevation((baseElevation + baseElevation
//                            * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (1 - realOffset)));
//                }
//            }
//
//            RelativeLayout nextCard = mAdapter.getCardViewAt(nextPosition);
//
//            if (nextCard != null) {
//                if (mScalingEnabled) {
////                    currentCard.setTranslationX(-position * (currentCard.getWidth() / 2)); //Half the normal speed
//                }
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    nextCard.setElevation((baseElevation + baseElevation
//                            * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (realOffset)));
//                }
//            }
//
//            mLastOffset = positionOffset;
////        }

    }
}
