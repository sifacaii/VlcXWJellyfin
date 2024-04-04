package org.chromium.content.browser.accessibility.captioning;

import android.annotation.TargetApi;
import java.util.Objects;

@TargetApi(19)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/TextTrackSettings.class */
public final class TextTrackSettings {
    private static final String DEFAULT_VALUE = "";
    private boolean mTextTracksEnabled;
    private String mTextTrackBackgroundColor;
    private String mTextTrackFontFamily;
    private String mTextTrackFontStyle;
    private String mTextTrackFontVariant;
    private String mTextTrackTextColor;
    private String mTextTrackTextShadow;
    private String mTextTrackTextSize;

    public TextTrackSettings() {
    }

    public TextTrackSettings(boolean textTracksEnabled, String textTrackBackgroundColor, String textTrackFontFamily, String textTrackFontStyle, String textTrackFontVariant, String textTrackTextColor, String textTrackTextShadow, String textTrackTextSize) {
        this.mTextTracksEnabled = textTracksEnabled;
        this.mTextTrackBackgroundColor = textTrackBackgroundColor;
        this.mTextTrackFontFamily = textTrackFontFamily;
        this.mTextTrackFontStyle = textTrackFontStyle;
        this.mTextTrackFontVariant = textTrackFontVariant;
        this.mTextTrackTextColor = textTrackTextColor;
        this.mTextTrackTextShadow = textTrackTextShadow;
        this.mTextTrackTextSize = textTrackTextSize;
    }

    public boolean getTextTracksEnabled() {
        return this.mTextTracksEnabled;
    }

    public String getTextTrackBackgroundColor() {
        return Objects.toString(this.mTextTrackBackgroundColor, "");
    }

    public String getTextTrackFontFamily() {
        return Objects.toString(this.mTextTrackFontFamily, "");
    }

    public String getTextTrackFontStyle() {
        return Objects.toString(this.mTextTrackFontStyle, "");
    }

    public String getTextTrackFontVariant() {
        return Objects.toString(this.mTextTrackFontVariant, "");
    }

    public String getTextTrackTextColor() {
        return Objects.toString(this.mTextTrackTextColor, "");
    }

    public String getTextTrackTextShadow() {
        return Objects.toString(this.mTextTrackTextShadow, "");
    }

    public String getTextTrackTextSize() {
        return Objects.toString(this.mTextTrackTextSize, "");
    }
}
