package com.netimur.godnotej;

import java.util.ArrayList;

public class NoteItemThemeRepository {
    private static ArrayList<NoteItemTheme> themes = new ArrayList<>();

    static {
        //TODO List.of а не вот это вот...
        //NoteItemTheme anamnisar = new NoteItemTheme(R.drawable.gradient_anamnisar, 0xFF000000);
        NoteItemTheme coolBlues = new NoteItemTheme(R.drawable.gradient_cool_blues, 0xFFFFFFFF);
        NoteItemTheme quepal = new NoteItemTheme(R.drawable.gradient_quepal, 0xFFFFFFFF);
        //NoteItemTheme viceCity = new NoteItemTheme(R.drawable.gradient_vice_city, 0xFF000000);
        NoteItemTheme yellow = new NoteItemTheme(R.drawable.gradient_yellow, 0xFFFFFFFF);
        NoteItemTheme burningOrange = new NoteItemTheme(R.drawable.gradient_burning_orange, 0xFFFFFFFF);
        NoteItemTheme moonPurple = new NoteItemTheme(R.drawable.gradient_moon_purple, 0xFFFFFFFF);
        NoteItemTheme shifter = new NoteItemTheme(R.drawable.gradient_shifter, 0xFFFFFFFF);
        NoteItemTheme socialive = new NoteItemTheme(R.drawable.gradient_socialive, 0xFFFFFFFF);

        //themes.add(anamnisar);
        themes.add(coolBlues);
        themes.add(quepal);
        //themes.add(viceCity);
        themes.add(yellow);
        themes.add(burningOrange);
        themes.add(moonPurple);
        themes.add(shifter);
        themes.add(socialive);

    }

    public static ArrayList<NoteItemTheme> getThemes() {
        return themes;
    }

}
