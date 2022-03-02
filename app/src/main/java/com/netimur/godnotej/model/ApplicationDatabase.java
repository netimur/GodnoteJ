package com.netimur.godnotej.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class, version = 1, exportSchema = false)
abstract public class ApplicationDatabase extends RoomDatabase {
    private static ApplicationDatabase instance = null;

    public abstract NoteDAO noteDAO();

    public static synchronized ApplicationDatabase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, ApplicationDatabase.class, "note_database").build();
        }
        return instance;
    }
}
