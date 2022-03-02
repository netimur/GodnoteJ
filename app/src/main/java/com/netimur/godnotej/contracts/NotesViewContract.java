package com.netimur.godnotej.contracts;

import android.content.Context;

import com.netimur.godnotej.databinding.FragmentNotesListBinding;
import com.netimur.godnotej.model.Note;

import java.util.ArrayList;

public interface NotesViewContract {
    interface View {
        Context getContext();
        FragmentNotesListBinding getBinding();
        void showData();
        void showEmptyLabel();
        void showNotes(ArrayList<Note> notes);
    }
    interface Presenter {
        void getData();
        void onAddButtonClickListener();

    }

}