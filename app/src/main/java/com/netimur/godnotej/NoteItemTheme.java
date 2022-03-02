package com.netimur.godnotej;

public class NoteItemTheme {
    private int backgroundResourceId;
    private int textColor;

    public NoteItemTheme(int background, int textColor) {
        this.backgroundResourceId = background;
        this.textColor = textColor;
    }

    public int getBackgroundResourceId() {
        return backgroundResourceId;
    }

    public int getTextColorId() {
        return textColor;
    }
}
