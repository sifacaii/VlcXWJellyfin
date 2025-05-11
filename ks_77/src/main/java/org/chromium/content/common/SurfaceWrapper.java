package org.chromium.content.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("content")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/common/SurfaceWrapper.class */
public class SurfaceWrapper implements Parcelable {
    private final Surface mSurface;
    private final boolean mCanBeUsedWithSurfaceControl;
    public static final Parcelable.Creator<SurfaceWrapper> CREATOR = new Parcelable.Creator<SurfaceWrapper>() { // from class: org.chromium.content.common.SurfaceWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SurfaceWrapper createFromParcel(Parcel in) {
            Surface surface = (Surface) Surface.CREATOR.createFromParcel(in);
            boolean canBeUsedWithSurfaceControl = in.readInt() == 1;
            return new SurfaceWrapper(surface, canBeUsedWithSurfaceControl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SurfaceWrapper[] newArray(int size) {
            return new SurfaceWrapper[size];
        }
    };

    public SurfaceWrapper(Surface surface, boolean canBeUsedWithSurfaceControl) {
        this.mSurface = surface;
        this.mCanBeUsedWithSurfaceControl = canBeUsedWithSurfaceControl;
    }

    @CalledByNative
    public Surface getSurface() {
        return this.mSurface;
    }

    @CalledByNative
    public boolean canBeUsedWithSurfaceControl() {
        return this.mCanBeUsedWithSurfaceControl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        this.mSurface.writeToParcel(out, 0);
        out.writeInt(this.mCanBeUsedWithSurfaceControl ? 1 : 0);
    }

    @CalledByNative
    private static SurfaceWrapper create(Surface surface, boolean canBeUsedWithSurfaceControl) {
        return new SurfaceWrapper(surface, canBeUsedWithSurfaceControl);
    }
}
