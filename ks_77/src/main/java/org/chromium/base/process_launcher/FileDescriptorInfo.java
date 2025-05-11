package org.chromium.base.process_launcher;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import javax.annotation.concurrent.Immutable;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.annotations.UsedByReflection;

@UsedByReflection("child_process_launcher_helper_android.cc")
@Immutable
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/FileDescriptorInfo.class */
public final class FileDescriptorInfo implements Parcelable {
    public final int id;
    public final ParcelFileDescriptor fd;
    public final long offset;
    public final long size;
    public static final Parcelable.Creator<FileDescriptorInfo> CREATOR = new Parcelable.Creator<FileDescriptorInfo>() { // from class: org.chromium.base.process_launcher.FileDescriptorInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDescriptorInfo createFromParcel(Parcel in) {
            return new FileDescriptorInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDescriptorInfo[] newArray(int size) {
            return new FileDescriptorInfo[size];
        }
    };

    public FileDescriptorInfo(int id, ParcelFileDescriptor fd, long offset, long size) {
        this.id = id;
        this.fd = fd;
        this.offset = offset;
        this.size = size;
    }

    FileDescriptorInfo(Parcel in) {
        this.id = in.readInt();
        this.fd = (ParcelFileDescriptor) in.readParcelable(ParcelFileDescriptor.class.getClassLoader());
        this.offset = in.readLong();
        this.size = in.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeParcelable(this.fd, 1);
        dest.writeLong(this.offset);
        dest.writeLong(this.size);
    }
}
