package org.chromium.content_public.browser;

import java.util.ArrayList;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/AccessibilitySnapshotNode.class */
public class AccessibilitySnapshotNode {
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean isRootNode;
    public float textSize;
    public String text;
    public String className;
    public boolean hasStyle;
    public int color;
    public int bgcolor;
    public boolean bold;
    public boolean italic;
    public boolean underline;
    public boolean lineThrough;
    public boolean hasSelection;
    public int startSelection;
    public int endSelection;
    public ArrayList<AccessibilitySnapshotNode> children = new ArrayList<>();

    public AccessibilitySnapshotNode(String text, String className) {
        this.text = text;
        this.className = className;
    }

    public void setStyle(int color, int bgcolor, float textSize, boolean bold, boolean italic, boolean underline, boolean lineThrough) {
        this.color = color;
        this.bgcolor = bgcolor;
        this.textSize = textSize;
        this.bold = bold;
        this.italic = italic;
        this.underline = underline;
        this.lineThrough = lineThrough;
        this.hasStyle = true;
    }

    public void setSelection(int start, int end) {
        this.hasSelection = true;
        this.startSelection = start;
        this.endSelection = end;
    }

    public void setLocationInfo(int x, int y, int width, int height, boolean isRootNode) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isRootNode = isRootNode;
    }

    public void addChild(AccessibilitySnapshotNode node) {
        this.children.add(node);
    }
}
