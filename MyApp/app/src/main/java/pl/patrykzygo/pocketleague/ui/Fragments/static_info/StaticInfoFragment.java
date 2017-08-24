package pl.patrykzygo.pocketleague.ui.Fragments.static_info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;
import pl.patrykzygo.pocketleague.ui.adapters.StaticInfoAdapter;
import pl.patrykzygo.pocketleague.ui.activities.champions_list.ChampionsListActivity;


public class StaticInfoFragment extends Fragment implements StaticInfoAdapter.OnMenuPositionClickListener {


    @BindView(R.id.static_menu_recycler_view)
    RecyclerView recyclerView;

    @Inject
    StaticInfoAdapter adapter;

    public StaticInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.static_info_fragment, container, false);
        ButterKnife.bind(this, view);

        adapter.setOnMenuPositionClickLiostener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onMenuPositionClicked(String positionName) {
        switch (positionName){
            case "Champions":
                startActivity(new Intent(getContext(), ChampionsListActivity.class));
                break;
            default:
                Toast.makeText(getContext(), "Unknown error occurred", Toast.LENGTH_LONG).show();
        }
    }
}
