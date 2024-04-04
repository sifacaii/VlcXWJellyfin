package org.chromium.content.browser.accessibility;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import android.text.SpannableString;
import android.text.style.LocaleSpan;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Locale;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.WebContents;

@JNINamespace("content")
@TargetApi(21)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/LollipopWebContentsAccessibility.class */
public class LollipopWebContentsAccessibility extends KitKatWebContentsAccessibility {
    private static SparseArray<AccessibilityNodeInfo.AccessibilityAction> sAccessibilityActionMap = new SparseArray<>();
    private String mSystemLanguageTag;
    private BroadcastReceiver mBroadcastReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LollipopWebContentsAccessibility(WebContents webContents) {
        super(webContents);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.content.browser.accessibility.KitKatWebContentsAccessibility, org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    public void onNativeInit() {
        super.onNativeInit();
        this.mBroadcastReceiver = new BroadcastReceiver() { // from class: org.chromium.content.browser.accessibility.LollipopWebContentsAccessibility.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                LollipopWebContentsAccessibility.this.mSystemLanguageTag = Locale.getDefault().toLanguageTag();
            }
        };
        if (this.mView.isAttachedToWindow()) {
            registerLocaleChangeReceiver();
        }
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityNodeInfoLollipopAttributes(AccessibilityNodeInfo node, boolean canOpenPopup, boolean contentInvalid, boolean dismissable, boolean multiLine, int inputType, int liveRegion, String errorMessage) {
        node.setCanOpenPopup(canOpenPopup);
        node.setContentInvalid(contentInvalid);
        node.setDismissable(contentInvalid);
        node.setMultiLine(multiLine);
        node.setInputType(inputType);
        node.setLiveRegion(liveRegion);
        node.setError(errorMessage);
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityNodeInfoCollectionInfo(AccessibilityNodeInfo node, int rowCount, int columnCount, boolean hierarchical) {
        node.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, columnCount, hierarchical));
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityNodeInfoCollectionItemInfo(AccessibilityNodeInfo node, int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading) {
        node.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading));
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityNodeInfoRangeInfo(AccessibilityNodeInfo node, int rangeType, float min, float max, float current) {
        node.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(rangeType, min, max, current));
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityNodeInfoViewIdResourceName(AccessibilityNodeInfo node, String viewIdResourceName) {
        node.setViewIdResourceName(viewIdResourceName);
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityEventLollipopAttributes(AccessibilityEvent event, boolean canOpenPopup, boolean contentInvalid, boolean dismissable, boolean multiLine, int inputType, int liveRegion) {
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityEventCollectionInfo(AccessibilityEvent event, int rowCount, int columnCount, boolean hierarchical) {
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityEventHeadingFlag(AccessibilityEvent event, boolean heading) {
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityEventCollectionItemInfo(AccessibilityEvent event, int rowIndex, int rowSpan, int columnIndex, int columnSpan) {
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityEventRangeInfo(AccessibilityEvent event, int rangeType, float min, float max, float current) {
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void addAction(AccessibilityNodeInfo node, int actionId) {
        AccessibilityNodeInfo.AccessibilityAction action = sAccessibilityActionMap.get(actionId);
        if (action == null) {
            action = new AccessibilityNodeInfo.AccessibilityAction(actionId, null);
            sAccessibilityActionMap.put(actionId, action);
        }
        node.addAction(action);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    public CharSequence computeText(String text, boolean annotateAsLink, String language) {
        SpannableString spannable;
        CharSequence charSequence = super.computeText(text, annotateAsLink, language);
        if (!language.isEmpty() && !language.equals(this.mSystemLanguageTag)) {
            if (charSequence instanceof SpannableString) {
                spannable = (SpannableString) charSequence;
            } else {
                spannable = new SpannableString(charSequence);
            }
            Locale locale = Locale.forLanguageTag(language);
            spannable.setSpan(new LocaleSpan(locale), 0, spannable.length(), 0);
            return spannable;
        }
        return charSequence;
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl, org.chromium.content.browser.WindowEventObserver
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isNativeInitialized()) {
            ContextUtils.getApplicationContext().unregisterReceiver(this.mBroadcastReceiver);
        }
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl, org.chromium.content.browser.WindowEventObserver
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerLocaleChangeReceiver();
    }

    private void registerLocaleChangeReceiver() {
        if (isNativeInitialized()) {
            try {
                IntentFilter filter = new IntentFilter("android.intent.action.LOCALE_CHANGED");
                ContextUtils.getApplicationContext().registerReceiver(this.mBroadcastReceiver, filter);
            } catch (ReceiverCallNotAllowedException e) {
            }
            this.mSystemLanguageTag = Locale.getDefault().toLanguageTag();
        }
    }
}
