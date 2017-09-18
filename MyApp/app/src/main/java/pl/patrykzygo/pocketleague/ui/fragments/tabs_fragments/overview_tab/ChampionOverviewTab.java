package pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.overview_tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.ui.fragments.base_fragments.BaseChampionFragment;
import pl.patrykzygo.pocketleague.ui.fragments.enemy_tips.ChampionTipsFragment;
import pl.patrykzygo.pocketleague.ui.fragments.info.ChampionInfoFragment;
import pl.patrykzygo.pocketleague.ui.fragments.main_info.OverViewFragment;

public class ChampionOverviewTab extends BaseChampionFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_overview_tab, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }


    public void attachInfo(){
        BaseChampionFragment overView = new OverViewFragment();
        BaseChampionFragment championInfo = new ChampionInfoFragment();
        BaseChampionFragment championTips = new ChampionTipsFragment();
        overView.setChampion(getChampion());
        championInfo.setChampion(getChampion());
        championTips.setChampion(getChampion());
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.overview_first_fragment, overView);
        transaction.replace(R.id.overview_second_fragment, championInfo);
        transaction.replace(R.id.overview_third_fragment, championTips);
        transaction.commit();
    }

}