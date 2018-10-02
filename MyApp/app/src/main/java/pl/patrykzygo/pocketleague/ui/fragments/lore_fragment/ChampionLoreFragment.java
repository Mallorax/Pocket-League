package pl.patrykzygo.pocketleague.ui.fragments.lore_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.base.BaseChampionFragment;

public class ChampionLoreFragment extends BaseChampionFragment{

    @BindView(R.id.champion_lore)
    TextView championLore;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_lore_fragment, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }


    public void attachInfo(){
        championLore.setText(getChampion().getLore());
    }

}
