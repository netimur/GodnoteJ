package com.netimur.godnotej.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.netimur.godnotej.R;
import com.netimur.godnotej.contracts.CreateNoteContract;
import com.netimur.godnotej.databinding.FragmentCreateNoteBinding;
import com.netimur.godnotej.presenter.CreateNotePresenter;


public class CreateNoteFragment extends Fragment implements CreateNoteContract.View {
    private FragmentCreateNoteBinding binding;
    private CreateNoteContract.Presenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new CreateNotePresenter(this);
        binding.createNoteButton.setOnClickListener((v) -> presenter.onCreateButtonClickListener(binding.noteNameEditText.getText().toString(), binding.noteBodyEditText.getText().toString()));
        return view;
    }

    @Override
    public FragmentCreateNoteBinding getBinding() {
        return binding;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void showSnackbar(String message) {
        Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_SHORT).show();
    }
}