package com.buggyarts.customviews.customViews;//        if (mScalingEnabled && !enable) {
//            // shrink main card
//            RelativeLayout currentCard = mAdapter.getCardViewAt(mViewPager.getCurrentItem());
//            if (currentCard != null) {
//                currentCard.animate().scaleY(1.5f);
//                currentCard.animate().scaleX(1.5f);
//            }
//        }else if(!mScalingEnabled && enable){
//            // grow main card
//            RelativeLayout currentCard = mAdapter.getCardViewAt(mViewPager.getCurrentItem());
//            if (currentCard != null) {
//                currentCard.animate().scaleY(1.5f);
//                currentCard.animate().scaleX(1.5f);
//            }
//        }

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.buggyarts.customviews.R;
import com.github.siyamed.shapeimageview.ShapeImageView;

public class SkewedLayout extends FrameLayout{

    public int backgroundColor;
    public ShapeImageView imageView;
    public TextView labelTextView;

    //paint for drawing custom view
    private Paint mPaint;
    private Path mPath;

    int width;
    int height;

    View view;

    public SkewedLayout(@NonNull Context context) {
        super(context);

    }

    public SkewedLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

//        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.SkewLayout,0,0);
//
//        try {
//            //get the text and colors specified using the names in attrs.xml
//            backgroundColor = a.getInteger(R.styleable.SkewLayout_backgroundColor, 0);//0 is default
//        } finally {
//            a.recycle();
//        }
//
//        init();

        view = LayoutInflater.from(context).inflate(R.layout.skewed_frame,this,true);
        imageView = findViewById(R.id.cell_iv);
        labelTextView = findViewById(R.id.labelText);

    }

//    void init(){
//        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
//        mPaint.setColor(backgroundColor);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPath = new Path();
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
//        width = MeasureSpec.getSize(widthMeasureSpec);
//        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        height = MeasureSpec.getSize(heightMeasureSpec);
//        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//    }
//
//    @Override
//    protected void dispatchDraw(Canvas canvas) {
//        super.dispatchDraw(canvas);
//
//        mPath.moveTo(width/2,0);
//        mPath.lineTo(width,0);
//        mPath.lineTo(width/2,height);
//        mPath.lineTo(0,height);
//        mPath.lineTo(width/2,0);
//        mPath.close();
//
//        canvas.drawPath(mPath,mPaint);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//
//        getChildAt(0).layout(0,0,width,height);
//    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        //redraw the view
        invalidate();
        requestLayout();
    }

    public ShapeImageView getImageView() {
        return imageView;
    }

    public void setImageView(ShapeImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getLabelTextView() {
        return labelTextView;
    }

    public void setLabelTextView(TextView labelTextView) {
        this.labelTextView = labelTextView;
    }
}
