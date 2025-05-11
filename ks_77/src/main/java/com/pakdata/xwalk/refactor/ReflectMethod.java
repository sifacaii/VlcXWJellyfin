package com.pakdata.xwalk.refactor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/ReflectMethod.class */
public class ReflectMethod {
    private Object mInstance;
    private Class<?> mClass;
    private String mName;
    private Class<?>[] mParameterTypes;
    private Method mMethod;
    private Object[] mArguments;

    public ReflectMethod() {
    }

    public ReflectMethod(Object instance, String name, Class<?>... parameterTypes) {
        init(instance, null, name, parameterTypes);
    }

    public ReflectMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        init(null, clazz, name, parameterTypes);
    }

    public boolean init(Object instance, Class<?> clazz, String name, Class<?>... parameterTypes) {
        this.mInstance = instance;
        this.mClass = clazz != null ? clazz : instance != null ? instance.getClass() : null;
        this.mName = name;
        this.mParameterTypes = parameterTypes;
        this.mMethod = null;
        if (this.mClass == null) {
            return false;
        }
        try {
            this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> cls = this.mClass;
            while (true) {
                Class<?> parent = cls;
                if (parent == null) {
                    break;
                }
                try {
                    this.mMethod = parent.getDeclaredMethod(this.mName, this.mParameterTypes);
                    this.mMethod.setAccessible(true);
                    break;
                } catch (NoSuchMethodException e2) {
                    cls = parent.getSuperclass();
                }
            }
        }
        return this.mMethod != null;
    }

    public Object invoke(Object... args) {
        if (this.mMethod == null) {
            throw new UnsupportedOperationException(toString());
        }
        try {
            return this.mMethod.invoke(this.mInstance, args);
        } catch (IllegalAccessException | NullPointerException e) {
            throw new RejectedExecutionException(e);
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3.getCause());
        }
    }

    public boolean isNull() {
        return this.mMethod == null;
    }

    public String toString() {
        if (this.mMethod != null) {
            return this.mMethod.toString();
        }
        String ret = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
        if (this.mClass != null) {
            ret = ret + this.mClass.toString() + ".";
        }
        if (this.mName != null) {
            ret = ret + this.mName;
        }
        return ret;
    }

    public String getName() {
        return this.mName;
    }

    public Object getInstance() {
        return this.mInstance;
    }

    public Object[] getArguments() {
        return this.mArguments;
    }

    public void setArguments(Object... args) {
        this.mArguments = args;
    }

    public Object invokeWithArguments() {
        return invoke(this.mArguments);
    }
}
