package com.pakdata.xwalk.refactor;

import java.lang.reflect.Field;
import java.util.concurrent.RejectedExecutionException;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/ReflectField.class */
public class ReflectField {
    private Object mInstance;
    private Class<?> mClass;
    private String mName;
    private Field mField;

    public ReflectField() {
    }

    public ReflectField(Object instance, String name) {
        init(instance, null, name);
    }

    public ReflectField(Class<?> clazz, String name) {
        init(null, clazz, name);
    }

    public boolean init(Object instance, Class<?> clazz, String name) {
        this.mInstance = instance;
        this.mClass = clazz != null ? clazz : instance != null ? instance.getClass() : null;
        this.mName = name;
        this.mField = null;
        if (this.mClass == null) {
            return false;
        }
        try {
            this.mField = this.mClass.getField(this.mName);
        } catch (NoSuchFieldException e) {
            Class<?> cls = this.mClass;
            while (true) {
                Class<?> parent = cls;
                if (parent == null) {
                    break;
                }
                try {
                    this.mField = parent.getDeclaredField(this.mName);
                    this.mField.setAccessible(true);
                    break;
                } catch (NoSuchFieldException e2) {
                    cls = parent.getSuperclass();
                }
            }
        }
        return this.mField != null;
    }

    public Object get() {
        if (this.mField == null) {
            throw new UnsupportedOperationException(toString());
        }
        try {
            return this.mField.get(this.mInstance);
        } catch (ExceptionInInitializerError e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException | NullPointerException e2) {
            throw new RejectedExecutionException(e2);
        } catch (IllegalArgumentException e3) {
            throw e3;
        }
    }

    public boolean isNull() {
        return this.mField == null;
    }

    public String toString() {
        if (this.mField != null) {
            return this.mField.toString();
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
}
