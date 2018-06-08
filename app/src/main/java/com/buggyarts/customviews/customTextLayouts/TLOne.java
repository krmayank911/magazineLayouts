package com.buggyarts.customviews.customTextLayouts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.buggyarts.customviews.R;

public class TLOne extends FrameLayout implements View.OnClickListener {

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

    private RelativeLayout textContainer;

    public TLOne(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.text_layout_1,this,true);

        title = findViewById(R.id.viewTitle);
        subTitle = findViewById(R.id.viewSubTitle);
        text = findViewById(R.id.viewText);
        textContainer = findViewById(R.id.viewTextContainer);

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

    public RelativeLayout getTextContainer() {
        return textContainer;
    }
}
