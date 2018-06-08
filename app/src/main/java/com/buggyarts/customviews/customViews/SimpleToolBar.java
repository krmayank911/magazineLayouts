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

public class SimpleToolBar extends FrameLayout implements View.OnClickListener{

    private TextView titleLabel;
    private ImageView backButton;
    private RelativeLayout backGroundView;

    private TopBarCallback topCallback;

    public interface TopBarCallback {
        void backButtonCalled();
    }

    public void setTopbarListener(TopBarCallback mCallback) {
        this.topCallback = mCallback;
    }

    public SimpleToolBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_topbar, this, true);
        titleLabel = findViewById(R.id.title);
        backGroundView = findViewById(R.id.backgroundView);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.backButton){
            topCallback.backButtonCalled();
        }
    }

    public RelativeLayout getBackGroundView() {
        return backGroundView;
    }

    public void setBackGroundView(RelativeLayout backGroundView) {
        this.backGroundView = backGroundView;
    }

    public ImageView getBackButton() {
        return backButton;
    }

    public TextView getTitleLabel() {
        return titleLabel;
    }
}
