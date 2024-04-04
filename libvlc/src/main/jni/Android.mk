LOCAL_PATH := $(call my-dir)

# D:\Android\Sdk\ndk\21.4.7075529\ndk-build

# libvlcjni
include $(CLEAR_VARS)
LOCAL_MODULE    := libvlcjni
LOCAL_SRC_FILES := libvlcjni.c
LOCAL_SRC_FILES += libvlcjni-mediaplayer.c
LOCAL_SRC_FILES += libvlcjni-vlcobject.c
LOCAL_SRC_FILES += libvlcjni-media.c libvlcjni-medialist.c libvlcjni-mediadiscoverer.c libvlcjni-rendererdiscoverer.c
LOCAL_SRC_FILES += libvlcjni-dialog.c
LOCAL_SRC_FILES += std_logger.c
#LOCAL_C_INCLUDES := D:/code/vlc-3.0.8/include/include D:/code/vlc-3.0.8/include/vlc
LOCAL_CFLAGS := -std=c11
LOCAL_LDLIBS := -llog
LOCAL_LDFLAGS := ../jniLibs/$(TARGET_ARCH_ABI)/libvlc.so
#LOCAL_SHARED_LIBRARIES := ../jniLibs/$(TARGET_ARCH_ABI)/libvlc.so

LOCAL_MODULE_PATH := jniLibs/$(TARGET_ARCH_ABI)

include $(BUILD_SHARED_LIBRARY)


