package org.chromium.mojo_base;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.BigBufferSharedMemoryRegion;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/BigBufferUtil.class */
public final class BigBufferUtil {
    public static final int MAX_INLINE_ARRAY_SIZE = 65536;

    public static byte[] getBytesFromBigBuffer(BigBuffer buffer) {
        if (buffer.which() == 0) {
            return buffer.getBytes();
        }
        BigBufferSharedMemoryRegion region = buffer.getSharedMemory();
        ByteBuffer byteBuffer = region.bufferHandle.map(0L, region.size, SharedBufferHandle.MapFlags.NONE);
        byte[] bytes = new byte[region.size];
        byteBuffer.get(bytes);
        return bytes;
    }

    public static BigBuffer createBigBufferFromBytes(byte[] bytes) {
        BigBuffer buffer = new BigBuffer();
        if (bytes.length <= 65536) {
            buffer.setBytes(bytes);
            return buffer;
        }
        Core core = CoreImpl.getInstance();
        BigBufferSharedMemoryRegion region = new BigBufferSharedMemoryRegion();
        region.bufferHandle = core.createSharedBuffer(new SharedBufferHandle.CreateOptions(), bytes.length);
        region.size = bytes.length;
        ByteBuffer mappedRegion = region.bufferHandle.map(0L, bytes.length, SharedBufferHandle.MapFlags.NONE);
        mappedRegion.put(bytes);
        buffer.setSharedMemory(region);
        return buffer;
    }
}
