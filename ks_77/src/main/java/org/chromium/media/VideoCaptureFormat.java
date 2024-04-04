package org.chromium.media;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCaptureFormat.class */
class VideoCaptureFormat {
    int mWidth;
    int mHeight;
    final int mFramerate;
    final int mPixelFormat;

    public VideoCaptureFormat(int width, int height, int framerate, int pixelformat) {
        this.mWidth = width;
        this.mHeight = height;
        this.mFramerate = framerate;
        this.mPixelFormat = pixelformat;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getFramerate() {
        return this.mFramerate;
    }

    public int getPixelFormat() {
        return this.mPixelFormat;
    }
}
