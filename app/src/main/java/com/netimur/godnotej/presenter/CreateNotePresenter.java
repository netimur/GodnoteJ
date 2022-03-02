package com.netimur.godnotej.presenter;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.netimur.godnotej.R;
import com.netimur.godnotej.contracts.CreateNoteContract;
import com.netimur.godnotej.contracts.DatabaseModel;
import com.netimur.godnotej.model.ApplicationDatabase;
import com.netimur.godnotej.model.Model;
import com.netimur.godnotej.model.Note;

public class CreateNotePresenter implements CreateNoteContract.Presenter {
    private CreateNoteContract.View view;
    private DatabaseModel model;

    public CreateNotePresenter(CreateNoteContract.View view) {
        this.view = view;
        model = new Model(ApplicationDatabase.getDatabase(view.getContext()).noteDAO());
    }

    @Override
    public void onCreateButtonClickListener(String name, String body) {
        if (isLongerThanEmptiness(name) && isLongerThanEmptiness(body)) {
            Runnable runnable = () -> {
                Note note = new Note(name, body);
                model.createNote(note);
            };
            Thread thread = new Thread(runnable);
            thread.start();
            goHomeScreen();
        } else {
            view.showSnackbar(view.getContext().getResources().getString(R.string.zero_length_error));
        }
    }

    private void goHomeScreen() {
        NavController controller = Navigation.findNavController(view.getBinding().getRoot());
        controller.navigate(R.id.action_createNoteFragment_to_notesListFragment);
        controller.popBackStack(R.id.createNoteFragment, true);
    }

    private boolean isLongerThanEmptiness(String string) {
        return string.length() > 0;
    }
}
