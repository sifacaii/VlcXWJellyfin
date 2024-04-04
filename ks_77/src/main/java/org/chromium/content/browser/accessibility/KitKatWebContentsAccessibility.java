package org.chromium.content.browser.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.WebContents;

@JNINamespace("content")
@TargetApi(19)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/KitKatWebContentsAccessibility.class */
public class KitKatWebContentsAccessibility extends WebContentsAccessibilityImpl {
    private String mSupportedHtmlElementTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KitKatWebContentsAccessibility(WebContents webContents) {
        super(webContents);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    public void onNativeInit() {
        super.onNativeInit();
        this.mSupportedHtmlElementTypes = nativeGetSupportedHtmlElementTypes(this.mNativeObj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    public void setAccessibilityNodeInfoKitKatAttributes(AccessibilityNodeInfo node, boolean isRoot, boolean isEditableText, String role, String roleDescription, String hint, int selectionStartIndex, int selectionEndIndex, boolean hasImage, boolean contentInvalid) {
        Bundle bundle = node.getExtras();
        bundle.putCharSequence("AccessibilityNodeInfo.chromeRole", role);
        bundle.putCharSequence("AccessibilityNodeInfo.roleDescription", roleDescription);
        bundle.putCharSequence("AccessibilityNodeInfo.hint", hint);
        if (hasImage) {
            bundle.putCharSequence("AccessibilityNodeInfo.hasImage", "true");
        }
        if (isRoot) {
            bundle.putCharSequence("ACTION_ARGUMENT_HTML_ELEMENT_STRING_VALUES", this.mSupportedHtmlElementTypes);
        }
        if (isEditableText) {
            node.setEditable(true);
            node.setTextSelection(selectionStartIndex, selectionEndIndex);
        }
        node.setContentInvalid(contentInvalid);
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected int getAccessibilityServiceCapabilitiesMask() {
        int capabilitiesMask = 0;
        for (AccessibilityServiceInfo service : this.mAccessibilityManager.getEnabledAccessibilityServiceList(-1)) {
            capabilitiesMask |= service.getCapabilities();
        }
        return capabilitiesMask;
    }
}
