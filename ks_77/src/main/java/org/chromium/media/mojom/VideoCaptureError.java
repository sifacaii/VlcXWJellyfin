package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureError.class */
public final class VideoCaptureError {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NONE = 0;
    public static final int VIDEO_CAPTURE_CONTROLLER_INVALID_OR_UNSUPPORTED_VIDEO_CAPTURE_PARAMETERS_REQUESTED = 1;
    public static final int VIDEO_CAPTURE_CONTROLLER_IS_ALREADY_IN_ERROR_STATE = 2;
    public static final int VIDEO_CAPTURE_MANAGER_DEVICE_CONNECTION_LOST = 3;
    public static final int FRAME_SINK_VIDEO_CAPTURE_DEVICE_ALERADY_ENDED_ON_FATAL_ERROR = 4;
    public static final int FRAME_SINK_VIDEO_CAPTURE_DEVICE_ENCOUNTERED_FATAL_ERROR = 5;
    public static final int V4L2_FAILED_TO_OPEN_V4L2_DEVICE_DRIVER_FILE = 6;
    public static final int V4L2_THIS_IS_NOT_AV4L2_VIDEO_CAPTURE_DEVICE = 7;
    public static final int V4L2_FAILED_TO_FIND_A_SUPPORTED_CAMERA_FORMAT = 8;
    public static final int V4L2_FAILED_TO_SET_VIDEO_CAPTURE_FORMAT = 9;
    public static final int V4L2_UNSUPPORTED_PIXEL_FORMAT = 10;
    public static final int V4L2_FAILED_TO_SET_CAMERA_FRAMERATE = 11;
    public static final int V4L2_ERROR_REQUESTING_MMAP_BUFFERS = 12;
    public static final int V4L2_ALLOCATE_BUFFER_FAILED = 13;
    public static final int V4L2_VIDIOC_STREAMON_FAILED = 14;
    public static final int V4L2_VIDIOC_STREAMOFF_FAILED = 15;
    public static final int V4L2_FAILED_TO_VIDIOC_REQBUFS_WITH_COUNT0 = 16;
    public static final int V4L2_POLL_FAILED = 17;
    public static final int V4L2_MULTIPLE_CONTINUOUS_TIMEOUTS_WHILE_READ_POLLING = 18;
    public static final int V4L2_FAILED_TO_DEQUEUE_CAPTURE_BUFFER = 19;
    public static final int V4L2_FAILED_TO_ENQUEUE_CAPTURE_BUFFER = 20;
    public static final int SINGLE_CLIENT_VIDEO_CAPTURE_HOST_LOST_CONNECTION_TO_DEVICE = 21;
    public static final int SINGLE_CLIENT_VIDEO_CAPTURE_DEVICE_LAUNCH_ABORTED = 22;
    public static final int DESKTOP_CAPTURE_DEVICE_WEBRTC_DESKTOP_CAPTURER_HAS_FAILED = 23;
    public static final int FILE_VIDEO_CAPTURE_DEVICE_COULD_NOT_OPEN_VIDEO_FILE = 24;
    public static final int DEVICE_CAPTURE_LINUX_FAILED_TO_CREATE_VIDEO_CAPTURE_DELEGATE = 25;
    public static final int ERROR_FAKE_DEVICE_INTENTIONALLY_EMITTING_ERROR_EVENT = 26;
    public static final int DEVICE_CLIENT_TOO_MANY_FRAMES_DROPPED_Y16 = 27;
    public static final int DEVICE_MEDIA_TO_MOJO_ADAPTER_ENCOUNTERED_UNSUPPORTED_BUFFER_TYPE = 28;
    public static final int VIDEO_CAPTURE_MANAGER_PROCESS_DEVICE_START_QUEUE_DEVICE_INFO_NOT_FOUND = 29;
    public static final int IN_PROCESS_DEVICE_LAUNCHER_FAILED_TO_CREATE_DEVICE_INSTANCE = 30;
    public static final int SERVICE_DEVICE_LAUNCHER_LOST_CONNECTION_TO_DEVICE_FACTORY_DURING_DEVICE_START = 31;
    public static final int SERVICE_DEVICE_LAUNCHER_SERVICE_RESPONDED_WITH_DEVICE_NOT_FOUND = 32;
    public static final int SERVICE_DEVICE_LAUNCHER_CONNECTION_LOST_WHILE_WAITING_FOR_CALLBACK = 33;
    public static final int INTENTIONAL_ERROR_RAISED_BY_UNIT_TEST = 34;
    public static final int CROS_HAL_V3_FAILED_TO_START_DEVICE_THREAD = 35;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_MOJO_CONNECTION_ERROR = 36;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_GET_CAMERA_INFO = 37;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_MISSING_SENSOR_ORIENTATION_INFO = 38;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_OPEN_CAMERA_DEVICE = 39;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_INITIALIZE_CAMERA_DEVICE = 40;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_CONFIGURE_STREAMS = 41;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_WRONG_NUMBER_OF_STREAMS_CONFIGURED = 42;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_GET_DEFAULT_REQUEST_SETTINGS = 43;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_HAL_REQUESTED_TOO_MANY_BUFFERS = 44;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_CREATE_GPU_MEMORY_BUFFER = 45;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_MAP_GPU_MEMORY_BUFFER = 46;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_UNSUPPORTED_VIDEO_PIXEL_FORMAT = 47;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_DUP_FD = 48;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_WRAP_GPU_MEMORY_HANDLE = 49;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_REGISTER_BUFFER = 50;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_PROCESS_CAPTURE_REQUEST_FAILED = 51;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_INVALID_PENDING_RESULT_ID = 52;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_DUPLICATED_PARTIAL_METADATA = 53;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_INCORRECT_NUMBER_OF_OUTPUT_BUFFERS_RECEIVED = 54;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_INVALID_TYPE_OF_OUTPUT_BUFFERS_RECEIVED = 55;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_MULTIPLE_RESULT_BUFFERS_FOR_FRAME = 56;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_UNKNOWN_STREAM_IN_CAMERA3_NOTIFY_MSG = 57;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_INVALID_SHUTTER_TIME = 58;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_FATAL_DEVICE_ERROR = 59;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_FRAME_IS_OUT_OF_ORDER = 60;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_UNWRAP_RELEASE_FENCE_FD = 61;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_SYNC_WAIT_ON_RELEASE_FENCE_TIMED_OUT = 62;
    public static final int CROS_HAL_V3_BUFFER_MANAGER_INVALID_JPEG_BLOB = 63;
    public static final int ANDROID_FAILED_TO_ALLOCATE = 64;
    public static final int ANDROID_FAILED_TO_START_CAPTURE = 65;
    public static final int ANDROID_FAILED_TO_STOP_CAPTURE = 66;
    public static final int ANDROID_API1_CAMERA_ERROR_CALLBACK_RECEIVED = 67;
    public static final int ANDROID_API2_CAMERA_DEVICE_ERROR_RECEIVED = 68;
    public static final int ANDROID_API2_CAPTURE_SESSION_CONFIGURE_FAILED = 69;
    public static final int ANDROID_API2_IMAGE_READER_UNEXPECTED_IMAGE_FORMAT = 70;
    public static final int ANDROID_API2_IMAGE_READER_SIZE_DID_NOT_MATCH_IMAGE_SIZE = 71;
    public static final int ANDROID_API2_ERROR_RESTARTING_PREVIEW = 72;
    public static final int ANDROID_SCREEN_CAPTURE_UNSUPPORTED_FORMAT = 73;
    public static final int ANDROID_SCREEN_CAPTURE_FAILED_TO_START_CAPTURE_MACHINE = 74;
    public static final int ANDROID_SCREEN_CAPTURE_THE_USER_DENIED_SCREEN_CAPTURE = 75;
    public static final int ANDROID_SCREEN_CAPTURE_FAILED_TO_START_SCREEN_CAPTURE = 76;
    public static final int WIN_DIRECT_SHOW_CANT_GET_CAPTURE_FORMAT_SETTINGS = 77;
    public static final int WIN_DIRECT_SHOW_FAILED_TO_GET_NUMBER_OF_CAPABILITIES = 78;
    public static final int WIN_DIRECT_SHOW_FAILED_TO_GET_CAPTURE_DEVICE_CAPABILITIES = 79;
    public static final int WIN_DIRECT_SHOW_FAILED_TO_SET_CAPTURE_DEVICE_OUTPUT_FORMAT = 80;
    public static final int WIN_DIRECT_SHOW_FAILED_TO_CONNECT_THE_CAPTURE_GRAPH = 81;
    public static final int WIN_DIRECT_SHOW_FAILED_TO_PAUSE_THE_CAPTURE_DEVICE = 82;
    public static final int WIN_DIRECT_SHOW_FAILED_TO_START_THE_CAPTURE_DEVICE = 83;
    public static final int WIN_DIRECT_SHOW_FAILED_TO_STOP_THE_CAPTURE_GRAPH = 84;
    public static final int WIN_MEDIA_FOUNDATION_ENGINE_IS_NULL = 85;
    public static final int WIN_MEDIA_FOUNDATION_ENGINE_GET_SOURCE_FAILED = 86;
    public static final int WIN_MEDIA_FOUNDATION_FILL_PHOTO_CAPABILITIES_FAILED = 87;
    public static final int WIN_MEDIA_FOUNDATION_FILL_VIDEO_CAPABILITIES_FAILED = 88;
    public static final int WIN_MEDIA_FOUNDATION_NO_VIDEO_CAPABILITY_FOUND = 89;
    public static final int WIN_MEDIA_FOUNDATION_GET_AVAILABLE_DEVICE_MEDIA_TYPE_FAILED = 90;
    public static final int WIN_MEDIA_FOUNDATION_SET_CURRENT_DEVICE_MEDIA_TYPE_FAILED = 91;
    public static final int WIN_MEDIA_FOUNDATION_ENGINE_GET_SINK_FAILED = 92;
    public static final int WIN_MEDIA_FOUNDATION_SINK_QUERY_CAPTURE_PREVIEW_INTERFACE_FAILED = 93;
    public static final int WIN_MEDIA_FOUNDATION_SINK_REMOVE_ALL_STREAMS_FAILED = 94;
    public static final int WIN_MEDIA_FOUNDATION_CREATE_SINK_VIDEO_MEDIA_TYPE_FAILED = 95;
    public static final int WIN_MEDIA_FOUNDATION_CONVERT_TO_VIDEO_SINK_MEDIA_TYPE_FAILED = 96;
    public static final int WIN_MEDIA_FOUNDATION_SINK_ADD_STREAM_FAILED = 97;
    public static final int WIN_MEDIA_FOUNDATION_SINK_SET_SAMPLE_CALLBACK_FAILED = 98;
    public static final int WIN_MEDIA_FOUNDATION_ENGINE_START_PREVIEW_FAILED = 99;
    public static final int WIN_MEDIA_FOUNDATION_GET_MEDIA_EVENT_STATUS_FAILED = 100;
    public static final int MAC_SET_CAPTURE_DEVICE_FAILED = 101;
    public static final int MAC_COULD_NOT_START_CAPTURE_DEVICE = 102;
    public static final int MAC_RECEIVED_FRAME_WITH_UNEXPECTED_RESOLUTION = 103;
    public static final int MAC_UPDATE_CAPTURE_RESOLUTION_FAILED = 104;
    public static final int MAC_DECK_LINK_DEVICE_ID_NOT_FOUND_IN_THE_SYSTEM = 105;
    public static final int MAC_DECK_LINK_ERROR_QUERYING_INPUT_INTERFACE = 106;
    public static final int MAC_DECK_LINK_ERROR_CREATING_DISPLAY_MODE_ITERATOR = 107;
    public static final int MAC_DECK_LINK_COULD_NOT_FIND_A_DISPLAY_MODE = 108;
    public static final int MAC_DECK_LINK_COULD_NOT_SELECT_THE_VIDEO_FORMAT_WE_LIKE = 109;
    public static final int MAC_DECK_LINK_COULD_NOT_START_CAPTURING = 110;
    public static final int MAC_DECK_LINK_UNSUPPORTED_PIXEL_FORMAT = 111;
    public static final int MAC_AV_FOUNDATION_RECEIVED_AV_CAPTURE_SESSION_RUNTIME_ERROR_NOTIFICATION = 112;
    public static final int ANDROID_API2_ERROR_CONFIGURING_CAMERA = 113;
    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_FLUSH = 114;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 114;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private VideoCaptureError() {
    }
}
