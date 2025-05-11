package org.chromium.content.browser;

import org.chromium.base.task.TaskTraits;
import org.chromium.base.task.TaskTraitsExtensionDescriptor;
import org.chromium.content_public.browser.BrowserTaskExecutor;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/UiThreadTaskTraitsImpl.class */
public class UiThreadTaskTraitsImpl {
    public static final TaskTraitsExtensionDescriptor<UiThreadTaskTraitsImpl> DESCRIPTOR = new Descriptor();
    public static final TaskTraits DEFAULT = TaskTraits.USER_VISIBLE.withExtension(DESCRIPTOR, new UiThreadTaskTraitsImpl());
    public static final TaskTraits BOOTSTRAP = TaskTraits.USER_VISIBLE.withExtension(DESCRIPTOR, new UiThreadTaskTraitsImpl().setTaskType(1));
    public static final TaskTraits BEST_EFFORT = DEFAULT.taskPriority(0);
    public static final TaskTraits USER_VISIBLE = DEFAULT.taskPriority(1);
    public static final TaskTraits USER_BLOCKING = DEFAULT.taskPriority(2);
    private int mTaskType;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/UiThreadTaskTraitsImpl$Descriptor.class */
    private static class Descriptor implements TaskTraitsExtensionDescriptor<UiThreadTaskTraitsImpl> {
        private static final byte EXTENSION_ID = 1;
        private static final byte TASK_TYPE = 1;
        private static final byte NESTING_INDEX = 2;

        private Descriptor() {
        }

        @Override // org.chromium.base.task.TaskTraitsExtensionDescriptor
        public int getId() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.base.task.TaskTraitsExtensionDescriptor
        public UiThreadTaskTraitsImpl fromSerializedData(byte[] data) {
            return new UiThreadTaskTraitsImpl().setTaskType(data[1]);
        }

        @Override // org.chromium.base.task.TaskTraitsExtensionDescriptor
        public byte[] toSerializedData(UiThreadTaskTraitsImpl extension) {
            byte[] extensionData = new byte[8];
            extensionData[2] = 1;
            extensionData[1] = (byte) extension.mTaskType;
            return extensionData;
        }
    }

    static {
        BrowserTaskExecutor.register();
    }

    private UiThreadTaskTraitsImpl() {
        this.mTaskType = 0;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UiThreadTaskTraitsImpl setTaskType(int taskType) {
        this.mTaskType = taskType;
        return this;
    }
}
