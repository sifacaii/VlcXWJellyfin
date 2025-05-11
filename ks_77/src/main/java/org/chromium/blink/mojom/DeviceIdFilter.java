package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DeviceIdFilter.class */
public final class DeviceIdFilter extends Union {
    private short mVendor;
    private VendorAndProduct mVendorAndProduct;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DeviceIdFilter$Tag.class */
    public static final class Tag {
        public static final int Vendor = 0;
        public static final int VendorAndProduct = 1;
    }

    static {
        $assertionsDisabled = !DeviceIdFilter.class.desiredAssertionStatus();
    }

    public void setVendor(short vendor) {
        this.mTag = 0;
        this.mVendor = vendor;
    }

    public short getVendor() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mVendor;
        }
        throw new AssertionError();
    }

    public void setVendorAndProduct(VendorAndProduct vendorAndProduct) {
        this.mTag = 1;
        this.mVendorAndProduct = vendorAndProduct;
    }

    public VendorAndProduct getVendorAndProduct() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mVendorAndProduct;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Union
    public final void encode(Encoder encoder0, int offset) {
        encoder0.encode(16, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (this.mTag) {
            case 0:
                encoder0.encode(this.mVendor, offset + 8);
                return;
            case 1:
                encoder0.encode((Struct) this.mVendorAndProduct, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static DeviceIdFilter deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final DeviceIdFilter decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        DeviceIdFilter result = new DeviceIdFilter();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mVendor = decoder0.readShort(offset + 8);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mVendorAndProduct = VendorAndProduct.decode(decoder1);
                result.mTag = 1;
                break;
        }
        return result;
    }
}
