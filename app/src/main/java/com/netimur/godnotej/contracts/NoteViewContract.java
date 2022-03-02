package com.netimur.godnotej.contracts;

import android.content.Context;

import com.netimur.godnotej.databinding.FragmentNoteViewBinding;
import com.netimur.godnotej.model.Note;

public interface NoteViewContract {
    interface View {
        FragmentNoteViewBinding getBinding();
        Context getContext();
        void showCurrentNote(String name, String body);
        void showDeletionDialog(String name);
    }
    interface Presenter {
        void deleteCurrentNote();
        void setCurrentNote(Note note);
        void onDeleteButtonClickListener();
    }
}
