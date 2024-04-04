package org.libvlc;

import android.graphics.Insets;
import android.graphics.SurfaceTexture;
import android.net.Uri;

import java.util.HashMap;


public class Global {

    private static VMediaPlayer player;

    public static VMediaPlayer getPlayer() {
        return player;
    }

    public static void setPlayer(VMediaPlayer player) {
        Global.player = player;
    }

    private static SurfaceTexture currentSurfactTexture;

    public static SurfaceTexture getCurrentSurfactTexture() {
        return currentSurfactTexture;
    }

    public static void setCurrentSurfactTexture(SurfaceTexture currentSurfactTexture) {
        Global.currentSurfactTexture = currentSurfactTexture;
    }

    public static void setDefaultBufferSize(int width, int height) {
        if (currentSurfactTexture != null) {
            currentSurfactTexture.setDefaultBufferSize(width, height);
        }
    }

    public static void setPlaybackRate(float rate) {
        if (getPlayer() != null) {
            getPlayer().setPlaybackRate(rate);
        }
    }

    public static float getPlaybackRate() {
        return getPlayer() != null ? getPlayer().getPlaybackRate() : 1.0f;
    }

    public static int getCurrentAudioTrackId() {
        return getPlayer() != null ? getPlayer().getAudioTrackIndex() : -1;
    }

    public static void setAudioTrackId(int index){
        if(getPlayer()!= null) getPlayer().setAudioTrackIndex(index);
    }

    public static int getCurrentSubtitleTrackId() {
        return getPlayer() != null ? getPlayer().getSubtitleTrackIndex() : -1;
    }

    public static void setSubtitleTrackId(int index){
        if(getPlayer()!= null) getPlayer().setSubtitleTrackIndex(index);
    }

    public static HashMap<String, Integer> getSubtitleTracksInfo(){
        return getPlayer()!= null ? getPlayer().getSubtitleTracksInfo() : null;
    }

    public static HashMap<String, Integer> getAudioTracksInfo(){
        return getPlayer()!= null ? getPlayer().getAudioTracksInfo() : null;
    }

    public static void addExternalTrack(String type, Uri uri,boolean selected){
        if(getPlayer()!= null) getPlayer().AddExternalTrack(type, uri, selected);
    }
}
