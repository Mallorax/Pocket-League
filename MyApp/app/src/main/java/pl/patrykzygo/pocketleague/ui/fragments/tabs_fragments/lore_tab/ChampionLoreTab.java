package pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.lore_tab;


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
import pl.patrykzygo.pocketleague.ui.fragments.lore_fragment.ChampionLoreFragment;

public class ChampionLoreTab extends Fragment{

    private ChampionDto champion;

    public static ChampionLoreTab newInstance(@NonNull ChampionDto champion){
        ChampionLoreTab fragment = new ChampionLoreTab();
        fragment.setChampion(champion);
        return fragment;
    }

    public void setChampion(ChampionDto champion){
        this.champion = champion;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_lore_tab, container, false);
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
        transaction.replace(R.id.lore_fragment, ChampionLoreFragment.newInstance(champion));
        transaction.commit();
    }
}
