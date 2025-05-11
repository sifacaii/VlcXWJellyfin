package org.xwalk.core;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkMixedResources.class */
class XWalkMixedResources extends Resources {
    private Resources mLibraryResource;

    private boolean isCalledInLibrary() {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        for (StackTraceElement stack : stacks) {
            String className = stack.getClassName();
            if (className.startsWith("org.chromium") || className.startsWith("org.xwalk.core.internal")) {
                return true;
            }
            if (className.startsWith(XWalkLibraryInterface.XWALK_CORE_PACKAGE) && !className.endsWith("XWalkMixedResources")) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XWalkMixedResources(Resources base, Resources libraryResources) {
        super(base.getAssets(), base.getDisplayMetrics(), base.getConfiguration());
        this.mLibraryResource = libraryResources;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int id) throws Resources.NotFoundException {
        boolean calledInLibrary = isCalledInLibrary();
        try {
            return calledInLibrary ? this.mLibraryResource.getText(id) : super.getText(id);
        } catch (Resources.NotFoundException e) {
            return calledInLibrary ? super.getText(id) : this.mLibraryResource.getText(id);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int id) throws Resources.NotFoundException {
        boolean calledInLibrary = isCalledInLibrary();
        try {
            return calledInLibrary ? this.mLibraryResource.getLayout(id) : super.getLayout(id);
        } catch (Resources.NotFoundException e) {
            return calledInLibrary ? super.getLayout(id) : this.mLibraryResource.getLayout(id);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) {
        boolean calledInLibrary = isCalledInLibrary();
        try {
            if (calledInLibrary) {
                this.mLibraryResource.getValue(id, outValue, resolveRefs);
            } else {
                super.getValue(id, outValue, resolveRefs);
            }
        } catch (Resources.NotFoundException e) {
            if (!calledInLibrary) {
                this.mLibraryResource.getValue(id, outValue, resolveRefs);
            } else {
                super.getValue(id, outValue, resolveRefs);
            }
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) {
        boolean calledInLibrary = isCalledInLibrary();
        try {
            if (calledInLibrary) {
                this.mLibraryResource.getValueForDensity(id, density, outValue, resolveRefs);
            } else {
                super.getValueForDensity(id, density, outValue, resolveRefs);
            }
        } catch (Resources.NotFoundException e) {
            if (!calledInLibrary) {
                this.mLibraryResource.getValueForDensity(id, density, outValue, resolveRefs);
            } else {
                super.getValueForDensity(id, density, outValue, resolveRefs);
            }
        }
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String name, String defType, String defPackage) {
        boolean calledInLibrary = isCalledInLibrary();
        if (calledInLibrary) {
            int id = this.mLibraryResource.getIdentifier(name, defType, defPackage);
            return id != 0 ? id : super.getIdentifier(name, defType, defPackage);
        }
        int id2 = super.getIdentifier(name, defType, defPackage);
        return id2 != 0 ? id2 : this.mLibraryResource.getIdentifier(name, defType, defPackage);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int id) {
        boolean calledInLibrary = isCalledInLibrary();
        try {
            return calledInLibrary ? this.mLibraryResource.getDrawable(id) : super.getDrawable(id);
        } catch (Resources.NotFoundException e) {
            return calledInLibrary ? super.getDrawable(id) : this.mLibraryResource.getDrawable(id);
        }
    }
}
