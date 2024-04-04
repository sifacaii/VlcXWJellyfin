package org.chromium.content.browser.selection;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.textclassifier.TextClassification;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/AdditionalMenuItemProvider.class */
public interface AdditionalMenuItemProvider {
    void addMenuItems(Context context, Menu menu, TextClassification textClassification);

    void clearMenuItemListeners();

    void performAction(MenuItem menuItem, View view);
}
