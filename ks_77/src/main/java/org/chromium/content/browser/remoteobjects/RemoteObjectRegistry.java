package org.chromium.content.browser.remoteobjects;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.chromium.content.browser.remoteobjects.RemoteObjectImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/remoteobjects/RemoteObjectRegistry.class */
final class RemoteObjectRegistry implements RemoteObjectImpl.ObjectIdAllocator {
    private final Set<? super RemoteObjectRegistry> mRetainingSet;
    private final Map<Integer, Object> mObjectsById = new HashMap();
    private final Map<Object, Integer> mIdsByObject = new HashMap();
    private int mNextId;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !RemoteObjectRegistry.class.desiredAssertionStatus();
    }

    RemoteObjectRegistry(Set<? super RemoteObjectRegistry> retainingSet) {
        retainingSet.add(this);
        this.mRetainingSet = retainingSet;
    }

    public void close() {
        boolean removed = this.mRetainingSet.remove(this);
        if (!$assertionsDisabled && !removed) {
            throw new AssertionError();
        }
    }

    @Override // org.chromium.content.browser.remoteobjects.RemoteObjectImpl.ObjectIdAllocator
    public int getObjectId(Object object) {
        Integer existingId = this.mIdsByObject.get(object);
        if (existingId != null) {
            return existingId.intValue();
        }
        int newId = this.mNextId;
        this.mNextId = newId + 1;
        if ($assertionsDisabled || newId >= 0) {
            this.mObjectsById.put(Integer.valueOf(newId), object);
            this.mIdsByObject.put(object, Integer.valueOf(newId));
            return newId;
        }
        throw new AssertionError();
    }

    @Override // org.chromium.content.browser.remoteobjects.RemoteObjectImpl.ObjectIdAllocator
    public Object getObjectById(int id) {
        return this.mObjectsById.get(Integer.valueOf(id));
    }

    public void removeObjectById(int id) {
        Object o = this.mObjectsById.remove(Integer.valueOf(id));
        this.mIdsByObject.remove(o);
    }
}
