package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FontUniqueNameLookup.class */
public interface FontUniqueNameLookup extends Interface {
    public static final Interface.Manager<FontUniqueNameLookup, Proxy> MANAGER = FontUniqueNameLookup_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FontUniqueNameLookup$GetUniqueNameLookupTableIfAvailableResponse.class */
    public interface GetUniqueNameLookupTableIfAvailableResponse extends Callbacks.Callback2<Boolean, ReadOnlySharedMemoryRegion> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FontUniqueNameLookup$GetUniqueNameLookupTableResponse.class */
    public interface GetUniqueNameLookupTableResponse extends Callbacks.Callback1<ReadOnlySharedMemoryRegion> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FontUniqueNameLookup$Proxy.class */
    public interface Proxy extends FontUniqueNameLookup, Interface.Proxy {
    }

    void getUniqueNameLookupTableIfAvailable(GetUniqueNameLookupTableIfAvailableResponse getUniqueNameLookupTableIfAvailableResponse);

    void getUniqueNameLookupTable(GetUniqueNameLookupTableResponse getUniqueNameLookupTableResponse);
}
