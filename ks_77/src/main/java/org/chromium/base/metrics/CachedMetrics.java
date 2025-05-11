package org.chromium.base.metrics;

import java.util.ArrayList;
import java.util.List;
import org.chromium.base.TimeUtils;
import org.chromium.base.library_loader.LibraryLoader;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics.class */
public class CachedMetrics {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$CachedMetric.class */
    public static abstract class CachedMetric {
        private static final List<CachedMetric> sMetrics;
        protected final String mName;
        protected boolean mCached;
        static final /* synthetic */ boolean $assertionsDisabled;

        protected abstract void commitAndClear();

        static {
            $assertionsDisabled = !CachedMetrics.class.desiredAssertionStatus();
            sMetrics = new ArrayList();
        }

        protected CachedMetric(String name) {
            this.mName = name;
        }

        protected final void addToCache() {
            if (!$assertionsDisabled && !Thread.holdsLock(sMetrics)) {
                throw new AssertionError();
            }
            if (this.mCached) {
                return;
            }
            sMetrics.add(this);
            this.mCached = true;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$ActionEvent.class */
    public static class ActionEvent extends CachedMetric {
        private int mCount;

        public ActionEvent(String actionName) {
            super(actionName);
        }

        public void record() {
            synchronized (CachedMetric.sMetrics) {
                if (LibraryLoader.getInstance().isInitialized()) {
                    recordWithNative();
                } else {
                    this.mCount++;
                    addToCache();
                }
            }
        }

        private void recordWithNative() {
            RecordUserAction.record(this.mName);
        }

        @Override // org.chromium.base.metrics.CachedMetrics.CachedMetric
        protected void commitAndClear() {
            while (this.mCount > 0) {
                recordWithNative();
                this.mCount--;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$SparseHistogramSample.class */
    public static class SparseHistogramSample extends CachedMetric {
        private final List<Integer> mSamples;

        public SparseHistogramSample(String histogramName) {
            super(histogramName);
            this.mSamples = new ArrayList();
        }

        public void record(int sample) {
            synchronized (CachedMetric.sMetrics) {
                if (LibraryLoader.getInstance().isInitialized()) {
                    recordWithNative(sample);
                } else {
                    this.mSamples.add(Integer.valueOf(sample));
                    addToCache();
                }
            }
        }

        private void recordWithNative(int sample) {
            RecordHistogram.recordSparseHistogram(this.mName, sample);
        }

        @Override // org.chromium.base.metrics.CachedMetrics.CachedMetric
        protected void commitAndClear() {
            for (Integer sample : this.mSamples) {
                recordWithNative(sample.intValue());
            }
            this.mSamples.clear();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$EnumeratedHistogramSample.class */
    public static class EnumeratedHistogramSample extends CachedMetric {
        private final List<Integer> mSamples;
        private final int mMaxValue;

        public EnumeratedHistogramSample(String histogramName, int maxValue) {
            super(histogramName);
            this.mSamples = new ArrayList();
            this.mMaxValue = maxValue;
        }

        public void record(int sample) {
            synchronized (CachedMetric.sMetrics) {
                if (LibraryLoader.getInstance().isInitialized()) {
                    recordWithNative(sample);
                } else {
                    this.mSamples.add(Integer.valueOf(sample));
                    addToCache();
                }
            }
        }

        private void recordWithNative(int sample) {
            RecordHistogram.recordEnumeratedHistogram(this.mName, sample, this.mMaxValue);
        }

        @Override // org.chromium.base.metrics.CachedMetrics.CachedMetric
        protected void commitAndClear() {
            for (Integer sample : this.mSamples) {
                recordWithNative(sample.intValue());
            }
            this.mSamples.clear();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$TimesHistogramSample.class */
    public static class TimesHistogramSample extends CachedMetric {
        private final List<Long> mSamples;

        public TimesHistogramSample(String histogramName) {
            super(histogramName);
            this.mSamples = new ArrayList();
        }

        public void record(long sample) {
            synchronized (CachedMetric.sMetrics) {
                if (LibraryLoader.getInstance().isInitialized()) {
                    recordWithNative(sample);
                } else {
                    this.mSamples.add(Long.valueOf(sample));
                    addToCache();
                }
            }
        }

        protected void recordWithNative(long sample) {
            RecordHistogram.recordTimesHistogram(this.mName, sample);
        }

        @Override // org.chromium.base.metrics.CachedMetrics.CachedMetric
        protected void commitAndClear() {
            for (Long sample : this.mSamples) {
                recordWithNative(sample.longValue());
            }
            this.mSamples.clear();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$MediumTimesHistogramSample.class */
    public static class MediumTimesHistogramSample extends TimesHistogramSample {
        public MediumTimesHistogramSample(String histogramName) {
            super(histogramName);
        }

        @Override // org.chromium.base.metrics.CachedMetrics.TimesHistogramSample
        protected void recordWithNative(long sample) {
            RecordHistogram.recordMediumTimesHistogram(this.mName, sample);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$BooleanHistogramSample.class */
    public static class BooleanHistogramSample extends CachedMetric {
        private final List<Boolean> mSamples;

        public BooleanHistogramSample(String histogramName) {
            super(histogramName);
            this.mSamples = new ArrayList();
        }

        public void record(boolean sample) {
            synchronized (CachedMetric.sMetrics) {
                if (LibraryLoader.getInstance().isInitialized()) {
                    recordWithNative(sample);
                } else {
                    this.mSamples.add(Boolean.valueOf(sample));
                    addToCache();
                }
            }
        }

        private void recordWithNative(boolean sample) {
            RecordHistogram.recordBooleanHistogram(this.mName, sample);
        }

        @Override // org.chromium.base.metrics.CachedMetrics.CachedMetric
        protected void commitAndClear() {
            for (Boolean sample : this.mSamples) {
                recordWithNative(sample.booleanValue());
            }
            this.mSamples.clear();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$CustomCountHistogramSample.class */
    public static class CustomCountHistogramSample extends CachedMetric {
        private final List<Integer> mSamples;
        private final int mMin;
        private final int mMax;
        private final int mNumBuckets;

        public CustomCountHistogramSample(String histogramName, int min, int max, int numBuckets) {
            super(histogramName);
            this.mSamples = new ArrayList();
            this.mMin = min;
            this.mMax = max;
            this.mNumBuckets = numBuckets;
        }

        public void record(int sample) {
            synchronized (CachedMetric.sMetrics) {
                if (LibraryLoader.getInstance().isInitialized()) {
                    recordWithNative(sample);
                } else {
                    this.mSamples.add(Integer.valueOf(sample));
                    addToCache();
                }
            }
        }

        private void recordWithNative(int sample) {
            RecordHistogram.recordCustomCountHistogram(this.mName, sample, this.mMin, this.mMax, this.mNumBuckets);
        }

        @Override // org.chromium.base.metrics.CachedMetrics.CachedMetric
        protected void commitAndClear() {
            for (Integer sample : this.mSamples) {
                recordWithNative(sample.intValue());
            }
            this.mSamples.clear();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$Count100HistogramSample.class */
    public static class Count100HistogramSample extends CustomCountHistogramSample {
        public Count100HistogramSample(String histogramName) {
            super(histogramName, 1, 100, 50);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$Count1000HistogramSample.class */
    public static class Count1000HistogramSample extends CustomCountHistogramSample {
        public Count1000HistogramSample(String histogramName) {
            super(histogramName, 1, 1000, 50);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/CachedMetrics$Count1MHistogramSample.class */
    public static class Count1MHistogramSample extends CustomCountHistogramSample {
        public Count1MHistogramSample(String histogramName) {
            super(histogramName, 1, TimeUtils.NANOSECONDS_PER_MILLISECOND, 50);
        }
    }

    public static void commitCachedMetrics() {
        synchronized (CachedMetric.sMetrics) {
            for (CachedMetric metric : CachedMetric.sMetrics) {
                metric.commitAndClear();
            }
        }
    }
}
