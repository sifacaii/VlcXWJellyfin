package org.chromium.content.browser.accessibility;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Arrays;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.WebContents;

@JNINamespace("content")
@TargetApi(26)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/OWebContentsAccessibility.class */
public class OWebContentsAccessibility extends LollipopWebContentsAccessibility {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !OWebContentsAccessibility.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OWebContentsAccessibility(WebContents webContents) {
        super(webContents);
    }

    @Override // org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    protected void setAccessibilityNodeInfoOAttributes(AccessibilityNodeInfo node, boolean hasCharacterLocations) {
        if (hasCharacterLocations) {
            node.setAvailableExtraData(Arrays.asList("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.content.browser.accessibility.KitKatWebContentsAccessibility, org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl
    public void setAccessibilityNodeInfoKitKatAttributes(AccessibilityNodeInfo node, boolean isRoot, boolean isEditableText, String role, String roleDescription, String hint, int selectionStartIndex, int selectionEndIndex, boolean hasImage, boolean contentInvalid) {
        super.setAccessibilityNodeInfoKitKatAttributes(node, isRoot, isEditableText, role, roleDescription, hint, selectionStartIndex, selectionEndIndex, hasImage, contentInvalid);
        node.setHintText(hint);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
        int[] coords;
        if (extraDataKey.equals("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            if (!nativeAreInlineTextBoxesLoaded(this.mNativeObj, virtualViewId)) {
                nativeLoadInlineTextBoxes(this.mNativeObj, virtualViewId);
            }
            int positionInfoStartIndex = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int positionInfoLength = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (positionInfoLength <= 0 || positionInfoStartIndex < 0 || (coords = nativeGetCharacterBoundingBoxes(this.mNativeObj, virtualViewId, positionInfoStartIndex, positionInfoLength)) == null) {
                return;
            }
            if (!$assertionsDisabled && coords.length != positionInfoLength * 4) {
                throw new AssertionError();
            }
            RectF[] boundingRects = new RectF[positionInfoLength];
            for (int i = 0; i < positionInfoLength; i++) {
                Rect rect = new Rect(coords[(4 * i) + 0], coords[(4 * i) + 1], coords[(4 * i) + 2], coords[(4 * i) + 3]);
                convertWebRectToAndroidCoordinates(rect);
                boundingRects[i] = new RectF(rect);
            }
            info.getExtras().putParcelableArray(extraDataKey, boundingRects);
        }
    }
}
