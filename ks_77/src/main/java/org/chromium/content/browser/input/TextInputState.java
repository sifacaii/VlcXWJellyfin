package org.chromium.content.browser.input;

import android.text.TextUtils;
import java.util.Locale;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/TextInputState.class */
public class TextInputState {
    private final CharSequence mText;
    private final Range mSelection;
    private final Range mComposition;
    private final boolean mSingleLine;
    private final boolean mReplyToRequest;

    public TextInputState(CharSequence text, Range selection, Range composition, boolean singleLine, boolean replyToRequest) {
        selection.clamp(0, text.length());
        if (composition.start() != -1 || composition.end() != -1) {
            composition.clamp(0, text.length());
        }
        this.mText = text;
        this.mSelection = selection;
        this.mComposition = composition;
        this.mSingleLine = singleLine;
        this.mReplyToRequest = replyToRequest;
    }

    public CharSequence text() {
        return this.mText;
    }

    public Range selection() {
        return this.mSelection;
    }

    public Range composition() {
        return this.mComposition;
    }

    public boolean singleLine() {
        return this.mSingleLine;
    }

    public boolean replyToRequest() {
        return this.mReplyToRequest;
    }

    public CharSequence getSelectedText() {
        if (this.mSelection.start() == this.mSelection.end()) {
            return null;
        }
        return TextUtils.substring(this.mText, this.mSelection.start(), this.mSelection.end());
    }

    public CharSequence getTextAfterSelection(int maxChars) {
        return TextUtils.substring(this.mText, this.mSelection.end(), Math.min(this.mText.length(), this.mSelection.end() + Math.max(0, Math.min(maxChars, this.mText.length() - this.mSelection.end()))));
    }

    public CharSequence getTextBeforeSelection(int maxChars) {
        return TextUtils.substring(this.mText, Math.max(0, this.mSelection.start() - Math.max(0, Math.min(maxChars, this.mSelection.start()))), this.mSelection.start());
    }

    public boolean equals(Object o) {
        if (o instanceof TextInputState) {
            TextInputState t = (TextInputState) o;
            if (t == this) {
                return true;
            }
            return TextUtils.equals(this.mText, t.mText) && this.mSelection.equals(t.mSelection) && this.mComposition.equals(t.mComposition) && this.mSingleLine == t.mSingleLine && this.mReplyToRequest == t.mReplyToRequest;
        }
        return false;
    }

    public int hashCode() {
        return (this.mText.hashCode() * 7) + (this.mSelection.hashCode() * 11) + (this.mComposition.hashCode() * 13) + (this.mSingleLine ? 19 : 0) + (this.mReplyToRequest ? 23 : 0);
    }

    public boolean shouldUnblock() {
        return false;
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[5];
        objArr[0] = this.mText;
        objArr[1] = this.mSelection;
        objArr[2] = this.mComposition;
        objArr[3] = this.mSingleLine ? "SIN" : "MUL";
        objArr[4] = this.mReplyToRequest ? " ReplyToRequest" : CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
        return String.format(locale, "TextInputState {[%s] SEL%s COM%s %s%s}", objArr);
    }
}
