package org.chromium.content.browser.input;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import java.util.Arrays;
import javax.annotation.Nonnull;
import org.chromium.base.VisibleForTesting;
import org.chromium.content_public.browser.InputMethodManagerWrapper;

@TargetApi(21)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/CursorAnchorInfoController.class */
final class CursorAnchorInfoController {
    private boolean mIsEditable;
    private boolean mHasPendingImmediateRequest;
    private boolean mMonitorModeEnabled;
    @Nullable
    private float[] mCompositionCharacterBounds;
    private boolean mHasCoordinateInfo;
    private float mScale;
    private float mTranslationX;
    private float mTranslationY;
    private boolean mHasInsertionMarker;
    private boolean mIsInsertionMarkerVisible;
    private float mInsertionMarkerHorizontal;
    private float mInsertionMarkerTop;
    private float mInsertionMarkerBottom;
    @Nullable
    private CursorAnchorInfo mLastCursorAnchorInfo;
    @Nonnull
    private final Matrix mMatrix = new Matrix();
    @Nonnull
    private final int[] mViewOrigin = new int[2];
    @Nonnull
    private final CursorAnchorInfo.Builder mCursorAnchorInfoBuilder = new CursorAnchorInfo.Builder();
    @Nullable
    private InputMethodManagerWrapper mInputMethodManagerWrapper;
    @Nullable
    private final ComposingTextDelegate mComposingTextDelegate;
    @Nonnull
    private final ViewDelegate mViewDelegate;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/CursorAnchorInfoController$ComposingTextDelegate.class */
    public interface ComposingTextDelegate {
        CharSequence getText();

        int getSelectionStart();

        int getSelectionEnd();

        int getComposingTextStart();

        int getComposingTextEnd();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/CursorAnchorInfoController$ViewDelegate.class */
    public interface ViewDelegate {
        void getLocationOnScreen(View view, int[] iArr);
    }

    private CursorAnchorInfoController(InputMethodManagerWrapper inputMethodManagerWrapper, ComposingTextDelegate composingTextDelegate, ViewDelegate viewDelegate) {
        this.mInputMethodManagerWrapper = inputMethodManagerWrapper;
        this.mComposingTextDelegate = composingTextDelegate;
        this.mViewDelegate = viewDelegate;
    }

    public static CursorAnchorInfoController create(InputMethodManagerWrapper inputMethodManagerWrapper, ComposingTextDelegate composingTextDelegate) {
        return new CursorAnchorInfoController(inputMethodManagerWrapper, composingTextDelegate, new ViewDelegate() { // from class: org.chromium.content.browser.input.CursorAnchorInfoController.1
            @Override // org.chromium.content.browser.input.CursorAnchorInfoController.ViewDelegate
            public void getLocationOnScreen(View view, int[] location) {
                view.getLocationOnScreen(location);
            }
        });
    }

    @VisibleForTesting
    public void setInputMethodManagerWrapper(InputMethodManagerWrapper inputMethodManagerWrapper) {
        this.mInputMethodManagerWrapper = inputMethodManagerWrapper;
    }

    @VisibleForTesting
    public static CursorAnchorInfoController createForTest(InputMethodManagerWrapper inputMethodManagerWrapper, ComposingTextDelegate composingTextDelegate, ViewDelegate viewDelegate) {
        return new CursorAnchorInfoController(inputMethodManagerWrapper, composingTextDelegate, viewDelegate);
    }

    public void invalidateLastCursorAnchorInfo() {
        if (this.mIsEditable) {
            this.mLastCursorAnchorInfo = null;
        }
    }

    public void setCompositionCharacterBounds(float[] compositionCharacterBounds, View view) {
        if (this.mIsEditable && !Arrays.equals(compositionCharacterBounds, this.mCompositionCharacterBounds)) {
            this.mLastCursorAnchorInfo = null;
            this.mCompositionCharacterBounds = compositionCharacterBounds;
            if (this.mHasCoordinateInfo) {
                updateCursorAnchorInfo(view);
            }
        }
    }

    public void onUpdateFrameInfo(float scale, float contentOffsetYPix, boolean hasInsertionMarker, boolean isInsertionMarkerVisible, float insertionMarkerHorizontal, float insertionMarkerTop, float insertionMarkerBottom, @Nonnull View view) {
        if (this.mIsEditable) {
            this.mViewDelegate.getLocationOnScreen(view, this.mViewOrigin);
            float translationX = this.mViewOrigin[0];
            float translationY = this.mViewOrigin[1] + contentOffsetYPix;
            if (!this.mHasCoordinateInfo || scale != this.mScale || translationX != this.mTranslationX || translationY != this.mTranslationY || hasInsertionMarker != this.mHasInsertionMarker || isInsertionMarkerVisible != this.mIsInsertionMarkerVisible || insertionMarkerHorizontal != this.mInsertionMarkerHorizontal || insertionMarkerTop != this.mInsertionMarkerTop || insertionMarkerBottom != this.mInsertionMarkerBottom) {
                this.mLastCursorAnchorInfo = null;
                this.mHasCoordinateInfo = true;
                this.mScale = scale;
                this.mTranslationX = translationX;
                this.mTranslationY = translationY;
                this.mHasInsertionMarker = hasInsertionMarker;
                this.mIsInsertionMarkerVisible = isInsertionMarkerVisible;
                this.mInsertionMarkerHorizontal = insertionMarkerHorizontal;
                this.mInsertionMarkerTop = insertionMarkerTop;
                this.mInsertionMarkerBottom = insertionMarkerBottom;
            }
            if (this.mHasPendingImmediateRequest || (this.mMonitorModeEnabled && this.mLastCursorAnchorInfo == null)) {
                updateCursorAnchorInfo(view);
            }
        }
    }

    public void focusedNodeChanged(boolean isEditable) {
        this.mIsEditable = isEditable;
        this.mCompositionCharacterBounds = null;
        this.mHasCoordinateInfo = false;
        this.mLastCursorAnchorInfo = null;
    }

    public boolean onRequestCursorUpdates(boolean immediateRequest, boolean monitorRequest, View view) {
        if (this.mIsEditable) {
            if (this.mMonitorModeEnabled && !monitorRequest) {
                invalidateLastCursorAnchorInfo();
            }
            this.mMonitorModeEnabled = monitorRequest;
            if (immediateRequest) {
                this.mHasPendingImmediateRequest = true;
                updateCursorAnchorInfo(view);
                return true;
            }
            return true;
        }
        return false;
    }

    private void updateCursorAnchorInfo(View view) {
        if (this.mHasCoordinateInfo) {
            if (this.mLastCursorAnchorInfo == null) {
                this.mCursorAnchorInfoBuilder.reset();
                CharSequence text = this.mComposingTextDelegate.getText();
                int selectionStart = this.mComposingTextDelegate.getSelectionStart();
                int selectionEnd = this.mComposingTextDelegate.getSelectionEnd();
                int composingTextStart = this.mComposingTextDelegate.getComposingTextStart();
                int composingTextEnd = this.mComposingTextDelegate.getComposingTextEnd();
                if (text != null && 0 <= composingTextStart && composingTextEnd <= text.length()) {
                    this.mCursorAnchorInfoBuilder.setComposingText(composingTextStart, text.subSequence(composingTextStart, composingTextEnd));
                    float[] compositionCharacterBounds = this.mCompositionCharacterBounds;
                    if (compositionCharacterBounds != null) {
                        int numCharacter = compositionCharacterBounds.length / 4;
                        for (int i = 0; i < numCharacter; i++) {
                            float left = compositionCharacterBounds[i * 4];
                            float top = compositionCharacterBounds[(i * 4) + 1];
                            float right = compositionCharacterBounds[(i * 4) + 2];
                            float bottom = compositionCharacterBounds[(i * 4) + 3];
                            int charIndex = composingTextStart + i;
                            this.mCursorAnchorInfoBuilder.addCharacterBounds(charIndex, left, top, right, bottom, 1);
                        }
                    }
                }
                this.mCursorAnchorInfoBuilder.setSelectionRange(selectionStart, selectionEnd);
                this.mMatrix.setScale(this.mScale, this.mScale);
                this.mMatrix.postTranslate(this.mTranslationX, this.mTranslationY);
                this.mCursorAnchorInfoBuilder.setMatrix(this.mMatrix);
                if (this.mHasInsertionMarker) {
                    this.mCursorAnchorInfoBuilder.setInsertionMarkerLocation(this.mInsertionMarkerHorizontal, this.mInsertionMarkerTop, this.mInsertionMarkerBottom, this.mInsertionMarkerBottom, this.mIsInsertionMarkerVisible ? 1 : 2);
                }
                this.mLastCursorAnchorInfo = this.mCursorAnchorInfoBuilder.build();
            }
            if (this.mInputMethodManagerWrapper != null) {
                this.mInputMethodManagerWrapper.updateCursorAnchorInfo(view, this.mLastCursorAnchorInfo);
            }
            this.mHasPendingImmediateRequest = false;
        }
    }
}
