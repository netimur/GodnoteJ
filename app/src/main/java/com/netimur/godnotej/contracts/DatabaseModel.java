package com.netimur.godnotej.contracts;

import com.netimur.godnotej.model.Note;

import java.util.List;

public interface DatabaseModel {
    void createNote(Note note);
    List<Note> readNotes();
    void updateNote(Note note);
    void deleteNote(Note note);
}
