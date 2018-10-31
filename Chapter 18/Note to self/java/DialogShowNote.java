package com.gamecodeschool.notetoself;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogShowNote extends DialogFragment {

    private Note mNote;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // All the other code goes here
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_note, null);

        TextView txtTitle = (TextView) dialogView.findViewById(R.id.txtTitle);

        TextView txtDescription = (TextView) dialogView.findViewById(R.id.txtDescription);

        txtTitle.setText(mNote.getTitle());
        txtDescription.setText(mNote.getDescription());

        TextView txtImportant = (TextView) dialogView.findViewById(R.id.textViewImportant);

        TextView txtTodo = (TextView) dialogView.findViewById(R.id.textViewTodo);

        TextView txtIdea = (TextView) dialogView.findViewById(R.id.textViewIdea);

        if (!mNote.isImportant()){
            txtImportant.setVisibility(View.GONE);
        }

        if (!mNote.isTodo()){
            txtTodo.setVisibility(View.GONE);
        }

        if (!mNote.isIdea()){
            txtIdea.setVisibility(View.GONE);
        }

        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);

        builder.setView(dialogView).setMessage("Your Note");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();



    }


    // Receive a note from the MainActivity
    public void sendNoteSelected(Note noteSelected) {
        mNote = noteSelected;
    }

}

