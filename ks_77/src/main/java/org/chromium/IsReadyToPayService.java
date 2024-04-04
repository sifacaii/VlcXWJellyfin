package org.chromium;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import org.chromium.IsReadyToPayServiceCallback;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/IsReadyToPayService.class */
public interface IsReadyToPayService extends IInterface {
    void isReadyToPay(IsReadyToPayServiceCallback isReadyToPayServiceCallback) throws RemoteException;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/IsReadyToPayService$Stub.class */
    public static abstract class Stub extends Binder implements IsReadyToPayService {
        private static final String DESCRIPTOR = "org.chromium.IsReadyToPayService";
        static final int TRANSACTION_isReadyToPay = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IsReadyToPayService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IsReadyToPayService)) {
                return (IsReadyToPayService) iin;
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
                    IsReadyToPayServiceCallback _arg0 = IsReadyToPayServiceCallback.Stub.asInterface(data.readStrongBinder());
                    isReadyToPay(_arg0);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/IsReadyToPayService$Stub$Proxy.class */
        private static class Proxy implements IsReadyToPayService {
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

            @Override // org.chromium.IsReadyToPayService
            public void isReadyToPay(IsReadyToPayServiceCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
