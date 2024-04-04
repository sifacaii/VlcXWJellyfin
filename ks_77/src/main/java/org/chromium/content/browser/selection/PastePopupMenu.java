package org.chromium.content.browser.selection;

import android.graphics.Rect;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/PastePopupMenu.class */
public interface PastePopupMenu {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/PastePopupMenu$PastePopupMenuDelegate.class */
    public interface PastePopupMenuDelegate {
        void paste();

        void pasteAsPlainText();

        boolean canPaste();

        void selectAll();

        boolean canSelectAll();

        boolean canPasteAsPlainText();
    }

    void show(Rect rect);

    void hide();
}
