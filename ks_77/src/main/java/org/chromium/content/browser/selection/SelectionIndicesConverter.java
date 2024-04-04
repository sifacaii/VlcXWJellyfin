package org.chromium.content.browser.selection;

import java.text.BreakIterator;
import java.util.regex.Pattern;
import org.chromium.base.VisibleForTesting;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/SelectionIndicesConverter.class */
public class SelectionIndicesConverter {
    private static final Pattern PATTERN_WHITESPACE;
    private String mGlobalSelectionText;
    private int mGlobalStartOffset;
    private String mLastSelectionText;
    private int mLastStartOffset;
    private int mInitialStartOffset;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SelectionIndicesConverter.class.desiredAssertionStatus();
        PATTERN_WHITESPACE = Pattern.compile("[\\p{javaSpaceChar}\\s]+");
    }

    public boolean updateSelectionState(String selectionText, int startOffset) {
        if (this.mGlobalSelectionText == null) {
            updateLastSelection(selectionText, startOffset);
            updateGlobalSelection(selectionText, startOffset);
            return true;
        }
        boolean update = false;
        int endOffset = startOffset + selectionText.length();
        int lastEndOffset = this.mLastStartOffset + this.mLastSelectionText.length();
        if (overlap(this.mLastStartOffset, lastEndOffset, startOffset, endOffset)) {
            int l = Math.max(this.mLastStartOffset, startOffset);
            int r = Math.min(lastEndOffset, endOffset);
            update = this.mLastSelectionText.regionMatches(l - this.mLastStartOffset, selectionText, l - startOffset, r - l);
        }
        if (this.mLastStartOffset == endOffset || lastEndOffset == startOffset) {
            update = true;
        }
        if (!update) {
            this.mGlobalSelectionText = null;
            this.mLastSelectionText = null;
            return false;
        }
        updateLastSelection(selectionText, startOffset);
        combineGlobalSelection(selectionText, startOffset);
        return true;
    }

    public boolean getWordDelta(int start, int end, int[] wordIndices) {
        if ($assertionsDisabled || wordIndices.length == 2) {
            wordIndices[1] = 0;
            wordIndices[0] = 0;
            int start2 = start - this.mGlobalStartOffset;
            int end2 = end - this.mGlobalStartOffset;
            if (start2 < end2 && start2 >= 0 && start2 < this.mGlobalSelectionText.length() && end2 > 0 && end2 <= this.mGlobalSelectionText.length()) {
                int initialStartOffset = this.mInitialStartOffset - this.mGlobalStartOffset;
                BreakIterator breakIterator = BreakIterator.getWordInstance();
                breakIterator.setText(this.mGlobalSelectionText);
                if (start2 <= initialStartOffset) {
                    wordIndices[0] = -countWordsForward(start2, initialStartOffset, breakIterator);
                } else {
                    wordIndices[0] = countWordsBackward(start2, initialStartOffset, breakIterator);
                    if (!breakIterator.isBoundary(start2) && !isWhitespace(breakIterator.preceding(start2), breakIterator.following(start2))) {
                        wordIndices[0] = wordIndices[0] - 1;
                    }
                }
                if (end2 <= initialStartOffset) {
                    wordIndices[1] = -countWordsForward(end2, initialStartOffset, breakIterator);
                    return true;
                }
                wordIndices[1] = countWordsBackward(end2, initialStartOffset, breakIterator);
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    public void setInitialStartOffset(int offset) {
        this.mInitialStartOffset = offset;
    }

    @VisibleForTesting
    protected String getGlobalSelectionText() {
        return this.mGlobalSelectionText;
    }

    @VisibleForTesting
    protected int getGlobalStartOffset() {
        return this.mGlobalStartOffset;
    }

    @VisibleForTesting
    protected int countWordsBackward(int start, int end, BreakIterator iterator) {
        if (!$assertionsDisabled && start < end) {
            throw new AssertionError();
        }
        int wordCount = 0;
        int i = start;
        while (true) {
            int offset = i;
            if (offset > end) {
                int i2 = iterator.preceding(offset);
                if (!isWhitespace(i2, offset)) {
                    wordCount++;
                }
                i = i2;
            } else {
                return wordCount;
            }
        }
    }

    @VisibleForTesting
    protected int countWordsForward(int start, int end, BreakIterator iterator) {
        if (!$assertionsDisabled && start > end) {
            throw new AssertionError();
        }
        int wordCount = 0;
        int i = start;
        while (true) {
            int offset = i;
            if (offset < end) {
                int i2 = iterator.following(offset);
                if (!isWhitespace(offset, i2)) {
                    wordCount++;
                }
                i = i2;
            } else {
                return wordCount;
            }
        }
    }

    @VisibleForTesting
    protected boolean isWhitespace(int start, int end) {
        return PATTERN_WHITESPACE.matcher(this.mGlobalSelectionText.substring(start, end)).matches();
    }

    @VisibleForTesting
    protected static boolean overlap(int al, int ar, int bl, int br) {
        return al <= bl ? bl < ar : br > al;
    }

    @VisibleForTesting
    protected static boolean contains(int al, int ar, int bl, int br) {
        return al <= bl && br <= ar;
    }

    private void updateLastSelection(String selectionText, int startOffset) {
        this.mLastSelectionText = selectionText;
        this.mLastStartOffset = startOffset;
    }

    private void updateGlobalSelection(String selectionText, int startOffset) {
        this.mGlobalSelectionText = selectionText;
        this.mGlobalStartOffset = startOffset;
    }

    private void combineGlobalSelection(String selectionText, int startOffset) {
        int endOffset = startOffset + selectionText.length();
        int globalEndOffset = this.mGlobalStartOffset + this.mGlobalSelectionText.length();
        if (startOffset < this.mGlobalStartOffset) {
            updateGlobalSelection(selectionText.substring(0, this.mGlobalStartOffset - startOffset) + this.mGlobalSelectionText, startOffset);
        }
        if (endOffset > globalEndOffset) {
            updateGlobalSelection(this.mGlobalSelectionText + selectionText.substring(globalEndOffset - startOffset, selectionText.length()), this.mGlobalStartOffset);
        }
    }
}
