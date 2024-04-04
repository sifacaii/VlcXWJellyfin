package org.chromium.content.browser.accessibility.captioning;

import android.graphics.Color;
import android.graphics.Typeface;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import org.chromium.base.VisibleForTesting;
import org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/captioning/CaptioningChangeDelegate.class */
public class CaptioningChangeDelegate {
    private static final String FONT_STYLE_ITALIC = "italic";
    @VisibleForTesting
    public static final String DEFAULT_CAPTIONING_PREF_VALUE = "";
    private boolean mTextTracksEnabled;
    private String mTextTrackBackgroundColor;
    private String mTextTrackFontFamily;
    private String mTextTrackFontStyle;
    private String mTextTrackFontVariant;
    private String mTextTrackTextColor;
    private String mTextTrackTextShadow;
    private String mTextTrackTextSize;
    private final Map<SystemCaptioningBridge.SystemCaptioningBridgeListener, Boolean> mListeners = new WeakHashMap();

    public void onEnabledChanged(boolean enabled) {
        this.mTextTracksEnabled = enabled;
        notifySettingsChanged();
    }

    public void onFontScaleChanged(float fontScale) {
        this.mTextTrackTextSize = androidFontScaleToPercentage(fontScale);
        notifySettingsChanged();
    }

    public void onLocaleChanged(Locale locale) {
    }

    public void onUserStyleChanged(CaptioningStyle userStyle) {
        this.mTextTrackTextColor = androidColorToCssColor(userStyle.getForegroundColor());
        this.mTextTrackBackgroundColor = androidColorToCssColor(userStyle.getBackgroundColor());
        this.mTextTrackTextShadow = getShadowFromColorAndSystemEdge(androidColorToCssColor(userStyle.getEdgeColor()), userStyle.getEdgeType());
        Typeface typeFace = userStyle.getTypeface();
        this.mTextTrackFontFamily = getFontFromSystemFont(typeFace);
        if (typeFace != null && typeFace.isItalic()) {
            this.mTextTrackFontStyle = FONT_STYLE_ITALIC;
        } else {
            this.mTextTrackFontStyle = DEFAULT_CAPTIONING_PREF_VALUE;
        }
        this.mTextTrackFontVariant = DEFAULT_CAPTIONING_PREF_VALUE;
        notifySettingsChanged();
    }

    public static String getShadowFromColorAndSystemEdge(String color, Integer type) {
        String edgeShadow = DEFAULT_CAPTIONING_PREF_VALUE;
        if (type != null) {
            switch (type.intValue()) {
                case 1:
                    edgeShadow = "%2$s %2$s 0 %1$s, -%2$s -%2$s 0 %1$s, %2$s -%2$s 0 %1$s, -%2$s %2$s 0 %1$s";
                    break;
                case 2:
                    edgeShadow = "%1$s %2$s %2$s 0.1em";
                    break;
                case 3:
                    edgeShadow = "-%2$s -%2$s 0 %1$s";
                    break;
                case 4:
                    edgeShadow = "%2$s %2$s 0 %1$s";
                    break;
            }
        }
        String edgeColor = color;
        edgeColor = (edgeColor == null || edgeColor.isEmpty()) ? "silver" : "silver";
        return String.format(edgeShadow, edgeColor, "0.05em");
    }

    public static String getFontFromSystemFont(Typeface typeFace) {
        if (typeFace == null) {
            return DEFAULT_CAPTIONING_PREF_VALUE;
        }
        String[] fonts = {DEFAULT_CAPTIONING_PREF_VALUE, "sans-serif", "sans-serif-condensed", "sans-serif-monospace", "serif", "serif-monospace", "casual", "cursive", "sans-serif-smallcaps", "monospace"};
        for (String font : fonts) {
            if (Typeface.create(font, typeFace.getStyle()).equals(typeFace)) {
                return font;
            }
        }
        return DEFAULT_CAPTIONING_PREF_VALUE;
    }

    public static String androidColorToCssColor(Integer color) {
        if (color == null) {
            return DEFAULT_CAPTIONING_PREF_VALUE;
        }
        String alpha = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US)).format(Color.alpha(color.intValue()) / 255.0d);
        return String.format("rgba(%s, %s, %s, %s)", Integer.valueOf(Color.red(color.intValue())), Integer.valueOf(Color.green(color.intValue())), Integer.valueOf(Color.blue(color.intValue())), alpha);
    }

    public static String androidFontScaleToPercentage(float fontScale) {
        return new DecimalFormat("#%", new DecimalFormatSymbols(Locale.US)).format(fontScale);
    }

    private void notifySettingsChanged() {
        for (SystemCaptioningBridge.SystemCaptioningBridgeListener listener : this.mListeners.keySet()) {
            notifyListener(listener);
        }
    }

    public void notifyListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
        if (this.mTextTracksEnabled) {
            TextTrackSettings settings = new TextTrackSettings(this.mTextTracksEnabled, this.mTextTrackBackgroundColor, this.mTextTrackFontFamily, this.mTextTrackFontStyle, this.mTextTrackFontVariant, this.mTextTrackTextColor, this.mTextTrackTextShadow, this.mTextTrackTextSize);
            listener.onSystemCaptioningChanged(settings);
            return;
        }
        listener.onSystemCaptioningChanged(new TextTrackSettings());
    }

    public void addListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
        this.mListeners.put(listener, null);
    }

    public void removeListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
        this.mListeners.remove(listener);
    }

    public boolean hasActiveListener() {
        return !this.mListeners.isEmpty();
    }
}
