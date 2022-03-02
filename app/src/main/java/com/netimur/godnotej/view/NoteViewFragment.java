package com.netimur.godnotej.view;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netimur.godnotej.R;
import com.netimur.godnotej.contracts.NoteViewContract;
import com.netimur.godnotej.databinding.FragmentNoteViewBinding;
import com.netimur.godnotej.presenter.NoteViewPresenter;

public class NoteViewFragment extends Fragment implements NoteViewContract.View {
    private FragmentNoteViewBinding binding;
    private NoteViewContract.Presenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteViewBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new NoteViewPresenter(this);
        presenter.setCurrentNote(NoteViewFragmentArgs.fromBundle(getArguments()).getNote());
        binding.deleteButton.setOnClickListener((v) -> presenter.onDeleteButtonClickListener());
        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }

    @Override
    public FragmentNoteViewBinding getBinding() {
        return binding;
    }

    @Override
    public void showCurrentNote(String name, String body) {
        binding.noteNameView.setText(name);
        binding.noteBodyView.setText(body);
    }

    @Override
    public void showDeletionDialog(String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Delete note");
        builder.setMessage("Are you sure to delete the note?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            presenter.deleteCurrentNote();
            goHomeScreen();
        });
        builder.setNegativeButton("No", null);
        builder.create().show();
    }

    private void goHomeScreen() {
        NavController controller = Navigation.findNavController(binding.getRoot());
        controller.navigate(R.id.action_noteViewFragment_to_notesListFragment);
        controller.popBackStack(R.id.noteViewFragment, true);
    }

}