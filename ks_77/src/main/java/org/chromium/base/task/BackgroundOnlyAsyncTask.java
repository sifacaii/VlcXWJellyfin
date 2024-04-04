package org.chromium.base.task;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/BackgroundOnlyAsyncTask.class */
public abstract class BackgroundOnlyAsyncTask<Result> extends AsyncTask<Result> {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !BackgroundOnlyAsyncTask.class.desiredAssertionStatus();
    }

    @Override // org.chromium.base.task.AsyncTask
    protected final void onPostExecute(Result result) {
        if (!$assertionsDisabled) {
            throw new AssertionError();
        }
    }
}
