package pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.abilities_tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.ui.fragments.abilities_fragment.ChampionAbilitiesFragment;
import pl.patrykzygo.pocketleague.base.BaseChampionFragment;

public class ChampionAbilitiesTab extends BaseChampionFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_abilities_tab, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }


    public void attachInfo(){
        BaseChampionFragment fragment = new ChampionAbilitiesFragment();
        fragment.setChampion(getChampion());
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.abilities_fragment, fragment);
        transaction.commit();
    }
}
