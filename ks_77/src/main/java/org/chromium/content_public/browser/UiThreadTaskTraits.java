package org.chromium.content_public.browser;

import org.chromium.base.task.TaskTraits;
import org.chromium.content.browser.UiThreadTaskTraitsImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/UiThreadTaskTraits.class */
public class UiThreadTaskTraits {
    public static final TaskTraits DEFAULT = UiThreadTaskTraitsImpl.DEFAULT;
    public static final TaskTraits BEST_EFFORT = UiThreadTaskTraitsImpl.BEST_EFFORT;
    public static final TaskTraits USER_VISIBLE = UiThreadTaskTraitsImpl.USER_VISIBLE;
    public static final TaskTraits USER_BLOCKING = UiThreadTaskTraitsImpl.USER_BLOCKING;
    public static final TaskTraits BOOTSTRAP = UiThreadTaskTraitsImpl.BOOTSTRAP;

    private UiThreadTaskTraits() {
    }
}
