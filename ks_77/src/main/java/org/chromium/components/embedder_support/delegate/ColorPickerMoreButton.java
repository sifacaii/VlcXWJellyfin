package org.chromium.components.embedder_support.delegate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/embedder_support/delegate/ColorPickerMoreButton.class */
public class ColorPickerMoreButton extends Button {
    private Paint mBorderPaint;

    public ColorPickerMoreButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorPickerMoreButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(-1);
        this.mBorderPaint.setStrokeWidth(1.0f);
        this.mBorderPaint.setAntiAlias(false);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0.5f, 0.5f, getWidth() - 1.5f, getHeight() - 1.5f, this.mBorderPaint);
        super.onDraw(canvas);
    }
}
