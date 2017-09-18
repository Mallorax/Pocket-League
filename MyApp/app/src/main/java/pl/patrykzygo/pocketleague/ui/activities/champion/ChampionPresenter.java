package pl.patrykzygo.pocketleague.ui.activities.champion;


import android.support.annotation.Nullable;

public interface ChampionPresenter {

    void setView(@Nullable ChampionView view);
    void presentChampion(int id);
}
