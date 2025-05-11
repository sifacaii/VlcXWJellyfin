package org.chromium.content.browser.selection;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Magnifier;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;

@SuppressLint({"NewApi"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/MagnifierWrapperImpl.class */
public class MagnifierWrapperImpl implements MagnifierWrapper {
    private Magnifier mMagnifier;
    private SelectionPopupControllerImpl.ReadbackViewCallback mCallback;

    public MagnifierWrapperImpl(SelectionPopupControllerImpl.ReadbackViewCallback callback) {
        this.mCallback = callback;
    }

    @Override // org.chromium.content.browser.selection.MagnifierWrapper
    public void show(float x, float y) {
        View view = this.mCallback.getReadbackView();
        if (view == null) {
            return;
        }
        if (this.mMagnifier == null) {
            this.mMagnifier = new Magnifier(view);
        }
        this.mMagnifier.show(x, y);
    }

    @Override // org.chromium.content.browser.selection.MagnifierWrapper
    public void dismiss() {
        if (this.mMagnifier != null) {
            this.mMagnifier.dismiss();
            this.mMagnifier = null;
        }
    }

    @Override // org.chromium.content.browser.selection.MagnifierWrapper
    public boolean isAvailable() {
        return this.mCallback.getReadbackView() != null;
    }
}
