package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import org.chromium.base.annotations.CalledByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/UnguessableToken.class */
public class UnguessableToken implements Parcelable {
    private final long mHigh;
    private final long mLow;
    public static final Parcelable.Creator<UnguessableToken> CREATOR = new Parcelable.Creator<UnguessableToken>() { // from class: org.chromium.base.UnguessableToken.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnguessableToken createFromParcel(Parcel source) {
            long high = source.readLong();
            long low = source.readLong();
            if (high == 0 || low == 0) {
                return null;
            }
            return new UnguessableToken(high, low);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnguessableToken[] newArray(int size) {
            return new UnguessableToken[size];
        }
    };

    private UnguessableToken(long high, long low) {
        this.mHigh = high;
        this.mLow = low;
    }

    @CalledByNative
    private static UnguessableToken create(long high, long low) {
        return new UnguessableToken(high, low);
    }

    @CalledByNative
    public long getHighForSerialization() {
        return this.mHigh;
    }

    @CalledByNative
    public long getLowForSerialization() {
        return this.mLow;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.mHigh);
        dest.writeLong(this.mLow);
    }

    @CalledByNative
    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel parcel = Parcel.obtain();
        writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UnguessableToken token = CREATOR.createFromParcel(parcel);
        parcel.recycle();
        return token;
    }
}
