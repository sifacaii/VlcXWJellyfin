package org.chromium;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/IsReadyToPayServiceCallback.class */
public interface IsReadyToPayServiceCallback extends IInterface {
    void handleIsReadyToPay(boolean z) throws RemoteException;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/IsReadyToPayServiceCallback$Stub.class */
    public static abstract class Stub extends Binder implements IsReadyToPayServiceCallback {
        private static final String DESCRIPTOR = "org.chromium.IsReadyToPayServiceCallback";
        static final int TRANSACTION_handleIsReadyToPay = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IsReadyToPayServiceCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IsReadyToPayServiceCallback)) {
                return (IsReadyToPayServiceCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0 = 0 != data.readInt();
                    handleIsReadyToPay(_arg0);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/IsReadyToPayServiceCallback$Stub$Proxy.class */
        private static class Proxy implements IsReadyToPayServiceCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // org.chromium.IsReadyToPayServiceCallback
            public void handleIsReadyToPay(boolean isReadyToPay) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(isReadyToPay ? 1 : 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
