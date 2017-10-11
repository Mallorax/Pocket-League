package pl.patrykzygo.pocketleague.ui.fragments.dialog_fragments;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import pl.patrykzygo.pocketleague.R;

public class SortDialog extends DialogFragment {

    private SortDialogListener listener;
    private int position;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (SortDialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement SortDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // TODO save position of a radio button marked by a user
        if (savedInstanceState == null){
            position = 2;
        }else{
            position = savedInstanceState.getInt("position");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.sort_dialog_title)
                .setSingleChoiceItems(R.array.sort_dialog_positions, position, null)
                .setPositiveButton(R.string.confirm, (dialog, which) ->{
                    dialog.dismiss();
                    position = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                    listener.onConfirmButtonClicked(position);
        });

        return builder.create();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("position", position);
        super.onSaveInstanceState(outState);
    }

    public interface SortDialogListener{
        void onConfirmButtonClicked(int which);
    }
}
