package org.chromium.ui.text;

import androidx.annotation.Nullable;
import android.text.SpannableString;
import java.util.Arrays;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/text/SpanApplier.class */
public class SpanApplier {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/text/SpanApplier$SpanInfo.class */
    public static final class SpanInfo implements Comparable<SpanInfo> {
        final String mStartTag;
        final String mEndTag;
        @Nullable
        final Object[] mSpans;
        int mStartTagIndex;
        int mEndTagIndex;

        public SpanInfo(String startTag, String endTag, @Nullable Object span) {
            this.mStartTag = startTag;
            this.mEndTag = endTag;
            this.mSpans = span == null ? null : new Object[]{span};
        }

        public SpanInfo(String startTag, String endTag, Object... spans) {
            this.mStartTag = startTag;
            this.mEndTag = endTag;
            this.mSpans = spans;
        }

        @Override // java.lang.Comparable
        public int compareTo(SpanInfo other) {
            if (this.mStartTagIndex < other.mStartTagIndex) {
                return -1;
            }
            return this.mStartTagIndex == other.mStartTagIndex ? 0 : 1;
        }

        public boolean equals(Object other) {
            return (other instanceof SpanInfo) && compareTo((SpanInfo) other) == 0;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static SpannableString applySpans(String input, SpanInfo... spans) {
        Object[] objArr;
        for (SpanInfo span : spans) {
            span.mStartTagIndex = input.indexOf(span.mStartTag);
            span.mEndTagIndex = input.indexOf(span.mEndTag, span.mStartTagIndex + span.mStartTag.length());
        }
        Arrays.sort(spans);
        int inputIndex = 0;
        StringBuilder output = new StringBuilder(input.length());
        for (SpanInfo span2 : spans) {
            if (span2.mStartTagIndex == -1 || span2.mEndTagIndex == -1 || span2.mStartTagIndex < inputIndex) {
                span2.mStartTagIndex = -1;
                String error = String.format("Input string is missing tags %s%s: %s", span2.mStartTag, span2.mEndTag, input);
                throw new IllegalArgumentException(error);
            }
            output.append((CharSequence) input, inputIndex, span2.mStartTagIndex);
            int inputIndex2 = span2.mStartTagIndex + span2.mStartTag.length();
            span2.mStartTagIndex = output.length();
            output.append((CharSequence) input, inputIndex2, span2.mEndTagIndex);
            inputIndex = span2.mEndTagIndex + span2.mEndTag.length();
            span2.mEndTagIndex = output.length();
        }
        output.append((CharSequence) input, inputIndex, input.length());
        SpannableString spannableString = new SpannableString(output);
        for (SpanInfo span3 : spans) {
            if (span3.mStartTagIndex != -1 && span3.mSpans != null && span3.mSpans.length != 0) {
                for (Object s : span3.mSpans) {
                    if (s != null) {
                        spannableString.setSpan(s, span3.mStartTagIndex, span3.mEndTagIndex, 0);
                    }
                }
            }
        }
        return spannableString;
    }
}
