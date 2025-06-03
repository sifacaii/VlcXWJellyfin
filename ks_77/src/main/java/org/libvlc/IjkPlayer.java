package org.libvlc;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.Map;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class IjkPlayer extends MediaPlayer {
    String TAG = "IJK播放器";
    IjkMediaPlayer player;

    public IjkPlayer() {
        player = new IjkMediaPlayer();
        player.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
    }

    @Override
    public void setSurface(Surface surface) {
        if (surface != null) {
            player.setSurface(surface);
        }
    }

    @Override
    public void setDataSource(@NonNull Context context, @NonNull Uri uri, @Nullable Map<String, String> headers) throws IOException, IllegalArgumentException, IllegalStateException, SecurityException {
        if (player != null) player.setDataSource(context, uri, headers);
    }

    @Override
    public void prepareAsync() throws IllegalStateException {
        if (player != null) player.prepareAsync();
    }

    @Override
    public void start() throws IllegalStateException {
        if (player != null) player.start();
    }

    @Override
    public void stop() throws IllegalStateException {
        if (player != null) player.stop();
    }

    @Override
    public void pause() throws IllegalStateException {
        if (player != null) player.pause();
    }

    @Override
    public int getVideoWidth() {
        return player == null ? -1 : player.getVideoWidth();
    }

    @Override
    public int getVideoHeight() {
        return player == null ? -1 : player.getVideoHeight();
    }

    @Override
    public boolean isPlaying() {
        return player == null ? false : player.isPlaying();
    }

    @Override
    public void seekTo(int msec) throws IllegalStateException {
        if (player != null) player.seekTo(msec);
    }

    @Override
    public int getCurrentPosition() {
        return player == null ? -1 : (int) player.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return player == null ? -1 : (int) player.getDuration();
    }

    @Override
    public void release() {
        if (player != null) {
            player.reset();
            player.release();
            player = null;
        }
    }

    @Override
    public void setVolume(float leftVolume, float rightVolume) {
        if (player != null) player.setVolume(leftVolume, rightVolume);
    }

    @Override
    public TrackInfo[] getTrackInfo() throws IllegalStateException {
        return new TrackInfo[0];
    }

    @Override
    public void setOnPreparedListener(OnPreparedListener listener) {
        player.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer mp) {
                listener.onPrepared(null);
            }
        });
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        player.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer mp) {
                listener.onCompletion(null);
            }
        });
    }

    @Override
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        player.setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener() {
            @Override
            public void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sar_num, int sar_den) {
                listener.onVideoSizeChanged(null, width, height);
            }
        });
    }

    @Override
    public void setOnErrorListener(OnErrorListener listener) {
        player.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer mp, int what, int extra) {
                listener.onError(null, 1, 0);
                return false;
            }
        });
    }
}
