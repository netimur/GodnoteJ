package com.netimur.godnotej.model;

import com.netimur.godnotej.contracts.DatabaseModel;

import java.util.List;

public class Model implements DatabaseModel {
    private final NoteDAO noteDAO;

    public Model(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Override
    public void createNote(Note note) {
        noteDAO.createNote(note);
    }

    @Override
    public List<Note> readNotes() {
        return noteDAO.readNotes();
    }

    @Override
    public void updateNote(Note note) {
        noteDAO.updateNote(note);

    }

    @Override
    public void deleteNote(Note note) {
        noteDAO.deleteNote(note);
    }
}
