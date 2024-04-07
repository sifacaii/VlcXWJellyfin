package org.libvlc;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.chromium.base.ContextUtils;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.interfaces.IMedia;

public class VMediaPlayer {

    private LibVLC mILibVLC;
    private MediaPlayer mMediaPlayer;

    private Context context;

    String TAG = "自定义播放器";

    private OnCompletionListener onCompletionListener;
    private OnErrorListener onErrorListener;
    private OnPreparedListener onPreparedListener;
    private OnVideoSizeChangedListener onVideoSizeChangedListener;

    private ArrayList<String> options;

    private void initVLC() {
        context = ContextUtils.getApplicationContext();

        options = new ArrayList<>();
        //options.add("-vvv");
        options.add("--start-paused");

        mILibVLC = new LibVLC(context, options);

        mMediaPlayer = new MediaPlayer(this.mILibVLC);
        mMediaPlayer.setEventListener(new MediaPlayer.EventListener() {

            public void onEvent(MediaPlayer.Event event) {
                int type = event.type;
                switch (type) {
                    case MediaPlayer.Event.Opening:
                        break;
                    case MediaPlayer.Event.Playing:
                        if (onPreparedListener != null) {
                            onPreparedListener.onPrepared();
                        }

                        IMedia.VideoTrack vt = mMediaPlayer.getCurrentVideoTrack();
                        if(vt != null){
                            int w = vt.width;
                            int h = vt.height;
                            if (onVideoSizeChangedListener != null) {
                                onVideoSizeChangedListener.onVideoSizeChanged(w, h);
                            }
                            Global.setDefaultBufferSize(w,h);
                        }
                        break;
                    case MediaPlayer.Event.Paused:
                        break;
                    case MediaPlayer.Event.Stopped:
                        if (onCompletionListener != null) {
                            onCompletionListener.onCompletion();
                        }
                        break;
                    case MediaPlayer.Event.Buffering:
                        int bufi = (int) event.getBuffering();
                        break;
                    case MediaPlayer.Event.SeekableChanged:
                        break;
                    case MediaPlayer.Event.EncounteredError:
                        if (onErrorListener != null) {
                            onErrorListener.onError(android.media.MediaPlayer.MEDIA_ERROR_UNKNOWN,
                                    android.media.MediaPlayer.MEDIA_ERROR_UNKNOWN);
                        }
                        break;
                    case MediaPlayer.Event.Vout:
                        break;
                }
            }
        });
    }

    public VMediaPlayer() {
        initVLC();
        Global.setPlayer(this);
    }

    public void setMedia(Media media) {
        Uri uri = media.getUri();
        if (uri != null) {
            String url = uri.toString();
            boolean hacc = url.contains("hacc=true");
            boolean forceHacc = url.contains("forceHacc=true");
            media.setHWDecoderEnabled(hacc,forceHacc);
        }
        //media.addOption(":video-paused");
        mMediaPlayer.setMedia(media);
        media.release();
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.setDataSource(context, uri, (Map) null);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Media media = new Media(mILibVLC, uri);
        setMedia(media);
    }

    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Media media = new Media(mILibVLC, path);
        setMedia(media);
    }

    public void setDataSource(FileDescriptor fd) throws IOException, IllegalArgumentException, IllegalStateException {
        Media media = new Media(mILibVLC, fd);
        setMedia(media);
    }

    public void setDataSource(FileDescriptor fd, long offset, long length) throws IOException, IllegalArgumentException, IllegalStateException {
        this.setDataSource(fd);
    }

    public void prepare() throws IOException, IllegalStateException {
    }

    public void prepareAsync() {
        mMediaPlayer.play();
    }

    public void setDisplay(SurfaceHolder sh) {
        this.mMediaPlayer.getVLCVout().setVideoSurface(sh.getSurface(), sh);
    }

    public void setSurface(Surface surface) {
        if (surface != null) {
            if (mMediaPlayer.getVLCVout().areViewsAttached()) return;
            mMediaPlayer.getVLCVout().setVideoSurface(surface, (SurfaceHolder) null);
            mMediaPlayer.getVLCVout().attachViews();
        }
    }

    public void start() throws IllegalStateException {
        this.mMediaPlayer.play();
    }

    public void stop() throws IllegalStateException {
        this.mMediaPlayer.stop();
    }


    public void pause() throws IllegalStateException {
        this.mMediaPlayer.pause();
    }

    public void setPlaybackRate(float rate) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setRate(rate);
        }
    }

    public float getPlaybackRate() {
        float rate = 1.0f;
        if (mMediaPlayer != null) {
            rate = mMediaPlayer.getRate();
        }
        return rate;
    }

    public int getVideoWidth() {
        return mMediaPlayer != null ? mMediaPlayer.getCurrentVideoTrack().width : -1;
    }


    public int getVideoHeight() {
        return mMediaPlayer != null ? mMediaPlayer.getCurrentVideoTrack().height : -1;
    }

    public boolean hasVideo() {
        boolean hv = false;
        if (mMediaPlayer != null) {
            hv = mMediaPlayer.getVideoTracks().length > 0 ? true : false;
        }
        return hv;
    }

    public boolean hasAudio() {
        boolean ha = false;
        if (mMediaPlayer != null) {
            ha = mMediaPlayer.getAudioTracks().length > 0 ? true : false;
        }
        return ha;
    }

    public boolean isPlaying() {
        return this.mMediaPlayer != null ? mMediaPlayer.isPlaying() : false;
    }

    public void seekTo(int msec) throws IllegalStateException {
        if (mMediaPlayer != null) {
            mMediaPlayer.setTime(msec);
        }
    }

    public int getCurrentPosition() {
        int pos = mMediaPlayer != null ? (int) mMediaPlayer.getTime() : 0;
        return pos;
    }


    public int getDuration() {
        int duration = mMediaPlayer != null ? (int) mMediaPlayer.getLength() : -1;
        return duration;
    }


    public void release() {
        mMediaPlayer.release();
        mILibVLC.release();
        mMediaPlayer = null;
        Global.setPlayer(null);
    }


    public void reset() {
    }

    public void setLooping(boolean looping) {
    }


    public boolean isLooping() {
        return false;
    }


    public void setVolume(float leftVolume, float rightVolume) {
        if (mMediaPlayer != null) {
            this.mMediaPlayer.setVolume((int) ((leftVolume + rightVolume) * 100.0F / 2.0F));
        }
    }

    public boolean canPause() {
        return mMediaPlayer != null ? true : false;
    }

    public boolean canSeek() {
        return mMediaPlayer != null ? mMediaPlayer.isSeekable() : false;
    }

    public void setAudioTrackIndex(int AudioTrackId) throws IllegalArgumentException, IllegalStateException {
        if (mMediaPlayer != null) {
            mMediaPlayer.setAudioTrack(AudioTrackId);
        }
    }

    public int getAudioTrackIndex() {
        return mMediaPlayer != null ? mMediaPlayer.getAudioTrack() : -1;
    }

    public void setSubtitleTrackIndex(int SubtitleTrackId) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setSpuTrack(SubtitleTrackId);
        }
    }

    public int getSubtitleTrackIndex() {
        return mMediaPlayer != null ? mMediaPlayer.getSpuTrack() : -1;
    }

    public void AddExternalTrack(String type, Uri uri, boolean selected) {
        Log.d(TAG, "AddExternalTrack: " + type + " ;" + uri.toString() + ";" + selected);
        if (mMediaPlayer == null) return;
        if (type == "Audio") {
            this.mMediaPlayer.addSlave(IMedia.Track.Type.Audio, uri, selected);
        } else if (type == "Subtitle") {
            this.mMediaPlayer.addSlave(IMedia.Track.Type.Text, uri, selected);
        }
    }

    public HashMap<String, Integer> getSubtitleTracksInfo() {
        Log.d(TAG, "getSubtitleTracksInfo: 获取字幕");
        HashMap<String, Integer> info = new HashMap<>();
        if (mMediaPlayer != null) {
            MediaPlayer.TrackDescription[] tracks = mMediaPlayer.getSpuTracks();
            if (tracks != null) {
                for (MediaPlayer.TrackDescription tk : tracks) {
                    info.put(tk.name, tk.id);
                }
            }
        }
        return info;
    }

    public HashMap<String, Integer> getAudioTracksInfo() {
        Log.d(TAG, "getAudioTracksInfo: 获取音轨");
        HashMap<String, Integer> info = new HashMap<>();
        if (mMediaPlayer != null) {
            MediaPlayer.TrackDescription[] tracks = mMediaPlayer.getAudioTracks();
            if (tracks != null) {
                for (MediaPlayer.TrackDescription tk : tracks) {
                    info.put(tk.name, tk.id);
                }
            }
        }
        return info;
    }

    protected void finalize() {
    }

    public void setOnPreparedListener(OnPreparedListener listener) {
        this.onPreparedListener = listener;
    }

    public void setOnCompletionListener(OnCompletionListener listener) {
        this.onCompletionListener = listener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        this.onVideoSizeChangedListener = listener;
    }

    public void setOnErrorListener(OnErrorListener listener) {
        this.onErrorListener = listener;
    }

    public interface OnErrorListener {
        boolean onError(int what, int extra);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int width, int height);
    }

    public interface OnCompletionListener {
        void onCompletion();
    }

    public interface OnPreparedListener {
        void onPrepared();
    }
}
