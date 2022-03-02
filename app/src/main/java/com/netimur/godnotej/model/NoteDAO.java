package com.netimur.godnotej.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert
    void createNote(Note note);

    @Query("SELECT * FROM notes ORDER BY id ASC")
    List<Note> readNotes();

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);
}
