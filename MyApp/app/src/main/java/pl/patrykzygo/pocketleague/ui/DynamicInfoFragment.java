package pl.patrykzygo.pocketleague.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.patrykzygo.pocketleague.R;

/**
 * Created by Mallorax on 15.08.2017.
 */

public class DynamicInfoFragment extends Fragment {

    public DynamicInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dynamic_info_fragment, container, false);
    }
}
