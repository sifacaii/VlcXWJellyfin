package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/mojom/LatencyComponentType.class */
public final class LatencyComponentType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int INPUT_EVENT_LATENCY_BEGIN_RWH_COMPONENT = 0;
    public static final int LATENCY_BEGIN_SCROLL_LISTENER_UPDATE_MAIN_COMPONENT = 1;
    public static final int LATENCY_BEGIN_FRAME_RENDERER_MAIN_COMPONENT = 2;
    public static final int LATENCY_BEGIN_FRAME_RENDERER_INVALIDATE_COMPONENT = 3;
    public static final int LATENCY_BEGIN_FRAME_RENDERER_COMPOSITOR_COMPONENT = 4;
    public static final int LATENCY_BEGIN_FRAME_UI_MAIN_COMPONENT = 5;
    public static final int LATENCY_BEGIN_FRAME_UI_COMPOSITOR_COMPONENT = 6;
    public static final int LATENCY_BEGIN_FRAME_DISPLAY_COMPOSITOR_COMPONENT = 7;
    public static final int INPUT_EVENT_LATENCY_SCROLL_UPDATE_ORIGINAL_COMPONENT = 8;
    public static final int INPUT_EVENT_LATENCY_FIRST_SCROLL_UPDATE_ORIGINAL_COMPONENT = 9;
    public static final int INPUT_EVENT_LATENCY_ORIGINAL_COMPONENT = 10;
    public static final int INPUT_EVENT_LATENCY_UI_COMPONENT = 11;
    public static final int INPUT_EVENT_LATENCY_RENDERER_MAIN_COMPONENT = 12;
    public static final int INPUT_EVENT_LATENCY_RENDERING_SCHEDULED_MAIN_COMPONENT = 13;
    public static final int INPUT_EVENT_LATENCY_RENDERING_SCHEDULED_IMPL_COMPONENT = 14;
    public static final int INPUT_EVENT_LATENCY_FORWARD_SCROLL_UPDATE_TO_MAIN_COMPONENT = 15;
    public static final int INPUT_EVENT_LATENCY_SCROLL_UPDATE_LAST_EVENT_COMPONENT = 16;
    public static final int INPUT_EVENT_LATENCY_ACK_RWH_COMPONENT = 17;
    public static final int INPUT_EVENT_LATENCY_RENDERER_SWAP_COMPONENT = 18;
    public static final int DISPLAY_COMPOSITOR_RECEIVED_FRAME_COMPONENT = 19;
    public static final int INPUT_EVENT_GPU_SWAP_BUFFER_COMPONENT = 20;
    public static final int INPUT_EVENT_LATENCY_FRAME_SWAP_COMPONENT = 21;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 21;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private LatencyComponentType() {
    }
}
