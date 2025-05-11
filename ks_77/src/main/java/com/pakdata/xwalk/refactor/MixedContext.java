package com.pakdata.xwalk.refactor;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.LayoutInflater;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/MixedContext.class */
class MixedContext extends ContextWrapper {
    private Context mActivityCtx;

    public MixedContext(Context base, Context activity) {
        super(base);
        this.mActivityCtx = activity;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this.mActivityCtx.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent in, ServiceConnection conn, int flags) {
        return getApplicationContext().bindService(in, conn, flags);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection conn) {
        getApplicationContext().unbindService(conn);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        final ClassLoader appCl = getBaseContext().getClassLoader();
        final ClassLoader webViewCl = getClass().getClassLoader();
        return new ClassLoader() { // from class: com.pakdata.xwalk.refactor.MixedContext.1
            @Override // java.lang.ClassLoader
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    return webViewCl.loadClass(name);
                } catch (ClassNotFoundException e) {
                    return appCl.loadClass(name);
                }
            }
        };
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        if ("layout_inflater".equals(name)) {
            LayoutInflater i = (LayoutInflater) getBaseContext().getSystemService(name);
            return i.cloneInContext(this);
        }
        return getBaseContext().getSystemService(name);
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        getBaseContext().registerComponentCallbacks(callback);
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        getBaseContext().unregisterComponentCallbacks(callback);
    }
}
