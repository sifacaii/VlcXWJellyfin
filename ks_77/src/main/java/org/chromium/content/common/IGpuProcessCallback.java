package org.chromium.content.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import org.chromium.base.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/common/IGpuProcessCallback.class */
public interface IGpuProcessCallback extends IInterface {
    void forwardSurfaceForSurfaceRequest(UnguessableToken unguessableToken, Surface surface) throws RemoteException;

    SurfaceWrapper getViewSurface(int i) throws RemoteException;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/common/IGpuProcessCallback$Stub.class */
    public static abstract class Stub extends Binder implements IGpuProcessCallback {
        private static final String DESCRIPTOR = "org.chromium.content.common.IGpuProcessCallback";
        static final int TRANSACTION_forwardSurfaceForSurfaceRequest = 1;
        static final int TRANSACTION_getViewSurface = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGpuProcessCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IGpuProcessCallback)) {
                return (IGpuProcessCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            UnguessableToken _arg0;
            Surface _arg1;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    if (0 != data.readInt()) {
                        _arg0 = UnguessableToken.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    if (0 != data.readInt()) {
                        _arg1 = (Surface) Surface.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    forwardSurfaceForSurfaceRequest(_arg0, _arg1);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    SurfaceWrapper _result = getViewSurface(_arg02);
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/common/IGpuProcessCallback$Stub$Proxy.class */
        private static class Proxy implements IGpuProcessCallback {
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

            @Override // org.chromium.content.common.IGpuProcessCallback
            public void forwardSurfaceForSurfaceRequest(UnguessableToken requestToken, Surface surface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (requestToken != null) {
                        _data.writeInt(1);
                        requestToken.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if (surface != null) {
                        _data.writeInt(1);
                        surface.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(1, _data, null, 1);
                    _data.recycle();
                } catch (Throwable th) {
                    _data.recycle();
                    throw th;
                }
            }

            @Override // org.chromium.content.common.IGpuProcessCallback
            public SurfaceWrapper getViewSurface(int surfaceId) throws RemoteException {
                SurfaceWrapper _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(surfaceId);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    if (0 != _reply.readInt()) {
                        _result = SurfaceWrapper.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
