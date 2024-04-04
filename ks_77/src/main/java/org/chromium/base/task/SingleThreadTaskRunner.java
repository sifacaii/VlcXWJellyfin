package org.chromium.base.task;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/SingleThreadTaskRunner.class */
public interface SingleThreadTaskRunner extends SequencedTaskRunner {
    boolean belongsToCurrentThread();
}
