package org.chromium.content.browser.input;

import org.chromium.base.VisibleForTesting;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/input/Range.class */
public class Range {
    private int mStart;
    private int mEnd;

    public Range(int start, int end) {
        set(start, end);
    }

    public int start() {
        return this.mStart;
    }

    public int end() {
        return this.mEnd;
    }

    @VisibleForTesting
    public void set(int start, int end) {
        this.mStart = Math.min(start, end);
        this.mEnd = Math.max(start, end);
    }

    public void clamp(int start, int end) {
        this.mStart = Math.min(Math.max(this.mStart, start), end);
        this.mEnd = Math.max(Math.min(this.mEnd, end), start);
    }

    public boolean intersects(Range range) {
        return this.mStart <= range.mEnd && this.mEnd >= range.mStart;
    }

    public boolean equals(Object o) {
        if (o instanceof Range) {
            if (o == this) {
                return true;
            }
            Range r = (Range) o;
            return this.mStart == r.mStart && this.mEnd == r.mEnd;
        }
        return false;
    }

    public int hashCode() {
        return (11 * this.mStart) + (31 * this.mEnd);
    }

    public String toString() {
        return "[ " + this.mStart + ", " + this.mEnd + " ]";
    }
}
