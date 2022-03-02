package com.netimur.godnotej.presenter;

import androidx.navigation.Navigation;

import com.netimur.godnotej.R;
import com.netimur.godnotej.contracts.DatabaseModel;
import com.netimur.godnotej.contracts.NotesViewContract;
import com.netimur.godnotej.model.ApplicationDatabase;
import com.netimur.godnotej.model.Model;
import com.netimur.godnotej.model.Note;

import java.util.ArrayList;

public class NotesListPresenter implements NotesViewContract.Presenter {
    private NotesViewContract.View view;
    private DatabaseModel model;
    private ArrayList<Note> notes = new ArrayList<>();

    public NotesListPresenter(NotesViewContract.View view) {
        this.view = view;
        this.model = new Model(ApplicationDatabase.getDatabase(view.getContext()).noteDAO());
    }


    @Override
    public void getData() {
        Runnable runnable = () -> {
            notes = (ArrayList<Note>) model.readNotes();
            if (notes.size() > 0) {
                view.showNotes(notes);
            } else {
                view.showEmptyLabel();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


    @Override
    public void onAddButtonClickListener() {
        Navigation.findNavController(view.getBinding().getRoot()).navigate(R.id.action_notesListFragment_to_createNoteFragment);
    }

}
