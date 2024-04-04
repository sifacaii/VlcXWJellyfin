package org.chromium.base.task;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/TaskTraitsExtensionDescriptor.class */
public interface TaskTraitsExtensionDescriptor<Extension> {
    int getId();

    Extension fromSerializedData(byte[] bArr);

    byte[] toSerializedData(Extension extension);
}
