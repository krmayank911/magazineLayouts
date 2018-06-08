package com.buggyarts.customviews.customViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.buggyarts.customviews.R;

public class CVOne extends FrameLayout implements View.OnClickListener{

    public interface VOneCallbacks{
        void onTitleClick();
    }

    private VOneCallbacks callbackListener;

    public void setCallbackListener(VOneCallbacks listener){
        this.callbackListener = listener;
    }

    private TextView title;
    private TextView subTitle;
    private TextView text;

    private ImageView coverImage;

    private RelativeLayout textContainer;
    private RelativeLayout imageContainer;
    private RelativeLayout viewContainer;

    public CVOne(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.cv_one,this,true);

        title = findViewById(R.id.viewTitle);
        subTitle = findViewById(R.id.viewSubTitle);
        text = findViewById(R.id.viewText);

        textContainer = findViewById(R.id.viewTextContainer);
        imageContainer = findViewById(R.id.viewImageContainer);
        viewContainer = findViewById(R.id.viewContainer);

        title.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.viewTitle){
            callbackListener.onTitleClick();
        }
    }

    public void setTitle(String title){
        this.title.setText(title);
    }

    public TextView getTitle() {
        return title;
    }

    public void setSubTitle(String subTitle){
        this.subTitle.setText(subTitle);
    }

    public TextView getSubTitle() {
        return subTitle;
    }

    public void setText(String text){
        this.text.setText(text);
    }

    public TextView getText() {
        return text;
    }

    public void setCoverImage(int id){
        this.coverImage.setImageResource(id);
    }

    public ImageView getCoverImage() {
        return coverImage;
    }

    public RelativeLayout getImageContainer() {
        return imageContainer;
    }

    public RelativeLayout getTextContainer() {
        return textContainer;
    }

    public RelativeLayout getViewContainer() {
        return viewContainer;
    }
}
