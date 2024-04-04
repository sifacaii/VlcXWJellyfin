package org.xwalk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.pakdata.xwalk.refactor.ReflectMethod;
import com.pakdata.xwalk.refactor.XWalkCoreBridge;
import com.pakdata.xwalk.refactor.XWalkViewDelegate;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkCoreWrapper.class */
public class XWalkCoreWrapper {
    private static final String WRAPPER_PACKAGE = "org.xwalk.core";
    private static final String BRIDGE_PACKAGE = "org.xwalk.core.internal";
    private static final String TAG = "XWalkCoreWrapper";
    private static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
    private static XWalkCoreWrapper sProvisionalInstance;
    private static XWalkCoreWrapper sInstance;
    private static LinkedList<String> sReservedActivities = new LinkedList<>();
    private static HashMap<String, LinkedList<ReservedAction>> sReservedActions = new HashMap<>();
    private int mApiVersion = 8;
    private int mMinApiVersion;
    private int mCoreStatus;
    private Context mWrapperContext;
    private Context mBridgeContext;
    private ClassLoader mBridgeLoader;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkCoreWrapper$ReservedAction.class */
    public static class ReservedAction {
        Object mObject;
        Class<?> mClass;
        ReflectMethod mMethod;
        Object[] mArguments;

        ReservedAction(Object object) {
            this.mObject = object;
        }

        ReservedAction(Class<?> clazz) {
            this.mClass = clazz;
        }

        ReservedAction(ReflectMethod method) {
            this.mMethod = method;
            if (method.getArguments() != null) {
                this.mArguments = Arrays.copyOf(method.getArguments(), method.getArguments().length);
            }
        }
    }

    public static XWalkCoreWrapper getInstance() {
        return sInstance;
    }

    public static int getCoreStatus() {
        if (sInstance != null) {
            return sInstance.mCoreStatus;
        }
        if (sProvisionalInstance == null) {
            return 0;
        }
        return sProvisionalInstance.mCoreStatus;
    }

    public static void handlePreInit(String tag) {
        if (sInstance != null) {
            return;
        }
        Log.d(TAG, "Pre init xwalk core in " + tag);
        if (sReservedActions.containsKey(tag)) {
            sReservedActions.remove(tag);
        } else {
            sReservedActivities.add(tag);
        }
        sReservedActions.put(tag, new LinkedList<>());
    }

    public static void reserveReflectObject(Object object) {
        String tag = sReservedActivities.getLast();
        Log.d(TAG, "Reserve object " + object.getClass() + " to " + tag);
        sReservedActions.get(tag).add(new ReservedAction(object));
    }

    public static void reserveReflectClass(Class<?> clazz) {
        String tag = sReservedActivities.getLast();
        Log.d(TAG, "Reserve class " + clazz.toString() + " to " + tag);
        sReservedActions.get(tag).add(new ReservedAction(clazz));
    }

    public static void reserveReflectMethod(ReflectMethod method) {
        String tag = sReservedActivities.getLast();
        Log.d(TAG, "Reserve method " + method.toString() + " to " + tag);
        sReservedActions.get(tag).add(new ReservedAction(method));
    }

    public static void handlePostInit(String tag) {
        Log.d(TAG, "Post init xwalk core in " + tag);
        if (!sReservedActions.containsKey(tag)) {
            return;
        }
        LinkedList<ReservedAction> reservedActions = sReservedActions.get(tag);
        Iterator<ReservedAction> it = reservedActions.iterator();
        while (it.hasNext()) {
            ReservedAction action = it.next();
            if (action.mObject != null) {
                Log.d(TAG, "Init reserved object: " + action.mObject.getClass().getCanonicalName());
                new ReflectMethod(action.mObject, "reflectionInit", new Class[0]).invoke(new Object[0]);
            } else if (action.mClass != null) {
                Log.d(TAG, "Init reserved class: " + action.mClass.toString());
                new ReflectMethod(action.mClass, "reflectionInit", (Class<?>[]) new Class[0]).invoke(new Object[0]);
            } else {
                Log.d(TAG, "Call reserved method: " + action.mMethod.toString());
                Object[] args = action.mArguments;
                if (args != null) {
                    for (int i = 0; i < args.length; i++) {
                        if (args[i] instanceof ReflectMethod) {
                            args[i] = ((ReflectMethod) args[i]).invokeWithArguments();
                        }
                    }
                }
                action.mMethod.invoke(args);
            }
        }
        sReservedActions.remove(tag);
        sReservedActivities.remove(tag);
    }

    public static void handleRuntimeError(RuntimeException e) {
        Log.e(TAG, "This API is incompatible with the Crosswalk runtime library");
        e.printStackTrace();
    }

    public static int attachXWalkCore() {
        Log.d(TAG, "Attach xwalk core");
        sProvisionalInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), 1);
        if (sProvisionalInstance.findEmbeddedCore()) {
            return sProvisionalInstance.mCoreStatus;
        }
        if (XWalkEnvironment.isDownloadMode()) {
            sProvisionalInstance.findDownloadedCore();
            return sProvisionalInstance.mCoreStatus;
        }
        Log.d(TAG, "Not verifying the package integrity of Crosswalk runtime library");
        if (XWalkEnvironment.is64bitDevice()) {
            if (!sProvisionalInstance.findSharedCore("org.xwalk.core") && !sProvisionalInstance.findSharedCore(XWalkLibraryInterface.XWALK_CORE64_PACKAGE) && XWalkEnvironment.isIaDevice()) {
                sProvisionalInstance.findSharedCore(XWalkLibraryInterface.XWALK_CORE64_IA_PACKAGE);
            }
        } else if (!sProvisionalInstance.findSharedCore("org.xwalk.core") && XWalkEnvironment.isIaDevice()) {
            sProvisionalInstance.findSharedCore(XWalkLibraryInterface.XWALK_CORE_IA_PACKAGE);
        }
        return sProvisionalInstance.mCoreStatus;
    }

    public static void dockXWalkCore() {
        Log.d(TAG, "Dock xwalk core");
        sInstance = sProvisionalInstance;
        sProvisionalInstance = null;
        sInstance.initCoreBridge();
        sInstance.initXWalkView();
    }

    public static void initEmbeddedMode() {
        if (sInstance == null && sReservedActivities.isEmpty()) {
            Log.d(TAG, "Init embedded mode");
            XWalkCoreWrapper provisionalInstance = new XWalkCoreWrapper(null, -1);
            if (!provisionalInstance.findEmbeddedCore()) {
                throw new RuntimeException("Please have your activity extend XWalkActivity for shared mode");
            }
            sInstance = provisionalInstance;
            sInstance.initCoreBridge();
        }
    }

    private XWalkCoreWrapper(Context context, int minApiVersion) {
        this.mMinApiVersion = (minApiVersion <= 0 || minApiVersion > this.mApiVersion) ? this.mApiVersion : minApiVersion;
        this.mCoreStatus = 0;
        this.mWrapperContext = context;
    }

    private void initCoreBridge() {
        Log.d(TAG, "Init core bridge TODO");
        XWalkCoreBridge.init(this.mBridgeContext, this);
    }

    private void initXWalkView() {
        Log.d(TAG, "Init xwalk view TODO");
        XWalkViewDelegate.init(this.mBridgeContext, this.mWrapperContext);
    }

    private boolean findEmbeddedCore() {
        this.mBridgeContext = null;
        this.mBridgeLoader = XWalkCoreWrapper.class.getClassLoader();
        if (!checkCoreVersion() || !checkCoreArchitecture()) {
            this.mBridgeLoader = null;
            return false;
        }
        Log.d(TAG, "Running in embedded mode");
        this.mCoreStatus = 1;
        return true;
    }

    private boolean findSharedCore(String packageName) {
        if (checkCorePackage(packageName)) {
            this.mBridgeLoader = this.mBridgeContext.getClassLoader();
            if (!checkCoreVersion() || !checkCoreArchitecture()) {
                this.mBridgeContext = null;
                this.mBridgeLoader = null;
                return false;
            }
            Log.d(TAG, "Running in shared mode");
            this.mCoreStatus = 1;
            return true;
        }
        return false;
    }

    private boolean findDownloadedCore() {
        String libDir = XWalkEnvironment.getExtractedCoreDir();
        String dexPath = libDir + File.separator + XWALK_CORE_CLASSES_DEX;
        String dexOutputPath = XWalkEnvironment.getOptimizedDexDir();
        ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();
        this.mBridgeLoader = new DexClassLoader(dexPath, dexOutputPath, libDir, localClassLoader);
        if (!checkCoreVersion() || !checkCoreArchitecture()) {
            this.mBridgeLoader = null;
            return false;
        }
        Log.d(TAG, "Running in downloaded mode");
        this.mCoreStatus = 1;
        return true;
    }

    private boolean checkCoreVersion() {
        Log.d(TAG, "[Environment] SDK:" + Build.VERSION.SDK_INT);
        Log.d(TAG, "[App Version] build:77.0.3.0, api:" + this.mApiVersion + ", min_api:" + this.mMinApiVersion);
        Log.d(TAG, "XWalk core version matched");
        return true;
    }

    private boolean checkCoreArchitecture() {
        try {
            boolean architectureMatched = false;
            String libDir = null;
            if (this.mBridgeContext == null) {
                try {
                    architectureMatched = XWalkViewDelegate.loadXWalkLibrary(this.mBridgeContext, null);
                } catch (RuntimeException ex) {
                    Log.d(TAG, ex.getLocalizedMessage());
                }
                if (!architectureMatched && this.mWrapperContext != null) {
                    String libDir2 = XWalkEnvironment.getPrivateDataDir();
                    architectureMatched = XWalkViewDelegate.loadXWalkLibrary(this.mBridgeContext, libDir2);
                }
            } else {
                if (Build.VERSION.SDK_INT < 17) {
                    libDir = this.mBridgeContext.getApplicationInfo().dataDir + "/lib";
                }
                architectureMatched = XWalkViewDelegate.loadXWalkLibrary(this.mBridgeContext, libDir);
            }
            if (!architectureMatched) {
                Log.d(TAG, "Mismatch of CPU architecture");
                this.mCoreStatus = 6;
                return false;
            }
            Log.d(TAG, "XWalk core architecture matched");
            return true;
        } catch (RuntimeException e) {
            Log.d(TAG, e.getLocalizedMessage());
            if (e.getCause() instanceof UnsatisfiedLinkError) {
                this.mCoreStatus = 6;
                return false;
            }
            this.mCoreStatus = 5;
            return false;
        }
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private boolean checkCorePackage(String packageName) {
        try {
            this.mBridgeContext = this.mWrapperContext.createPackageContext(packageName, 3);
            Log.d(TAG, "Created package context for " + packageName);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d(TAG, packageName + " not found");
            return false;
        }
    }

    private boolean verifyPackageInfo(PackageInfo packageInfo, String hashAlgorithm, String hashCode) {
        if (packageInfo.signatures == null) {
            Log.e(TAG, "No signature in package info");
            return false;
        }
        try {
            MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
            byte[] hashArray = hexStringToByteArray(hashCode);
            if (hashArray == null) {
                throw new IllegalArgumentException("Invalid hash code");
            }
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                Log.d(TAG, "Checking signature " + i);
                byte[] binaryCert = packageInfo.signatures[i].toByteArray();
                byte[] digest = md.digest(binaryCert);
                if (!MessageDigest.isEqual(digest, hashArray)) {
                    Log.e(TAG, "Hash code does not match");
                } else {
                    Log.d(TAG, "Signature passed verification");
                    return true;
                }
            }
            return false;
        } catch (NullPointerException | NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Invalid hash algorithm");
        }
    }

    private byte[] hexStringToByteArray(String str) {
        if (str == null || str.isEmpty() || str.length() % 2 != 0) {
            return null;
        }
        byte[] result = new byte[str.length() / 2];
        for (int i = 0; i < str.length(); i += 2) {
            int digit = Character.digit(str.charAt(i), 16);
            result[i / 2] = (byte) ((digit << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return result;
    }

    public boolean isSharedMode() {
        return this.mBridgeContext != null;
    }

    public Object getBridgeObject(Object object) {
        try {
            return new ReflectMethod(object, "getBridge", new Class[0]).invoke(new Object[0]);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public Object getWrapperObject(Object object) {
        try {
            return new ReflectMethod(object, "getWrapper", new Class[0]).invoke(new Object[0]);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public Class<?> getBridgeClass(String name) {
        try {
            return this.mBridgeLoader.loadClass("org.xwalk.core.internal." + name);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
