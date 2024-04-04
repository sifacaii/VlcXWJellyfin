package org.chromium.content.browser.selection;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/MagnifierAnimator.class */
public class MagnifierAnimator implements SelectionInsertionHandleObserver {
    private static final long DURATION_MS = 100;
    private MagnifierWrapper mMagnifier;
    private ValueAnimator mAnimator;
    private boolean mMagnifierIsShowing;
    private float mAnimationCurrentX;
    private float mAnimationCurrentY;
    private float mAnimationStartX;
    private float mAnimationStartY;
    private float mTargetX;
    private float mTargetY;

    public MagnifierAnimator(MagnifierWrapper magnifier) {
        this.mMagnifier = magnifier;
        createValueAnimator();
        this.mTargetX = -1.0f;
        this.mTargetY = -1.0f;
    }

    @Override // org.chromium.content.browser.selection.SelectionInsertionHandleObserver
    public void handleDragStartedOrMoved(float x, float y) {
        if (this.mMagnifier.isAvailable()) {
            if (this.mMagnifierIsShowing && y != this.mTargetY) {
                if (this.mAnimator.isRunning()) {
                    this.mAnimator.cancel();
                    createValueAnimator();
                    this.mAnimationStartX = this.mAnimationCurrentX;
                    this.mAnimationStartY = this.mAnimationCurrentY;
                } else {
                    this.mAnimationStartX = this.mTargetX;
                    this.mAnimationStartY = this.mTargetY;
                }
                this.mAnimator.start();
            } else if (!this.mAnimator.isRunning()) {
                this.mMagnifier.show(x, y);
            }
            this.mTargetX = x;
            this.mTargetY = y;
            this.mMagnifierIsShowing = true;
        }
    }

    @Override // org.chromium.content.browser.selection.SelectionInsertionHandleObserver
    public void handleDragStopped() {
        this.mMagnifier.dismiss();
        this.mAnimator.cancel();
        this.mMagnifierIsShowing = false;
    }

    ValueAnimator getValueAnimatorForTesting() {
        return this.mAnimator;
    }

    private float currentValue(float start, float target, ValueAnimator animation) {
        return start + ((target - start) * animation.getAnimatedFraction());
    }

    private void createValueAnimator() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator.setDuration(DURATION_MS);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(animation -> {
            this.mAnimationCurrentX = currentValue(this.mAnimationStartX, this.mTargetX, animation);
            this.mAnimationCurrentY = currentValue(this.mAnimationStartY, this.mTargetY, animation);
            this.mMagnifier.show(this.mAnimationCurrentX, this.mAnimationCurrentY);
        });
    }
}
