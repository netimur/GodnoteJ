package com.netimur.godnotej.presenter;

import com.netimur.godnotej.contracts.DatabaseModel;
import com.netimur.godnotej.contracts.NoteViewContract;
import com.netimur.godnotej.model.ApplicationDatabase;
import com.netimur.godnotej.model.Model;
import com.netimur.godnotej.model.Note;

public class NoteViewPresenter implements NoteViewContract.Presenter {

    private NoteViewContract.View view;
    private DatabaseModel model;
    private Note currentNote;

    public void setCurrentNote(Note currentNote) {
        this.currentNote = currentNote;
        view.showCurrentNote(this.currentNote.getName(), this.currentNote.getBody());
    }

    public NoteViewPresenter(NoteViewContract.View view) {
        this.view = view;
        this.model = new Model(ApplicationDatabase.getDatabase(view.getContext()).noteDAO());
    }

    @Override
    public void onDeleteButtonClickListener() {
        view.showDeletionDialog(currentNote.getName());
    }

    @Override
    public void deleteCurrentNote() {
        Runnable runnable = () -> model.deleteNote(currentNote);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
