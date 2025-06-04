package org.libvlc;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.video.VideoSize;

import org.chromium.base.ContextUtils;

import java.io.IOException;
import java.util.Map;

public class VExoPlayer extends MediaPlayer {
    String TAG = "EXO播放器";
    SimpleExoPlayer ePlayer;

    public VExoPlayer() {
        RenderersFactory renderersFactory = new DefaultRenderersFactory(ContextUtils.getApplicationContext())
                .setEnableDecoderFallback(true)
                .setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON);
        ePlayer = new SimpleExoPlayer.Builder(ContextUtils.getApplicationContext(), renderersFactory)
                .setMediaSourceFactory(HttpsUtils.createNoTrustSourceFactory())
                .build();
    }

    @Override
    public void setSurface(Surface surface) {
        if (ePlayer != null && surface != null) {
            ePlayer.setVideoSurface(surface);
        }
    }

    @Override
    public void prepareAsync() {
        if (ePlayer == null) return;
        ePlayer.prepare();
    }

    @Override
    public boolean isPlaying() {
        if (ePlayer != null) {
            return ePlayer.isPlaying();
        }
        return false;
    }

    @Override
    public int getCurrentPosition() {
        if (ePlayer != null) {
            return (int) ePlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override
    public int getDuration() {
        if (ePlayer == null) return 0;
        return (int) ePlayer.getDuration();
    }

    @Override
    public TrackInfo[] getTrackInfo() throws IllegalStateException {
        TrackInfo[] trackInfos = null;
        trackInfos = new TrackInfo[0];
        return trackInfos;
    }

    @Override
    public int getVideoWidth() {
        if (ePlayer == null) return 0;
        return ePlayer.getVideoSize().width;
    }

    @Override
    public int getVideoHeight() {
        if (ePlayer == null) return 0;
        return ePlayer.getVideoSize().height;
    }

    @Override
    public void release() {
        if (ePlayer == null) return;
        ePlayer.release();
    }

    @Override
    public void setVolume(float leftVolume, float rightVolume) {
        if (ePlayer == null) return;
        ePlayer.setVolume((float) leftVolume);
    }

    @Override
    public void start() {
        if (ePlayer == null) return;
        ePlayer.play();
    }

    @Override
    public void pause() {
        if (ePlayer == null) return;
        ePlayer.pause();
    }

    @Override
    public void seekTo(int msec) throws IllegalStateException {
        if (ePlayer == null) return;
        ePlayer.seekTo(msec);
    }

    @Override
    public void setDataSource(@NonNull Context context, @NonNull Uri uri, @Nullable Map<String, String> headers) throws IOException, IllegalArgumentException, IllegalStateException, SecurityException {
        if (ePlayer == null) return;
        MediaItem mediaItem = MediaItem.fromUri(uri);
        ePlayer.setMediaItem(mediaItem);
    }

    @Override
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener listener) {
        if (ePlayer == null) return;
        ePlayer.addListener(new Player.Listener() {
            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playbackState == Player.STATE_ENDED) {
                    listener.onCompletion(null);
                }
            }
        });
    }

    @Override
    public void setOnErrorListener(MediaPlayer.OnErrorListener listener) {
        if (ePlayer == null) return;
        ePlayer.addListener(new Player.Listener() {
            @Override
            public void onPlayerError(PlaybackException error) {
                switch (error.errorCode) {
                    case PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED:
                    case PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED:
                        listener.onError(null, MediaPlayer.MEDIA_ERROR_UNKNOWN, MediaPlayer.MEDIA_ERROR_MALFORMED);
                        break;
                    case PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED:
                    case PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT:
                    case PlaybackException.ERROR_CODE_TIMEOUT:
                        listener.onError(null, MediaPlayer.MEDIA_ERROR_UNKNOWN, MediaPlayer.MEDIA_ERROR_TIMED_OUT);
                        break;
                    case PlaybackException.ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES:
                    case PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED:
                        listener.onError(null, MediaPlayer.MEDIA_ERROR_UNKNOWN, 0);
                        break;
                    default:
                        listener.onError(null, MediaPlayer.MEDIA_ERROR_UNKNOWN, 0);
                        break;
                }

            }
        });
    }

    @Override
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener listener) {
        if (ePlayer == null) return;
        ePlayer.addListener(new Player.Listener() {
            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playbackState == Player.STATE_READY) {
                    listener.onPrepared(null);
                }
            }
        });
    }

    @Override
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener listener) {
        if (ePlayer == null) return;
        ePlayer.addListener(new Player.Listener() {
            @Override
            public void onVideoSizeChanged(VideoSize videoSize) {
                listener.onVideoSizeChanged(null, videoSize.width, videoSize.height);
            }
        });
    }

}
