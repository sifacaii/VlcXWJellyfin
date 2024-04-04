package org.chromium.content.browser.selection;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.textclassifier.TextClassification;
import java.util.HashMap;
import java.util.Map;
import org.chromium.base.Log;

@SuppressLint({"NewApi"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/AdditionalMenuItemProviderImpl.class */
public class AdditionalMenuItemProviderImpl implements AdditionalMenuItemProvider {
    private static final String TAG = "MenuItemProvider";
    private static final int MENU_ITEM_ORDER_SECONDARY_ASSIST_ACTIONS_START = 50;
    private final Map<MenuItem, View.OnClickListener> mAssistClickHandlers = new HashMap();

    @Override // org.chromium.content.browser.selection.AdditionalMenuItemProvider
    public void addMenuItems(Context context, Menu menu, TextClassification classification) {
        if (menu == null || classification == null) {
            return;
        }
        int count = classification.getActions().size();
        if (count > 0) {
            RemoteAction primaryAction = classification.getActions().get(0);
            MenuItem item = menu.findItem(16908353);
            if (primaryAction.shouldShowIcon()) {
                item.setIcon(primaryAction.getIcon().loadDrawable(context));
            } else {
                item.setIcon((Drawable) null);
            }
        }
        for (int i = 1; i < count; i++) {
            RemoteAction action = classification.getActions().get(i);
            View.OnClickListener listener = getSupportedOnClickListener(action.getTitle(), action.getActionIntent());
            if (listener != null) {
                MenuItem item2 = menu.add(16908353, 0, 50 + i, action.getTitle());
                item2.setContentDescription(action.getContentDescription());
                if (action.shouldShowIcon()) {
                    item2.setIcon(action.getIcon().loadDrawable(context));
                }
                item2.setShowAsAction(1);
                this.mAssistClickHandlers.put(item2, listener);
            }
        }
    }

    @Override // org.chromium.content.browser.selection.AdditionalMenuItemProvider
    public void clearMenuItemListeners() {
        this.mAssistClickHandlers.clear();
    }

    @Override // org.chromium.content.browser.selection.AdditionalMenuItemProvider
    public void performAction(MenuItem item, View view) {
        View.OnClickListener listener = this.mAssistClickHandlers.get(item);
        if (listener == null) {
            return;
        }
        listener.onClick(view);
    }

    private static View.OnClickListener getSupportedOnClickListener(CharSequence title, PendingIntent pendingIntent) {
        if (TextUtils.isEmpty(title) || pendingIntent == null) {
            return null;
        }
        return v -> {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                Log.e(TAG, "Error creating OnClickListener from PendingIntent", e);
            }
        };
    }
}
