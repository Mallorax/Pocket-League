package pl.patrykzygo.pocketleague.ui.Fragments.main_info_fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;

public class ChampionMainFragment extends Fragment implements ChampionMainFragmentView {

    @BindView(R.id.champion_list_icon)
    ImageView championIcon;
    @BindView(R.id.champion_name_text_view)
    TextView championName;
    @BindView(R.id.champion_title_text_view)
    TextView championTitle;

    @Inject
    ChampionMainFragmentPresenter presenter;

    private static  ChampionMainFragment newInstance(int id){
        ChampionMainFragment fragment = new ChampionMainFragment();
        Bundle b = new Bundle();
        b.putInt("id", id);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champions_list_item, container, false);
        ButterKnife.bind(this, view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Override
    public void showInfo(ChampionDto champion) {
        championIcon.setImageBitmap(champion.getImage().getBitmap());
        championName.setText(champion.getName());
        championTitle.setText(champion.getTitle());
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }
}
