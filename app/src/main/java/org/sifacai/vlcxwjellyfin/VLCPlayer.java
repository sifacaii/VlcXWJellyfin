package org.sifacai.vlcxwjellyfin;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.util.VLCVideoLayout;

import java.util.ArrayList;

public class VLCPlayer extends VLCVideoLayout implements View.OnClickListener {

    private static final String TAG = "VLCPlayer播放器";
    int controllerShowTime = 6000;

    LibVLC mLibVLC;
    MediaPlayer mPlayer;

    boolean isShowController = false;
    long duration;
    long currentTime;

    View controller;
    LinearLayout controllerTop;
    LinearLayout controllerBottom;
    LinearLayout controllerProgress;
    SeekBar progressBar;
    TextView cTime;
    TextView backBtn;
    TextView playBtn;
    TextView rateBtn;
    TextView scaleBtn;
    TextView subtitleBtn;
    TextView audioBtn;
    ImageView pauseImageView;
    LinearLayout controllerFF;
    TextView timeFF;
    ProgressBar progressFF;


    ArrayList<String> options;

    private void initController() {
        controller = inflate(getContext(), R.layout.vlcplayer_controller, null);
        addView(controller);

        controllerTop = controller.findViewById(R.id.controller_top);
        controllerBottom = controller.findViewById(R.id.controller_bottom);
        controllerProgress = controller.findViewById(R.id.controller_progress);
        controllerTop.setVisibility(GONE);
        controllerBottom.setVisibility(GONE);
        controllerProgress.setVisibility(GONE);

        progressBar = controller.findViewById(R.id.progressBar);
        cTime = controller.findViewById(R.id.cTime);
        backBtn = controller.findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        playBtn = controller.findViewById(R.id.playBtn);
        playBtn.setOnClickListener(this);
        rateBtn = controller.findViewById(R.id.rateBtn);
        rateBtn.setOnClickListener(this);
        scaleBtn = controller.findViewById(R.id.scaleBtn);
        scaleBtn.setOnClickListener(this);
        subtitleBtn = controller.findViewById(R.id.subtitleBtn);
        subtitleBtn.setOnClickListener(this);
        audioBtn = controller.findViewById(R.id.audioBtn);
        audioBtn.setOnClickListener(this);

        pauseImageView = controller.findViewById(R.id.pauseImageView);

        controllerFF = controller.findViewById(R.id.controller_ff);
        timeFF = controllerFF.findViewById(R.id.time_ff);
        progressFF = controllerFF.findViewById(R.id.progress_ff);

        initRateMenu();
        initScaleTypeMenu();

        GradientDrawable drawable = new GradientDrawable();
        drawable.setSize(30, 1);

        LinearLayout controller_top = controller.findViewById(R.id.controller_top);
        LinearLayout controller_control = controller.findViewById(R.id.controller_control);
        controller_top.setDividerDrawable(drawable);
        controller_control.setDividerDrawable(drawable);
        controller_top.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        controller_control.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: " + v);
        int id = v.getId();
        if (id == backBtn.getId()) {
            stop();
        } else if (id == playBtn.getId()) {
            playORpause();
        } else if (id == rateBtn.getId()) {
            rateMenu.show();
        } else if (id == scaleBtn.getId()) {
            scaleMenu.show();
        } else if (id == subtitleBtn.getId()) {
            subtitleMenu.show();
        } else if (id == audioBtn.getId()) {
            audioMenu.show();
        }
    }

    public VLCPlayer(@NonNull Context context) {
        super(context);
    }

    public VLCPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VLCPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VLCPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init() {
        options = new ArrayList<>();
        options.add("-vvv");
        mLibVLC = new LibVLC(getContext(), options);
        mPlayer = new MediaPlayer(mLibVLC);
        mPlayer.attachViews(this, null, true, false);
        mPlayer.setEventListener(new MediaPlayer.EventListener() {
            @Override
            public void onEvent(MediaPlayer.Event event) {
                switch (event.type) {
                    case MediaPlayer.Event.Playing:
                        show();
                        break;
                    case MediaPlayer.Event.TimeChanged:
                        currentTime = event.getTimeChanged();
                        break;
                    case MediaPlayer.Event.LengthChanged:
                        duration = event.getLengthChanged();
                        break;
                    case MediaPlayer.Event.Vout:
                        initAudioMenu();
                        initSubtitleMenu();
                        break;
                    default:
                        break;
                }
            }
        });

        initController();
    }

    private int getPercentage(long c, long d) {
        int p = 0;
        if (c > 0 && d > 0) {
            p = (int) (1000L * c / d);
        }
        return p;
    }

    Runnable updateProgressBar = new Runnable() {
        @Override
        public void run() {
            cTime.setText(TrickToTime(currentTime) + "/" + TrickToTime(duration));
            progressBar.setProgress(getPercentage(currentTime,duration));
            postDelayed(updateProgressBar, 1000);
        }
    };

    private Runnable hideController = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    private void show() {
        controllerTop.setVisibility(VISIBLE);
        controllerBottom.setVisibility(VISIBLE);
        controllerProgress.setVisibility(VISIBLE);

        cTime.setText(TrickToTime(currentTime) + "/" + TrickToTime(duration));
        progressBar.setProgress(getPercentage(currentTime,duration));
        postDelayed(updateProgressBar, 1000);
        isShowController = true;

        removeCallbacks(hideController);
        postDelayed(hideController, controllerShowTime);
    }

    private void hide() {
        removeCallbacks(updateProgressBar);

        controllerTop.setVisibility(GONE);
        controllerBottom.setVisibility(GONE);
        controllerProgress.setVisibility(GONE);

        isShowController = false;
    }

    public String TrickToTime(long trick) {
        String time = "";
        long totalSeconds = trick / 1000;
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;

        time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return time;
    }

    public void setMedia(String url) {
        Media media = new Media(mLibVLC, Uri.parse(url));
        media.setHWDecoderEnabled(url.contains("hacc=true"), url.contains("forcehacc=true"));
        mPlayer.setMedia(media);
        media.release();
    }

    public void playORpause() {
        if(mPlayer.isPlaying()){
            mPlayer.pause();
            pauseImageView.setVisibility(VISIBLE);
        }else {
            mPlayer.play();
            pauseImageView.setVisibility(GONE);
        }
    }

    public void pause() {
        mPlayer.pause();
    }

    public void stop() {
        mPlayer.stop();
        mLibVLC.release();
        mLibVLC = null;
        mPlayer.release();
        mPlayer = null;

        ViewGroup parent = (ViewGroup) getParent();
        if (null != parent) parent.removeView(this);
    }

    String[] rates = {"0.5x", "1.0x", "1.5x", "2.0x", "2.5x", "3.0x"};
    PopupMenu rateMenu;

    private void initRateMenu() {
        rateMenu = new PopupMenu(getContext(), rateBtn);
        for (String rate : rates) {
            rateMenu.getMenu().add(rate).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(@NonNull MenuItem item) {
                    mPlayer.setRate(Float.valueOf(rate.replace("x", "")));
                    return true;
                }
            });
        }
    }

    PopupMenu scaleMenu;

    private void initScaleTypeMenu() {
        scaleMenu = new PopupMenu(getContext(), scaleBtn);
        for (MediaPlayer.ScaleType st : MediaPlayer.ScaleType.getMainScaleTypes()) {
            scaleMenu.getMenu().add(st.name().replace("SURFACE_", ""))
                    .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(@NonNull MenuItem item) {
                            mPlayer.setVideoScale(st);
                            return false;
                        }
                    });
        }
    }

    PopupMenu subtitleMenu;

    private void initSubtitleMenu() {
        subtitleMenu = new PopupMenu(getContext(), subtitleBtn);
        MediaPlayer.TrackDescription[] tds = mPlayer.getSpuTracks();
        for (MediaPlayer.TrackDescription td : tds) {
            subtitleMenu.getMenu().add(td.name).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(@NonNull MenuItem item) {
                    mPlayer.setSpuTrack(td.id);
                    return false;
                }
            });
        }
    }

    PopupMenu audioMenu;

    private void initAudioMenu() {
        audioMenu = new PopupMenu(getContext(), audioBtn);
        MediaPlayer.TrackDescription[] tds = mPlayer.getAudioTracks();
        for (MediaPlayer.TrackDescription td : tds) {
            audioMenu.getMenu().add(td.name).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(@NonNull MenuItem item) {
                    mPlayer.setAudioTrack(td.id);
                    return false;
                }
            });
        }
    }


    boolean isSeeking = false;
    boolean isFF = true;
    long Stepping = 0;

    Runnable FastForward = new Runnable() {
        @Override
        public void run() {
            Stepping += 10000;
            timeFF.setText(TrickToTime(currentTime + Stepping));
            progressFF.setProgress(getPercentage(currentTime + Stepping,duration));
            postDelayed(FastForward,500);
        }
    };

    void startSeek(boolean ff) {
        Log.d(TAG, "startSeek: ");
        controllerFF.setVisibility(VISIBLE);
        Stepping = 0;
        isSeeking = true;
        isFF = ff;
        postDelayed(FastForward, 0);
    }

    void stopSeek() {
        Log.d(TAG, "stopSeek: ");
        controllerFF.setVisibility(GONE);
        removeCallbacks(FastForward);

        isSeeking = false;
        long etime = currentTime;
        if (isFF) etime += Stepping;
        else etime -= Stepping;
        if (etime >= 0 && etime < duration) {
            mPlayer.setTime(etime);
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(TAG, "dispatchKeyEvent: 按键" + event.getAction() + ":" + event.getKeyCode() + ":" + event.getRepeatCount());
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (isShowController) {
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_BACK:
                        hide();
                        break;
                    default:
                        show();
                }
                //return super.dispatchKeyEvent(event);
            } else {
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_ENTER:
                        playORpause();
                        break;
                    case KeyEvent.KEYCODE_BACK:
                        stop();
                        break;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        //startSeek(true);
                        mPlayer.setTime(currentTime + 50000);
                        break;
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        //startSeek(false);
                        mPlayer.setTime(currentTime - 10000);
                        break;
                    default:
                        show();
                }
            }
        }

        if (event.getAction() == KeyEvent.ACTION_UP) {
            //if(isSeeking) stopSeek();
        }

        //return false;
        return super.dispatchKeyEvent(event);
    }
}