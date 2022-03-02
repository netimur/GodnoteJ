package com.netimur.godnotej.contracts;

import android.content.Context;

import com.netimur.godnotej.SnackbarShowCapable;
import com.netimur.godnotej.databinding.FragmentCreateNoteBinding;

public interface CreateNoteContract {
    interface View extends SnackbarShowCapable {
        Context getContext();
        FragmentCreateNoteBinding getBinding();

    }

    interface Presenter {
        void onCreateButtonClickListener(String name, String body);
    }
}
