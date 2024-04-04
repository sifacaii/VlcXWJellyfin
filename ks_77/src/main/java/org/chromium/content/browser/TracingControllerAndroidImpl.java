package org.chromium.content.browser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.chromium.base.Callback;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.TracingControllerAndroid;
import org.chromium.ui.widget.Toast;
import org.xwalk.core.R;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/TracingControllerAndroidImpl.class */
public class TracingControllerAndroidImpl implements TracingControllerAndroid {
    private static final String TAG = "cr.TracingController";
    private static final String ACTION_START = "GPU_PROFILER_START";
    private static final String ACTION_STOP = "GPU_PROFILER_STOP";
    private static final String ACTION_LIST_CATEGORIES = "GPU_PROFILER_LIST_CATEGORIES";
    private static final String FILE_EXTRA = "file";
    private static final String CATEGORIES_EXTRA = "categories";
    private static final String RECORD_CONTINUOUSLY_EXTRA = "continuous";
    private static final String DEFAULT_CHROME_CATEGORIES_PLACE_HOLDER = "_DEFAULT_CHROME_CATEGORIES";
    private static final String PROFILER_STARTED_FMT = "Profiler started: %s";
    private static final String PROFILER_FINISHED_FMT = "Profiler finished. Results are in %s.";
    private final Context mContext;
    private final TracingIntentFilter mIntentFilter;
    private boolean mIsTracing;
    private String mFilename;
    private boolean mCompressFile;
    private long mNativeTracingControllerAndroid;
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean mShowToasts = true;
    private final TracingBroadcastReceiver mBroadcastReceiver = new TracingBroadcastReceiver();

    private native long nativeInit();

    private native void nativeDestroy(long j);

    private native boolean nativeStartTracing(long j, String str, String str2);

    private native void nativeStopTracing(long j, String str, boolean z, Callback<Void> callback);

    private native boolean nativeGetKnownCategoriesAsync(long j, Callback<String[]> callback);

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeGetDefaultCategories();

    private native boolean nativeGetTraceBufferUsageAsync(long j, Callback<Pair<Float, Long>> callback);

    static {
        $assertionsDisabled = !TracingControllerAndroidImpl.class.desiredAssertionStatus();
    }

    public TracingControllerAndroidImpl(Context context) {
        this.mContext = context;
        this.mIntentFilter = new TracingIntentFilter(context);
    }

    public BroadcastReceiver getBroadcastReceiver() {
        return this.mBroadcastReceiver;
    }

    public IntentFilter getIntentFilter() {
        return this.mIntentFilter;
    }

    public void registerReceiver(Context context) {
        context.registerReceiver(getBroadcastReceiver(), getIntentFilter());
    }

    public void unregisterReceiver(Context context) {
        context.unregisterReceiver(getBroadcastReceiver());
    }

    @Override // org.chromium.content_public.browser.TracingControllerAndroid
    public boolean isTracing() {
        return this.mIsTracing;
    }

    @Override // org.chromium.content_public.browser.TracingControllerAndroid
    public String getOutputPath() {
        return this.mFilename;
    }

    @CalledByNative
    private static String generateTracingFilePath() {
        String state = Environment.getExternalStorageState();
        if (!"mounted".equals(state)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(dir, "chrome-profile-results-" + formatter.format(new Date()));
        return file.getPath();
    }

    public boolean startTracing(boolean showToasts, String categories, String traceOptions) {
        return startTracing(null, showToasts, categories, traceOptions, false);
    }

    private void initializeNativeControllerIfNeeded() {
        if (this.mNativeTracingControllerAndroid == 0) {
            this.mNativeTracingControllerAndroid = nativeInit();
        }
    }

    @Override // org.chromium.content_public.browser.TracingControllerAndroid
    public boolean startTracing(String filename, boolean showToasts, String categories, String traceOptions, boolean compressFile) {
        this.mShowToasts = showToasts;
        if (filename == null) {
            filename = generateTracingFilePath();
            if (filename == null) {
                logAndToastError(this.mContext.getString(R.string.profiler_no_storage_toast));
                return false;
            }
        }
        if (isTracing()) {
            Log.e(TAG, "Received startTracing, but we're already tracing", new Object[0]);
            return false;
        }
        initializeNativeControllerIfNeeded();
        if (!nativeStartTracing(this.mNativeTracingControllerAndroid, categories, traceOptions)) {
            logAndToastError(this.mContext.getString(R.string.profiler_error_toast));
            return false;
        }
        logForProfiler(String.format(PROFILER_STARTED_FMT, categories));
        showToast(this.mContext.getString(R.string.profiler_started_toast) + ": " + categories);
        this.mFilename = filename;
        this.mCompressFile = compressFile;
        this.mIsTracing = true;
        return true;
    }

    @Override // org.chromium.content_public.browser.TracingControllerAndroid
    public void stopTracing(Callback<Void> callback) {
        if (isTracing()) {
            nativeStopTracing(this.mNativeTracingControllerAndroid, this.mFilename, this.mCompressFile, callback);
        }
    }

    @CalledByNative
    protected void onTracingStopped(Object callback) {
        if (!isTracing()) {
            Log.e(TAG, "Received onTracingStopped, but we aren't tracing", new Object[0]);
            return;
        }
        logForProfiler(String.format(PROFILER_FINISHED_FMT, this.mFilename));
        showToast(this.mContext.getString(R.string.profiler_stopped_toast, this.mFilename));
        this.mIsTracing = false;
        this.mFilename = null;
        this.mCompressFile = false;
        if (callback != null) {
            ((Callback) callback).onResult(null);
        }
    }

    public void getKnownCategories() {
        if (!getKnownCategories(null)) {
            Log.e(TAG, "Unable to fetch tracing category list.", new Object[0]);
        }
    }

    @Override // org.chromium.content_public.browser.TracingControllerAndroid
    public boolean getKnownCategories(Callback<String[]> callback) {
        initializeNativeControllerIfNeeded();
        return nativeGetKnownCategoriesAsync(this.mNativeTracingControllerAndroid, callback);
    }

    @CalledByNative
    public void onKnownCategoriesReceived(String[] categories, Object callback) {
        if (callback != null) {
            ((Callback) callback).onResult(categories);
        }
    }

    @Override // org.chromium.content_public.browser.TracingControllerAndroid
    public boolean getTraceBufferUsage(Callback<Pair<Float, Long>> callback) {
        if ($assertionsDisabled || callback != null) {
            initializeNativeControllerIfNeeded();
            return nativeGetTraceBufferUsageAsync(this.mNativeTracingControllerAndroid, callback);
        }
        throw new AssertionError();
    }

    @CalledByNative
    public void onTraceBufferUsageReceived(float percentFull, long approximateEventCount, Object callback) {
        ((Callback) callback).onResult(new Pair(Float.valueOf(percentFull), Long.valueOf(approximateEventCount)));
    }

    @Override // org.chromium.content_public.browser.TracingControllerAndroid
    public void destroy() {
        if (this.mNativeTracingControllerAndroid != 0) {
            nativeDestroy(this.mNativeTracingControllerAndroid);
            this.mNativeTracingControllerAndroid = 0L;
        }
    }

    private void logAndToastError(String str) {
        Log.e(TAG, str, new Object[0]);
        if (this.mShowToasts) {
            Toast.makeText(this.mContext, str, 0).show();
        }
    }

    private void logForProfiler(String str) {
        Log.i(TAG, str, new Object[0]);
    }

    private void showToast(String str) {
        if (this.mShowToasts) {
            Toast.makeText(this.mContext, str, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/TracingControllerAndroidImpl$TracingIntentFilter.class */
    public static class TracingIntentFilter extends IntentFilter {
        TracingIntentFilter(Context context) {
            addAction(context.getPackageName() + "." + TracingControllerAndroidImpl.ACTION_START);
            addAction(context.getPackageName() + "." + TracingControllerAndroidImpl.ACTION_STOP);
            addAction(context.getPackageName() + "." + TracingControllerAndroidImpl.ACTION_LIST_CATEGORIES);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/TracingControllerAndroidImpl$TracingBroadcastReceiver.class */
    public class TracingBroadcastReceiver extends BroadcastReceiver {
        TracingBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String categories;
            if (!intent.getAction().endsWith(TracingControllerAndroidImpl.ACTION_START)) {
                if (intent.getAction().endsWith(TracingControllerAndroidImpl.ACTION_STOP)) {
                    TracingControllerAndroidImpl.this.stopTracing(null);
                    return;
                } else if (intent.getAction().endsWith(TracingControllerAndroidImpl.ACTION_LIST_CATEGORIES)) {
                    TracingControllerAndroidImpl.this.getKnownCategories();
                    return;
                } else {
                    Log.e(TracingControllerAndroidImpl.TAG, "Unexpected intent: %s", intent);
                    return;
                }
            }
            String categories2 = intent.getStringExtra(TracingControllerAndroidImpl.CATEGORIES_EXTRA);
            if (TextUtils.isEmpty(categories2)) {
                categories = TracingControllerAndroidImpl.this.nativeGetDefaultCategories();
            } else {
                categories = categories2.replaceFirst(TracingControllerAndroidImpl.DEFAULT_CHROME_CATEGORIES_PLACE_HOLDER, TracingControllerAndroidImpl.this.nativeGetDefaultCategories());
            }
            String traceOptions = intent.getStringExtra(TracingControllerAndroidImpl.RECORD_CONTINUOUSLY_EXTRA) == null ? "record-until-full" : "record-continuously";
            String filename = intent.getStringExtra("file");
            if (filename != null) {
                TracingControllerAndroidImpl.this.startTracing(filename, true, categories, traceOptions, false);
            } else {
                TracingControllerAndroidImpl.this.startTracing(true, categories, traceOptions);
            }
        }
    }
}
