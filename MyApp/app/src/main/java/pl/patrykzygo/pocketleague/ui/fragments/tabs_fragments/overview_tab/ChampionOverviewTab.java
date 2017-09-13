package pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.overview_tab;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.ui.fragments.enemy_tips.ChampionTipsFragment;
import pl.patrykzygo.pocketleague.ui.fragments.info.ChampionInfoFragment;
import pl.patrykzygo.pocketleague.ui.fragments.main_info.OverView;

public class ChampionOverviewTab extends Fragment{

    private ChampionDto champion;


    public static ChampionOverviewTab newInstance(@NonNull ChampionDto champion){
        ChampionOverviewTab fragment = new ChampionOverviewTab();
        fragment.setChampion(champion);
        return fragment;
    }

    public void setChampion(ChampionDto champion){
        this.champion = champion;
    }

    public ChampionDto getChampion() {
        return champion;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_overview_tab, container, false);
        ButterKnife.bind(this, view);
        attachFragments();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void attachFragments(){
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.overview_first_fragment, OverView.newInstance(champion));
        transaction.replace(R.id.overview_second_fragment, ChampionInfoFragment.newInstance(champion));
        transaction.replace(R.id.overview_third_fragment, ChampionTipsFragment.newInstance(champion));
        transaction.commit();
    }

}