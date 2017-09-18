package pl.patrykzygo.pocketleague.ui.fragments.base_fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import pl.patrykzygo.pocketleague.pojo.ChampionDto;

// Base class for every fragment, that requires champion's data

public abstract class BaseChampionFragment extends Fragment {

    @NonNull
    private ChampionDto champion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    public void setChampion(@NonNull ChampionDto champion){
        this.champion = champion;
    }

    public ChampionDto getChampion() {
        return champion;
    }

    public abstract void attachInfo();
}
