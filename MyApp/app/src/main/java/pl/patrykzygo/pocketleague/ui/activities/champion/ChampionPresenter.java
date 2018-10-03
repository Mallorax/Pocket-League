package pl.patrykzygo.pocketleague.ui.activities.champion;


import pl.patrykzygo.pocketleague.base.BasePresenter;

public interface ChampionPresenter extends BasePresenter<ChampionView> {

    void presentChampion(String name);
}
