package pl.patrykzygo.pocketleague.ui.fragments.base_fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import pl.patrykzygo.pocketleague.pojo.Champion;

// Base class for every fragment, that requires champion's data

public abstract class BaseChampionFragment extends Fragment {

    @NonNull
    private Champion champion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    public void setChampion(@NonNull Champion champion){
        this.champion = champion;
    }

    public Champion getChampion() {
        return champion;
    }

    public abstract void attachInfo();
}
