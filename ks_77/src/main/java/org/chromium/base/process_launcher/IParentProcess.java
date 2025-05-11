package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/IParentProcess.class */
public interface IParentProcess extends IInterface {
    void sendPid(int i) throws RemoteException;

    void reportCleanExit() throws RemoteException;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/IParentProcess$Stub.class */
    public static abstract class Stub extends Binder implements IParentProcess {
        private static final String DESCRIPTOR = "org.chromium.base.process_launcher.IParentProcess";
        static final int TRANSACTION_sendPid = 1;
        static final int TRANSACTION_reportCleanExit = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IParentProcess asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IParentProcess)) {
                return (IParentProcess) iin;
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
                    int _arg0 = data.readInt();
                    sendPid(_arg0);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    reportCleanExit();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/IParentProcess$Stub$Proxy.class */
        private static class Proxy implements IParentProcess {
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

            @Override // org.chromium.base.process_launcher.IParentProcess
            public void sendPid(int pid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(pid);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // org.chromium.base.process_launcher.IParentProcess
            public void reportCleanExit() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
