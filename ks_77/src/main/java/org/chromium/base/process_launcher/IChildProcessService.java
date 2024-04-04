package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import org.chromium.base.process_launcher.IParentProcess;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/IChildProcessService.class */
public interface IChildProcessService extends IInterface {
    boolean bindToCaller() throws RemoteException;

    void setupConnection(Bundle bundle, IParentProcess iParentProcess, List<IBinder> list) throws RemoteException;

    void forceKill() throws RemoteException;

    void onMemoryPressure(int i) throws RemoteException;

    void dumpProcessStack() throws RemoteException;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/IChildProcessService$Stub.class */
    public static abstract class Stub extends Binder implements IChildProcessService {
        private static final String DESCRIPTOR = "org.chromium.base.process_launcher.IChildProcessService";
        static final int TRANSACTION_bindToCaller = 1;
        static final int TRANSACTION_setupConnection = 2;
        static final int TRANSACTION_forceKill = 3;
        static final int TRANSACTION_onMemoryPressure = 4;
        static final int TRANSACTION_dumpProcessStack = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IChildProcessService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IChildProcessService)) {
                return (IChildProcessService) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle _arg0;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = bindToCaller();
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    if (0 != data.readInt()) {
                        _arg0 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    IParentProcess _arg1 = IParentProcess.Stub.asInterface(data.readStrongBinder());
                    List<IBinder> _arg2 = data.createBinderArrayList();
                    setupConnection(_arg0, _arg1, _arg2);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    forceKill();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    onMemoryPressure(_arg02);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    dumpProcessStack();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/process_launcher/IChildProcessService$Stub$Proxy.class */
        private static class Proxy implements IChildProcessService {
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

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public boolean bindToCaller() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = 0 != _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public void setupConnection(Bundle args, IParentProcess parentProcess, List<IBinder> clientInterfaces) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (args != null) {
                        _data.writeInt(1);
                        args.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeStrongBinder(parentProcess != null ? parentProcess.asBinder() : null);
                    _data.writeBinderList(clientInterfaces);
                    this.mRemote.transact(2, _data, null, 1);
                    _data.recycle();
                } catch (Throwable th) {
                    _data.recycle();
                    throw th;
                }
            }

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public void forceKill() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public void onMemoryPressure(int pressure) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(pressure);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public void dumpProcessStack() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
