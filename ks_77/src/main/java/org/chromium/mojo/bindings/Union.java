package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Core;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/Union.class */
public abstract class Union {
    protected int mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void encode(Encoder encoder, int i);

    public int which() {
        return this.mTag;
    }

    public boolean isUnknown() {
        return this.mTag == -1;
    }

    public Message serialize(Core core) {
        Encoder encoder = new Encoder(core, 16);
        encoder.claimMemory(16);
        encode(encoder, 0);
        return encoder.getMessage();
    }
}
