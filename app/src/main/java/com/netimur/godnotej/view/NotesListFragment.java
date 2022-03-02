package com.netimur.godnotej.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netimur.godnotej.R;
import com.netimur.godnotej.contracts.NotesViewContract;
import com.netimur.godnotej.databinding.FragmentNotesListBinding;
import com.netimur.godnotej.model.Note;
import com.netimur.godnotej.presenter.NotesListPresenter;

import java.util.ArrayList;

public class NotesListFragment extends Fragment implements NotesViewContract.View, LifecycleOwner {
    private FragmentNotesListBinding binding;
    private NotesViewContract.Presenter presenter;
    private NoteRecyclerviewadapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotesListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new NotesListPresenter(this);
        adapter = new NoteRecyclerviewadapter(requireContext());
        binding.noteListRecyclerView.setAdapter(adapter);
        showData();
        binding.addButton.setOnClickListener((v) -> presenter.onAddButtonClickListener()
        );
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void showData() {
        //Пока сделал в отдельном потоке...
        presenter.getData();
    }

    @Override
    public FragmentNotesListBinding getBinding() {
        return this.binding;
    }

    @Override
    public void showEmptyLabel() {
        binding.emptyLabel.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNotes(ArrayList<Note> notes) {
        binding.emptyLabel.setVisibility(View.INVISIBLE);
        this.adapter.setNotes(notes);
        this.binding.noteListRecyclerView.setAdapter(adapter);
    }
}