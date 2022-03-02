package com.netimur.godnotej.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.godnotej.NoteItemTheme;
import com.netimur.godnotej.NoteItemThemeRepository;
import com.netimur.godnotej.databinding.NoteListItemBinding;
import com.netimur.godnotej.model.Note;

import java.util.ArrayList;

public class NoteRecyclerviewadapter extends RecyclerView.Adapter<NoteRecyclerviewadapter.NoteViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<NoteItemTheme> themes = NoteItemThemeRepository.getThemes();

    public NoteRecyclerviewadapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(NoteListItemBinding.inflate(this.inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = this.notes.get(position);
        String name = currentNote.getName();
        String body = currentNote.getBody();
        View.OnClickListener listener = (v) -> {
            NotesListFragmentDirections.ActionNotesListFragmentToNoteViewFragment act =
                    NotesListFragmentDirections.actionNotesListFragmentToNoteViewFragment(currentNote);
            Navigation.findNavController(holder.itemView).navigate(act);
        };
        holder.bind(name, body, position, listener);

    }


    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private NoteListItemBinding binding;

        public NoteViewHolder(NoteListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String name, String body, int position, View.OnClickListener listener) {
            int index;
            if (position < themes.size()) {
                applyTheme(this, themes.get(position));
            } else {
                index = (themes.size() - position) * -1;
                applyTheme(this, themes.get(index));
            }


            this.binding.noteName.setText(name);
            this.binding.noteBody.setText(body);
            this.binding.noteItem.setOnClickListener(listener);
        }


        private void applyTheme(NoteViewHolder holder, NoteItemTheme theme) {
            holder.binding.constaintLayout.setBackgroundResource(theme.getBackgroundResourceId());
            holder.binding.noteName.setTextColor(theme.getTextColorId());
            holder.binding.noteBody.setTextColor(theme.getTextColorId());
        }
    }
}
