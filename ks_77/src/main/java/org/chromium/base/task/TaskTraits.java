package org.chromium.base.task;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/TaskTraits.class */
public class TaskTraits {
    public static final byte INVALID_EXTENSION_ID = 0;
    public static final int MAX_EXTENSION_ID = 4;
    public static final int EXTENSION_STORAGE_SIZE = 8;
    public static final TaskTraits BEST_EFFORT;
    public static final TaskTraits BEST_EFFORT_MAY_BLOCK;
    public static final TaskTraits USER_VISIBLE;
    public static final TaskTraits USER_VISIBLE_MAY_BLOCK;
    public static final TaskTraits USER_BLOCKING;
    public static final TaskTraits USER_BLOCKING_MAY_BLOCK;
    public static final TaskTraits CHOREOGRAPHER_FRAME;
    public static final TaskTraits THREAD_POOL;
    public static final TaskTraits THREAD_POOL_USER_BLOCKING;
    public static final TaskTraits THREAD_POOL_USER_VISIBLE;
    public static final TaskTraits THREAD_POOL_BEST_EFFORT;
    boolean mPrioritySetExplicitly;
    int mPriority;
    boolean mMayBlock;
    boolean mUseThreadPool;
    byte mExtensionId;
    byte[] mExtensionData;
    boolean mIsChoreographerFrame;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !TaskTraits.class.desiredAssertionStatus();
        BEST_EFFORT = new TaskTraits().taskPriority(0);
        BEST_EFFORT_MAY_BLOCK = BEST_EFFORT.mayBlock();
        USER_VISIBLE = new TaskTraits().taskPriority(1);
        USER_VISIBLE_MAY_BLOCK = USER_VISIBLE.mayBlock();
        USER_BLOCKING = new TaskTraits().taskPriority(2);
        USER_BLOCKING_MAY_BLOCK = USER_BLOCKING.mayBlock();
        CHOREOGRAPHER_FRAME = new TaskTraits();
        CHOREOGRAPHER_FRAME.mIsChoreographerFrame = true;
        THREAD_POOL = new TaskTraits().threadPool();
        THREAD_POOL_USER_BLOCKING = THREAD_POOL.taskPriority(2);
        THREAD_POOL_USER_VISIBLE = THREAD_POOL.taskPriority(1);
        THREAD_POOL_BEST_EFFORT = THREAD_POOL.taskPriority(0);
    }

    private TaskTraits() {
        this.mPriority = 1;
    }

    private TaskTraits(TaskTraits other) {
        this.mPrioritySetExplicitly = other.mPrioritySetExplicitly;
        this.mPriority = other.mPriority;
        this.mMayBlock = other.mMayBlock;
        this.mUseThreadPool = other.mUseThreadPool;
        this.mExtensionId = other.mExtensionId;
        this.mExtensionData = other.mExtensionData;
    }

    public TaskTraits taskPriority(int taskPriority) {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mPrioritySetExplicitly = true;
        taskTraits.mPriority = taskPriority;
        return taskTraits;
    }

    public TaskTraits mayBlock() {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mMayBlock = true;
        return taskTraits;
    }

    public TaskTraits threadPool() {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mUseThreadPool = true;
        return taskTraits;
    }

    public boolean hasExtension() {
        return this.mExtensionId != 0;
    }

    public <Extension> Extension getExtension(TaskTraitsExtensionDescriptor<Extension> descriptor) {
        if (this.mExtensionId == descriptor.getId()) {
            return descriptor.fromSerializedData(this.mExtensionData);
        }
        return null;
    }

    public <Extension> TaskTraits withExtension(TaskTraitsExtensionDescriptor<Extension> descriptor, Extension extension) {
        int id = descriptor.getId();
        byte[] data = descriptor.toSerializedData(extension);
        if ($assertionsDisabled || (id > 0 && id <= 4)) {
            if ($assertionsDisabled || data.length <= 8) {
                TaskTraits taskTraits = new TaskTraits(this);
                taskTraits.mExtensionId = (byte) id;
                taskTraits.mExtensionData = data;
                return taskTraits;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof TaskTraits) {
            TaskTraits other = (TaskTraits) object;
            return this.mPrioritySetExplicitly == other.mPrioritySetExplicitly && this.mPriority == other.mPriority && this.mExtensionId == other.mExtensionId && Arrays.equals(this.mExtensionData, other.mExtensionData);
        }
        return false;
    }

    public int hashCode() {
        int hash = (37 * 31) + (this.mPrioritySetExplicitly ? 0 : 1);
        return (37 * ((37 * ((37 * ((37 * ((37 * ((37 * hash) + this.mPriority)) + (this.mMayBlock ? 0 : 1))) + (this.mUseThreadPool ? 0 : 1))) + this.mExtensionId)) + Arrays.hashCode(this.mExtensionData))) + (this.mIsChoreographerFrame ? 0 : 1);
    }
}
