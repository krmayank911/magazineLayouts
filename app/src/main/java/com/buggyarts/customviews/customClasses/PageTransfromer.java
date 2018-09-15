package com.buggyarts.customviews.customClasses;

import android.os.Build;
import android.support.annotation.FloatRange;
import android.view.View;

import com.buggyarts.customviews.R;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import com.yarolegovich.discretescrollview.transform.Pivot;

public class PageTransfromer implements DiscreteScrollItemTransformer {

    private Pivot pivotX;
    private Pivot pivotY;
    private float minScale;
    private float maxMinDiff;

    private View imageView;

    public PageTransfromer() {
        pivotX = Pivot.X.CENTER.create();
        pivotY = Pivot.Y.CENTER.create();
        minScale = 0.8f;
        maxMinDiff = 0.2f;
    }

    @Override
    public void transformItem(View item, float position) {
        pivotX.setOn(item);
        pivotY.setOn(item);
        float closenessToCenter = 1f - Math.abs(position);
        float scale = minScale + maxMinDiff * closenessToCenter;
        item.setScaleX(scale);
        item.setScaleY(scale);

//        float width = item.findViewById(R.id.skewLayout).getMeasuredWidth();
//        float translation = width / (scale);
//
//        item.findViewById(R.id.cell_iv).setTranslationX(- item.getWidth()/2 * position);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (position!= 0) {
                item.setElevation(2);
            } else {
                item.setElevation(4);
            }
        }

    }

    public static class Builder {

        private PageTransfromer transformer;
        private float maxScale;

        public Builder() {
            transformer = new PageTransfromer();
            maxScale = 1f;
        }

        public PageTransfromer.Builder setMinScale(@FloatRange(from = 0.01) float scale) {
            transformer.minScale = scale;
            return this;
        }

        public PageTransfromer.Builder setMaxScale(@FloatRange(from = 0.01) float scale) {
            maxScale = scale;
            return this;
        }

        public PageTransfromer.Builder setPivotX(Pivot.X pivotX) {
            return setPivotX(pivotX.create());
        }

        public PageTransfromer.Builder setPivotX(Pivot pivot) {
            assertAxis(pivot, Pivot.AXIS_X);
            transformer.pivotX = pivot;
            return this;
        }

        public PageTransfromer.Builder setPivotY(Pivot.Y pivotY) {
            return setPivotY(pivotY.create());
        }

        public PageTransfromer.Builder setPivotY(Pivot pivot) {
            assertAxis(pivot, Pivot.AXIS_Y);
            transformer.pivotY = pivot;
            return this;
        }

        public PageTransfromer.Builder setImageView(View imageView) {
            transformer.imageView = imageView;
            return this;
        }

        public PageTransfromer build() {
            transformer.maxMinDiff = maxScale - transformer.minScale;
            return transformer;
        }

        private void assertAxis(Pivot pivot, @Pivot.Axis int axis) {
            if (pivot.getAxis() != axis) {
                throw new IllegalArgumentException("You passed a Pivot for wrong axis.");
            }
        }
    }
}
