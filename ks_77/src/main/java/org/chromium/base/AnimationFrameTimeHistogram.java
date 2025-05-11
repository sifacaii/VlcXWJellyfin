package org.chromium.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeAnimator;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/AnimationFrameTimeHistogram.class */
public class AnimationFrameTimeHistogram {
    private static final String TAG = "AnimationFrameTimeHistogram";
    private static final int MAX_FRAME_TIME_NUM = 600;
    private final Recorder mRecorder = new Recorder();
    private final String mHistogramName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/AnimationFrameTimeHistogram$Natives.class */
    public interface Natives {
        void saveHistogram(String str, long[] jArr, int i);
    }

    public static Animator.AnimatorListener getAnimatorRecorder(final String histogramName) {
        return new AnimatorListenerAdapter() { // from class: org.chromium.base.AnimationFrameTimeHistogram.1
            private final AnimationFrameTimeHistogram mAnimationFrameTimeHistogram;

            {
                this.mAnimationFrameTimeHistogram = new AnimationFrameTimeHistogram(histogramName);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                this.mAnimationFrameTimeHistogram.startRecording();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                this.mAnimationFrameTimeHistogram.endRecording();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                this.mAnimationFrameTimeHistogram.endRecording();
            }
        };
    }

    public AnimationFrameTimeHistogram(String histogramName) {
        this.mHistogramName = histogramName;
    }

    public void startRecording() {
        this.mRecorder.startRecording();
    }

    public void endRecording() {
        if (this.mRecorder.endRecording()) {
            AnimationFrameTimeHistogramJni.get().saveHistogram(this.mHistogramName, this.mRecorder.getFrameTimesMs(), this.mRecorder.getFrameTimesCount());
        }
        this.mRecorder.cleanUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/AnimationFrameTimeHistogram$Recorder.class */
    public static class Recorder implements TimeAnimator.TimeListener {
        private final TimeAnimator mAnimator;
        private long[] mFrameTimesMs;
        private int mFrameTimesCount;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !AnimationFrameTimeHistogram.class.desiredAssertionStatus();
        }

        private Recorder() {
            this.mAnimator = new TimeAnimator();
            this.mAnimator.setTimeListener(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startRecording() {
            if (!$assertionsDisabled && this.mAnimator.isRunning()) {
                throw new AssertionError();
            }
            this.mFrameTimesCount = 0;
            this.mFrameTimesMs = new long[600];
            this.mAnimator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean endRecording() {
            boolean succeeded = this.mAnimator.isStarted();
            this.mAnimator.end();
            return succeeded;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long[] getFrameTimesMs() {
            return this.mFrameTimesMs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getFrameTimesCount() {
            return this.mFrameTimesCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanUp() {
            this.mFrameTimesMs = null;
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
            if (this.mFrameTimesCount == this.mFrameTimesMs.length) {
                this.mAnimator.end();
                cleanUp();
                android.util.Log.w(AnimationFrameTimeHistogram.TAG, "Animation frame time recording reached the maximum number. It's eitherthe animation took too long or recording end is not called.");
            } else if (deltaTime > 0) {
                long[] jArr = this.mFrameTimesMs;
                int i = this.mFrameTimesCount;
                this.mFrameTimesCount = i + 1;
                jArr[i] = deltaTime;
            }
        }
    }
}
