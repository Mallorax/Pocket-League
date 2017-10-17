package pl.patrykzygo.pocketleague.ui.fragments.dialog_fragments;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import pl.patrykzygo.pocketleague.R;

public class SortDialog extends DialogFragment {

    private SortDialogListener listener;
    private static final String SELECTED_OPTION = "SelectedOption";
    private SharedPreferences sharedPreference;
    private SharedPreferences.Editor sharedPrefEditor;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.sort_dialog_title)
                .setSingleChoiceItems(R.array.sort_dialog_positions, getSelectedOption(), (dialog, which) ->{
                    saveSelectedOption(which);
                })
                .setPositiveButton(R.string.confirm, (dialog, which) ->{
                    dialog.dismiss();
                    listener.onConfirmButtonClicked(getSelectedOption());
        });

        return builder.create();
    }

    private int getSelectedOption() {
        if (sharedPreference == null) {
            sharedPreference = PreferenceManager
                    .getDefaultSharedPreferences(getContext());
        }
        return sharedPreference.getInt(SELECTED_OPTION, 2);
    }

    private void saveSelectedOption(int item) {
        if (sharedPreference == null) {
            sharedPreference = PreferenceManager
                    .getDefaultSharedPreferences(getContext());
        }
        sharedPrefEditor = sharedPreference.edit();
        sharedPrefEditor.putInt(SELECTED_OPTION, item);
        sharedPrefEditor.commit();
    }

    public interface SortDialogListener{
        void onConfirmButtonClicked(int which);
    }
}
