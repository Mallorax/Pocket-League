package pl.patrykzygo.pocketleague.ui.activities.champions_list;


import android.support.annotation.Nullable;

public interface ChampionsListPresenter {

    void setView(@Nullable ChampionsListView view);
    void showChampions();

}
