package org.chromium.content.browser;

import java.util.ArrayList;
import java.util.List;
import org.chromium.base.UserData;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/PopupController.class */
public class PopupController implements UserData {
    private final List<HideablePopup> mHideablePopups;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/PopupController$HideablePopup.class */
    public interface HideablePopup {
        void hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/PopupController$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<PopupController> INSTANCE = x$0 -> {
            return new PopupController(x$0);
        };

        private UserDataFactoryLazyHolder() {
        }
    }

    public static PopupController fromWebContents(WebContents webContents) {
        return (PopupController) ((WebContentsImpl) webContents).getOrSetUserData(PopupController.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    private PopupController(WebContents webContents) {
        this.mHideablePopups = new ArrayList();
    }

    public static void hideAll(WebContents webContents) {
        PopupController controller;
        if (webContents != null && (controller = fromWebContents(webContents)) != null) {
            controller.hideAllPopups();
        }
    }

    public static void hidePopupsAndClearSelection(WebContents webContents) {
        if (webContents == null) {
            return;
        }
        SelectionPopupControllerImpl controller = SelectionPopupControllerImpl.fromWebContents(webContents);
        if (controller != null) {
            controller.destroyActionModeAndUnselect();
        }
        hideAll(webContents);
    }

    public static void register(WebContents webContents, HideablePopup popup) {
        if (webContents == null) {
            return;
        }
        fromWebContents(webContents).registerPopup(popup);
    }

    public void hideAllPopups() {
        for (HideablePopup popup : this.mHideablePopups) {
            popup.hide();
        }
    }

    public void registerPopup(HideablePopup popup) {
        this.mHideablePopups.add(popup);
    }
}
